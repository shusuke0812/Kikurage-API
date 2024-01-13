const { createServer } = require('http')
const { ApolloServer } = require(`apollo-server-express`)
const express = require(`express`)
const expressPlayground = require(`graphql-playground-middleware-express`).default
const { readFileSync } = require(`fs`)

const { MongoClient } = require(`mongodb`)
require(`dotenv`).config()

const typeDefs = readFileSync(`./typeDefs.graphql`, `UTF-8`)
const resolvers = require(`./resolvers`)
const { create } = require('domain')

async function start() {
    const app = express()
    const MONGO_DB = process.env.DB_HOST
    const client = await MongoClient.connect(
        MONGO_DB,
    )
    const db = client.db()

    const context = { db }

    const server = new ApolloServer({
        typeDefs,
        resolvers,
        context: async ({ req }) => {
            const githubToken = req.headers.authorization
            const currentUser = await db.collection('users').findOne({ githubToken })
            return { db, currentUser }
        }
    })

    await server.start()
    server.applyMiddleware({ app })
    app.get(`/`, (req, res) => res.end(`Welcom to the PhotoShare API`))
    app.get(`/playground`, expressPlayground({ endpoint: `/graphql` }))
    
    
    const httpServer = createServer(app)
    server.installSubscriptionHandlers(httpServer)
    httpServer.timeout = 5000

    httpServer.listen({ port: 4000 }, () =>
        console.log(`GraphQL Serverr running at localhost:4000${server.graphqlPath}`)
    )
}

start()
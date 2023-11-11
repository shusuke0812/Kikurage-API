const auth = require('../auth')
require('dotenv').config()

module.exports = {
    async postPhoto(parent, args, { db, currentUser }) {
        if(!currentUser) {
            throw new Error('only an authorized user can post a photo')
        }

        const newPhoto = {
            ...args.input,
            userID: currentUser.githubLogin,
            created: Date()
        }
        
        const { insertedIds } = await db.collection('photos').insert(newPhoto)
        newPhoto.id = insertedIds[0]

        return newPhoto
    },

    async githubAuth(parent, { code }, { db }) {
        let {
            message,
            access_token,
            avatar_url,
            login,
            name
        } = await auth.GitHubAuth.authorizeWithGitHub({
            client_id: process.env.CLIENT_ID,
            client_secret: process.env.CLIENT_SECRET,
            code
        })

        if(message) {
            throw new Error(message)
        }

        let latestUserInfo = {
            name,
            githubLogin: login,
            githubToken: access_token,
            avatar: avatar_url
        }

        const { ops:[user] } = await db
            .collection('users')
            .replaceOne({ githubLogin: login }, latestUserInfo, { upsert: true })

        return { user, token: access_token }
    },

    addFakeUsers: async (root, {count}, {db}) => {
        var randomUserApi = 'https://randomuser.me/api/?results=${count}'

        var { results } = await fetch(randomUserApi)
            .then(res => res.json())
        
        var users = results.map(r => ({
            githubLogin: r.login.username,
            name: `${r.name.first} ${r.name.last}`,
            avatar: r.picture.thumbnail,
            githubToken: r.login.sha1
        }))

        await db.collection(`users`).insert(users)
        return users
    }
}
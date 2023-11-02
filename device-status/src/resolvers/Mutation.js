const auth = require('../auth')
require('dotenv').config()

var _id = 0

module.exports = {
    postPhoto(parent, args) {
        var newPhoto = {
            id: _id++,
            ...args.input,
            created: Date()
        }
        photos.push(newPhoto)
        return newPhoto
    },

    async githubAuth(parent, { code }, { db }) {
        let {
            message,
            access_token,
            avatar_url,
            login,
            name
        } = await auth({
            client_id: process.env.CLIENT_ID,
            cllient_secret: process.env.CLIENT_SECRET,
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
            .collection('user')
            .replaceOne({ githubLogin: login }, latestUserInfo, { upsert: true })

        return { user, token: access_token }
    }
}
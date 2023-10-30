import { fetch } from 'node-fetch';
import { fs } from 'fs';

function requestToken(credentials) {
    return fetch(
        'https://github.com/login/oauth/access_token',
        {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
                'Accept': 'application/json'
            },
            body: JSON.stringify(credentials)
        }
    )
    .then(res => res.json())
    .catch(error => {
        throw new Error(JSON.stringify(error))
    })
}

function requestUserAccount(token) {
    return fetch('https://api.github.com/user?access_token=${token}')
        .then(toJSON)
        .catch(throwError)
}

module.exports = {
    async authorize(credentials) {
        const { access_token } = await requestToken(credentials)
        const user = await requestUserAccount(access_token)
        return { ...user, access_token }
    }
}
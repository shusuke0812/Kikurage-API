import React, { Component } from 'react'
import { withRouter } from 'react-router-dom'
import { Query, Mutation } from 'react-apollo'
import { gql } from 'apollo-boost'
import { ROOT_QUERY } from './App'
import dotenv from 'dotenv'
dotenv.config({ path: '../.env/'})

class AuthorizedUSer extends Component {
    state = { signingIn: false }
    authorizationComplete = (cache, {data}) => {
        localStorage.setItem('token', data.githubAuth.token)
        this.props.history.replace('/')
        this.setState({ signingIn: false })
    }

    componentDidMount() {
        if (window.location.search.match(/code=/)) {
            this.setState({ signingIn: true })
            const code = window.location.search.replace("?code=", "")
            this.githubAuthMutation({ variables: {code} })
            //alert(code)
            //this.props.history.replace('/')
        }
    }

    requestCode() {
        var clientID = process.dotenv.REACT_APP_CLIENT_SECRET
        window.location = `https://github.com/login/oauth/authorize?client_id=${clientID}&scope=user`
    }

    render() {
        return(
            <Mutation mutation={GITHUB_AUTH_MUTATION}
                update={this.authorizationComplete}
                refetchQueries={[{ query: ROOT_QUERY }]}
            >
                { mutation => {
                    this.githubAuthMutation = mutation
                    return (
                        <Me signingIn={this.state.signingIn}
                        requestCode={this.requestCode}
                        logout={() => localStorage.removeItem('token')} />
                    )
                }}
            </Mutation>
        )
    }
}

const GITHUB_AUTH_MUTATION = gql`
    mutation githubAuth($code:String!) {
        githubAuth(code:$code) { token }
    }
`

const Me = ({ logout, requestCode, signingIn }) =>
    <Query query={ROOT_QUERY}>
        {({ loading, data }) => data.me ?
            <CurrentUser {...data.me} logout={logout} /> :
            loading ?
                <p>loading...</p> :
                <button onClick={this.requestCode} disabled={this.state.signingIn}>
                    Sign In with GitHub
                </button>
        }
    </Query>

const CurrentUser = ({ name, avatar, logout }) =>
    <div>
        <img src={avatar} width={52} height={52} alt='' />
        <h1>name</h1>
        <button onClick={logout}>logout</button>
    </div>

export default withRouter(AuthorizedUSer)
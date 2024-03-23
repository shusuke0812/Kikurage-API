import './App.css';
import React from 'react';
import Users from './Users';
import { gql } from 'apollo-boost';
import { BrowserRouter } from 'react-router-dom';
import AuthorizedUser from './AuthorizedUser';

export const ROOT_QUERY = gql`
    query allUsers {
        totalUsers
        allUsers { ...useInfo }
        me { ...useInfo }
    }

    fragment userInfo on User {
        githubLogin
        name
        avatar
    }
`
const App = () => 
    <BrowserRouter>
        <div>
            <AuthorizedUser />
            <Users />
        </div>
    </BrowserRouter>

export default App;

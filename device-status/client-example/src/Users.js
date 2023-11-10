import React from 'react'
import { Query } from 'react-apollo'
import { ROOT_QUERY } from './App'

const Users = () =>
    //<Query query={ROOT_QUERY} pollInterval={1000}> //NOTE: polling [ms]
    <Query query={ROOT_QUERY}>
        {({ data, loading, fetch }) => loading ?
            <p>loading users ...</p> :
            <UserList
                count={data.totalUsers}
                users={data.allUsers}
                fetchUsers={fetch} />
        }
    </Query>

const UserList = ({ count, users, refetchUsers }) =>
    <div>
        <p>{count} Users</p>
        <button onClick={() => refetchUsers()}>Refetch Users</button>
        <ul>
            {users.map(user =>
                <UserListItem
                    key={user.githubLogin}
                    name={user.name}
                    avatar={user.avatar} />
            )}
        </ul>
    </div>

const UserListItem = ({ name, avatar }) =>
    <li>
        <img src={avatar} width={52} height={52} alt="" />
    </li>

export default Users
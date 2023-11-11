# Device Status API

## Development

- GraphQL server
- Express ([node version 18.18.2](https://github.com/shusuke0812/Kikurage-API/blob/develop/device-status/.node-version))

## What APIs are supported ?

- M5Stack temperature
- M5Stack humidity
- M5Stack battery SOC

## Start debug
1. MogoDB start

```bash
# Check running of MongoDB
$ brew services list

# Start
$ brew services start mongodb-community

# Stop
$ brew services stop mongodb-community
```

2. Run GraphQL server

```bash
$ cd ./device-status
$ npm start
```

**other tips**

```bash
# Start MongoDB shell
$ modosh
```

## Reference

- [Learning GraphQL](https://www.oreilly.com/library/view/learning-graphql/9781492030706/)
- [Learning GraphQL Repository](https://github.com/MoonHighway/learning-graphql)
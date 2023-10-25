import Vapor

func routes(_ app: Application) throws {
    app.get { req async in
        "It works!"
    }

    app.get("number", ":x") { req -> String in
        guard let number = req.parameters.get("x", as: Int.self) else {
            throw Abort(.badRequest)
        }
        return "\(number) is a great number"
    }
    
    app.get("user") { req in
        let greeting = try req.content.decode(User.self)
        print(greeting.name)
        return HTTPStatus.ok
    }
}

//
//  File.swift
//  
//
//  Created by Shusuke Ota on 2023/2/19.
//

import Vapor

struct User: Content {
    var name: String
    var email: String
    var image: Data
}

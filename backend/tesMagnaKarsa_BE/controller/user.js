'use strict';

var connection = require('../conn');

exports.users = function(req, res) {
    connection.query('SELECT * FROM user', function (error, rows, fields){
        if(error){
            console.log(error)
        } else{
            res.json(rows)
            res.end();
        }
    });
};

exports.createUsers = function(req, res) {
    
    var username = req.body.username;
    var password = req.body.password;
    var logintime = req.body.logintime;
    var loginstate = "Login";

    connection.query('INSERT INTO user (username, password, login_time, login_state) values (?,?,?,?)',
    [ username, password, logintime, loginstate ], 
    function (error, rows, fields){
        if(error){
            console.log(error)
            res.status(403).json({'error_message' : "Gagal Menambahkan User"})
            res.end()
        } else{
            res.json({'message' : "Berhasil Menambahkan User"})
            res.end()
        }
    });
};

exports.login = function(req, res) {
    
    var username = req.query.username;
    var password = req.query.password;
    var logintime = req.query.logintime;


    connection.query('SELECT * FROM user where username = ? AND password = ?',
    [ username, password ], 
    function (error, rows, fields){
        if(error){
            res.status(403).json({'error_message' : "Gagal Login"})
            console.log(error)
        } else{
            if(rows.length == 0) {
                res.status(403).json({'error_message' : "Gagal Login"})
            } else {
                setLoginState(username, logintime);
            res.json({'message' : "Login Berhasil"});
            res.end();
            }
        }
    });
};

exports.logout = function(req, res) {
    var username = req.query.username;
    var loginstate = "Logout";

    connection.query('UPDATE user SET login_state = ? WHERE username = ?',
    [ loginstate, username ], 
    function (error, rows, fields){
        if(error){
            console.log(error);
        } else{
            res.json({"message" : "Logout Berhasil"});
        }
    });
}

exports.hello = function(req, res) {
    
    var username = req.query.username;

    connection.query('SELECT * FROM user where username = ?',
    [ username ], 
    function (error, rows, fields){
        if(error){
            res.status(403).json({'error_message' : "Gagal Fetch Data"})
            console.log(error)
        } else{
            res.json(rows[0]);
            res.end();
        }
    });
};

function setLoginState(username, logintime) {
    console.log("Jalan");
    var loginstate = "Login";
    connection.query('UPDATE user SET login_time = ?, login_state = ? WHERE username = ?',
    [ logintime, loginstate, username ], 
    function (error, rows, fields){
        if(error){
            console.log(error);
        } else{
            console.log("Login State Berhasil");
        }
    });
}


'use strict';

var response = require('../res');
var connection = require('../conn');

exports.tes = function(req,res){
    connection.query("SELECT * FROM table_tes", function(error, rows, field) {
        if(error) {
            console.log(error)
        } else {
            res.json(rows)
            res.end();
        }
    })
}


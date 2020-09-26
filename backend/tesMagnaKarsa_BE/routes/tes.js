var express = require('express');
var router = express.Router();
var controller = require('../controller/tes')

router.get('/', function(req, res, next) {
    controller.tes(req,res)
})

module.exports = router;
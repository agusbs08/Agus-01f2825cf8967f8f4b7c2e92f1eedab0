var express = require('express');
var router = express.Router();
var controller = require('../controller/user');
const { route } = require('./tes');
/* GET users listing. */
router.get('/', function(req, res, next) {
  controller.users(req, res)
});

router.post('/register', function(req, res, next) {
  controller.createUsers(req, res)
})

router.get('/login', function(req, res, next){
  controller.login(req, res)
})

router.get('/logout', function(req, res, next){
  controller.logout(req, res)
})

router.get('/hello', function(req, res, next){
  controller.hello(req, res)
})

module.exports = router;

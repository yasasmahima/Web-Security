var express = require('express');
var router = express.Router();
var jwt = require('jsonwebtoken');
var bodyParser = require('body-parser');
var config = require('../authentication/config.js');
var VerifyToken = require('../authentication/VerifyToken.js');

router.use(bodyParser.urlencoded({ extended: true }));
router.use(bodyParser.json());
var User = require('../models/Customer.js');


// CREATES A NEW USER
router.post('/add',VerifyToken,function (req, res) {

        User.create({
                name : req.body.name,
                contact : req.body.contact,
            }, 
            function (err, user) {
                if (err) return res.status(500).send("There was a problem adding the information to the database.");
                res.status(200).send(user);
            });
   
});

// RETURNS ALL THE USERS IN THE DATABASE
router.get('/view',VerifyToken, function (req, res) {

        User.find({}, function (err, users) {
            if (err) return res.status(500).send("There was a problem finding the users.");
            res.status(200).send(users);
        });
    
});

// GETS A SINGLE USER FROM THE DATABASE
router.get('/view/:id',VerifyToken, function (req, res) {

        User.findById(req.params.id, function (err, user) {
            if (err) return res.status(500).send("There was a problem finding the user.");
            if (!user) return res.status(404).send("No user found.");
            res.status(200).send(user);
        });

});

// DELETES A USER FROM THE DATABASE
router.delete('delete/:id', VerifyToken,function (req, res) {

        User.findByIdAndRemove(req.params.id, function (err, user) {
            if (err) return res.status(500).send("There was a problem deleting the user.");
                res.status(200).send("User: "+ user.name +" was deleted.");
        });
});

// UPDATES A SINGLE USER IN THE DATABASE
router.put('update/:id',VerifyToken, function (req, res) {

        User.findByIdAndUpdate(req.params.id, req.body, {new: true}, function (err, user) {
            if (err) return res.status(500).send("There was a problem updating the user.");
                res.status(200).send(user);
        });
});


module.exports = router;
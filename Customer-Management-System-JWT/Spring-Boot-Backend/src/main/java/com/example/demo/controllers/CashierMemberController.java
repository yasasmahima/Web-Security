package com.example.demo.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin()
public class CashierMemberController {
    @RequestMapping(value = "/greeting", method = RequestMethod.GET)
    public ResponseEntity<String> getResponse() {
        return new ResponseEntity<>("Log in Success", HttpStatus.OK);
    }

}

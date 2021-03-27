package org.launchcode.ezeeinvestapp.controllers;


import org.launchcode.ezeeinvestapp.models.data.AccountDao;
import org.launchcode.ezeeinvestapp.models.form.Account;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.MediaType;

import org.springframework.web.bind.annotation.*;




@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class AccountController {
    @Autowired
    private AccountDao accountDao;


    @GetMapping("/api/account")
    public Iterable fetchAllStudents() {

        Iterable<Account> listofmaps = accountDao.findAll ();

        return listofmaps;
    }

    @PostMapping("/api/account/add")
    public void addNewAccount(@RequestBody Account newAccount) {
        accountDao.save (newAccount);
    }


    @DeleteMapping("/api/account/{id}")
    void deleteAccount(@PathVariable int id) {
        accountDao.deleteById(id);
    }


}
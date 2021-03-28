package org.launchcode.ezeeinvestapp.controllers;

import org.launchcode.ezeeinvestapp.models.data.AccountDao;
import org.launchcode.ezeeinvestapp.models.data.TransactionDao;
import org.launchcode.ezeeinvestapp.models.form.Account;
import org.launchcode.ezeeinvestapp.models.form.Transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;

@CrossOrigin
@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class TransactionController {
    @Autowired
    private TransactionDao transactionDao;
    @Autowired
    private AccountDao accountDao;



    @RequestMapping(value="/api/fetch" , method=RequestMethod.GET)
    @ResponseBody
    public Iterable fetchTransactions() {

        Iterable<Transaction> listofmaps = transactionDao.findAll ();
        ArrayList<Transaction> transactions = new ArrayList<> (  );
        for (Transaction map : listofmaps) {
                transactions.add (map);
        }
        Collections.sort(transactions);
        return transactions;

    }


    @PostMapping("/api/transaction/add")
    public void takeNewTransaction(@RequestBody Transaction newTransaction) {
        Account account = accountDao.findById ( newTransaction.getAccountIdToSet() ).orElseGet ( null );

        newTransaction.setAccount (account);

        transactionDao.save ( newTransaction );
    }




}







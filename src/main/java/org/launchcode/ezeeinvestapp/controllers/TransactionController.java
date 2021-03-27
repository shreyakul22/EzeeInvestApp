package org.launchcode.ezeeinvestapp.controllers;

import org.launchcode.ezeeinvestapp.models.data.ClientDao;
import org.launchcode.ezeeinvestapp.models.data.TransactionDao;
import org.launchcode.ezeeinvestapp.models.form.Transaction;

import org.launchcode.ezeeinvestapp.models.form.TransactionType;
import org.launchcode.ezeeinvestapp.models.form.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;


@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class TransactionController {
    @Autowired
    private TransactionDao transactionDao;
    @Autowired
    private ClientDao clientDao;



    @RequestMapping(value="/api/fetch" , method=RequestMethod.GET)
    @ResponseBody
    public Iterable fetchTransactions() {

        Iterable<Transaction> listofmaps = transactionDao.findAll ();
        ArrayList<Transaction> transactions = new ArrayList<> (  );
        for (Transaction map : listofmaps) {
                transactions.add (map);
        }

        return transactions;

    }


    @PostMapping("/api/transaction/add")
    public void takeNewTransaction(@RequestBody Transaction newTransaction) {
        Client client = clientDao.findById ( newTransaction.getClientIdToSet() ).orElseGet ( null );

        newTransaction.setClient (client);

        transactionDao.save ( newTransaction );
    }




}






package org.launchcode.ezeeinvestapp.controllers;

import org.launchcode.ezeeinvestapp.models.Transaction;
import org.launchcode.ezeeinvestapp.models.data.ClientRepository;
import org.launchcode.ezeeinvestapp.models.data.TransactionRepository;
import org.launchcode.ezeeinvestapp.models.data.BankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.launchcode.ezeeinvestapp.models.TransactionData;

import java.util.HashMap;

/**
 * Created by LaunchCode
 */
@Controller
@RequestMapping(value = "list")
public class ListController {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private BankRepository bankRepository;

    static HashMap<String, String> columnChoices = new HashMap<>();

    public ListController () {

        columnChoices.put("all", "All");
        columnChoices.put("employer", "Client");
        columnChoices.put("skill", "Bank");

    }

    @RequestMapping("")
    public String list(Model model) {
        model.addAttribute("jobs", transactionRepository.findAll());
        model.addAttribute("clients", clientRepository.findAll());
        model.addAttribute("banks", bankRepository.findAll());

        return "list";
    }

    @RequestMapping(value = "jobs")
    public String listJobsByColumnAndValue(Model model, @RequestParam String column, @RequestParam String value) {
        Iterable<Transaction> jobs;
        if (column.toLowerCase().equals("all")){
            jobs = transactionRepository.findAll();
            model.addAttribute("title", "All Jobs");
        } else {
            jobs = TransactionData.findByColumnAndValue(column, value, transactionRepository.findAll());
            model.addAttribute("title", "Jobs with " + columnChoices.get(column) + ": " + value);
        }
        model.addAttribute("jobs", jobs);

        return "list-jobs";
    }
}

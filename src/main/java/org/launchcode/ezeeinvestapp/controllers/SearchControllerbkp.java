package org.launchcode.ezeeinvestapp.controllers;

import org.launchcode.ezeeinvestapp.models.Transaction;
import org.launchcode.ezeeinvestapp.models.TransactionData;
import org.launchcode.ezeeinvestapp.models.data.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import static org.launchcode.ezeeinvestapp.controllers.ListController.columnChoices;

/**
 * Created by LaunchCode
 */
@Controller
@RequestMapping("search")
public class SearchControllerbkp {

    @Autowired
    private TransactionRepository transactionRepository;

    @RequestMapping("")
    public String search(Model model) {
        model.addAttribute("columns", columnChoices);
        return "search";
    }

    @PostMapping("results")
    public String displaySearchResults(Model model, @RequestParam String searchType, @RequestParam String searchTerm){
        Iterable<Transaction> jobs;
        if (searchTerm.toLowerCase().equals("all") || searchTerm.equals("")){
            jobs = transactionRepository.findAll();
        } else {
            jobs = TransactionData.findByColumnAndValue(searchType, searchTerm, transactionRepository.findAll());
        }
        model.addAttribute("columns", columnChoices);
        model.addAttribute("title", "Jobs with " + columnChoices.get(searchType) + ": " + searchTerm);
        model.addAttribute("jobs", jobs);

        return "search";
    }
}
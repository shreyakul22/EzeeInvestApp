package org.launchcode.ezeeinvestapp.controllers;

import org.launchcode.ezeeinvestapp.models.Client;
import org.launchcode.ezeeinvestapp.models.Transaction;
import org.launchcode.ezeeinvestapp.models.Bank;
import org.launchcode.ezeeinvestapp.models.data.ClientRepository;
import org.launchcode.ezeeinvestapp.models.data.TransactionRepository;
import org.launchcode.ezeeinvestapp.models.data.BankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

/**
 * Created by LaunchCode
 */
@Controller
public class HomeController {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private BankRepository bankRepository;

    @Autowired
    private TransactionRepository transactionRepository;


    @RequestMapping("")
    public String index(Model model) {

        model.addAttribute("title", "My Jobs");

        return "index";
    }

    @GetMapping("add")
    public String displayAddJobForm(Model model) {
        model.addAttribute("title", "Add Transaction");
        model.addAttribute(new Transaction());

        model.addAttribute("clients", clientRepository.findAll());
        model.addAttribute("banks", bankRepository.findAll());

        return "add";
    }

    @PostMapping("add")
    public String processAddJobForm(@ModelAttribute @Valid Transaction newTransaction,
                                    Errors errors, Model model, @RequestParam Integer clientId, @RequestParam(required = false) List<Integer> skills) {
        model.addAttribute("clients", clientRepository.findAll());

        if (errors.hasErrors() || (clientId == null || skills == null)) {
            model.addAttribute("title", "Add Transaction");
            return "add";
        } else {
            Optional<Client> empResults = clientRepository.findById(clientId);
            List<Bank> bankObjs = (List<Bank>) bankRepository.findAllById(skills);
            if (empResults.isPresent() && !bankObjs.isEmpty()) {
                Client client = empResults.get();
                newTransaction.setClient(client);
                newTransaction.setSkills(bankObjs);
                transactionRepository.save(newTransaction);
            }

            return "redirect:";
        }
    }

    @GetMapping("view/{jobId}")
    public String displayViewJob(Model model, @PathVariable int jobId) {
        Optional<Transaction> result = transactionRepository.findById(jobId);
        if(result.isPresent()){
            Transaction transaction = result.get();
            model.addAttribute("transaction", transaction);
        }else{
            return "redirect:";
        }

        return "view";
    }

}

package org.launchcode.ezeeinvestapp.controllers;

import org.launchcode.ezeeinvestapp.models.Client;
import org.launchcode.ezeeinvestapp.models.data.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("clients")
public class ClientController {

    @Autowired
    private ClientRepository clientRepository;

    @GetMapping("")
    public String displayAllClients(Model model) {
        model.addAttribute("clients", clientRepository.findAll());
        return "clients/index";
    }


    @GetMapping("add")
    public String displayAddClientForm(Model model) {
        model.addAttribute(new Client());
        return "clients/add";
    }

    @PostMapping("add")
    public String processAddClientForm(@ModelAttribute @Valid Client newClient,
                                       Errors errors, Model model) {

        if (errors.hasErrors()) {
            return "clients/add";
        }
        clientRepository.save(newClient);
        return "redirect:../add";
    }


    @GetMapping("view/{clientId}")
    public String displayViewClient(Model model, @PathVariable int clientId) {

        Optional optClient = clientRepository.findById(clientId);
        if (optClient.isPresent()) {
            Client client = (Client) optClient.get();
            model.addAttribute("client", client);
            return "clients/view";

        } else {
            return "redirect:../";
        }

    }

}
package org.launchcode.ezeeinvestapp.controllers;


import org.launchcode.ezeeinvestapp.models.data.ClientDao;
import org.launchcode.ezeeinvestapp.models.form.Client;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.MediaType;

import org.springframework.web.bind.annotation.*;




@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class ClientController {
    @Autowired
    private ClientDao clientDao;


    @GetMapping("/api/client")
    public Iterable fetchAllStudents() {

        Iterable<Client> listofmaps = clientDao.findAll ();

        return listofmaps;
    }

    @PostMapping("/api/client/add")
    public void addNewClient(@RequestBody Client newClient) {
        clientDao.save (newClient);
    }


    @DeleteMapping("/api/client/{id}")
    void deleteClient(@PathVariable int id) {
        clientDao.deleteById(id);
    }


}
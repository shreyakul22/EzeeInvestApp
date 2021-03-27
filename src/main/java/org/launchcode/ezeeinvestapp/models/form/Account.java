package org.launchcode.ezeeinvestapp.models.form;
import org.launchcode.ezeeinvestapp.models.data.TransactionDao;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Account {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    @Size (min = 3, max = 15)
    private String name;

//    @OneToMany
//    @JsonIgnore
//    private List<Transaction> transactions;


    public Account (String name) {
        this.name = name;
    }

    public Account () {

    }

    public int getId () {
        return id;
    }

    public void setId (int id) {
        this.id = id;
    }

    public String getName () {
        return name;
    }

    public void setName (String name) {
        this.name = name;
    }
}
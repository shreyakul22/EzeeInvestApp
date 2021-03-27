package org.launchcode.ezeeinvestapp.models.form;
import org.launchcode.ezeeinvestapp.models.data.TransactionDao;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Client {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    @Size (min = 3, max = 15)
    private String name;

    @NotNull
    @Size (min = 3, max = 15)
    private String lastname;

    // one student has many attendance so I created a list
    @OneToMany (mappedBy = "student")
    @JsonIgnore
    private List<Transaction> attendanceDays;


    public Client (String name, String lastname) {
        this.name = name;
        this.lastname = lastname;
    }


    public Client () {

    }

    public int getId () {
        return id;
    }

    public void setId (int id) {
        this.id = id;
    }

    @JsonProperty ("firstname")
    public String getName () {
        return name;
    }

    public void setName (String name) {
        this.name = name;
    }

    public String getLastname () {
        return lastname;
    }

    public void setLastname (String lastname) {
        this.lastname = lastname;

    }
}
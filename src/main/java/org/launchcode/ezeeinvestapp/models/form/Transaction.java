package org.launchcode.ezeeinvestapp.models.form;


import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;



@Entity
public class Transaction {
    @Id
    @GeneratedValue
    private int id;

    // creating client instance to establish Many to One relationship

    @ManyToOne
    @JoinColumn(name="client_id")
    private Client client;


    @NotNull
    private LocalDate date;

    @NotNull
    private BigDecimal amount;

    @NotNull
    private Boolean credit;

    @Transient
    private int clientIdToSet;
//    @NotNull
//    private BigDecimal savings;

    // id, date, amount, credit, savings

    // only to set client id for json


    public Transaction() {

    }

    public int getId () {
        return id;
    }

    public void setId (int id) {
        this.id = id;
    }

    public Client getClient () {
        return client;
    }

    public void setClient (Client client) {
        this.client = client;
    }

    public LocalDate getDate () {
        return date;
    }

    public void setDate (LocalDate date) {
        this.date = date;
    }

    public BigDecimal getAmount () {
        return amount;
    }

    public void setAmount (BigDecimal amount) {
        this.amount = amount;
    }

    public Boolean getCredit () {
        return credit;
    }

    public void setCredit (Boolean credit) {
        this.credit = credit;
    }

    public int getClientIdToSet () {
        return clientIdToSet;
    }

    public void setClientIdToSet (int clientIdToSet) {
        this.clientIdToSet = clientIdToSet;
    }
}

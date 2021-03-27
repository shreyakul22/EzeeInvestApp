package org.launchcode.ezeeinvestapp.models.form;


import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;



@Entity
public class Transaction {
    @Id
    @GeneratedValue
    private int id;

    // creating account instance to establish Many to One relationship

    @ManyToOne
    @JoinColumn(name="account_id")
    private Account account;


    @NotNull
    private LocalDate date;

    @NotNull
    private BigDecimal amount;

    @NotNull
    private Boolean credit;

    @Transient
    private int accountIdToSet;
//    @NotNull
//    private BigDecimal savings;

    // id, date, amount, credit, savings

    // only to set account id for json


    public Transaction() {

    }

    public int getId () {
        return id;
    }

    public void setId (int id) {
        this.id = id;
    }

    public Account getAccount () {
        return account;
    }

    public void setAccount (Account account) {
        this.account = account;
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

    public int getAccountIdToSet () {
        return accountIdToSet;
    }

    public void setAccountIdToSet (int accountIdToSet) {
        this.accountIdToSet = accountIdToSet;
    }
}

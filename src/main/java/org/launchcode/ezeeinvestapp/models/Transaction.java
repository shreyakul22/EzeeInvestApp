package org.launchcode.ezeeinvestapp.models;

import javax.persistence.*;
import java.util.List;


@Entity
public class Transaction extends AbstractEntity{

    @ManyToOne
    private Client client;

    @ManyToMany
    private List<Bank> banks;

    public Transaction() {
    }


    public Transaction(Client anClient, List aSkill) {
        super();
        this.client = anClient;
        this.banks = aSkill;
    }

    // Getters and setters.


    public Client getClient() {
        return client;
    }

    public List<Bank> getSkills() {
        return banks;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void setSkills(List<Bank> banks) {
        this.banks = banks;
    }


}
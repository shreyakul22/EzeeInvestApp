package org.launchcode.ezeeinvestapp.models;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Bank extends AbstractEntity {

    @NotBlank(message="Please add a description of banks")
    @Size(max=255)
    private String description;

    @ManyToMany(mappedBy = "banks")
    private List<Transaction> transactions = new ArrayList<>();

    public Bank(){}

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Transaction> getJobs() { return transactions; }

    public void setJobs(List<Transaction> transactions) { this.transactions = transactions;}

}
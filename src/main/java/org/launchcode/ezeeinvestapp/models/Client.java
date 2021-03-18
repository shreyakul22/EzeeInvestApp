package org.launchcode.ezeeinvestapp.models;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Client extends AbstractEntity {

    @NotBlank
    private String location;

    @OneToMany
    @JoinColumn
    private List<Transaction> transactions = new ArrayList<>();

    public Client(){};

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }


}

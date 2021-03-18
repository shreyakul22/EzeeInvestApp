package org.launchcode.ezeeinvestapp.models.data;

import org.launchcode.ezeeinvestapp.models.Client;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends CrudRepository<Client, Integer> {
}






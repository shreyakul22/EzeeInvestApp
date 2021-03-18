package org.launchcode.ezeeinvestapp.models.data;

import org.launchcode.ezeeinvestapp.models.Bank;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankRepository extends CrudRepository<Bank, Integer> {
}

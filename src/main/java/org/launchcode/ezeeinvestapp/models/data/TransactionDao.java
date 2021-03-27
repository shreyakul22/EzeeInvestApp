package org.launchcode.ezeeinvestapp.models.data;

import org.launchcode.ezeeinvestapp.models.form.Transaction;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionDao extends CrudRepository<Transaction, Integer> {
}

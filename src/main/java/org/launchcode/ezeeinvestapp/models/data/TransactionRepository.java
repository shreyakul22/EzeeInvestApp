package org.launchcode.ezeeinvestapp.models.data;

import org.launchcode.ezeeinvestapp.models.Transaction;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface TransactionRepository extends CrudRepository<Transaction, Integer> {
}

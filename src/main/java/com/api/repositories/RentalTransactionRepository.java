package com.api.repositories;

import java.util.Set;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.api.models.RentalTransaction;

@Repository
public interface RentalTransactionRepository extends CrudRepository<RentalTransaction, String> {
	public Set<RentalTransaction> findAll();
}

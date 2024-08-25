package com.api.repositories;

import java.util.Set;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.api.models.RentalItem;

@Repository
public interface RentalItemRepository extends CrudRepository<RentalItem, String>{
	public Set<RentalItem> findAll();
	public RentalItem findByItemId(String itemId);
}

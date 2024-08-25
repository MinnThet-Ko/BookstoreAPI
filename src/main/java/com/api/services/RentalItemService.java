package com.api.services;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.models.RentalItem;
import com.api.repositories.RentalItemRepository;

@Service
public class RentalItemService {

	@Autowired
	private RentalItemRepository rentalItemRepository;
	
	public void saveRentalItem(RentalItem rentalItem) {
		this.rentalItemRepository.save(rentalItem);
	}
	
	public Set<RentalItem> getAllRentalItems() {
		return this.rentalItemRepository.findAll();
	}
}

package com.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.models.RentalItem;
import com.api.models.RentalTransaction;
import com.api.repositories.RentalItemRepository;
import com.api.repositories.RentalTransactionRepository;

import jakarta.transaction.Transactional;

@Service
public class RentalTransactionService {

	@Autowired
	private RentalTransactionRepository rentalTransactionRepository;
	
	@Autowired
	private RentalItemRepository rentalItemRepository;
	
	@Transactional
	public void saveRentalTransaction(RentalTransaction rentalTransaction) {
		this.rentalTransactionRepository.save(rentalTransaction);
		for(RentalItem rentalItem: rentalTransaction.getRentalItems()) {
			RentalItem currentItem = this.rentalItemRepository.findByItemId(rentalItem.getItemId());
			currentItem.reduceItemCount();
			this.rentalItemRepository.save(currentItem);
		}
	}
	
}

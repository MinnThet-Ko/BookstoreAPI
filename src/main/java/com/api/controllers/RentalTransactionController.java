package com.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.models.RentalTransaction;
import com.api.services.RentalTransactionService;

@RestController
@RequestMapping(path = "/rentalTransaction", produces = "application/json")
@CrossOrigin(origins = "*")
public class RentalTransactionController {

	@Autowired
	private RentalTransactionService rentalTransactionService;
	
	@PostMapping(path = "saveTransaction", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void saveRentalTransaction(@RequestBody RentalTransaction rentalTransaction) {
		
		this.rentalTransactionService.saveRentalTransaction(rentalTransaction);
	}
}

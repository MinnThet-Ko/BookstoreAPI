package com.api.controllers;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.models.RentalItem;
import com.api.services.RentalItemService;

@RestController
@RequestMapping(path = "/rentalItem", produces = "application/json")
@CrossOrigin(origins = "*")
public class RentalItemController {

	@Autowired
	private RentalItemService rentalItemService;
	
	@GetMapping(path = "/getAllRentalItems")
	public Set<RentalItem> getAllRentalItems(){
		return this.rentalItemService.getAllRentalItems();
	}
	
	@PostMapping(path = "/saveRentalItem", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void saveRentalItem(@RequestBody RentalItem rentalItem) {
		this.rentalItemService.saveRentalItem(rentalItem);
	}
}

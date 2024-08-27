package com.api.controllers;

import java.util.Set;

import org.apache.commons.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.log.LogAccessor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.models.RentalItem;
import com.api.services.RentalItemService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

@RestController
@RequestMapping(path = "/rentalItem", produces = "application/json")
@CrossOrigin(origins = "*")
public class RentalItemController {

	@Autowired
	private RentalItemService rentalItemService;
	
	@GetMapping(path = "/getAllRentalItems", produces = "application/json")
	public @ResponseBody Set<RentalItem> getAllRentalItems() throws JsonProcessingException{
		Set<RentalItem> rentalItems = this.rentalItemService.getAllRentalItems();
		
		ObjectMapper mapper = new ObjectMapper();
		mapper.enable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
		String responseString = mapper.writeValueAsString(rentalItems);
		System.out.println(responseString);
		return rentalItems;
	}
	
	@PostMapping(path = "/saveRentalItem", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void saveRentalItem(@RequestBody RentalItem rentalItem) {
		this.rentalItemService.saveRentalItem(rentalItem);
	}
}

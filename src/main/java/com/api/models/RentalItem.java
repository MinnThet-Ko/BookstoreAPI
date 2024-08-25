package com.api.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@Entity
@Table(name = "rental_item")
@ToString
public class RentalItem {
	@Id
	@Column(name = "item_id")
	private String itemId;
	
	@Column(name = "rental_rate")
	private double rentalRate;
	
	@Column(name = "available_items")
	private int availableItems;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "isbnNumber")
	private Book book;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name = "transaction_item",
	joinColumns = @JoinColumn(name = "item_id"),
	inverseJoinColumns = @JoinColumn(name = "transaction_id"))
	private RentalTransaction rentalTransaction;
	
	public void reduceItemCount() {
		this.availableItems--;
	}
}

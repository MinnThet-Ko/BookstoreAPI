package com.api.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@Entity
@Table(name = "book")
@ToString
public class Book {
	
	@Id
	@Column(name = "isbn_number")
	private String isbnNumber;
	private String title;
	private String author;
	
//	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//	@JoinColumn(name = "item_id")
//	private RentalItem rentalItem;

}

package com.api.models;

 import java.util.Date;
import java.util.Set;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@Entity
@Table(name = "rental_transaction")
@ToString
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class RentalTransaction {
	
	@Id
	@Column(name = "transaction_id")
	private String transactionId;
	
	@Column(name = "start_date")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date startDate;
	
	@Column(name = "end_date")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date endDate;
	
	@Column(name = "total_fees")
	private double totalFees;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name = "transaction_item",
	joinColumns = @JoinColumn(name = "transaction_id"),
	inverseJoinColumns = @JoinColumn(name = "item_id"))
	private Set<RentalItem> rentalItems;
}

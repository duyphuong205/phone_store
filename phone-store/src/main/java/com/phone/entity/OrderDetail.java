package com.phone.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Setter
@Getter
@Entity
@Table(name = "order_details")
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OrderDetail implements Serializable {

	private static final long serialVersionUID = -1705231188251117243L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	Double price;
	Integer quantity;
	
	@ManyToOne
	@JoinColumn(name = "orderId", referencedColumnName = "id")
	@JsonIgnoreProperties
	Order order;
	
	@ManyToOne
	@JoinColumn(name = "productId", referencedColumnName = "id")
	@JsonIgnoreProperties
	Product product;
	
}

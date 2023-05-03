package com.phone.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.phone.entity.base.BaseEntity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Setter
@Getter
@Entity
@Table(name = "products")
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Product extends BaseEntity implements Serializable {

	private static final long serialVersionUID = -5441060967409779677L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	String name;
	Integer quantity;
	Double price;
	String slug;
	Float discount;
	Integer selled;
	Integer view;
	String description;

	@ManyToOne
	@JoinColumn(name = "categoryId", referencedColumnName = "id")
	@JsonIgnoreProperties
	Category category;
	
	@OneToMany(mappedBy = "product")
	@JsonIgnore
	List<MultipleImages> multipleImage;
	
	@OneToMany(mappedBy = "product")
	@JsonIgnore
	List<OrderDetail> orderDetail;
	
	

}

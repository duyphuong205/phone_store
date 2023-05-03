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
@Table(name = "orders")
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Order extends BaseEntity implements Serializable {


	private static final long serialVersionUID = -3216098580149021036L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	String address;
	String phone;
	
	@ManyToOne
	@JoinColumn(name = "userId", referencedColumnName = "id")
	@JsonIgnoreProperties
	User user;
	
	@ManyToOne
	@JoinColumn(name = "orderStatusId", referencedColumnName = "id")
	@JsonIgnoreProperties
	OrderStatus orderStatus;
	

	@OneToMany(mappedBy = "order")
	@JsonIgnore
	List<OrderDetail> orderDetail;
	
}

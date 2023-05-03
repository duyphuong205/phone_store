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
@Table(name = "multiple_images")
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MultipleImages extends BaseEntity implements Serializable {

	private static final long serialVersionUID = -9189422815627751113L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	String imageUrl;

	@ManyToOne
	@JoinColumn(name = "productId", referencedColumnName = "id")
	@JsonIgnoreProperties
	Product product;
}

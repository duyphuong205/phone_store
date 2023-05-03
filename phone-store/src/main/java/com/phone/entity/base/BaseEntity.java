package com.phone.entity.base;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;

import com.phone.constants.ActiveConstant;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@MappedSuperclass
public class BaseEntity implements Serializable {

	private static final long serialVersionUID = 58509211609376467L;

	@CreatedBy
	@Column(insertable = true, updatable = false)
	String createBy;

	@LastModifiedBy
	@Column(insertable = false, updatable = true)
	String updateBy;

	@CreationTimestamp
	@Column(insertable = true, updatable = false)
	Timestamp createDate;

	@UpdateTimestamp
	@Column(insertable = false, updatable = true)
	Timestamp updateDate;

	Boolean isActive = ActiveConstant.ENABLE;
}

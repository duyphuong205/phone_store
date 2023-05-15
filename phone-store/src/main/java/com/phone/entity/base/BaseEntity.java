package com.phone.entity.base;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;

import com.phone.constants.ActiveConstant;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Setter
@Getter
@MappedSuperclass
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BaseEntity implements Serializable {

	private static final long serialVersionUID = 58509211609376467L;

	@CreatedBy
	@Column(name = "createdBy", updatable = false)
	private String createdBy;

	@LastModifiedBy
	@Column(name = "updatedBy", insertable = false)
	private String updatedBy;

	@CreationTimestamp
	@Column(name = "createDate", updatable = false, insertable = true)
	@Temporal(TemporalType.TIMESTAMP)
	protected Date createDate;

	@UpdateTimestamp
	@Column(name = "updateDate", insertable = false, updatable = true)
	@Temporal(TemporalType.TIMESTAMP)
	private Date updateDate;

	@Column(name = "isActive")
	Boolean isActive = ActiveConstant.ENABLE;
}

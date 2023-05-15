package com.phone.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 3379374994275165380L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	@NotBlank(message = "Tên người dùng không được trống!")
	String username;
	@NotBlank(message = "Mật khẩu không được trống!")
	String password;
	@NotBlank(message = "Họ tên người dùng không được trống!")
	String fullname;
	@NotBlank(message = "Email người dùng không được trống!")
	@Email(message = "Không đúng định dạng email!")
	String email;
	String avatarUrl;

	@OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
	@JsonIgnore
	List<UserRole> userRoles;

	@OneToMany(mappedBy = "user")
	@JsonIgnore
	List<Order> orders;
}

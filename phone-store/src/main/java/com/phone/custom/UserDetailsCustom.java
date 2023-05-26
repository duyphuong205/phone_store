package com.phone.custom;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.phone.entity.User;
import com.phone.entity.UserRole;

public class UserDetailsCustom implements UserDetails {

	private static final long serialVersionUID = -3001260887548963467L;

	private User user;

	public UserDetailsCustom(User user) {
		this.user = user;
	}

	//lấy thông tin người dùng đăng nhập có vài trò từ db -> add vô hệ thống security(phân quyền)
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<UserRole> userRole = user.getUserRoles();
		List<SimpleGrantedAuthority> roles = new ArrayList<>();
		for (UserRole ur : userRole) {
			roles.add(new SimpleGrantedAuthority("ROLE_" + ur.getRole().getName()));
		}
		return roles;
	}

	@Override
	public String getPassword() {
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		return user.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}

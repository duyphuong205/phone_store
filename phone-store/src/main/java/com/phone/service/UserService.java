package com.phone.service;

import com.phone.entity.User;
import com.phone.service.base.BaseService;

public interface UserService extends BaseService<User>{
	User register(User user);
	User getByUsername(String username);
	User getByEmail(String email);
}

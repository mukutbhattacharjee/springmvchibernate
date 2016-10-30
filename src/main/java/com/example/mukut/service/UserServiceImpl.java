package com.example.mukut.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mukut.dao.UserDaoImpl;
import com.example.mukut.entity.User;


public class UserServiceImpl implements UserService {
	
	UserDaoImpl daoImpl;

	public UserDaoImpl getDaoImpl() {
		return daoImpl;
	}

	public void setDaoImpl(UserDaoImpl daoImpl) {
		this.daoImpl = daoImpl;
	}

	@Transactional
	public void saveUser(User user) {
		System.out.println("in service");
		getDaoImpl().saveUser(user);
	}

}

package com.rmbin.jpa.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.rmbin.jpa.entity.User;

@Repository
public class UserRepository{
	
	@PersistenceContext 
	private EntityManager entityManager;
	
	public List<User> findAll()
	{
		return this.entityManager.createQuery("SELECT * from user t",User.class).getResultList();
	}
	
	public User getUserByUserName(String userName)
	{
		return this.entityManager.createQuery("SELECT * FROM user where userName = '" +userName + "'",User.class).getSingleResult();
	}

}

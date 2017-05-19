package fr.malkav.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import fr.malkav.modele.entity.User;

@Repository
public class UserDaoImpl implements IUserDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public User getById(int userId) {
		return entityManager.find(User.class, userId);
	}
}

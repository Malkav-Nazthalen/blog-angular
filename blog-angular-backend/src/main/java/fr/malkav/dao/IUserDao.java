package fr.malkav.dao;

import fr.malkav.modele.entity.User;

public interface IUserDao {

	User getById(int userId);

}

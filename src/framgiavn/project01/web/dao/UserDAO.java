package framgiavn.project01.web.dao;

import framgiavn.project01.web.model.User;

public interface UserDAO {
	public User findByUserId(Integer user_id);

	public User findByUsername(String username);
}
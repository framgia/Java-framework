package framgiavn.project01.web.business.impl;

import framgiavn.project01.web.business.UserBusiness;
import framgiavn.project01.web.dao.UserDAO;
import framgiavn.project01.web.info.UserInfo;
import framgiavn.project01.web.model.User;

public class UserBusinessImpl implements UserBusiness {

	private UserDAO userDAO;

	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	@Override
	public UserInfo findByUserId(Integer user_id) {
		try {
//			return getUserDAO().findByUserId(user_id);
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public UserInfo findByUsername(String username) {
		try {
//			return getUserDAO().findByUsername(username);
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

}
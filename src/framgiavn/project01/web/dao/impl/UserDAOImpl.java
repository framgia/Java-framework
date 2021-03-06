package framgiavn.project01.web.dao.impl;

import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.SessionFactory;

import framgiavn.project01.web.dao.UserDAO;
import framgiavn.project01.web.model.User;
import framgiavn.project01.web.ulti.Logit2;

public class UserDAOImpl implements UserDAO {

	private static final Logit2 log = Logit2.getInstance(UserDAOImpl.class);
	public SessionFactory sessionFactory;

	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	protected void initDAO() {
		// Do nothing
	}

	@Override
	public User findByUserId(Integer user_id) {
		return findByUserId(user_id, false);
	}

	public User findByUserId(Integer user_id, boolean lock) {
		try {
			Query query = sessionFactory.getCurrentSession().getNamedQuery("User.SelectUserByUserId");
			if (lock)
				query.setLockMode("User", LockMode.UPGRADE);
			query.setParameter("user_id", user_id);
			return (User) query.uniqueResult();
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	@Override
	public User findByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}

}
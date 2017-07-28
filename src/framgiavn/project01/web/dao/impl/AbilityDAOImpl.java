package framgiavn.project01.web.dao.impl;

import org.hibernate.SessionFactory;

import framgiavn.project01.web.dao.AbilityDAO;
import framgiavn.project01.web.model.Ability;
import framgiavn.project01.web.ulti.Logit2;

public class AbilityDAOImpl implements AbilityDAO{

	private static final Logit2 log = Logit2.getInstance(AbilityDAOImpl.class);
	public SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public Ability findAbilityByName(String name) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Ability findAbilityById(int id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addAbility(Ability a) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteAbility(Ability a) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}
	
}

package framgiavn.project01.web.dao;

import framgiavn.project01.web.model.Ability;

public interface AbilityDAO {
	public Ability findAbilityByName(String name) throws Exception;
	public Ability findAbilityById(int id) throws Exception;
	public boolean addAbility(Ability a) throws Exception;
	public boolean deleteAbility(Ability a) throws Exception;
}

package framgiavn.project01.web.business;

import framgiavn.project01.web.info.UserInfo;
import framgiavn.project01.web.model.User;

public interface UserBusiness {
	public UserInfo findByUserId(Integer user_id);

	public UserInfo findByUsername(String username);
}
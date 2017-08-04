package mvs.service.impl;

import mvs.model.Role;
import mvs.model.User;
import mvs.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	UserRepository userRepository;
	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUsername(username);
		if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
		
		Set<GrantedAuthority> grantedAuthorities = new HashSet<GrantedAuthority>();
		Set<Role> roles = user.getRoles();
		for (Role role : roles) {
			grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
		}
		
		return new org.springframework.security.core.userdetails.User(
				user.getUsername(), user.getPassword(), grantedAuthorities);
	}

}

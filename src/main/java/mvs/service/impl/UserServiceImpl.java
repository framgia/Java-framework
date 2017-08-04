package mvs.service.impl;


import mvs.model.Role;
import mvs.model.User;
import mvs.repository.RoleRepository;
import mvs.repository.UserRepository;
import mvs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void save(User user) {
       userRepository.save(user);
    }

    @Override
    public void saveAndGrantRole(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        HashSet<Role> roles = new HashSet<Role>();
        roles.add(roleRepository.findByName("ROLE_MEMBER"));
        user.setRoles(roles);
        userRepository.save(user);

    }


    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public User getCurentUser() {
        User user=userRepository.findByUsername( SecurityContextHolder.getContext().getAuthentication().getName() );

        return user;
    }
}

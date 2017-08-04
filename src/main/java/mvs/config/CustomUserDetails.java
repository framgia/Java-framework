package mvs.config;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

/**
 * Created by quangminh on 25/07/2017.
 */
public class CustomUserDetails extends User {
    public CustomUserDetails(String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
    }
    private String firstName;
    private String lastName;
}

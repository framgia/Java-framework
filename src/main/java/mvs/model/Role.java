package mvs.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * Created by quangminh on 27/06/2017.
 */
@Entity
public class Role {
    @Id
    @GeneratedValue
    Long id;

    @Column(name = "name", nullable = false)
    String name;


    @ManyToMany(mappedBy = "roles")
    private Set<User> users;

    public Role(String name) {
        this.name = name;
    }

    public Role() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}

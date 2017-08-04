package mvs.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by quangminh on 31/07/2017.
 */
@Entity
public class Category {

    @Id
    @GeneratedValue
    Long id;

    String name;


    @ManyToMany(mappedBy = "categories")
    List<Post> posts;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Category() {
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }
}

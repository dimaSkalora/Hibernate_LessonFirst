package lesson_13.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="user")
public class User extends Model {
    private static final long serialVersionUID = -5845118151518L;

    @Column(name="age")
    private int age;
    @Column(name = "firstname",length = 50)
    private String firstname;
    @Column(name = "lastname", length = 50)
    private String lastname;

    @ManyToMany
    @JoinTable(name="user_role",
            joinColumns=@JoinColumn(name="user_id"),
    inverseJoinColumns=@JoinColumn(name="role_id"))
    private Set<Role> roles = new HashSet<Role>();

    public User(){
        super();
    }
    public User(Long id){
        super((id));
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}

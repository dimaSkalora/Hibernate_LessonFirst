package mapping_annotation;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name="user")
public class User implements Serializable{
    private static final long serialVersionUID = -5845118151518L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id",length = 11)
    private long id;
    @Column(name="age")
    private int age;
    @Column(name = "firstname",length = 50)
    private String firstname;
    @Column(name = "lastname", length = 50)
    private String lastname;

    public User(){

    }

    public User(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

}

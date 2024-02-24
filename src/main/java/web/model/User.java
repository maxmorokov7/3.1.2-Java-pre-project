package web.model;



import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;
    @Column
    @NotEmpty(message = "The name cannot be empty")
    @Size(min=2,max=45, message = "Enter from 2 to 45 characters")
    private String name;
    @Column
    @NotEmpty(message = "The surname cannot be empty")
    @Size(min=2,max=45, message = "Enter from 2 to 45 characters")
    private String surname;
    @Column
    @NotNull(message = "The age cannot be null")
    @Min(value = 14, message = "The age cannot be less than 14 years old")
    private Integer age;
    @Column
    private String department;

    public User() {
    }

    public User(Integer id, String name, String surname, int age, String department) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.department = department;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", department='" + department + '\'' +
                '}';
    }
}

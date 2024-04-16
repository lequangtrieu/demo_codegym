package codegym.model;

import javax.annotation.Generated;
import javax.persistence.*;

@Entity
@NamedQueries({
        @NamedQuery(
                name = "searchByAddress",
                query = "select s from Student s where s.address like :address"
        ),
        @NamedQuery(
                name = "searchByName",
                query = "select s from Student s where s.name like :name"
        ),
})
public class Student {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private int age;
    @Column(name = "DiaChi")
    private String address;

    public Student() {
    }

    public Student(int id, String name, int age, String address) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}

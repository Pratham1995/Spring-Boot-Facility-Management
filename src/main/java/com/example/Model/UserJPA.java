package com.example.Model;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name="user", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class UserJPA {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="firstname")
    private String firstname;
    @Column(name="lastname")
    private String lastname;
    @Column(name="email")
    private String email;
    private String password;

    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinTable(
            name="user_role",
            joinColumns = @JoinColumn(
                    name="user_id",referencedColumnName = "id"
            ),
            inverseJoinColumns = @JoinColumn(
                    name="role_id",referencedColumnName = "id"
            )

    )
    private Collection<RoleJPA> roles;

    public UserJPA() {
    }

    public UserJPA(String firstname, String lastname, String email, String password, Collection<RoleJPA> roles) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
        this.roles = roles;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Collection<RoleJPA> getRoles() {
        return roles;
    }

    public void setRoles(Collection<RoleJPA> roles) {
        this.roles = roles;
    }
}

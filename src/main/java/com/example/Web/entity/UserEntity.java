package com.example.Web.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Basic
    @Column(name = "username", nullable = false, length = -1)
    private String username;

    @Basic
    @Column(name = "userpassword", nullable = false, length = -1)
    private String userpassword;

    @ManyToMany(cascade = {CascadeType.MERGE,CascadeType.PERSIST},fetch = FetchType.EAGER)
    @JoinTable(name = "users_roles",joinColumns = @JoinColumn(name="user_id"),inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<RoleEntity> roles=new HashSet<>();

    public void addRole(RoleEntity role){
        this.roles.add(role);
    }

    public void addRoles(List<RoleEntity> roles){
        this.roles.addAll(roles);
    }

    public void removeRole(RoleEntity role){
        this.roles.remove(role);
    }
}

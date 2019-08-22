package com.gok.waybill.waybillservice.data.model.user;


import com.gok.waybill.waybillservice.data.model.Model;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@Entity
@Table(name = "user")
public class User extends Model {

    public User(Integer id, boolean isDeleted, String login, String password, Role role) {
        super(id, isDeleted);
        this.login = login;
        this.password = password;
        this.role = role;
    }

    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private String password;

    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private Role role;

    public User() {
    }
}
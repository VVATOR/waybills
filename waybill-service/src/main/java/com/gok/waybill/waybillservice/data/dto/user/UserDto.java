package com.gok.waybill.waybillservice.data.dto.user;


import com.gok.waybill.waybillservice.constants.UserRole;
import com.gok.waybill.waybillservice.data.dto.Dto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class UserDto extends Dto {

    public UserDto(Integer id, boolean isDeleted, String login, String password, UserRole role) {
        super(id, isDeleted);
        this.login = login;
        this.password = password;
        this.role = role;
    }

    private String login;

    private String password;

    private UserRole role;

    public UserDto() {
    }
}

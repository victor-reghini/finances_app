package br.com.victor.finances_app.dto;

import br.com.victor.finances_app.entity.User;
import lombok.Getter;

import java.io.Serializable;

@Getter
public class UserDTO implements Serializable {
    private Long id;
    private String name;

    public UserDTO fromUser(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.id = user.getId();
        userDTO.name = user.getName();
        return userDTO;
    }
}

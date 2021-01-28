package com.fuini.sd.web.service.User;

import com.fiuni.sd.DTO.User.UserDTO;
import com.fuini.sd.web.beans.User.UserB;
import com.fuini.sd.web.service.Base.IBaseService;

import java.util.List;

public interface IUserService extends IBaseService<UserB, UserDTO> {

    UserB update(UserB updateBean);

    Integer getCPages();

    UserB delete(Integer id);

    UserB toBean(UserDTO userDTO);

    UserDTO toDTO(UserB user);

    List<UserB> getUsers();

    UserB getByUserName(String userName);
}

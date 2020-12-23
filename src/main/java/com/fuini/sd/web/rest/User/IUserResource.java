package com.fuini.sd.web.rest.User;

import com.fiuni.sd.DTO.User.UserDTO;
import com.fiuni.sd.DTO.User.UserResult;
import com.fuini.sd.web.rest.Base.IBaseResource;

public interface IUserResource extends IBaseResource<UserDTO> {

    UserResult getAll(Integer page);

    UserDTO update(UserDTO DTO);

    UserDTO delete(Integer id);

    UserResult getUsers();
}

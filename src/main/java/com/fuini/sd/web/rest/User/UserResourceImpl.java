package com.fuini.sd.web.rest.User;

import com.fiuni.sd.DTO.User.UserDTO;
import com.fiuni.sd.DTO.User.UserResult;
import com.fuini.sd.web.rest.Base.BaseResourceImpl;
import org.springframework.stereotype.Repository;

@Repository("userResource")
public class UserResourceImpl extends BaseResourceImpl<UserDTO> implements IUserResource {

    public UserResourceImpl() {
        super(UserDTO.class, "users");
    }

    @Override
    public UserResult getAll(Integer page) {
        System.out.println("all -> " + getWebResource().path("/page/" + page).toString());
        return getWebResource().path("/page/" + page).get(UserResult.class);
    }

    @Override
    public UserDTO update(UserDTO userDTO) {
        System.out.println("update -> " + getWebResource().path("/" + UserDTO.getId()).toString());
        UserDTO updateDTO = getWebResource().path("/" + userDTO.getId()).entity(userDTO).put(getDTOClass());
        return updateDTO;
    }

    @Override
    public UserDTO delete(Integer id) {
        System.out.println("delete -> " + getWebResource().path("/" + id).toString());
        UserDTO DTO = getWebResource().path("/" + id).delete(getDTOClass());
        return DTO;
    }

    @Override
    public UserResult getUsers() {
        System.out.println("all -> " + getWebResource().path("/all").toString());
        return getWebResource().path("/all").get(UserResult.class);
    }
}

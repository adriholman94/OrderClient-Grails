package com.fuini.sd.web.rest.Role;

import com.fiuni.sd.DTO.Role.RoleDTO;
import com.fiuni.sd.DTO.Role.RoleResult;
import com.fuini.sd.web.rest.Base.BaseResourceImpl;
import org.springframework.stereotype.Repository;

@Repository("roleResource")
public class RoleResourceImpl extends BaseResourceImpl<RoleDTO> implements IRoleResource {

    public RoleResourceImpl() {
        super(RoleDTO.class, "roles");
    }

    @Override
    public RoleResult getAll(Integer page) {
        System.out.println("all -> " + getWebResource().path("/page/" + page).toString());
        return getWebResource().path("/page/" + page).get(RoleResult.class);
    }

    @Override
    public RoleDTO update(RoleDTO RoleDTO) {
        System.out.println("update -> " + getWebResource().path("/" + roleDTO.getId()).toString());
        RoleDTO updateDTO = getWebResource().path("/" + roleDTO.getId()).entity(roleDTO).put(getDTOClass());
        return updateDTO;
    }

    @Override
    public RoleDTO delete(Integer id) {
        System.out.println("delete -> " + getWebResource().path("/" + id).toString());
        RoleDTO DTO = getWebResource().path("/" + id).delete(getDTOClass());
        return DTO;
    }

    @Override
    public RoleResult getRoles() {
        System.out.println("all -> " + getWebResource().path("/all").toString());
        return getWebResource().path("/all").get(RoleResult.class);
    }
}

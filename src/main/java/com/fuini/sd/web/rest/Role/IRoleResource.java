package com.fuini.sd.web.rest.Role;

import com.fiuni.sd.DTO.Role.RoleDTO;
import com.fiuni.sd.DTO.Role.RoleResult;
import com.fuini.sd.web.rest.Base.IBaseResource;

public interface IRoleResource extends IBaseResource<RoleDTO> {

    RoleResult getAll(Integer page);

    RoleDTO update(RoleDTO DTO);

    RoleDTO delete(Integer id);

    RoleResult getRoles();
}

package com.fuini.sd.web.Role;

import com.fiuni.sd.DTO.Role.RoleDTO;
import com.fuini.sd.web.beans.Role.RoleB;
import com.fuini.sd.web.service.Base.IBaseService;
import java.util.List;


public interface IRoleService extends IBaseService<RoleB, RoleDTO> {

    RoleB update(RoleB updateBean);

    Integer getCPages();

    RoleB delete(Integer id);

    RoleB toBean(RoleDTO DTO);

    RoleDTO toDTO(RoleB role);

    List<RoleB> getRoles();
}

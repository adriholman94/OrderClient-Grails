package com.fuini.sd.web.Role;

import com.fiuni.sd.DTO.Role.RoleDTO;
import com.fiuni.sd.DTO.Role.RoleResult;
import com.fuini.sd.web.beans.Role.RoleB;
import com.fuini.sd.web.rest.Role.IRoleResource;
import com.fuini.sd.web.service.Base.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("roleService")
public class RoleServiceImpl extends BaseServiceImpl<RoleB, RoleDTO> implements IRoleService {

    @Autowired
    private IRoleResource roleResource;

    private Integer pages;

    @Override
    protected RoleB convertDtoToBean(RoleDTO dto) {
        final Map<String, String> params = new HashMap<>();
        params.put("id", String.valueOf(dto.getId()));
        params.put("roleName", dto.getRoleName());
        return new RoleB(params);
    }

    @Override
    protected RoleDTO convertBeanToDto(RoleB bean) {
        final RoleDTO DTO = new RoleDTO();
        DTO.setId(bean.getId());
        DTO.setRoleName(bean.getRoleName());
        return DTO;
    }

    @Override
    public RoleB getById(Integer id) {
        final RoleDTO roleDTO = roleResource.getById(id);
        return convertDtoToBean(roleDTO);
    }

    @Override
    public List<RoleB> getAll(Integer page) {
        final RoleResult result = roleResource.getAll(page);
        final List<RoleDTO> dto = null == result.getRoles() ? new ArrayList<>() : result.getRoles();
      //  setCPages(result.getPages());
        final List<RoleB> roles = new ArrayList<>();
        dto.forEach(c -> roles.add(convertDtoToBean(c)));
        return roles;
    }

    @Override
    public RoleB save(RoleB bean) {
        final RoleDTO dto = convertBeanToDto(bean);
        return convertDtoToBean(roleResource.save(dto));
    }

    @Override
    public RoleB update(RoleB updateBean) {
        final RoleDTO dto = convertBeanToDto(updateBean);
        return convertDtoToBean(roleResource.update(dto));
    }

    @Override
    public Integer getCPages() {
        return pages;
    }
    public void setCPages(Integer pages) {
        this.pages = pages;
    }

    @Override
    public RoleB delete(Integer id) {
        RoleDTO dto = roleResource.delete(id);
        return dto.getId() == null ? null : convertDtoToBean(dto);
    }

    public RoleB toBean(RoleDTO roleDTO){
        return convertDtoToBean(roleDTO);
    }

    @Override
    public RoleDTO toDTO(RoleB role) {
        return convertBeanToDto(role);
    }

    @Override
    public List<RoleB> getRoles() {
        final RoleResult result = roleResource.getRoles();
        final List<RoleDTO> cList = null == result.getRoles() ? new ArrayList<>() : result.getRoles();
        final List<RoleB> roles = new ArrayList<>();
        for (RoleDTO dto : cList) {
            roles.add(convertDtoToBean(dto));
        }
        return roles;
    }
}

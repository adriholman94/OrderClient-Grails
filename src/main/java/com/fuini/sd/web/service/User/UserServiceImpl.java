package com.fuini.sd.web.service.User;

import com.fiuni.sd.DTO.User.UserDTO;
import com.fiuni.sd.DTO.User.UserResult;
import com.fuini.sd.web.beans.User.UserB;
import com.fuini.sd.web.rest.User.IUserResource;
import com.fuini.sd.web.service.Base.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("userService")
public class UserServiceImpl extends BaseServiceImpl<UserB, UserDTO> implements IUserService {

    @Autowired
    private IUserResource userResource;

    private Integer pages;

    @Override
    protected UserB convertDtoToBean(UserDTO dto) {
        final Map<String, String> params = new HashMap<>();
        params.put("id", String.valueOf(dto.getId()));
        params.put("userName", dto.getUserName());
        return new UserB(params);
    }

    @Override
    protected UserDTO convertBeanToDto(UserB bean) {
        final UserDTO DTO = new UserDTO();
        DTO.setId(bean.getId());
        DTO.setUserName(bean.getUserName());
        return DTO;
    }

    @Override
    public UserB getById(Integer id) {
        final UserDTO userDTO = userResource.getById(id);
        return convertDtoToBean(userDTO);
    }

    @Override
    public List<UserB> getAll(Integer page) {
        final UserResult result = userResource.getAll(page);
        final List<UserDTO> dto = null == result.getUsers() ? new ArrayList<>() : result.getUsers();
        setCPages(result.getPages());
        final List<UserB> users = new ArrayList<>();
        dto.forEach(c -> users.add(convertDtoToBean(c)));
        return users;
    }

    @Override
    public UserB save(UserB bean) {
        final UserDTO dto = convertBeanToDto(bean);
        return convertDtoToBean(userResource.save(dto));
    }

    @Override
    public UserB update(UserB updateBean) {
        final UserDTO dto = convertBeanToDto(updateBean);
        return convertDtoToBean(userResource.update(dto));
    }

    @Override
    public Integer getCPages() {
        return pages;
    }

    public void setCPages(Integer pages) {
        this.pages = pages;
    }

    @Override
    public UserB delete(Integer id) {
        UserDTO dto = userResource.delete(id);
        return dto.getId() == null ? null : convertDtoToBean(dto);
    }

    public UserB toBean(UserDTO userDTO){
        return convertDtoToBean(userDTO);
    }

    @Override
    public UserDTO toDTO(UserB user) {
        return convertBeanToDto(user);
    }

    @Override
    public List<UserB> getUsers() {
        final UserResult result = userResource.getUsers();
        final List<UserDTO> cList = null == result.getUsers() ? new ArrayList<>() : result.getUsers();
        final List<UserB> users = new ArrayList<>();
        for (UserDTO dto : cList) {
            users.add(convertDtoToBean(dto));
        }
        return users;
    }
}

package com.fuini.sd.web.service.Base;

import com.fiuni.sd.DTO.Base.BaseDTO;
import com.fuini.sd.web.beans.Base.BaseBean;

import java.util.List;

public interface IBaseService<BEAN extends BaseBean, DTO extends BaseDTO> {

    BEAN getById(Integer id);

    List<BEAN> getAll(Integer page);

    BEAN save(BEAN bean);
}

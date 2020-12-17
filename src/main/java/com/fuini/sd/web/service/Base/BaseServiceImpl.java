package com.fuini.sd.web.service.Base;

import com.fiuni.sd.DTO.Base.BaseDTO;
import com.fuini.sd.web.beans.Base.BaseBean;

public abstract class BaseServiceImpl<BEAN extends BaseBean, DTO extends BaseDTO> implements IBaseService<BEAN, DTO> {

    protected abstract BEAN convertDtoToBean(DTO dto);

    protected abstract DTO convertBeanToDto(BEAN bean);

}

package com.fuini.sd.web.rest.Base;

import com.fiuni.sd.DTO.Base.BaseDTO;

public interface IBaseResource<DTO extends BaseDTO> {

    DTO save(DTO dto);

    DTO getById(Integer id);
}

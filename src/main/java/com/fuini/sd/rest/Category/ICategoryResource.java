package com.fuini.sd.rest.Category;

import com.fiuni.sd.DTO.Category.CategoryDTO;
import com.fiuni.sd.DTO.Category.CategoryResult;
import com.fuini.sd.rest.Base.IBaseResource;

public interface ICategoryResource extends IBaseResource<CategoryDTO> {

    CategoryResult getAll(Integer page);

    CategoryResult getCategories();
}

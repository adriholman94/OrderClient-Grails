package com.fuini.sd.web.service.Category;

import com.fiuni.sd.DTO.Category.CategoryDTO;
import com.fuini.sd.web.beans.Category.CategoryB;
import com.fuini.sd.web.service.Base.IBaseService;

import java.util.List;

public interface ICategoryService extends IBaseService<CategoryB, CategoryDTO> {

    CategoryB update(CategoryB updateBean);

    Integer getCPages();

    CategoryB delete(Integer id);

    CategoryB toBean(CategoryDTO categoryDTO);

    CategoryDTO toDTO(CategoryB category);

    List<CategoryB> getCategories();
}

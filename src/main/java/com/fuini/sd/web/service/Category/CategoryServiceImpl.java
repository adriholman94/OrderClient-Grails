package com.fuini.sd.web.service.Category;

import com.fiuni.sd.DTO.Category.CategoryDTO;
import com.fiuni.sd.DTO.Category.CategoryResult;
import com.fuini.sd.web.beans.Category.CategoryB;
import com.fuini.sd.web.rest.Category.ICategoryResource;
import com.fuini.sd.web.service.Base.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

public class CategoryServiceImpl extends BaseServiceImpl<CategoryB, CategoryDTO> implements ICategoryService {

    @Autowired
    private ICategoryResource categoryResource;

    @Override
    protected CategoryB convertDtoToBean(CategoryDTO dto) {
        final Map<String, String> params = new HashMap<String, String>();
        params.put("id", String.valueOf(dto.getId()));
        params.put("categoryName", dto.getCategoryName());
        final CategoryB c = new CategoryB(params);
        return c;
    }

    @Override
    protected CategoryDTO convertBeanToDto(CategoryB bean) {
        final CategoryDTO DTO = new CategoryDTO();
        DTO.setId(bean.getId());
        DTO.setCategoryName(bean.getCategoryName());
        return DTO;
    }

    @Override
    public CategoryB getById(Integer id) {
        final CategoryDTO categoryDTO = categoryResource.getById(id);
        return convertDtoToBean(categoryDTO);
    }

    @Override
    public List<CategoryB> getAll(Integer page) {
        final CategoryResult result = categoryResource.getAll(page);
        final List<CategoryDTO> dto = null == result.getCategories() ? new ArrayList<CategoryDTO>() : result.getCategories();
        final List<CategoryB> categories = new ArrayList<CategoryB>();
        dto.forEach(c -> categories.add(convertDtoToBean(c)));
        return categories;
    }

    @Override
    public CategoryB save(CategoryB bean) {
        final CategoryDTO dto = convertBeanToDto(bean);
        return convertDtoToBean(categoryResource.save(dto));
    }
}

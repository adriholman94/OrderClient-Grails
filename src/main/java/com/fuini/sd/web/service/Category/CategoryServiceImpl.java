package com.fuini.sd.web.service.Category;

import com.fiuni.sd.DTO.Category.CategoryDTO;
import com.fiuni.sd.DTO.Category.CategoryResult;
import com.fuini.sd.web.beans.Category.CategoryB;
import com.fuini.sd.web.rest.Category.ICategoryResource;
import com.fuini.sd.web.service.Base.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("categoryService")
public class CategoryServiceImpl extends BaseServiceImpl<CategoryB, CategoryDTO> implements ICategoryService {

    @Autowired
    private ICategoryResource categoryResource;

    private Integer pages;

    @Override
    protected CategoryB convertDtoToBean(CategoryDTO dto) {
        final Map<String, String> params = new HashMap<>();
        params.put("id", String.valueOf(dto.getId()));
        params.put("categoryName", dto.getCategoryName());
        return new CategoryB(params);
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
        final List<CategoryDTO> dto = null == result.getCategories() ? new ArrayList<>() : result.getCategories();
        setCPages(result.getPages());
        final List<CategoryB> categories = new ArrayList<>();
        dto.forEach(c -> categories.add(convertDtoToBean(c)));
        return categories;
    }

    @Override
    public CategoryB save(CategoryB bean) {
        final CategoryDTO dto = convertBeanToDto(bean);
        return convertDtoToBean(categoryResource.save(dto));
    }

    @Override
    public CategoryB update(CategoryB updateBean) {
        final CategoryDTO dto = convertBeanToDto(updateBean);
        return convertDtoToBean(categoryResource.update(dto));
    }

    @Override
    public Integer getCPages() {
        return pages;
    }

    public void setCPages(Integer pages) {
        this.pages = pages;
    }

    @Override
    public CategoryB delete(Integer id) {
        CategoryDTO dto = categoryResource.delete(id);
        return dto.getId() == null ? null : convertDtoToBean(dto);
    }

    public CategoryB toBean(CategoryDTO categoryDTO){
        return convertDtoToBean(categoryDTO);
    }

    @Override
    public CategoryDTO toDTO(CategoryB category) {
        return convertBeanToDto(category);
    }
}

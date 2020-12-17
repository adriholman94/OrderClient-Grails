package com.fuini.sd.rest.Category;

import com.fiuni.sd.DTO.Category.CategoryDTO;
import com.fiuni.sd.DTO.Category.CategoryResult;
import com.fuini.sd.rest.Base.BaseResourceImpl;
import org.springframework.stereotype.Repository;

@Repository("categoryResource")
public class CategoryResourceImpl extends BaseResourceImpl<CategoryDTO> implements ICategoryResource{
    public CategoryResourceImpl() {
        super(CategoryDTO.class, "categories");
    }

    @Override
    public CategoryResult getAll(Integer page) {
        return getWebResource().path("/" + page + "/" + 20).get(CategoryResult.class);
    }

    @Override
    public CategoryResult getCategories() {
        return getWebResource().path("/" + 1 + "/" + 200).get(CategoryResult.class);
    }
}
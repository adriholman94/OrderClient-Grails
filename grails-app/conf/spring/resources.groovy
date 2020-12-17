import com.fuini.sd.web.rest.Category.CategoryResourceImpl
import com.fuini.sd.web.service.Category.CategoryServiceImpl

// Place your Spring DSL code here
beans = {
    //Resources
    categoryResource(CategoryResourceImpl)

    //Services
    categoryService(CategoryServiceImpl)
}

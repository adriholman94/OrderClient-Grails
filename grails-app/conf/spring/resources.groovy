import com.fuini.sd.web.rest.Category.CategoryResourceImpl
import com.fuini.sd.web.service.Category.CategoryServiceImpl
import com.fuini.sd.web.rest.Supplier.SupplierResourceImpl
import com.fuini.sd.web.service.Supplier.SupplierServiceImpl

// Place your Spring DSL code here
beans = {
    //Resources
    categoryResource(CategoryResourceImpl)
    supplierResource(SupplierResourceImpl)
    //Services
    categoryService(CategoryServiceImpl)
    supplierService(SupplierServiceImpl)
}

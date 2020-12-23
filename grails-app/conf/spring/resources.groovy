import com.fuini.sd.web.rest.Category.CategoryResourceImpl
import com.fuini.sd.web.rest.Product.ProductResourceImpl
import com.fuini.sd.web.rest.PurchaseRecord.PurchaseRecordResourceImpl
import com.fuini.sd.web.rest.Role.RoleResourceImpl
import com.fuini.sd.web.service.Category.CategoryServiceImpl
import com.fuini.sd.web.rest.Supplier.SupplierResourceImpl
import com.fuini.sd.web.service.Product.ProductServiceImpl
import com.fuini.sd.web.service.PurchaseRecord.PurchaseRecordServiceImpl
import com.fuini.sd.web.service.Supplier.SupplierServiceImpl

// Place your Spring DSL code here
beans = {
    //Resources
    categoryResource(CategoryResourceImpl)
    supplierResource(SupplierResourceImpl)
    productResource(ProductResourceImpl)
    purchaseRecordResource(PurchaseRecordResourceImpl)
    roleResource(RoleResourceImpl)

    //Services
    categoryService(CategoryServiceImpl)
    supplierService(SupplierServiceImpl)
    productService(ProductServiceImpl)
    _categoryService(CategoryServiceImpl)
    purchaseRecordService(PurchaseRecordServiceImpl)
    roleService(RoleServiceImpl)
}

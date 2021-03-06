import com.fuini.sd.web.rest.Category.CategoryResourceImpl
import com.fuini.sd.web.rest.Product.ProductResourceImpl
import com.fuini.sd.web.rest.PurchaseRecord.PurchaseRecordResourceImpl
import com.fuini.sd.web.rest.Role.RoleResourceImpl
import com.fuini.sd.web.rest.User.UserResourceImpl
import com.fuini.sd.web.service.Auth.AuthServiceImpl
import com.fuini.sd.web.service.Category.CategoryServiceImpl
import com.fuini.sd.web.rest.Supplier.SupplierResourceImpl
import com.fuini.sd.web.service.Product.ProductServiceImpl
import com.fuini.sd.web.service.PurchaseRecord.PurchaseRecordServiceImpl
import com.fuini.sd.web.service.Supplier.SupplierServiceImpl
import com.fuini.sd.web.service.Role.RoleServiceImpl
import com.fuini.sd.web.service.User.UserServiceImpl
import com.fuini.sd.web.utils.MyAuthenticationProvider

// Place your Spring DSL code here
beans = {
    //Resources
    categoryResource(CategoryResourceImpl)
    supplierResource(SupplierResourceImpl)
    productResource(ProductResourceImpl)
    purchaseRecordResource(PurchaseRecordResourceImpl)
    roleResource(RoleResourceImpl)
    userResource(UserResourceImpl)
    myAuthenticationProvider(MyAuthenticationProvider) {
    }

    //Services
    categoryService(CategoryServiceImpl)
    supplierService(SupplierServiceImpl)
    productService(ProductServiceImpl)
    _categoryService(CategoryServiceImpl)
    purchaseRecordService(PurchaseRecordServiceImpl)
    roleService(RoleServiceImpl)
    userService(UserServiceImpl)
    authService(AuthServiceImpl)
}

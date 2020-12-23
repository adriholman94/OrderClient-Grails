package orderclient.grails

import com.fuini.sd.web.beans.Product.ProductB
import com.fuini.sd.web.service.Category.ICategoryService
import com.fuini.sd.web.service.Product.IProductService
import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class ProductsController {

    IProductService productService
    ICategoryService categoryService

    static allowedMethods = [save: "POST", update: "POST", delete: "DELETE"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list() {
        System.out.println("params -> " + params)
        def page = null == params['id'] ? 0 : Integer.valueOf(params['id'])
        def products = productService.getAll(page)
        def next = products.size() == 0 ? 0 : (productService.getCPages() == page + 1 ? 0 : 1)
        [productInstanceL: products, productInstanceT: products?.size(), page: page, next: next]
    }

    def show(Integer id) {
        System.out.println("params -> " + params)
        def productInstance = productService.getById(id)
        [productInstance: productInstance]
    }

    def create() {
        System.out.println("params -> " + params)
        [productInstance: new Products(params), categories: categoryService.getCategories()]
    }

    def save() {
        System.out.println("params -> " + params)
        def productInstance = new ProductB(params)
        def category = categoryService.getById(Integer.valueOf(params['categoryId']))
        System.out.println(productInstance.productPrice)
        productInstance.setCategory(category)
        def newProductInstance = productService.save(productInstance)
        if (!newProductInstance?.getId()) {
            render(view: "create", model: [productInstance: productInstance])
            return
        }
        flash.message = message(code: 'default.created.message', args: [message(code: 'products.label', default: 'Products'), newProductInstance.getId()])
        redirect(action: "show", id: newProductInstance.getId())
    }

    def edit(Integer id) {
        System.out.println("params -> " + params)
        def productInstance = productService.getById(id.intValue())
        if (!productInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'products.label', default: 'Products'), id])
            redirect(action: "list")
            return
        }
        [productInstance: productInstance, categories: categoryService.getCategories()]
    }

    def update() {
        System.out.println("params -> " + params)
        def productInstance = productService.getById(Integer.parseInt(params.get("id")))
        def newProductInstance = new ProductB(params)
        newProductInstance.setProductName(params.get("productName"))
        newProductInstance.setProductPrice(Integer.valueOf(params.get("productPrice")))
        def category = categoryService.getById(Integer.valueOf(params['categoryId']))
        newProductInstance.setCategory(category)
        productInstance = productService.update(newProductInstance)

        flash.message = message(code: 'default.updated.message', args: [message(code: 'products.label', default: 'Products'), productInstance.getId()])
        redirect(action: "show", id: productInstance.getId())
    }

    def delete(Integer id) {
        System.out.println("params -> " + params)
        def productInstance = productService.delete(id)
        if (!productInstance) {
            flash.message = message(code: 'default.not.found.message', args: [
                    message(code: 'products.label', default: 'Products'),
                    id
            ])
            redirect(action: "list")
            return
        } else {
            flash.message = message(code: 'default.deleted.message', args: [
                    message(code: 'products.label', default: 'Products'),
                    id
            ])
            redirect(action: "list")
            return
        }
    }
}

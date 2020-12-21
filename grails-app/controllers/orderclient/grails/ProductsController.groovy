package orderclient.grails

import com.fuini.sd.web.beans.Product.ProductB
import com.fuini.sd.web.service.Product.IProductService
import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class ProductsController {

    IProductService productService

    static allowedMethods = [save: "POST", update: "POST", delete: "DELETE"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max){
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
        [productInstance: new Products(params)]
    }

    def save() {
        System.out.println("params -> " + params)
        def productInstance = new ProductB(params)
        def newProductInstance = productService.save(productInstance)
        if (!newProductInstance?.getId()) {
            render(view: "create", model: [productInstance: productInstance])
            return
        }
        flash.message = message(code: 'default.created.message', args: [message(code: 'products.label', default: 'Products'), newProductInstance.getId()])
        redirect(action: "show", id: newProductInstance.getId())
    }

    def edit(Integer id) {
        def productInstance = productService.getById(id.intValue())
        if (!productInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'products.label', default: 'Products'), id])
            redirect(action: "list")
            return
        }
        [productInstance: productInstance]
    }

    def update() {
        System.out.println("params -> " + params)
        def newProductInstance = new ProductB(params)
        newProductInstance.setId(Integer.parseInt(params.get("edit")))
        newProductInstance.setProductName(params.get("productName"))
        newProductInstance.setProductPrice(params.get("productPrice"))
        productService.update(newProductInstance)

        flash.message = message(code: 'default.updated.message', args: [message(code: 'products.label', default: 'Products'), newProductInstance.getId()])
        redirect(action: "show", id: newProductInstance.getId())
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
        }else {
            flash.message = message(code: 'default.deleted.message', args: [
                    message(code: 'products.label', default: 'Products'),
                    id
            ])
            redirect(action: "list")
            return
        }
    }
}

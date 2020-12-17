package orderclient.grails

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class SuppliersController {

    SuppliersService suppliersService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]


    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max){
        def page = null == params['id'] ? 0 : Integer.valueOf(params['id'])
        def suppliers = supplierService.getAll(page)
        [supplierInstanceList: suppliers, supplierInstanceTotal: suppliers.size()]
    }

    def show(Integer id) {
        def supplierInstance = supplierService.getById(id)
        [supplierInstance: supplierInstance]
    }

    def create() {
        respond new Suppliers(params)
    }

    def save(Suppliers suppliers) {
        if (suppliers == null) {
            notFound()
            return
        }

        try {
            suppliersService.save(suppliers)
        } catch (ValidationException e) {
            respond suppliers.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'suppliers.label', default: 'Suppliers'), suppliers.id])
                redirect suppliers
            }
            '*' { respond suppliers, [status: CREATED] }
        }
    }

    def edit(Integer id) {
        respond suppliersService.get(id)
    }

    def update(Suppliers suppliers) {
        if (suppliers == null) {
            notFound()
            return
        }

        try {
            suppliersService.save(suppliers)
        } catch (ValidationException e) {
            respond suppliers.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'suppliers.label', default: 'Suppliers'), suppliers.id])
                redirect suppliers
            }
            '*'{ respond suppliers, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        suppliersService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'suppliers.label', default: 'Suppliers'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'suppliers.label', default: 'Suppliers'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}

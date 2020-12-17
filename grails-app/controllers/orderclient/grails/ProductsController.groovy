package orderclient.grails

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class ProductsController {

    ProductsService productsService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond productsService.list(params), model:[productsCount: productsService.count()]
    }

    def show(Long id) {
        respond productsService.get(id)
    }

    def create() {
        respond new Products(params)
    }

    def save(Products products) {
        if (products == null) {
            notFound()
            return
        }

        try {
            productsService.save(products)
        } catch (ValidationException e) {
            respond products.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'products.label', default: 'Products'), products.id])
                redirect products
            }
            '*' { respond products, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond productsService.get(id)
    }

    def update(Products products) {
        if (products == null) {
            notFound()
            return
        }

        try {
            productsService.save(products)
        } catch (ValidationException e) {
            respond products.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'products.label', default: 'Products'), products.id])
                redirect products
            }
            '*'{ respond products, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        productsService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'products.label', default: 'Products'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'products.label', default: 'Products'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}

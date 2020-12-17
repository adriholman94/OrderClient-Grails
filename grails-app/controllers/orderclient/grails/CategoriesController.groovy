package orderclient.grails

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class CategoriesController {

    CategoriesService categoriesService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond categoriesService.list(params), model:[categoriesCount: categoriesService.count()]
    }

    def show(Long id) {
        respond categoriesService.get(id)
    }

    def create() {
        respond new Categories(params)
    }

    def save(Categories categories) {
        if (categories == null) {
            notFound()
            return
        }

        try {
            categoriesService.save(categories)
        } catch (ValidationException e) {
            respond categories.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'categories.label', default: 'Categories'), categories.id])
                redirect categories
            }
            '*' { respond categories, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond categoriesService.get(id)
    }

    def update(Categories categories) {
        if (categories == null) {
            notFound()
            return
        }

        try {
            categoriesService.save(categories)
        } catch (ValidationException e) {
            respond categories.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'categories.label', default: 'Categories'), categories.id])
                redirect categories
            }
            '*'{ respond categories, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        categoriesService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'categories.label', default: 'Categories'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'categories.label', default: 'Categories'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}

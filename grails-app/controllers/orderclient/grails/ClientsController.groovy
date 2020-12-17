package orderclient.grails

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class ClientsController {

    ClientsService clientsService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond clientsService.list(params), model:[clientsCount: clientsService.count()]
    }

    def show(Long id) {
        respond clientsService.get(id)
    }

    def create() {
        respond new Clients(params)
    }

    def save(Clients clients) {
        if (clients == null) {
            notFound()
            return
        }

        try {
            clientsService.save(clients)
        } catch (ValidationException e) {
            respond clients.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'clients.label', default: 'Clients'), clients.id])
                redirect clients
            }
            '*' { respond clients, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond clientsService.get(id)
    }

    def update(Clients clients) {
        if (clients == null) {
            notFound()
            return
        }

        try {
            clientsService.save(clients)
        } catch (ValidationException e) {
            respond clients.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'clients.label', default: 'Clients'), clients.id])
                redirect clients
            }
            '*'{ respond clients, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        clientsService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'clients.label', default: 'Clients'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'clients.label', default: 'Clients'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}

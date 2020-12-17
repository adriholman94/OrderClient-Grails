package orderclient.grails

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class OrderDetailsController {

    OrderDetailsService orderDetailsService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond orderDetailsService.list(params), model:[orderDetailsCount: orderDetailsService.count()]
    }

    def show(Long id) {
        respond orderDetailsService.get(id)
    }

    def create() {
        respond new OrderDetails(params)
    }

    def save(OrderDetails orderDetails) {
        if (orderDetails == null) {
            notFound()
            return
        }

        try {
            orderDetailsService.save(orderDetails)
        } catch (ValidationException e) {
            respond orderDetails.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'orderDetails.label', default: 'OrderDetails'), orderDetails.id])
                redirect orderDetails
            }
            '*' { respond orderDetails, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond orderDetailsService.get(id)
    }

    def update(OrderDetails orderDetails) {
        if (orderDetails == null) {
            notFound()
            return
        }

        try {
            orderDetailsService.save(orderDetails)
        } catch (ValidationException e) {
            respond orderDetails.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'orderDetails.label', default: 'OrderDetails'), orderDetails.id])
                redirect orderDetails
            }
            '*'{ respond orderDetails, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        orderDetailsService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'orderDetails.label', default: 'OrderDetails'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'orderDetails.label', default: 'OrderDetails'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}

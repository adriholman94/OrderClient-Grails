package orderclient.grails

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class OrderDetailController {

    OrderDetailService orderDetailService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond orderDetailService.list(params), model:[orderDetailCount: orderDetailService.count()]
    }

    def show(Long id) {
        respond orderDetailService.get(id)
    }

    def create() {
        respond new OrderDetail(params)
    }

    def save(OrderDetail orderDetail) {
        if (orderDetail == null) {
            notFound()
            return
        }

        try {
            orderDetailService.save(orderDetail)
        } catch (ValidationException e) {
            respond orderDetail.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'orderDetail.label', default: 'OrderDetail'), orderDetail.id])
                redirect orderDetail
            }
            '*' { respond orderDetail, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond orderDetailService.get(id)
    }

    def update(OrderDetail orderDetail) {
        if (orderDetail == null) {
            notFound()
            return
        }

        try {
            orderDetailService.save(orderDetail)
        } catch (ValidationException e) {
            respond orderDetail.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'orderDetail.label', default: 'OrderDetail'), orderDetail.id])
                redirect orderDetail
            }
            '*'{ respond orderDetail, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        orderDetailService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'orderDetail.label', default: 'OrderDetail'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'orderDetail.label', default: 'OrderDetail'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}

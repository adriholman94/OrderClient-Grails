package orderclient.grails

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class PurchaseRecordDetailsController {

    PurchaseRecordDetailsService purchaseRecordDetailsService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond purchaseRecordDetailsService.list(params), model:[purchaseRecordDetailsCount: purchaseRecordDetailsService.count()]
    }

    def show(Long id) {
        respond purchaseRecordDetailsService.get(id)
    }

    def create() {
        respond new PurchaseRecordDetails(params)
    }

    def save(PurchaseRecordDetails purchaseRecordDetails) {
        if (purchaseRecordDetails == null) {
            notFound()
            return
        }

        try {
            purchaseRecordDetailsService.save(purchaseRecordDetails)
        } catch (ValidationException e) {
            respond purchaseRecordDetails.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'purchaseRecordDetails.label', default: 'PurchaseRecordDetails'), purchaseRecordDetails.id])
                redirect purchaseRecordDetails
            }
            '*' { respond purchaseRecordDetails, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond purchaseRecordDetailsService.get(id)
    }

    def update(PurchaseRecordDetails purchaseRecordDetails) {
        if (purchaseRecordDetails == null) {
            notFound()
            return
        }

        try {
            purchaseRecordDetailsService.save(purchaseRecordDetails)
        } catch (ValidationException e) {
            respond purchaseRecordDetails.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'purchaseRecordDetails.label', default: 'PurchaseRecordDetails'), purchaseRecordDetails.id])
                redirect purchaseRecordDetails
            }
            '*'{ respond purchaseRecordDetails, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        purchaseRecordDetailsService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'purchaseRecordDetails.label', default: 'PurchaseRecordDetails'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'purchaseRecordDetails.label', default: 'PurchaseRecordDetails'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}

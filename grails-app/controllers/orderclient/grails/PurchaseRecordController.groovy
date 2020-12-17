package orderclient.grails

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class PurchaseRecordController {

    PurchaseRecordService purchaseRecordService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond purchaseRecordService.list(params), model:[purchaseRecordCount: purchaseRecordService.count()]
    }

    def show(Long id) {
        respond purchaseRecordService.get(id)
    }

    def create() {
        respond new PurchaseRecord(params)
    }

    def save(PurchaseRecord purchaseRecord) {
        if (purchaseRecord == null) {
            notFound()
            return
        }

        try {
            purchaseRecordService.save(purchaseRecord)
        } catch (ValidationException e) {
            respond purchaseRecord.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'purchaseRecord.label', default: 'PurchaseRecord'), purchaseRecord.id])
                redirect purchaseRecord
            }
            '*' { respond purchaseRecord, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond purchaseRecordService.get(id)
    }

    def update(PurchaseRecord purchaseRecord) {
        if (purchaseRecord == null) {
            notFound()
            return
        }

        try {
            purchaseRecordService.save(purchaseRecord)
        } catch (ValidationException e) {
            respond purchaseRecord.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'purchaseRecord.label', default: 'PurchaseRecord'), purchaseRecord.id])
                redirect purchaseRecord
            }
            '*'{ respond purchaseRecord, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        purchaseRecordService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'purchaseRecord.label', default: 'PurchaseRecord'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'purchaseRecord.label', default: 'PurchaseRecord'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}

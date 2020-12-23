package orderclient.grails

import com.fuini.sd.web.service.PurchaseRecord.IPurchaseRecordService
import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class PurchaseRecordsController {

    IPurchaseRecordService purchaseRecordService

    static allowedMethods = [save: "POST", update: "POST", delete: "DELETE"]

    def index(Integer max) {

    }

    def show(Integer id) {
        def purchaseRecordInstance = purchaseRecordService.getById(id)
        [purchaseRecordInstance: purchaseRecordInstance, purchaseRecordDetailInstance: purchaseRecordInstance.getPurchaseRecordDetails()]
    }

    def create() {
        respond new PurchaseRecords(params)
    }

    def save(PurchaseRecords purchaseRecords) {
        if (purchaseRecords == null) {
            notFound()
            return
        }

        try {
            purchaseRecordsService.save(purchaseRecords)
        } catch (ValidationException e) {
            respond purchaseRecords.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'purchaseRecords.label', default: 'PurchaseRecords'), purchaseRecords.id])
                redirect purchaseRecords
            }
            '*' { respond purchaseRecords, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond purchaseRecordsService.get(id)
    }

    def update(PurchaseRecords purchaseRecords) {
        if (purchaseRecords == null) {
            notFound()
            return
        }

        try {
            purchaseRecordsService.save(purchaseRecords)
        } catch (ValidationException e) {
            respond purchaseRecords.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'purchaseRecords.label', default: 'PurchaseRecords'), purchaseRecords.id])
                redirect purchaseRecords
            }
            '*'{ respond purchaseRecords, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        purchaseRecordsService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'purchaseRecords.label', default: 'PurchaseRecords'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'purchaseRecords.label', default: 'PurchaseRecords'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}

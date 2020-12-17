package orderclient.grails

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class PurchaseRecordDetailController {

    PurchaseRecordDetailService purchaseRecordDetailService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond purchaseRecordDetailService.list(params), model:[purchaseRecordDetailCount: purchaseRecordDetailService.count()]
    }

    def show(Long id) {
        respond purchaseRecordDetailService.get(id)
    }

    def create() {
        respond new PurchaseRecordDetail(params)
    }

    def save(PurchaseRecordDetail purchaseRecordDetail) {
        if (purchaseRecordDetail == null) {
            notFound()
            return
        }

        try {
            purchaseRecordDetailService.save(purchaseRecordDetail)
        } catch (ValidationException e) {
            respond purchaseRecordDetail.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'purchaseRecordDetail.label', default: 'PurchaseRecordDetail'), purchaseRecordDetail.id])
                redirect purchaseRecordDetail
            }
            '*' { respond purchaseRecordDetail, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond purchaseRecordDetailService.get(id)
    }

    def update(PurchaseRecordDetail purchaseRecordDetail) {
        if (purchaseRecordDetail == null) {
            notFound()
            return
        }

        try {
            purchaseRecordDetailService.save(purchaseRecordDetail)
        } catch (ValidationException e) {
            respond purchaseRecordDetail.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'purchaseRecordDetail.label', default: 'PurchaseRecordDetail'), purchaseRecordDetail.id])
                redirect purchaseRecordDetail
            }
            '*'{ respond purchaseRecordDetail, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        purchaseRecordDetailService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'purchaseRecordDetail.label', default: 'PurchaseRecordDetail'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'purchaseRecordDetail.label', default: 'PurchaseRecordDetail'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}

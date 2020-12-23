package orderclient.grails

import com.fuini.sd.web.beans.PurchaseRecord.PurchaseRecordB
import com.fuini.sd.web.service.Product.IProductService
import com.fuini.sd.web.service.PurchaseRecord.IPurchaseRecordService
import com.fuini.sd.web.service.Supplier.ISupplierService
import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class PurchaseRecordsController {

    IPurchaseRecordService purchaseRecordService
    IProductService productService
    ISupplierService supplierService

    static allowedMethods = [save: "POST", update: "POST", delete: "DELETE"]

    def index(Integer max) {
        System.out.println("params -> " + params)
    }

    def show(Integer id) {
        System.out.println("params -> " + params)
        def purchaseRecordInstance = purchaseRecordService.getById(id)
        [purchaseRecordInstance: purchaseRecordInstance, purchaseRecordDetailInstance: purchaseRecordInstance.getPurchaseRecordDetails()]
    }

    def create() {
        System.out.println("params -> " + params)
        [purchaseRecordInstance: new PurchaseRecordB(params), products: productService.getProducts(), suppliers: supplierService.getSuppliers()]
    }

    def save(PurchaseRecords purchaseRecords) {

    }

    def edit(Long id) {

    }

    def update(PurchaseRecords purchaseRecords) {

    }

    def delete(Long id) {

    }
}

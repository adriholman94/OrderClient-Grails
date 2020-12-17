package orderclient.grails

class PurchaseRecordDetails {

    Integer productQuantity
    Integer productPrice
    Integer totalPrice

    static belongsTo = [product: Products, supplier: Suppliers, purchaseRecord: PurchaseRecords]

    static constraints = {
        productQuantity blank: false
        productPrice blank: true
        totalPrice blank: true
    }
}

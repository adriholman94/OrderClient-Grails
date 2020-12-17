package orderclient.grails

class PurchaseRecordDetail {

    Integer productQuantity
    Integer productPrice
    Integer TotalPrice

    static belongsTo = [product: Product, supplier: Supplier, purchaseRecord: PurchaseRecord]

    static constraints = {
    }
}

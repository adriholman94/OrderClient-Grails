package orderclient.grails

class OrderDetails {

    Integer productQuantity
    Integer quantityPrice

    static belongsTo = [product: Products, order: Orders]

    static constraints = {
    }
}

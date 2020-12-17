package orderclient.grails

class OrderDetail {

    Integer productQuantity
    Integer quantityPrice

    static belongsTo = [product: Product, order: Order]

    static constraints = {
    }
}
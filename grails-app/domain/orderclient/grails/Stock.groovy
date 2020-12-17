package orderclient.grails

class Stock {

    Integer productQuantity

    static belongsTo = [product: Product]

    static constraints = {
    }
}

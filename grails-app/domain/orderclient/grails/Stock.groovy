package orderclient.grails

class Stock {

    Integer productQuantity

    static belongsTo = [product: Products]

    static constraints = {
    }
}
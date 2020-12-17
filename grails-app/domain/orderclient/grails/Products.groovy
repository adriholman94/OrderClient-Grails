package orderclient.grails

class Products {

    String productName
    Integer productPrice

    static belongsTo = [category: Categories]

    static constraints = {
        productName blank: false, size: 3..50
    }
}

package orderclient.grails

class Product {

    String productName
    Integer productPrice

    static belongsTo = [category: Category]

    static constraints = {
        productName blank: false, size: 3..50
    }
}

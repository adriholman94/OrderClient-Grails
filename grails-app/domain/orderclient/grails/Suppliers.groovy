package orderclient.grails

class Suppliers {

    String supplierName

    static constraints = {
        supplierName blank: false, size: 3..50
    }
}

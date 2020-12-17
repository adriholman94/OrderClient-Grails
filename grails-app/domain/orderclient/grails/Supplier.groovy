package orderclient.grails

class Supplier {

    String supplierName

    static constraints = {
        supplierName blank: false, size: 3..50
    }
}


package orderclient.grails

import java.time.LocalDate

class PurchaseRecords {

    LocalDate purchaseDate
    Integer finalPrice

    static constraints = {
        finalPrice blank: true
    }
}

package orderclient.grails

import java.time.LocalDate

class PurchaseRecord {

    LocalDate purchaseDate
    Integer finalPrice

    static constraints = {
    }
}

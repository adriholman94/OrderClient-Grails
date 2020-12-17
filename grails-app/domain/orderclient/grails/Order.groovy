package orderclient.grails

import java.time.LocalDate

class Order {

    LocalDate orderDate
    Integer finalPrice
    boolean isCanceled
    String clientRuc

    static constraints = {
        orderDate blank: false
        clientRuc blank: false, size: 3..15
    }
}
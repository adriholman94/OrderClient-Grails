package orderclient.grails

import java.time.LocalDate

class Orders {

    LocalDate orderDate
    Integer finalPrice
    boolean isCanceled
    String clientRuc

    static constraints = {
        orderDate blank: false
        clientRuc blank: false, size: 3..15
    }
}

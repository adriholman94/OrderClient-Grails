package orderclient.grails

class Clients {
    String firstName
    String lastName
    String clientPhone
    String clientRuc

    static constraints = {
        firstName blank: false, size: 3..30
        lastName blank: false, size: 3..30
        clientPhone blank: false, size: 3..30
        clientRuc blank: false, size: 3..30
    }
}

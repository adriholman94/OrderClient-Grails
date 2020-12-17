package orderclient.grails

class Client {

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


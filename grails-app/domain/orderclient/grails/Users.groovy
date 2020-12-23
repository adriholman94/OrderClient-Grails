package orderclient.grails

class Users {
    String userName

    static constraints = {
        userName blank: false, size: 3..50
    }
}

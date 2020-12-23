package orderclient.grails

class Users {
    String userName
    String email
    String password

    static constraints = {
        userName blank: false, size: 3..50
        email blank: false, size: 3..50
        password blank: false, size: 3..50
    }
}

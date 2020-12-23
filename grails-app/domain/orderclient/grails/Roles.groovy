package orderclient.grails

class Roles {
    String roleName

    static constraints = {
        roleName blank: false, size: 3..50
    }
}

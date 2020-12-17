package orderclient.grails

class Category {

    String categoryName

    static constraints = {
        categoryName blank: false, size: 3..50
    }
}
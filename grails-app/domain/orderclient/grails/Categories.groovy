package orderclient.grails

class Categories {

    String categoryName

    static constraints = {
        categoryName blank: false, size: 3..50
    }
}

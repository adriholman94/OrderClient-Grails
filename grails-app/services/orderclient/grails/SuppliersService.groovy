package orderclient.grails

import grails.gorm.services.Service

@Service(Suppliers)
interface SuppliersService {

    Suppliers get(Serializable id)

    List<Suppliers> list(Map args)

    Long count()

    void delete(Serializable id)

    Suppliers save(Suppliers suppliers)

}
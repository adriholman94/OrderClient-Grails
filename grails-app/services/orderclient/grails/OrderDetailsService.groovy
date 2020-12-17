package orderclient.grails

import grails.gorm.services.Service

@Service(OrderDetails)
interface OrderDetailsService {

    OrderDetails get(Serializable id)

    List<OrderDetails> list(Map args)

    Long count()

    void delete(Serializable id)

    OrderDetails save(OrderDetails orderDetails)

}
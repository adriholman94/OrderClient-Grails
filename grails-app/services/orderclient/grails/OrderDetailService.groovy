package orderclient.grails

import grails.gorm.services.Service

@Service(OrderDetail)
interface OrderDetailService {

    OrderDetail get(Serializable id)

    List<OrderDetail> list(Map args)

    Long count()

    void delete(Serializable id)

    OrderDetail save(OrderDetail orderDetail)

}
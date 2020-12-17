package orderclient.grails

import grails.gorm.services.Service

@Service(PurchaseRecord)
interface PurchaseRecordService {

    PurchaseRecord get(Serializable id)

    List<PurchaseRecord> list(Map args)

    Long count()

    void delete(Serializable id)

    PurchaseRecord save(PurchaseRecord purchaseRecord)

}
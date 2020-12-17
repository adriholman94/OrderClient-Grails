package orderclient.grails

import grails.gorm.services.Service

@Service(PurchaseRecords)
interface PurchaseRecordsService {

    PurchaseRecords get(Serializable id)

    List<PurchaseRecords> list(Map args)

    Long count()

    void delete(Serializable id)

    PurchaseRecords save(PurchaseRecords purchaseRecords)

}
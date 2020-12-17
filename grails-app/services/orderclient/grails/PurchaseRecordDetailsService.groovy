package orderclient.grails

import grails.gorm.services.Service

@Service(PurchaseRecordDetails)
interface PurchaseRecordDetailsService {

    PurchaseRecordDetails get(Serializable id)

    List<PurchaseRecordDetails> list(Map args)

    Long count()

    void delete(Serializable id)

    PurchaseRecordDetails save(PurchaseRecordDetails purchaseRecordDetails)

}
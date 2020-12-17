package orderclient.grails

import grails.gorm.services.Service

@Service(PurchaseRecordDetail)
interface PurchaseRecordDetailService {

    PurchaseRecordDetail get(Serializable id)

    List<PurchaseRecordDetail> list(Map args)

    Long count()

    void delete(Serializable id)

    PurchaseRecordDetail save(PurchaseRecordDetail purchaseRecordDetail)

}
package orderclient.grails

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class PurchaseRecordDetailServiceSpec extends Specification {

    PurchaseRecordDetailService purchaseRecordDetailService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new PurchaseRecordDetail(...).save(flush: true, failOnError: true)
        //new PurchaseRecordDetail(...).save(flush: true, failOnError: true)
        //PurchaseRecordDetail purchaseRecordDetail = new PurchaseRecordDetail(...).save(flush: true, failOnError: true)
        //new PurchaseRecordDetail(...).save(flush: true, failOnError: true)
        //new PurchaseRecordDetail(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //purchaseRecordDetail.id
    }

    void "test get"() {
        setupData()

        expect:
        purchaseRecordDetailService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<PurchaseRecordDetail> purchaseRecordDetailList = purchaseRecordDetailService.list(max: 2, offset: 2)

        then:
        purchaseRecordDetailList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        purchaseRecordDetailService.count() == 5
    }

    void "test delete"() {
        Long purchaseRecordDetailId = setupData()

        expect:
        purchaseRecordDetailService.count() == 5

        when:
        purchaseRecordDetailService.delete(purchaseRecordDetailId)
        sessionFactory.currentSession.flush()

        then:
        purchaseRecordDetailService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        PurchaseRecordDetail purchaseRecordDetail = new PurchaseRecordDetail()
        purchaseRecordDetailService.save(purchaseRecordDetail)

        then:
        purchaseRecordDetail.id != null
    }
}

package orderclient.grails

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class PurchaseRecordServiceSpec extends Specification {

    PurchaseRecordService purchaseRecordService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new PurchaseRecord(...).save(flush: true, failOnError: true)
        //new PurchaseRecord(...).save(flush: true, failOnError: true)
        //PurchaseRecord purchaseRecord = new PurchaseRecord(...).save(flush: true, failOnError: true)
        //new PurchaseRecord(...).save(flush: true, failOnError: true)
        //new PurchaseRecord(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //purchaseRecord.id
    }

    void "test get"() {
        setupData()

        expect:
        purchaseRecordService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<PurchaseRecord> purchaseRecordList = purchaseRecordService.list(max: 2, offset: 2)

        then:
        purchaseRecordList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        purchaseRecordService.count() == 5
    }

    void "test delete"() {
        Long purchaseRecordId = setupData()

        expect:
        purchaseRecordService.count() == 5

        when:
        purchaseRecordService.delete(purchaseRecordId)
        sessionFactory.currentSession.flush()

        then:
        purchaseRecordService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        PurchaseRecord purchaseRecord = new PurchaseRecord()
        purchaseRecordService.save(purchaseRecord)

        then:
        purchaseRecord.id != null
    }
}

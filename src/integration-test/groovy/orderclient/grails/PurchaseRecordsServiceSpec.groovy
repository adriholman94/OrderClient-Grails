package orderclient.grails

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class PurchaseRecordsServiceSpec extends Specification {

    PurchaseRecordsService purchaseRecordsService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new PurchaseRecords(...).save(flush: true, failOnError: true)
        //new PurchaseRecords(...).save(flush: true, failOnError: true)
        //PurchaseRecords purchaseRecords = new PurchaseRecords(...).save(flush: true, failOnError: true)
        //new PurchaseRecords(...).save(flush: true, failOnError: true)
        //new PurchaseRecords(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //purchaseRecords.id
    }

    void "test get"() {
        setupData()

        expect:
        purchaseRecordsService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<PurchaseRecords> purchaseRecordsList = purchaseRecordsService.list(max: 2, offset: 2)

        then:
        purchaseRecordsList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        purchaseRecordsService.count() == 5
    }

    void "test delete"() {
        Long purchaseRecordsId = setupData()

        expect:
        purchaseRecordsService.count() == 5

        when:
        purchaseRecordsService.delete(purchaseRecordsId)
        sessionFactory.currentSession.flush()

        then:
        purchaseRecordsService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        PurchaseRecords purchaseRecords = new PurchaseRecords()
        purchaseRecordsService.save(purchaseRecords)

        then:
        purchaseRecords.id != null
    }
}

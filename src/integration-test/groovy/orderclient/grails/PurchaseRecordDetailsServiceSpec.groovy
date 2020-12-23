package orderclient.grails

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class PurchaseRecordDetailsServiceSpec extends Specification {

    PurchaseRecordDetailsService purchaseRecordDetailsService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new PurchaseRecordDetails(...).save(flush: true, failOnError: true)
        //new PurchaseRecordDetails(...).save(flush: true, failOnError: true)
        //PurchaseRecordDetails purchaseRecordDetails = new PurchaseRecordDetails(...).save(flush: true, failOnError: true)
        //new PurchaseRecordDetails(...).save(flush: true, failOnError: true)
        //new PurchaseRecordDetails(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //purchaseRecordDetails.id
    }

    void "test get"() {
        setupData()

        expect:
        purchaseRecordDetailsService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<PurchaseRecordDetails> purchaseRecordDetailsList = purchaseRecordDetailsService.list(max: 2, offset: 2)

        then:
        purchaseRecordDetailsList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        purchaseRecordDetailsService.count() == 5
    }

    void "test delete"() {
        Long purchaseRecordDetailsId = setupData()

        expect:
        purchaseRecordDetailsService.count() == 5

        when:
        purchaseRecordDetailsService.delete(purchaseRecordDetailsId)
        sessionFactory.currentSession.flush()

        then:
        purchaseRecordDetailsService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        PurchaseRecordDetails purchaseRecordDetails = new PurchaseRecordDetails()
        purchaseRecordDetailsService.save(purchaseRecordDetails)

        then:
        purchaseRecordDetails.id != null
    }
}

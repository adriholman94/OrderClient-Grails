package orderclient.grails

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class SuppliersServiceSpec extends Specification {

    SuppliersService suppliersService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Suppliers(...).save(flush: true, failOnError: true)
        //new Suppliers(...).save(flush: true, failOnError: true)
        //Suppliers suppliers = new Suppliers(...).save(flush: true, failOnError: true)
        //new Suppliers(...).save(flush: true, failOnError: true)
        //new Suppliers(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //suppliers.id
    }

    void "test get"() {
        setupData()

        expect:
        suppliersService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Suppliers> suppliersList = suppliersService.list(max: 2, offset: 2)

        then:
        suppliersList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        suppliersService.count() == 5
    }

    void "test delete"() {
        Long suppliersId = setupData()

        expect:
        suppliersService.count() == 5

        when:
        suppliersService.delete(suppliersId)
        sessionFactory.currentSession.flush()

        then:
        suppliersService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Suppliers suppliers = new Suppliers()
        suppliersService.save(suppliers)

        then:
        suppliers.id != null
    }
}

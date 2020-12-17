package orderclient.grails

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class OrderDetailsServiceSpec extends Specification {

    OrderDetailsService orderDetailsService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new OrderDetails(...).save(flush: true, failOnError: true)
        //new OrderDetails(...).save(flush: true, failOnError: true)
        //OrderDetails orderDetails = new OrderDetails(...).save(flush: true, failOnError: true)
        //new OrderDetails(...).save(flush: true, failOnError: true)
        //new OrderDetails(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //orderDetails.id
    }

    void "test get"() {
        setupData()

        expect:
        orderDetailsService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<OrderDetails> orderDetailsList = orderDetailsService.list(max: 2, offset: 2)

        then:
        orderDetailsList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        orderDetailsService.count() == 5
    }

    void "test delete"() {
        Long orderDetailsId = setupData()

        expect:
        orderDetailsService.count() == 5

        when:
        orderDetailsService.delete(orderDetailsId)
        sessionFactory.currentSession.flush()

        then:
        orderDetailsService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        OrderDetails orderDetails = new OrderDetails()
        orderDetailsService.save(orderDetails)

        then:
        orderDetails.id != null
    }
}

package dowithconfig

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.services.ServiceUnitTestMixin} for usage instructions
 */
@TestFor(FooService)
class FooServiceSpec extends Specification {

    static doWithConfig(c) {
        c.foobar.foo = "2"
        c.foobar.bar = ["2"]
        c.foobar.baz = ["2": "2"]
        c.baz = ["2": "2"]
    }

    void "test string"() {
        expect:
            grailsApplication.config.foobar.foo == "2"
    }

    void "test list"() {
        expect:
            grailsApplication.config.foobar.bar == ["2"]
    }

    void "test map one level"() {
        expect:
            grailsApplication.config.baz == ["2": "2"]
    }

    void "test map two levels"() {
        expect:
            grailsApplication.config.foobar.baz == ["2": "2"]
    }

}

package linklike



import grails.test.mixin.*
import org.junit.*

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Link)
class LinkTests {


	void testLink() {
		def testLink = new Link(title: '1234', url: '5678');

		assert testLink.title == '1234'
		assert testLink.url == '5678'
		assert testLink.like == 0
	}
}

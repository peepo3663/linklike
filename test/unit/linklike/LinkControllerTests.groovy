package linklike



import grails.test.mixin.*
import org.junit.*

/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */
@TestFor(LinkController)
class LinkControllerTests {
	void testLinkUsable() {
		params.title = 'Title'
		params.url = 'Url'

		controller.create()

		assert Link.count == 1
	}
	void testBeforeLike() {
		params.title = 'Title'
		params.url = 'Url'

		controller.create()

		assert Link.like == 0
	}
	void testLike() {
		mockDomain(Link, [
			[title: 'A', url: 'a'],
			[title: 'B', url: 'b']
		])

		def model = controller.index()
		assert model.links.size() == 3

		controller.like(Link.findByUrl('a'))
		controller.like(Link.findByUrl('a'))

		controller.like(Link.findByUrl('b'))
		
		assert Link.findByUrl('a').like == 2
		assert Link.findByUrl('b').like == 1
	}
}

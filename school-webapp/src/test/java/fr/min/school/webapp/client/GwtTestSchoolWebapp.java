package fr.min.school.webapp.client;

import junit.framework.Assert;

import com.google.gwt.core.client.GWT;
import com.google.gwt.junit.client.GWTTestCase;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.ServiceDefTarget;

import fr.min.school.webapp.client.authentication.AuthenticationService;
import fr.min.school.webapp.client.authentication.AuthenticationServiceAsync;
import fr.min.school.webapp.shared.FieldVerifier;

/**
 * GWT JUnit <b>integration</b> tests must extend GWTTestCase. Using
 * <code>"GwtTest*"</code> naming pattern exclude them from running with
 * surefire during the test phase.
 * 
 * If you run the tests using the Maven command line, you will have to navigate
 * with your browser to a specific url given by Maven. See
 * http://mojo.codehaus.org/gwt-maven-plugin/user-guide/testing.html for
 * details.
 */
public class GwtTestSchoolWebapp extends GWTTestCase {

	/**
	 * Must refer to a valid module that sources this class.
	 */
	@Override
	public String getModuleName() {
		return "fr.min.school.webapp.SchoolWebappJUnit";
	}

	/**
	 * Tests the FieldVerifier.
	 */
	public void testFieldVerifier() {
		Assert.assertFalse(FieldVerifier.isValidName(null));
		Assert.assertFalse(FieldVerifier.isValidName(""));
		Assert.assertFalse(FieldVerifier.isValidName("a"));
		Assert.assertFalse(FieldVerifier.isValidName("ab"));
		Assert.assertFalse(FieldVerifier.isValidName("abc"));
		Assert.assertTrue(FieldVerifier.isValidName("abcd"));
	}

	/**
	 * This test will send a request to the server using the greetServer method
	 * in GreetingService and verify the response.
	 */
	public void testGreetingService() {
		// Create the service that we will test.
		final AuthenticationServiceAsync authenticationService = GWT
				.create(AuthenticationService.class);
		final ServiceDefTarget target = (ServiceDefTarget) authenticationService;
		target.setServiceEntryPoint(GWT.getModuleBaseURL()
				+ "SchoolWebapp/greet");

		// Since RPC calls are asynchronous, we will need to wait for a response
		// after this test method returns. This line tells the test runner to
		// wait
		// up to 10 seconds before timing out.
		delayTestFinish(10000);

		// Send a request to the server.
		authenticationService.authenticate("GWT User", "GWT Password",
				new AsyncCallback<String>() {
					public void onFailure(final Throwable caught) {
						// The request resulted in an unexpected error.
						Assert.fail("Request failure: " + caught.getMessage());
					}

					public void onSuccess(final String result) {
						// Verify that the response is correct.
						Assert.assertTrue(result.startsWith("Hello, GWT User!"));

						// Now that we have received a response, we need to tell
						// the test runner
						// that the test is complete. You must call finishTest()
						// after an
						// asynchronous test finishes successfully, or the test
						// will time out.
						finishTest();
					}
				});
	}

}

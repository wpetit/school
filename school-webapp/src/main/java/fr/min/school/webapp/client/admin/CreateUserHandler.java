/**
 * 
 */
package fr.min.school.webapp.client.admin;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.smartgwt.client.types.KeyNames;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.fields.events.KeyUpEvent;
import com.smartgwt.client.widgets.form.fields.events.KeyUpHandler;

import fr.min.school.webapp.shared.Errors;

/**
 * Create user handler. Submit user creation to server.
 * 
 * @author Wilfried Petit
 * 
 */
public class CreateUserHandler implements ClickHandler, KeyUpHandler {

	/**
	 * Create a remote service proxy to talk to the server-side Authentication
	 * service.
	 */
	private final UserServiceAsync userService = GWT.create(UserService.class);

	/** Error messages **/
	private final Errors errors = GWT.create(Errors.class);

	/** The user panel **/
	private UserAdminPanel userAdminPanel;

	/**
	 * Constructor.
	 * 
	 * @param authenticationPanel
	 *            the authentication panel this handler is linked to.
	 */
	public CreateUserHandler(UserAdminPanel userAdminPanel) {
		this.userAdminPanel = userAdminPanel;
	}

	/**
	 * Send the name from the nameField to the server and wait for a response.
	 */
	private void createUserOnServer() {
		userService.createUser(userAdminPanel.getUser(),
				new AsyncCallback<Void>() {
					@Override
					public void onFailure(Throwable caught) {
						userAdminPanel.setErrorText(errors
								.invalidLoginPassword());
					}

					@Override
					public void onSuccess(Void result) {
						userAdminPanel.processSuccess();
					}
				});
	}

	@Override
	public void onKeyUp(KeyUpEvent event) {
		if (event.getKeyName() == KeyNames.ENTER) {
			createUserOnServer();
		}
	}

	@Override
	public void onClick(ClickEvent event) {
		createUserOnServer();
	}
}

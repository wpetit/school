/**
 * 
 */
package fr.min.school.webapp.client.authentication;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.smartgwt.client.types.KeyNames;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.fields.events.KeyUpEvent;
import com.smartgwt.client.widgets.form.fields.events.KeyUpHandler;

import fr.min.school.model.dto.UserDTO;
import fr.min.school.webapp.shared.AuthenticationVerifier;
import fr.min.school.webapp.shared.Errors;

/**
 * Authentication handler. Submit authentication credentials to server.
 * 
 * @author Wilfried Petit
 * 
 */
public class AuthenticationHandler implements ClickHandler, KeyUpHandler {

	/**
	 * Create a remote service proxy to talk to the server-side Authentication
	 * service.
	 */
	private final AuthenticationServiceAsync authenticationService = GWT
			.create(AuthenticationService.class);

	/** Error messages **/
	private final Errors errors = GWT.create(Errors.class);

	/** The authentication panel **/
	private AuthenticationPanel authenticationPanel;

	/**
	 * Constructor.
	 * 
	 * @param authenticationPanel
	 *            the authentication panel this handler is linked to.
	 */
	public AuthenticationHandler(AuthenticationPanel authenticationPanel) {
		this.authenticationPanel = authenticationPanel;
	}

	/**
	 * Send the name from the nameField to the server and wait for a response.
	 */
	private void sendLoginPasswordToServer() {
		// First, we validate the input.
		final String login = authenticationPanel.getLogin();
		if (!AuthenticationVerifier.isValidLogin(login)) {
			authenticationPanel.setErrorText(errors.tooShortLogin());
			return;
		}
		final String password = authenticationPanel.getPassword();
		if (!AuthenticationVerifier.isValidPassword(password)) {
			authenticationPanel.setErrorText(errors.tooShortPassword());
			return;
		}

		// Then, we send the input to the server.
		authenticationService.authenticate(login, password,
				new AsyncCallback<UserDTO>() {
					@Override
					public void onFailure(final Throwable caught) {
						authenticationPanel.setErrorText(errors
								.invalidLoginPassword());
					}

					@Override
					public void onSuccess(final UserDTO userDTO) {
						authenticationPanel.processSuccess(userDTO);
						;
					}
				});
	}

	@Override
	public void onKeyUp(KeyUpEvent event) {
		if (event.getKeyName() == KeyNames.ENTER) {
			sendLoginPasswordToServer();
		}
	}

	@Override
	public void onClick(ClickEvent event) {
		sendLoginPasswordToServer();
	}
}

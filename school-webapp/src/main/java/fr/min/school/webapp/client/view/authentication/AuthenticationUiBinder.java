/**
 * 
 */
package fr.min.school.webapp.client.view.authentication;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

import fr.min.school.model.dto.UserDTO;
import fr.min.school.webapp.client.authentication.AuthenticationService;
import fr.min.school.webapp.client.authentication.AuthenticationServiceAsync;
import fr.min.school.webapp.client.event.SuccessfulAuthenticationEvent;
import fr.min.school.webapp.shared.AuthenticationVerifier;

/**
 * @author Wilfried Petit
 * 
 */
public class AuthenticationUiBinder extends Composite {

	private static AuthenticationUiBinderUiBinder uiBinder = GWT
			.create(AuthenticationUiBinderUiBinder.class);

	/**
	 * Create a remote service proxy to talk to the server-side Authentication
	 * service.
	 */
	private final AuthenticationServiceAsync authenticationService = GWT
			.create(AuthenticationService.class);

	@UiField
	Button button;

	@UiField
	TextBox loginTextBox;

	@UiField
	PasswordTextBox passwordTextBox;

	@UiField
	Label informationsLabel;

	private HandlerManager eventBus;

	interface AuthenticationUiBinderUiBinder extends
			UiBinder<Widget, AuthenticationUiBinder> {
	}

	public AuthenticationUiBinder(HandlerManager eventBus) {
		initWidget(AuthenticationUiBinder.uiBinder.createAndBindUi(this));
		this.eventBus = eventBus;
	}

	@UiHandler("button")
	void onButtonClick(ClickEvent event) {
		// First, we validate the input.
		final String login = loginTextBox.getValue();
		if (!AuthenticationVerifier.isValidLogin(login)) {
			informationsLabel.setText("Invalid login.");
			return;
		}
		final String password = passwordTextBox.getValue();
		if (!AuthenticationVerifier.isValidPassword(password)) {
			informationsLabel.setText("Invalid password.");
			return;
		}

		// Then, we send the input to the server.
		authenticationService.authenticate(login, password,
				new AsyncCallback<UserDTO>() {
					@Override
					public void onFailure(final Throwable caught) {
						informationsLabel.setText("Invalid login or password.");
						return;
					}

					@Override
					public void onSuccess(final UserDTO userDTO) {
						informationsLabel.setText(userDTO.getLogin()
								+ " successfully logged in.");
						eventBus.fireEvent(new SuccessfulAuthenticationEvent(
								userDTO.getId()));
						return;
					}
				});
	}
}

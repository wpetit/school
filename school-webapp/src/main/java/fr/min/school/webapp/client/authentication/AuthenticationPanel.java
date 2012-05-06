/**
 * 
 */
package fr.min.school.webapp.client.authentication;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

import fr.min.school.webapp.client.Messages;
import fr.min.school.webapp.client.SchoolWebapp;
import fr.min.school.webapp.shared.FieldVerifier;

/**
 * Authentication Panel.
 * 
 * @author Wilfried Petit
 * 
 */
public class AuthenticationPanel extends VerticalPanel {
	/**
	 * Create a remote service proxy to talk to the server-side Authentication
	 * service.
	 */
	private final AuthenticationServiceAsync authenticationService = GWT
			.create(AuthenticationService.class);

	private final Messages messages = GWT.create(Messages.class);

	/**
	 * Constructor.
	 */
	public AuthenticationPanel() {
		final Button sendButton = new Button(messages.sendButton());
		final TextBox loginField = new TextBox();
		loginField.setText(messages.loginField());
		final PasswordTextBox passwordField = new PasswordTextBox();
		passwordField.setText(messages.passwordField());
		final Label errorLabel = new Label();

		// We can add style names to widgets
		sendButton.addStyleName("sendButton");

		// Add the nameField and sendButton to the RootPanel
		// Use RootPanel.get() to get the entire body element
		this.add(loginField);
		this.add(passwordField);
		this.add(sendButton);
		this.add(errorLabel);

		// Focus the cursor on the name field when the app loads
		loginField.setFocus(true);
		loginField.selectAll();

		// Create the popup dialog box
		final DialogBox dialogBox = new DialogBox();
		dialogBox.setText("Remote Procedure Call");
		dialogBox.setAnimationEnabled(true);
		final Button closeButton = new Button("Close");
		// We can set the id of a widget by accessing its Element
		closeButton.getElement().setId("closeButton");
		final Label textToServerLabel = new Label();
		final HTML serverResponseLabel = new HTML();
		final VerticalPanel dialogVPanel = new VerticalPanel();
		dialogVPanel.addStyleName("dialogVPanel");
		dialogVPanel.add(new HTML("<b>Sending name to the server:</b>"));
		dialogVPanel.add(textToServerLabel);
		dialogVPanel.add(new HTML("<br><b>Server replies:</b>"));
		dialogVPanel.add(serverResponseLabel);
		dialogVPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);
		dialogVPanel.add(closeButton);
		dialogBox.setWidget(dialogVPanel);

		// Add a handler to close the DialogBox
		closeButton.addClickHandler(new ClickHandler() {
			public void onClick(final ClickEvent event) {
				dialogBox.hide();
				sendButton.setEnabled(true);
				sendButton.setFocus(true);
			}
		});

		// Create a handler for the sendButton and nameField
		class MyHandler implements ClickHandler, KeyUpHandler {
			/**
			 * Fired when the user clicks on the sendButton.
			 */
			public void onClick(final ClickEvent event) {
				sendNameToServer();
			}

			/**
			 * Fired when the user types in the nameField.
			 */
			public void onKeyUp(final KeyUpEvent event) {
				if (event.getNativeKeyCode() == KeyCodes.KEY_ENTER) {
					sendNameToServer();
				}
			}

			/**
			 * Send the name from the nameField to the server and wait for a
			 * response.
			 */
			private void sendNameToServer() {
				// First, we validate the input.
				errorLabel.setText("");
				final String login = loginField.getText();
				if (!FieldVerifier.isValidName(login)) {
					errorLabel.setText("Please enter at least four characters");
					return;
				}
				final String password = passwordField.getText();

				// Then, we send the input to the server.
				sendButton.setEnabled(false);
				textToServerLabel.setText(login);
				serverResponseLabel.setText("");
				authenticationService.authenticate(login, password,
						new AsyncCallback<String>() {
							public void onFailure(final Throwable caught) {
								// Show the RPC error message to the user
								dialogBox
										.setText("Remote Procedure Call - Failure");
								serverResponseLabel
										.addStyleName("serverResponseLabelError");
								serverResponseLabel
										.setHTML(SchoolWebapp.SERVER_ERROR);
								dialogBox.center();
								closeButton.setFocus(true);
							}

							public void onSuccess(final String result) {
								dialogBox.setText("Remote Procedure Call");
								serverResponseLabel
										.removeStyleName("serverResponseLabelError");
								serverResponseLabel.setHTML(result);
								dialogBox.center();
								closeButton.setFocus(true);
							}
						});
			}
		}

		// Add a handler to send the name to the server
		final MyHandler handler = new MyHandler();
		sendButton.addClickHandler(handler);
		loginField.addKeyUpHandler(handler);

	}
}

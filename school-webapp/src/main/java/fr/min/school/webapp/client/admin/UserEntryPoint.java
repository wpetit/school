package fr.min.school.webapp.client.admin;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;

import fr.min.school.webapp.client.AuthenticationService;
import fr.min.school.webapp.client.AuthenticationServiceAsync;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class UserEntryPoint implements EntryPoint {

	/**
	 * Create a remote service proxy to talk to the server-side Greeting
	 * service.
	 */
	private final AuthenticationServiceAsync authenticationService = GWT
			.create(AuthenticationService.class);

	/**
	 * This is the entry point method.
	 */
	@Override
	public void onModuleLoad() {
		final Button sendButton = new Button("Connexion");
		final TextBox loginField = new TextBox();
		final Label loginLabel = new Label("Utilisateur : ");
		final Label errorLabel = new Label();
		final PasswordTextBox passwordField = new PasswordTextBox();
		final Label passwordLabel = new Label("Password : ");

		// Add the nameField and sendButton to the RootPanel
		// Use RootPanel.get() to get the entire body element
		final RootPanel rootPanel = RootPanel.get();
		rootPanel.add(new Label("School Web Application"));

		rootPanel.add(loginLabel);
		rootPanel.add(loginField);

		rootPanel.add(passwordLabel);
		rootPanel.add(passwordField);

		rootPanel.add(sendButton);
		rootPanel.add(errorLabel);

		// Focus the cursor on the name field when the app loads
		loginField.setFocus(true);
		loginField.selectAll();

		// Create the popup dialog box
		/*
		 * final DialogBox dialogBox = new DialogBox();
		 * dialogBox.setText("Remote Procedure Call");
		 * dialogBox.setAnimationEnabled(true); final Button closeButton = new
		 * Button("Close"); // We can set the id of a widget by accessing its
		 * Element closeButton.getElement().setId("closeButton"); final Label
		 * textToServerLabel = new Label(); final HTML serverResponseLabel = new
		 * HTML(); final VerticalPanel dialogVPanel = new VerticalPanel();
		 * dialogVPanel.addStyleName("dialogVPanel"); dialogVPanel.add(new
		 * HTML("<b>Sending name to the server:</b>"));
		 * dialogVPanel.add(textToServerLabel); dialogVPanel.add(new
		 * HTML("<br><b>Server replies:</b>"));
		 * dialogVPanel.add(serverResponseLabel);
		 * dialogVPanel.setHorizontalAlignment
		 * (HasHorizontalAlignment.ALIGN_RIGHT); dialogVPanel.add(closeButton);
		 * dialogBox.setWidget(dialogVPanel);
		 * 
		 * // Add a handler to close the DialogBox
		 * closeButton.addClickHandler(new ClickHandler() {
		 * 
		 * @Override public void onClick(final ClickEvent event) {
		 * dialogBox.hide(); sendButton.setEnabled(true);
		 * sendButton.setFocus(true); } });
		 */

		// Create a handler for the sendButton and nameField
		// class MyHandler implements ClickHandler, KeyUpHandler {
		/**
		 * Fired when the user clicks on the sendButton.
		 */
		/*
		 * @Override public void onClick(final ClickEvent event) {
		 * sendNameToServer(); }
		 */

		/**
		 * Fired when the user types in the nameField.
		 */
		/*
		 * @Override public void onKeyUp(final KeyUpEvent event) { if
		 * (event.getNativeKeyCode() == KeyCodes.KEY_ENTER) {
		 * sendNameToServer(); } }
		 */

		/**
		 * Send the name from the nameField to the server and wait for a
		 * response.
		 */
		/*
		 * private void sendNameToServer() { // First, we validate the input.
		 * errorLabel.setText(""); final String textToServer =
		 * nameField.getText(); if (!FieldVerifier.isValidName(textToServer)) {
		 * errorLabel.setText("Please enter at least four characters"); return;
		 * }
		 * 
		 * // Then, we send the input to the server.
		 * sendButton.setEnabled(false);
		 * textToServerLabel.setText(textToServer);
		 * serverResponseLabel.setText("");
		 * greetingService.greetServer(textToServer, new AsyncCallback<String>()
		 * {
		 * 
		 * @Override public void onFailure(final Throwable caught) { // Show the
		 * RPC error message to the user dialogBox
		 * .setText("Remote Procedure Call - Failure"); serverResponseLabel
		 * .addStyleName("serverResponseLabelError"); serverResponseLabel
		 * .setHTML(TestGWT.SERVER_ERROR); dialogBox.center();
		 * closeButton.setFocus(true); }
		 * 
		 * @Override public void onSuccess(final String result) {
		 * dialogBox.setText("Remote Procedure Call"); serverResponseLabel
		 * .removeStyleName("serverResponseLabelError");
		 * serverResponseLabel.setHTML(result); dialogBox.center();
		 * closeButton.setFocus(true); } }); } }
		 */

		// Add a handler to send the name to the server
		/*
		 * final MyHandler handler = new MyHandler();
		 * sendButton.addClickHandler(handler);
		 * nameField.addKeyUpHandler(handler);
		 */
	}
}

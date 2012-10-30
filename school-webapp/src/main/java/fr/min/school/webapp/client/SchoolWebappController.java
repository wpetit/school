/**
 * 
 */
package fr.min.school.webapp.client;

import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

import fr.min.school.webapp.client.event.SuccessfulAuthenticationEvent;
import fr.min.school.webapp.client.event.SuccessfulAuthenticationEventHandler;
import fr.min.school.webapp.client.view.admin.user.CreateUserUiBinder;
import fr.min.school.webapp.client.view.authentication.AuthenticationUiBinder;

/**
 * @author Wilfried Petit
 * 
 */
public class SchoolWebappController {

	/** Main Panel **/
	private Panel mainPanel;

	/** Authentication Panel **/
	private AuthenticationUiBinder authenticationUiBinder;

	/** Create User UI **/
	private CreateUserUiBinder createUserUiBinder;

	/** The error label **/
	private Label errorLabel;

	HandlerManager eventBus;

	public SchoolWebappController() {
		bind();
		initHandler();
	}

	public void initHandler() {
		eventBus.addHandler(SuccessfulAuthenticationEvent.TYPE,
				new SuccessfulAuthenticationEventHandler() {

					@Override
					public void onSuccessfulAuthentication(
							SuccessfulAuthenticationEvent event) {
						displayFavouriteScreen(event.getUserId());
					}
				});
	}

	public void bind() {
		Panel centralPanel = RootPanel.get("centralPanel");
		eventBus = new HandlerManager(null);
		authenticationUiBinder = new AuthenticationUiBinder(eventBus);
		createUserUiBinder = new CreateUserUiBinder(eventBus);
		errorLabel = new Label("");
		mainPanel = new VerticalPanel();
		mainPanel.add(authenticationUiBinder);
		centralPanel.add(mainPanel);
		centralPanel.add(errorLabel);
	}

	public void displayAuthentication() {
		mainPanel.clear();
		mainPanel.add(authenticationUiBinder);
	}

	public void displayCreateUser() {
		mainPanel.clear();
		mainPanel.add(createUserUiBinder);
	}

	/**
	 * Set the error displayed.
	 * 
	 * @param error
	 *            the error to display.
	 */
	public void setErrorText(String error) {
		errorLabel.setText(error);
	}

	/**
	 * Display the favourite screen of the user given.
	 * 
	 * @param userDTO
	 *            the user given.
	 */
	public void displayFavouriteScreen(int userId) {
		// TODO deal with profiles
		if (1 == userId) {
			displayCreateUser();
		} else {
			// TODO redirect to the good panel
			setErrorText(userId + "Favourite screen not yet implemented.");
		}
	}
}

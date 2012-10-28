/**
 * 
 */
package fr.min.school.webapp.client;

import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.RootPanel;
import com.smartgwt.client.widgets.layout.Layout;
import com.smartgwt.client.widgets.layout.VLayout;

import fr.min.school.webapp.client.event.SuccessfulAuthenticationEvent;
import fr.min.school.webapp.client.event.SuccessfulAuthenticationEventHandler;
import fr.min.school.webapp.client.view.admin.user.CreateUserUiBinder;
import fr.min.school.webapp.client.view.authentication.AuthenticationUiBinder;

/**
 * @author Wilfried Petit
 * 
 */
public class SchoolWebappController {

	/** Central Panel Layout **/
	private Layout centralPanelLayout;

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
						Window.alert("successful event catch "
								+ event.getUserId());
						displayFavouriteScreen(event.getUserId());
					}
				});
	}

	public void bind() {
		Panel centralPanel = RootPanel.get("centralPanel");
		eventBus = new HandlerManager(null);
		authenticationUiBinder = new AuthenticationUiBinder(eventBus);
		createUserUiBinder = new CreateUserUiBinder(eventBus);
		centralPanelLayout = new VLayout(20);
		errorLabel = new Label("");
		centralPanelLayout.addMember(authenticationUiBinder);
		centralPanel.add(centralPanelLayout);
		centralPanel.add(errorLabel);
	}

	public void displayAuthentication() {
		centralPanelLayout.clear();
		centralPanelLayout.addMember(authenticationUiBinder);
	}

	public void displayCreateUser() {
		centralPanelLayout.clear();
		centralPanelLayout.addMember(authenticationUiBinder);
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
			setErrorText("");
			displayCreateUser();
		} else {
			// TODO redirect to the good panel
			setErrorText(userId + " successfully logged in.");
		}
	}
}

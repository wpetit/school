/**
 * 
 */
package fr.min.school.webapp.client;

import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

import fr.min.school.model.dto.UserDTO;
import fr.min.school.webapp.client.event.admin.user.UserCreationEvent;
import fr.min.school.webapp.client.event.admin.user.UserCreationEventHandler;
import fr.min.school.webapp.client.event.admin.user.UserCreationQueryEvent;
import fr.min.school.webapp.client.event.admin.user.UserCreationQueryEventHandler;
import fr.min.school.webapp.client.event.admin.user.UserDeletionEvent;
import fr.min.school.webapp.client.event.admin.user.UserDeletionEventHandler;
import fr.min.school.webapp.client.event.admin.user.UserModificationEvent;
import fr.min.school.webapp.client.event.admin.user.UserModificationEventHandler;
import fr.min.school.webapp.client.event.admin.user.UserModificationQueryEvent;
import fr.min.school.webapp.client.event.admin.user.UserModificationQueryEventHandler;
import fr.min.school.webapp.client.event.authentication.SuccessfulAuthenticationEvent;
import fr.min.school.webapp.client.event.authentication.SuccessfulAuthenticationEventHandler;
import fr.min.school.webapp.client.view.admin.user.CreateUserUiBinder;
import fr.min.school.webapp.client.view.admin.user.DisplayUsersUiBinder;
import fr.min.school.webapp.client.view.admin.user.ModifyUserUiBinder;
import fr.min.school.webapp.client.view.authentication.AuthenticationUiBinder;

/**
 * @author Wilfried Petit
 * 
 */
public class SchoolWebappController {

	/** Main Panel **/
	private Panel mainPanel;

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

		eventBus.addHandler(UserCreationQueryEvent.TYPE,
				new UserCreationQueryEventHandler() {
					@Override
					public void onUserCreationQuery(UserCreationQueryEvent event) {
						displayCreateUser();
					}
				});

		eventBus.addHandler(UserModificationQueryEvent.TYPE,
				new UserModificationQueryEventHandler() {
					@Override
					public void onUserModificationQuery(
							UserModificationQueryEvent event) {
						displayModifyUser(event.getUserDTO());
					}
				});

		eventBus.addHandler(UserCreationEvent.TYPE,
				new UserCreationEventHandler() {
					@Override
					public void onUserCreation(UserCreationEvent event) {
						displayUsers();
					}
				});

		eventBus.addHandler(UserModificationEvent.TYPE,
				new UserModificationEventHandler() {
					@Override
					public void onUserModification(UserModificationEvent event) {
						displayUsers();
					}
				});

		eventBus.addHandler(UserDeletionEvent.TYPE,
				new UserDeletionEventHandler() {
					@Override
					public void onUserDeletion(UserDeletionEvent event) {
						displayUsers();
					}
				});
	}

	public void bind() {
		Panel centralPanel = RootPanel.get("centralPanel");
		eventBus = new HandlerManager(null);
		errorLabel = new Label("");
		mainPanel = new VerticalPanel();
		mainPanel.add(new AuthenticationUiBinder(eventBus));
		centralPanel.add(mainPanel);
		centralPanel.add(errorLabel);
	}

	public void displayAuthentication() {
		mainPanel.clear();
		mainPanel.add(new AuthenticationUiBinder(eventBus));
	}

	public void displayCreateUser() {
		mainPanel.clear();
		mainPanel.add(new CreateUserUiBinder(eventBus));
	}

	public void displayModifyUser(UserDTO userDTO) {
		mainPanel.clear();
		mainPanel.add(new ModifyUserUiBinder(eventBus, userDTO));
	}

	public void displayUsers() {
		mainPanel.clear();
		mainPanel.add(new DisplayUsersUiBinder(eventBus));
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
			displayUsers();
		} else {
			// TODO redirect to the good panel
			setErrorText(userId + "Favourite screen not yet implemented.");
		}
	}
}

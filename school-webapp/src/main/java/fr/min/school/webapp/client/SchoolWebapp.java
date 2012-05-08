package fr.min.school.webapp.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.RootPanel;
import com.smartgwt.client.widgets.layout.Layout;
import com.smartgwt.client.widgets.layout.VLayout;

import fr.min.school.model.dto.UserDTO;
import fr.min.school.webapp.client.admin.AdminPanel;
import fr.min.school.webapp.client.authentication.AuthenticationPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class SchoolWebapp implements EntryPoint {

	/** Central Panel Layout **/
	private Layout centralPanelLayout;

	/** Authentication Panel **/
	private Layout authenticationPanel;

	/** Admin Panel **/
	private Layout adminPanel;

	/** The error label **/
	private Label errorLabel;

	/**
	 * This is the entry point method.
	 */
	@Override
	public void onModuleLoad() {
		Panel centralPanel = RootPanel.get("centralPanel");
		centralPanelLayout = new VLayout(20);
		errorLabel = new Label("");
		authenticationPanel = new AuthenticationPanel(this);
		adminPanel = new AdminPanel(this);
		centralPanelLayout.addMember(authenticationPanel);
		centralPanel.add(centralPanelLayout);
		centralPanel.add(errorLabel);
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
	public void displayFavouriteScreen(UserDTO userDTO) {
		// TODO deal with profiles
		if ("admin".equals(userDTO.getLogin())) {
			setErrorText("");
			centralPanelLayout.setMembers(adminPanel);
		} else {
			// TODO redirect to the good panel
			setErrorText(userDTO.getLogin() + " successfully logged in.");
		}
	}
}

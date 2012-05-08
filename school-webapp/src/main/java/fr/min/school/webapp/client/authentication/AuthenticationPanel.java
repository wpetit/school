/**
 * 
 */
package fr.min.school.webapp.client.authentication;

import com.google.gwt.core.client.GWT;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.TitleOrientation;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.FormItem;
import com.smartgwt.client.widgets.form.fields.PasswordItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.layout.VLayout;

import fr.min.school.model.dto.UserDTO;
import fr.min.school.webapp.client.Messages;
import fr.min.school.webapp.client.SchoolWebapp;

/**
 * Authentication Panel.
 * 
 * @author Wilfried Petit
 * 
 */
public class AuthenticationPanel extends VLayout {

	private final Messages messages = GWT.create(Messages.class);

	/** SchoolWebapp **/
	private SchoolWebapp schoolWebapp;

	private TextItem loginItem;
	private TextItem passwordItem;

	/**
	 * Constructor.
	 */
	public AuthenticationPanel(final SchoolWebapp schoolWebapp) {
		this.schoolWebapp = schoolWebapp;
		setMargin(20);

		this.setAlign(Alignment.CENTER);
		this.setLayoutAlign(Alignment.CENTER);
		final DynamicForm form = new DynamicForm();
		form.setTitleOrientation(TitleOrientation.LEFT);

		loginItem = new TextItem();
		loginItem.setTitle(messages.loginField());
		loginItem.setRequired(true);

		passwordItem = new PasswordItem();
		passwordItem.setTitle(messages.passwordField());
		passwordItem.setRequired(true);

		final IButton sendButton = new IButton(messages.sendButton());

		form.setFields(new FormItem[] { loginItem, passwordItem });
		this.addMember(form);
		this.addMember(sendButton);

		draw();
		loginItem.focusInItem();

		// Add a handler to send the name to the server
		final AuthenticationHandler authenticationHandler = new AuthenticationHandler(
				this);
		sendButton.addClickHandler(authenticationHandler);
		loginItem.addKeyUpHandler(authenticationHandler);

	}

	/**
	 * Return the login filled by the user.
	 * 
	 * @return the login
	 */
	public String getLogin() {
		return loginItem.getValueAsString();
	}

	/**
	 * Return the password filled by the user.
	 * 
	 * @return the password
	 */
	public String getPassword() {
		return passwordItem.getValueAsString();
	}

	/**
	 * Set the error displayed.
	 * 
	 * @param error
	 *            the error displayed.
	 */
	public void setErrorText(String error) {
		schoolWebapp.setErrorText(error);
	}

	/**
	 * When the authentication succeed, display the next screen.
	 * 
	 * @param result
	 */
	public void processSuccess(UserDTO userDTO) {
		schoolWebapp.displayFavouriteScreen(userDTO);
	}
}

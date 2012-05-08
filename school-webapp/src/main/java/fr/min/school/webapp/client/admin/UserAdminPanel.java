/**
 * 
 */
package fr.min.school.webapp.client.admin;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.smartgwt.client.types.TitleOrientation;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.FormItem;
import com.smartgwt.client.widgets.form.fields.PasswordItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.layout.HLayout;

import fr.min.school.model.dto.ProfileDTO;
import fr.min.school.model.dto.UserDTO;
import fr.min.school.webapp.client.Messages;
import fr.min.school.webapp.client.SchoolWebapp;
import fr.min.school.webapp.shared.Errors;

/**
 * @author Wilfried Petit
 * 
 */
public class UserAdminPanel extends HLayout {

	private final Messages messages = GWT.create(Messages.class);

	/** Error messages **/
	private final Errors errors = GWT.create(Errors.class);

	/**
	 * Create a remote service proxy to talk to the server-side Authentication
	 * service.
	 */
	private final UserServiceAsync userService = GWT.create(UserService.class);

	/** School Webapp **/
	private SchoolWebapp schoolWebapp;

	private TextItem loginItem;
	private TextItem passwordItem;
	private SelectItem profilesItem;

	private LinkedHashMap<String, ProfileDTO> profilesMap;

	@SuppressWarnings("rawtypes")
	public UserAdminPanel(SchoolWebapp schoolWebapp) {
		this.schoolWebapp = schoolWebapp;
		final DynamicForm form = new DynamicForm();
		form.setTitleOrientation(TitleOrientation.LEFT);

		loginItem = new TextItem();
		loginItem.setTitle(messages.loginField());
		loginItem.setRequired(true);

		passwordItem = new PasswordItem();
		passwordItem.setTitle(messages.passwordField());
		passwordItem.setRequired(true);

		profilesItem = new SelectItem();
		profilesItem.setTitle(messages.profilesField());

		profilesMap = new LinkedHashMap<String, ProfileDTO>();

		userService.retrieveProfiles(new AsyncCallback<List>() {

			@SuppressWarnings("unchecked")
			@Override
			public void onSuccess(List result) {
				LinkedHashMap<String, String> profilesComboMap = new LinkedHashMap<String, String>();
				for (ProfileDTO profile : (List<ProfileDTO>) result) {
					profilesComboMap.put(profile.getName(), profile.getName());
					profilesMap.put(profile.getName(), profile);
				}
				profilesItem.setValueMap(profilesComboMap);
			}

			@Override
			public void onFailure(Throwable caught) {
				setErrorText(errors.profilesCanNotBeRetrieved());
			}
		});

		final IButton creationButton = new IButton(messages.createUserButton());

		form.setFields(new FormItem[] { loginItem, passwordItem, profilesItem });
		this.addMember(form);
		this.addMember(creationButton);

		CreateUserHandler createUserHandler = new CreateUserHandler(this);
		creationButton.addClickHandler(createUserHandler);
		loginItem.addKeyUpHandler(createUserHandler);

	}

	/**
	 * Set the error displayed.
	 * 
	 * @param error
	 *            the error to display.
	 */
	public void setErrorText(String error) {
		schoolWebapp.setErrorText(error);
	}

	/**
	 * Return the user to create.
	 * 
	 * @return the user.
	 */
	public UserDTO getUser() {
		UserDTO userDTO = new UserDTO();
		userDTO.setLogin(loginItem.getValueAsString());
		userDTO.setPassword(passwordItem.getValueAsString());
		List<ProfileDTO> profiles = new ArrayList<ProfileDTO>();
		profiles.add(profilesMap.get(profilesItem.getValue()));
		userDTO.setProfiles(profiles);
		return userDTO;
	}

	/**
	 * Display sucess.
	 */
	public void processSuccess() {
		cleanFields();
		setErrorText(messages.userSuccessfullyCreated());
	}

	/**
	 * Clean fields
	 */
	private void cleanFields() {
		loginItem.setValue("");
		passwordItem.setValue("");
	}

}

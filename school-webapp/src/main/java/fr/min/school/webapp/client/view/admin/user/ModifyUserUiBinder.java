/**
 * 
 */
package fr.min.school.webapp.client.view.admin.user;

import java.util.LinkedHashMap;
import java.util.List;

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
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

import fr.min.school.model.dto.ProfileDTO;
import fr.min.school.model.dto.UserDTO;
import fr.min.school.webapp.client.event.admin.user.UserModificationEvent;
import fr.min.school.webapp.client.service.admin.user.UserService;
import fr.min.school.webapp.client.service.admin.user.UserServiceAsync;

/**
 * @author Wilfried Petit
 * 
 */
public class ModifyUserUiBinder extends Composite {

	private static ModifyUserUiBinderUiBinder uiBinder = GWT
			.create(ModifyUserUiBinderUiBinder.class);

	/**
	 * Create a remote service proxy to talk to the server-side User service.
	 */
	private static final UserServiceAsync userService = GWT
			.create(UserService.class);

	@UiField
	Button button;

	@UiField
	ListBox profileListBox;

	@UiField
	Label informationsLabel;

	@UiField
	TextBox loginTextField;

	@UiField
	TextBox passwordTextField;

	@UiField
	TextBox nameTextField;

	@UiField
	TextBox firstnameTextField;

	@UiField
	TextBox emailTextField;

	private UserDTO userDTO;

	private HandlerManager eventBus;

	private LinkedHashMap<String, ProfileDTO> profilesMap;

	interface ModifyUserUiBinderUiBinder extends
			UiBinder<Widget, ModifyUserUiBinder> {
	}

	/**
	 * Because this class has a default constructor, it can be used as a binder
	 * template. In other words, it can be used in other *.ui.xml files as
	 * follows: <ui:UiBinder xmlns:ui="urn:ui:com.google.gwt.uibinder"
	 * xmlns:g="urn:import:**user's package**">
	 * <g:**UserClassName**>Hello!</g:**UserClassName> </ui:UiBinder> Note that
	 * depending on the widget that is used, it may be necessary to implement
	 * HasHTML instead of HasText.
	 */
	public ModifyUserUiBinder(HandlerManager eventBus, UserDTO userDTO) {
		this.eventBus = eventBus;
		this.userDTO = userDTO;
		initWidget(ModifyUserUiBinder.uiBinder.createAndBindUi(this));
		profilesMap = new LinkedHashMap<String, ProfileDTO>();
		ModifyUserUiBinder.userService
				.retrieveProfiles(new AsyncCallback<List<ProfileDTO>>() {

					@Override
					public void onSuccess(List<ProfileDTO> result) {
						LinkedHashMap<String, String> profilesComboMap = new LinkedHashMap<String, String>();
						for (ProfileDTO profile : result) {
							profilesComboMap.put(profile.getName(),
									profile.getName());
							profilesMap.put(profile.getName(), profile);
							profileListBox.addItem(profile.getName());
						}
					}

					@Override
					public void onFailure(Throwable caught) {
						informationsLabel.setText(caught.getMessage());
					}
				});
		initFields();
	}

	void initFields() {
		loginTextField.setText(userDTO.getLogin());
		passwordTextField.setText(userDTO.getPassword());
		firstnameTextField.setText(userDTO.getFirstname());
		nameTextField.setText(userDTO.getName());
		emailTextField.setText(userDTO.getEmail());
		for (int i = 0; i < profileListBox.getItemCount(); i++) {
			if (profileListBox.getItemText(i).equals(
					userDTO.getProfile().getName())) {
				profileListBox.setSelectedIndex(i);
			}
		}
	}

	@UiHandler("button")
	void onButtonClick(ClickEvent event) {
		userDTO.setLogin(loginTextField.getText());
		userDTO.setPassword(passwordTextField.getText());
		userDTO.setFirstname(firstnameTextField.getText());
		userDTO.setName(nameTextField.getText());
		userDTO.setEmail(emailTextField.getText());
		userDTO.setProfile(profilesMap.get(profileListBox
				.getValue(profileListBox.getSelectedIndex())));
		ModifyUserUiBinder.userService.updateUser(userDTO,
				new AsyncCallback<Void>() {

					@Override
					public void onFailure(Throwable caught) {
						informationsLabel.setText("user update failed.");
					}

					@Override
					public void onSuccess(Void result) {
						eventBus.fireEvent(new UserModificationEvent());
					}
				});
	}
}

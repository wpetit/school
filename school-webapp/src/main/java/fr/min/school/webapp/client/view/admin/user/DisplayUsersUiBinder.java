/**
 * 
 */
package fr.min.school.webapp.client.view.admin.user;

import java.util.List;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.cellview.client.DataGrid;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

import fr.min.school.model.dto.UserDTO;
import fr.min.school.webapp.client.admin.user.UserService;
import fr.min.school.webapp.client.admin.user.UserServiceAsync;
import fr.min.school.webapp.client.event.UserCreationQueryEvent;

/**
 * @author Wilfried Petit
 * 
 */
public class DisplayUsersUiBinder extends Composite {

	private static DisplayUsersUiBinderUiBinder uiBinder = GWT
			.create(DisplayUsersUiBinderUiBinder.class);

	/**
	 * Create a remote service proxy to talk to the server-side User service.
	 */
	private static final UserServiceAsync userService = GWT
			.create(UserService.class);

	@UiField
	Button createUserButton;

	@UiField
	Button modifyUserButton;

	@UiField
	Button deleteUserButton;

	@UiField
	Label informationsLabel;

	@UiField(provided = true)
	DataGrid<Object> dataGrid = new DataGrid<Object>();

	private HandlerManager eventBus;

	interface DisplayUsersUiBinderUiBinder extends
			UiBinder<Widget, DisplayUsersUiBinder> {
	}

	public DisplayUsersUiBinder(HandlerManager eventBus) {
		this.eventBus = eventBus;
		initWidget(DisplayUsersUiBinder.uiBinder.createAndBindUi(this));
		DisplayUsersUiBinder.userService
				.retrieveUsers(new AsyncCallback<List<UserDTO>>() {

					@Override
					public void onSuccess(List<UserDTO> result) {
						for (UserDTO user : result) {
							// dataGrid.add
							// TODO Fill gridData
						}
					}

					@Override
					public void onFailure(Throwable caught) {
						informationsLabel.setText(caught.getMessage());
					}
				});
	}

	@UiHandler("createUserButton")
	void onCreateUserButtonClick(ClickEvent event) {
		eventBus.fireEvent(new UserCreationQueryEvent());
	}
}

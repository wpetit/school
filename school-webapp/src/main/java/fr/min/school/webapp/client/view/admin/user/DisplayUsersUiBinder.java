/**
 * 
 */
package fr.min.school.webapp.client.view.admin.user;

import java.util.List;

import com.google.gwt.cell.client.CheckboxCell;
import com.google.gwt.cell.client.TextCell;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.safehtml.shared.SafeHtmlUtils;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.DataGrid;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.view.client.ListDataProvider;

import fr.min.school.model.dto.UserDTO;
import fr.min.school.webapp.client.admin.user.UserService;
import fr.min.school.webapp.client.admin.user.UserServiceAsync;
import fr.min.school.webapp.client.event.admin.user.UserCreationQueryEvent;
import fr.min.school.webapp.client.event.admin.user.UserDeletionQueryEvent;
import fr.min.school.webapp.client.event.admin.user.UserModificationQueryEvent;

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
	DataGrid<UserDTO> dataGrid = new DataGrid<UserDTO>();

	/**
	 * The provider that holds the list of users in the database.
	 */
	private ListDataProvider<UserDTO> dataProvider = new ListDataProvider<UserDTO>();

	private HandlerManager eventBus;

	interface DisplayUsersUiBinderUiBinder extends
			UiBinder<Widget, DisplayUsersUiBinder> {
	}

	public DisplayUsersUiBinder(HandlerManager eventBus) {
		this.eventBus = eventBus;
		dataGrid = new DataGrid<UserDTO>(new UserDTOProvidesKey());
		dataGrid.setEmptyTableWidget(new Label("No users found."));

		initTableColumns();
		dataProvider.addDataDisplay(dataGrid);

		DisplayUsersUiBinder.userService
				.retrieveUsers(new AsyncCallback<List<UserDTO>>() {

					@Override
					public void onSuccess(List<UserDTO> result) {
						dataProvider.getList().clear();
						for (UserDTO user : result) {
							dataProvider.getList().add(user);
						}
					}

					@Override
					public void onFailure(Throwable caught) {
						informationsLabel.setText(caught.getMessage());
					}
				});
		initWidget(DisplayUsersUiBinder.uiBinder.createAndBindUi(this));
	}

	@UiHandler("createUserButton")
	void onCreateUserButtonClick(ClickEvent event) {
		eventBus.fireEvent(new UserCreationQueryEvent());
	}

	@UiHandler("modifyUserButton")
	void onModifyUserButtonClick(ClickEvent event) {
		eventBus.fireEvent(new UserModificationQueryEvent());
	}

	@UiHandler("deleteUserButton")
	void onDeleteUserButtonClick(ClickEvent event) {
		eventBus.fireEvent(new UserDeletionQueryEvent());
	}

	/**
	 * Add the columns to the table.
	 */
	private void initTableColumns() {
		// Checkbox column. This table will uses a checkbox column for
		// selection.
		// Alternatively, you can call dataGrid.setSelectionEnabled(true) to
		// enable
		// mouse selection.
		Column<UserDTO, Boolean> checkColumn = new Column<UserDTO, Boolean>(
				new CheckboxCell(true, false)) {
			@Override
			public Boolean getValue(UserDTO object) {
				// Get the value from the selection model.
				return true;// selectionModel.isSelected(object);
			}
		};
		dataGrid.addColumn(checkColumn, SafeHtmlUtils.fromSafeConstant("<br/>"));
		dataGrid.setColumnWidth(checkColumn, 40, Unit.PX);

		// ID.
		Column<UserDTO, String> idColumn = new Column<UserDTO, String>(
				new TextCell()) {
			@Override
			public String getValue(UserDTO object) {
				return String.valueOf(object.getId());
			}
		};
		dataGrid.addColumn(idColumn, "Id");
		dataGrid.setColumnWidth(idColumn, 20, Unit.PCT);

		// First name.
		Column<UserDTO, String> loginColumn = new Column<UserDTO, String>(
				new TextCell()) {
			@Override
			public String getValue(UserDTO object) {
				return object.getLogin();
			}
		};
		dataGrid.addColumn(loginColumn, "Login");
		dataGrid.setColumnWidth(loginColumn, 50, Unit.PCT);

		// Firstname.
		Column<UserDTO, String> firstnameColumn = new Column<UserDTO, String>(
				new TextCell()) {
			@Override
			public String getValue(UserDTO object) {
				return object.getFirstname();
			}
		};
		dataGrid.addColumn(firstnameColumn, "Prénom");
		dataGrid.setColumnWidth(firstnameColumn, 50, Unit.PCT);

		// Name.
		Column<UserDTO, String> nameColumn = new Column<UserDTO, String>(
				new TextCell()) {
			@Override
			public String getValue(UserDTO object) {
				return object.getName();
			}
		};
		dataGrid.addColumn(nameColumn, "Nom");
		dataGrid.setColumnWidth(nameColumn, 50, Unit.PCT);

		// Email.
		Column<UserDTO, String> emailColumn = new Column<UserDTO, String>(
				new TextCell()) {
			@Override
			public String getValue(UserDTO object) {
				return object.getEmail();
			}
		};
		dataGrid.addColumn(emailColumn, "Email");
		dataGrid.setColumnWidth(emailColumn, 50, Unit.PCT);

		// Column<UserDTO, List<ProfileDTO>> categoryColumn = new
		// Column<UserDTO, List<ProfileDTO>>(
		// new SelectionCell()) {
		// @Override
		// public List<ProfileDTO> getValue(UserDTO object) {
		// return object.getProfiles();
		// }
		// };
		// dataGrid.addColumn(categoryColumn, "Profils");
		// dataGrid.setColumnWidth(categoryColumn, 130, Unit.PX);

	}
}

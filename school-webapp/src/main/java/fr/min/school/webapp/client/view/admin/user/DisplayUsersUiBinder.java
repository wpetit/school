/**
 * 
 */
package fr.min.school.webapp.client.view.admin.user;

import java.util.Comparator;
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
import com.google.gwt.user.cellview.client.ColumnSortEvent.ListHandler;
import com.google.gwt.user.cellview.client.DataGrid;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.view.client.DefaultSelectionEventManager;
import com.google.gwt.view.client.ListDataProvider;
import com.google.gwt.view.client.SingleSelectionModel;

import fr.min.school.model.dto.UserDTO;
import fr.min.school.webapp.client.event.admin.user.UserCreationQueryEvent;
import fr.min.school.webapp.client.event.admin.user.UserDeletionEvent;
import fr.min.school.webapp.client.event.admin.user.UserModificationQueryEvent;
import fr.min.school.webapp.client.event.information.ErrorEvent;
import fr.min.school.webapp.client.service.admin.user.UserService;
import fr.min.school.webapp.client.service.admin.user.UserServiceAsync;

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

	private SingleSelectionModel<UserDTO> selectionModel;

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

		initTable();
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
		UserDTO userSelected = selectionModel.getSelectedObject();
		eventBus.fireEvent(new UserModificationQueryEvent(userSelected));
	}

	@UiHandler("deleteUserButton")
	void onDeleteUserButtonClick(ClickEvent event) {
		UserDTO userSelected = selectionModel.getSelectedObject();
		DisplayUsersUiBinder.userService.deleteUser(userSelected,
				new AsyncCallback<Void>() {

					@Override
					public void onFailure(Throwable caught) {
						eventBus.fireEvent(new ErrorEvent(caught));
					}

					@Override
					public void onSuccess(Void result) {
						eventBus.fireEvent(new UserDeletionEvent());
					}
				});
	}

	/**
	 * Add the columns to the table.
	 */
	private void initTable() {

		// Add a selection model so we can select cells.
		selectionModel = new SingleSelectionModel<UserDTO>(
				new UserDTOProvidesKey());
		dataGrid.setSelectionModel(selectionModel,
				DefaultSelectionEventManager.<UserDTO> createCheckboxManager());

		// Attach a column sort handler to the ListDataProvider to sort the
		// list.
		ListHandler<UserDTO> sortHandler = new ListHandler<UserDTO>(
				dataProvider.getList());
		dataGrid.addColumnSortHandler(sortHandler);

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
				return selectionModel.isSelected(object);
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
		sortHandler.setComparator(idColumn, new Comparator<UserDTO>() {
			@Override
			public int compare(UserDTO o1, UserDTO o2) {
				return o1.getId() - o2.getId();
			}
		});
		idColumn.setSortable(true);
		dataGrid.addColumn(idColumn, "Id");
		dataGrid.setColumnWidth(idColumn, 20, Unit.PCT);

		// Login.
		Column<UserDTO, String> loginColumn = new Column<UserDTO, String>(
				new TextCell()) {
			@Override
			public String getValue(UserDTO object) {
				return object.getLogin();
			}
		};
		sortHandler.setComparator(loginColumn, new Comparator<UserDTO>() {
			@Override
			public int compare(UserDTO o1, UserDTO o2) {
				return o1.getLogin().compareTo(o2.getLogin());
			}
		});
		loginColumn.setSortable(true);
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
		sortHandler.setComparator(firstnameColumn, new Comparator<UserDTO>() {
			@Override
			public int compare(UserDTO o1, UserDTO o2) {
				return o1.getFirstname().compareTo(o2.getFirstname());
			}
		});
		firstnameColumn.setSortable(true);
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
		sortHandler.setComparator(nameColumn, new Comparator<UserDTO>() {
			@Override
			public int compare(UserDTO o1, UserDTO o2) {
				return o1.getName().compareTo(o2.getName());
			}
		});
		nameColumn.setSortable(true);
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
		sortHandler.setComparator(emailColumn, new Comparator<UserDTO>() {
			@Override
			public int compare(UserDTO o1, UserDTO o2) {
				return o1.getEmail().compareTo(o2.getEmail());
			}
		});
		emailColumn.setSortable(true);
		dataGrid.addColumn(emailColumn, "Email");
		dataGrid.setColumnWidth(emailColumn, 50, Unit.PCT);

		// Profil.
		Column<UserDTO, String> profilColumn = new Column<UserDTO, String>(
				new TextCell()) {
			@Override
			public String getValue(UserDTO object) {
				if (object.getProfile() != null) {
					return object.getProfile().getName();
				} else {
					return null;
				}
			}
		};
		sortHandler.setComparator(profilColumn, new Comparator<UserDTO>() {
			@Override
			public int compare(UserDTO o1, UserDTO o2) {
				return o1.getProfile().getName()
						.compareTo(o2.getProfile().getName());
			}
		});
		profilColumn.setSortable(true);
		dataGrid.addColumn(profilColumn, "Profil");
		dataGrid.setColumnWidth(profilColumn, 50, Unit.PCT);
	}
}

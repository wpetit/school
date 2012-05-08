/**
 * 
 */
package fr.min.school.webapp.client.admin;

import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.Layout;

import fr.min.school.webapp.client.SchoolWebapp;

/**
 * The Admin Panel. Allow user administration and so on.
 * 
 * @author Wilfried Petit
 * 
 */
public class AdminPanel extends HLayout {

	/** School Webapp **/
	private SchoolWebapp schoolWebapp;

	private UserAdminPanel userAdminLayout;
	private Layout adminLayout;
	private Layout menu;

	/**
	 * Constructor.
	 * 
	 * @param schoolWebapp
	 *            the school webapp.
	 */
	public AdminPanel(SchoolWebapp schoolWebapp) {
		setMargin(20);
		this.schoolWebapp = schoolWebapp;
		adminLayout = new Layout();
		userAdminLayout = new UserAdminPanel(schoolWebapp);
		menu = new Layout();
		createMenu();
		displayUserAdminPanel();
		this.addMember(menu);
		this.addMember(adminLayout);
	}

	/**
	 * Create the administration menu.
	 */
	private void createMenu() {

	}

	/**
	 * Display the user administration panel.
	 */
	private void displayUserAdminPanel() {
		adminLayout.setMembers(userAdminLayout);
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
}

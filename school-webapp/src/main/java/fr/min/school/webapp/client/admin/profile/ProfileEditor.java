/**
 * 
 */
package fr.min.school.webapp.client.admin.profile;

import com.google.gwt.editor.client.Editor;
import com.google.gwt.user.client.ui.FormPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;

import fr.min.school.model.dto.ProfileDTO;

/**
 * Profile editor.
 * 
 * @author Wilfried Petit
 * 
 */
public class ProfileEditor extends FormPanel implements Editor<ProfileDTO> {
	Label idEditor;
	TextBox nameEditor;
}

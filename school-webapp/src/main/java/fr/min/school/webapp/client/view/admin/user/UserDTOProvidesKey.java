/**
 * 
 */
package fr.min.school.webapp.client.view.admin.user;

import com.google.gwt.view.client.ProvidesKey;

import fr.min.school.model.dto.UserDTO;

/**
 * @author Wilfried Petit
 * 
 */
public class UserDTOProvidesKey implements ProvidesKey<UserDTO> {

	@Override
	public Object getKey(UserDTO item) {
		return item == null ? null : String.valueOf(item.getId());
	}

}

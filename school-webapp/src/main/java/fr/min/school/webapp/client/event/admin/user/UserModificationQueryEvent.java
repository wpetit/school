/**
 * 
 */
package fr.min.school.webapp.client.event.admin.user;

import com.google.gwt.event.shared.GwtEvent;

import fr.min.school.model.dto.UserDTO;

/**
 * @author Wilfried Petit
 * 
 */
public class UserModificationQueryEvent extends
		GwtEvent<UserModificationQueryEventHandler> {
	public static Type<UserModificationQueryEventHandler> TYPE = new Type<UserModificationQueryEventHandler>();

	private UserDTO userDTO;

	/**
	 * Constructor.
	 * 
	 * @param userDTO
	 */
	public UserModificationQueryEvent(UserDTO userDTO) {
		this.userDTO = userDTO;
	}

	@Override
	public Type<UserModificationQueryEventHandler> getAssociatedType() {
		return UserModificationQueryEvent.TYPE;
	}

	@Override
	protected void dispatch(UserModificationQueryEventHandler handler) {
		handler.onUserModificationQuery(this);
	}

	/**
	 * Return the UserModificationQueryEvent userDTO.
	 * 
	 * @return the userDTO
	 */
	public UserDTO getUserDTO() {
		return userDTO;
	}

}
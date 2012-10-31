package fr.min.school.webapp.client.event.authentication;

import com.google.gwt.event.shared.EventHandler;

public interface SuccessfulAuthenticationEventHandler extends EventHandler {
	void onSuccessfulAuthentication(SuccessfulAuthenticationEvent event);
}

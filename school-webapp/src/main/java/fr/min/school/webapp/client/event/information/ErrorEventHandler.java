package fr.min.school.webapp.client.event.information;

import com.google.gwt.event.shared.EventHandler;

public interface ErrorEventHandler extends EventHandler {
	void onError(ErrorEvent event);
}

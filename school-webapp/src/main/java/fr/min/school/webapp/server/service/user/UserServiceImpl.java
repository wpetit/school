package fr.min.school.webapp.server.service.user;

import java.util.List;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import fr.min.school.business.UserBusiness;
import fr.min.school.model.dto.ProfileDTO;
import fr.min.school.model.dto.UserDTO;
import fr.min.school.webapp.client.service.admin.user.UserService;

/**
 * The server side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class UserServiceImpl extends RemoteServiceServlet implements
		UserService {

	@Override
	public void createUser(UserDTO userDTO) {
		WebApplicationContext ctx = WebApplicationContextUtils
				.getWebApplicationContext(getServletContext());
		UserBusiness userBusiness = (UserBusiness) ctx.getBean("userBusiness");
		// Create the user with these informations.
		userBusiness.createUser(userDTO);
	}

	@Override
	public List<ProfileDTO> retrieveProfiles() {
		WebApplicationContext ctx = WebApplicationContextUtils
				.getWebApplicationContext(getServletContext());
		UserBusiness userBusiness = (UserBusiness) ctx.getBean("userBusiness");
		return userBusiness.retrieveProfiles();
	}

	@Override
	public void updateUser(UserDTO userDTO) {
		WebApplicationContext ctx = WebApplicationContextUtils
				.getWebApplicationContext(getServletContext());
		UserBusiness userBusiness = (UserBusiness) ctx.getBean("userBusiness");
		// Create the user with these informations.
		userBusiness.updateUser(userDTO);
	}

	@Override
	public List<UserDTO> retrieveUsers() {
		WebApplicationContext ctx = WebApplicationContextUtils
				.getWebApplicationContext(getServletContext());
		UserBusiness userBusiness = (UserBusiness) ctx.getBean("userBusiness");
		return userBusiness.retrieveUsers();
	}

	@Override
	public void deleteUser(UserDTO userDTO) {
		WebApplicationContext ctx = WebApplicationContextUtils
				.getWebApplicationContext(getServletContext());
		UserBusiness userBusiness = (UserBusiness) ctx.getBean("userBusiness");
		userBusiness.deleteUser(userDTO);
	}

}

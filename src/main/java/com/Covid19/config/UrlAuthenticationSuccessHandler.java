package com.Covid19.config;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.Covid19.model.ActiveUserData;

@Component("myAuthenticationSuccessHandler")
public class UrlAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

	@Autowired
	ActiveUserData activeUserData;

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException {
		HttpSession session = request.getSession(false);
		if (session != null) {
			LoggedUser user = new LoggedUser();
			user.setUsername(authentication.getName());
			user.setActiveUserData(activeUserData);
			session.setAttribute("user", user);
		}
	}

}

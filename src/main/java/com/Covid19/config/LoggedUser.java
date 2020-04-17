package com.Covid19.config;

import java.util.List;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

import org.springframework.stereotype.Component;

import com.Covid19.model.ActiveUserData;

import lombok.Data;

@Component
@Data
public class LoggedUser implements HttpSessionBindingListener {

	private String username;
	private ActiveUserData activeUserData;

	@Override
	public void valueBound(HttpSessionBindingEvent event) {
		List<String> users = activeUserData.getUsers();
		LoggedUser user = (LoggedUser) event.getValue();
		if (!users.contains(user.getUsername())) {
			users.add(user.getUsername());
		}
	}

	@Override
	public void valueUnbound(HttpSessionBindingEvent event) {
		List<String> users = activeUserData.getUsers();
		LoggedUser user = (LoggedUser) event.getValue();
		if (users.contains(user.getUsername())) {
			users.remove(user.getUsername());
		}
	}
}

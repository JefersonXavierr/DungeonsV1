package com.dungeos.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import com.dungeos.entities.Person;
import com.dungeos.entities.User;
import com.dungeos.service.UserService;

@Named("cadastroBean")
@RequestScoped
public class CadastroBean {

	private User user = new User();
	private List<User> users;

	@Inject
	private UserService userService;

	@PostConstruct
	public void init() {
		users = userService.list();
	}

	public String submit() {
		System.out.println("Gravando usuario " + this.user.getNomeuser());
		if ((this.user.getIduser() == null) && (this.user.getNomeuser() != null)) {
			userService.create(this.user);
			this.user = new User();
			return "login?faces-redirect=true";
		} else {

			return "cadastro?faces-redirect=true";
		}
	}
	
	public String editar() {
		System.out.println("Editando usuário:  " + this.user.getNomeuser());
    	if ((this.user.getIduser() != null) && (this.user.getNomeuser() != null)) {
			userService.merge(this.user);
			this.user = new User();
			return "usuario?faces-redirect=true";
		} else {

			return "usuario?faces-redirect=true";
		}
	}

	public String editarUser(User user) {
		this.user = user;
		return "updateuser";
	}
	
	public boolean isDisable() {
	    return FacesContext.getCurrentInstance().getRenderResponse();
	}
	
	public String remove(User user) {
		System.out.println("Removendo Personagem " + user.getNomeuser());
		if ((user.getIduser() != null) && (user.getNomeuser() != null)) {
			userService.remove(user);
			return "usuario?faces-redirect=true";
		} else {

			return "usuario?faces-redirect=true";
		}
	}

	public User getUser() {
		return user;
	}

	public List<User> getUsers() {
		return users;
	}
}

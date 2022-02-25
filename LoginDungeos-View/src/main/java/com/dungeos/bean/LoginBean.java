package com.dungeos.bean;

import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import com.dungeos.service.LoginService;
import com.dungeos.entities.User;

@Named ("LoginBean")
@RequestScoped
public class LoginBean {
	private User user = new User();
	@Inject
	private LoginService login;
	
	public User getUser() {
		return user;
	}
	
	@PostConstruct
	public void init() {
	    user= new User ();
	}

	
	public String efetuaLogin() throws IOException{
		System.out.println("Fazendo o login"
				+this.user.getEmail());
		FacesContext context = FacesContext.getCurrentInstance();
		boolean existe = login.existe(this.user);
		
		if(existe) {
			context.getExternalContext().getSessionMap()
			.put("Login realizado com sucesso",this.user);
			System.out.println("Passou");
			return "index?faces-redirect=true";
		}
		context.getExternalContext().getFlash().setKeepMessages(true);
		context.addMessage(null, new FacesMessage("Usuário não encontrado"));
		return "login?faces-redirect= true";
	}
	
	public String deslogar() {
		FacesContext context = FacesContext.getCurrentInstance();
		context.getExternalContext().getSessionMap()
			.remove("userLogado");
		
		return "login?faces-redirect=true";
	}
}
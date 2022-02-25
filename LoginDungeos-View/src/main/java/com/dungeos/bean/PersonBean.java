package com.dungeos.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import com.dungeos.entities.Person;
import com.dungeos.service.PersonService;

@Named
@RequestScoped
public class PersonBean {

	private Person person = new Person();
	private List<Person> persons;

	@Inject
	private PersonService personService;

	@PostConstruct
	public void init() {
		persons = personService.list();
	}

	public String submit() {
		System.out.println("Gravando Personagem " + this.person.getNomeperson());
		if ((this.person.getIdperson() == null) && (this.person.getNomeperson() != null)) {
			personService.create(this.person);
			this.person = new Person();
			return "index?faces-redirect=true";
		} else {

			return "cadastro?faces-redirect=true";
		}
	}

	public String editarPerson(Person person) {
		this.person = person;
		return "update";
	}

	public String editar() {
    	if ((this.person.getIdperson() != null) && (this.person.getNomeperson() != null)) {
			personService.merge(person);
			return "listar?faces-redirect=true";
		} else {

			return "listar?faces-redirect=true";
		}
	}

	public String remove(Person person) {
		System.out.println("Removendo Personagem " + person.getNomeperson());
		if ((person.getIdperson() != null) && (person.getNomeperson() != null)) {
			personService.remove(person);
			return "listar?faces-redirect=true";
		} else {

			return "listar?faces-redirect=true";
		}
	}
	
	public boolean isDisable() {
	    return FacesContext.getCurrentInstance().getRenderResponse();
	}

	public Person getPerson() {
		return person;
	}

	public List<Person> getPersons() {
		return persons;
	}
}

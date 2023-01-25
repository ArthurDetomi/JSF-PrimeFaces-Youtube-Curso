package br.com.dominio.controller;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named("msg")
@ViewScoped
public class MessagesMB implements Serializable {

	private static final long serialVersionUID = 1L;

	public void salvar() {
		FacesMessage message = new FacesMessage("Mensagem de sucesso");
		FacesContext.getCurrentInstance().addMessage(null, message);
	}
	
	public void erro() {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Mensagem de Erro", null);
		FacesContext.getCurrentInstance().addMessage(null, message);
	}

}

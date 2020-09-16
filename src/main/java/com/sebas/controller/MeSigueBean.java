package com.sebas.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.sebas.model.PublicadorSeguidor;
import com.sebas.model.Usuario;
import com.sebas.service.ISeguidorService;

@Named
@ViewScoped
public class MeSigueBean implements Serializable {

	@Inject
	private ISeguidorService service;
	private List<PublicadorSeguidor> seguidores;
	private Usuario us;

	@PostConstruct
	public void init() {
		FacesContext context = FacesContext.getCurrentInstance();
		this.us = (Usuario) context.getExternalContext().getSessionMap().get("usuario");
		this.listarSeguidores();
	}

	public void listarSeguidores() {
		try {
			this.seguidores = this.service.listarSeguidores(this.us.getPersona());
		} catch (Exception e) {
			//
		}
	}

	public List<PublicadorSeguidor> getSeguidores() {
		return seguidores;
	}

	public void setSeguidores(List<PublicadorSeguidor> seguidores) {
		this.seguidores = seguidores;
	}

}

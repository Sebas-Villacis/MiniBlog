package com.sebas.service.impl;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.inject.Named;

import org.mindrot.jbcrypt.BCrypt;

import com.sebas.dao.IUsuarioDAO;
import com.sebas.model.Usuario;
import com.sebas.service.IUsuarioService;

@Named
public class UsuarioServiceImpl implements IUsuarioService, Serializable {

	@EJB
	private IUsuarioDAO dao;

	@Override
	public Usuario login(Usuario us) {
		String clave = us.getContrasena();
		String claveHash = dao.traerPassHashed(us.getUsuario());

		try {
			if (BCrypt.checkpw(clave, claveHash)) {
				return dao.leerPorNombreUsuario(us.getUsuario());
			}
		} catch (Exception e) {
			throw e;
		}

		return new Usuario();
	}

}

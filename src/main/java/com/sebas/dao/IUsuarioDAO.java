package com.sebas.dao;

import javax.ejb.Local;

import com.sebas.model.Usuario;

@Local
public interface IUsuarioDAO extends ICRUD<Usuario>{

	String traerPassHashed(String us);
	Usuario leerPorNombreUsuario(String us);
}

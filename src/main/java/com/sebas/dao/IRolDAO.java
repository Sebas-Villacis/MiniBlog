package com.sebas.dao;

import java.util.List;

import javax.ejb.Local;

import com.sebas.model.Rol;
import com.sebas.model.Usuario;
import com.sebas.model.UsuarioRol;

@Local
public interface IRolDAO extends ICRUD<Rol>{

	Integer asignar(Usuario us, List<UsuarioRol> roles);
}

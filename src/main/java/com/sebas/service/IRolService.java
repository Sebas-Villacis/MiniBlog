package com.sebas.service;

import java.util.List;

import com.sebas.model.Rol;
import com.sebas.model.Usuario;

public interface IRolService extends IService<Rol>{

	Integer asignar(Usuario us, List<Rol> roles);
}

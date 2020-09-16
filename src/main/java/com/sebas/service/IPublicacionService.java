package com.sebas.service;

import java.util.List;

import com.sebas.model.Persona;
import com.sebas.model.Publicacion;

public interface IPublicacionService extends IService<Publicacion> {

	List<Publicacion> listarPublicacionesPorPublicador(Persona publicador) throws Exception;
	List<Publicacion> listarPublicacionesDeSeguidores(Persona per);
}

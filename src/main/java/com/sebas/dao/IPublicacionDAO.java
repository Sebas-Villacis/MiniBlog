package com.sebas.dao;

import java.util.List;

import javax.ejb.Local;

import com.sebas.model.Persona;
import com.sebas.model.Publicacion;

@Local
public interface IPublicacionDAO extends ICRUD<Publicacion>{
	
	List<Publicacion> listarPublicacionesPorPublicador(Persona publicador) throws Exception;
	List<Publicacion> listarPublicacionesDeSeguidores(Persona per);

}

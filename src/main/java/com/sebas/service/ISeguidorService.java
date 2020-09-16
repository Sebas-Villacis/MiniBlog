package com.sebas.service;

import java.util.List;

import com.sebas.model.Persona;
import com.sebas.model.PublicadorSeguidor;
import com.sebas.util.ReporteSeguidor;

public interface ISeguidorService {
	
	Integer registrarPublicadoresSeguidores(List<Persona> seguidores, List<Persona> publicadores);
	List<PublicadorSeguidor> listarSeguidores(Persona per);
	Integer dejarSeguir(List<Persona> seguidores, List<Persona> publicadores);
	List<ReporteSeguidor> listarSeguidores();
	List<PublicadorSeguidor> listarSeguidos(Persona per);
}

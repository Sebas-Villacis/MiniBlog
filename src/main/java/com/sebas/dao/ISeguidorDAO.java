package com.sebas.dao;

import java.util.List;

import javax.ejb.Local;

import com.sebas.model.Persona;
import com.sebas.model.PublicadorSeguidor;
import com.sebas.util.ReporteSeguidor;

@Local
public interface ISeguidorDAO {
	
	Integer registrarPublicadoresSeguidores(List<PublicadorSeguidor> publicadores_seguidores);
	List<PublicadorSeguidor> listarSeguidores(Persona per);	
	Integer dejarSeguir(List<PublicadorSeguidor> publicadores_seguidores);	
	List<ReporteSeguidor> listarSeguidores();
	List<PublicadorSeguidor> listarSeguidos(Persona per);
}

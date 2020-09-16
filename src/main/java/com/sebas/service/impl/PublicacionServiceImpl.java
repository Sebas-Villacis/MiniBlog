package com.sebas.service.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.inject.Named;

import com.sebas.dao.IPublicacionDAO;
import com.sebas.model.Mencion;
import com.sebas.model.Persona;
import com.sebas.model.Publicacion;
import com.sebas.model.Tag;
import com.sebas.service.IPublicacionService;

@Named
public class PublicacionServiceImpl implements IPublicacionService, Serializable {

	@EJB
	private IPublicacionDAO dao;

	@Override
	public Integer registrar(Publicacion publicacion) throws Exception {
		List<Tag> tags = new ArrayList<>();
		List<Mencion> menciones = new ArrayList<>();

		String texto = publicacion.getCuerpo();
		texto = texto.replaceAll(",", "");
		String[] arreglo = texto.split(" ");
		for (String elemento : arreglo) {
			if (elemento.startsWith("@")) {
				elemento = elemento.substring(1, elemento.length());
				menciones.add(new Mencion(publicacion, elemento));
			}

			if (elemento.startsWith("#")) {
				elemento = elemento.substring(1, elemento.length());
				tags.add(new Tag(publicacion, elemento));
			}
		}
		publicacion.setTags(tags);
		publicacion.setMenciones(menciones);

		// "Hola como estas @mitocode #premium #2018"
		int rpta = dao.registrar(publicacion);
		return rpta > 0 ? 1 : 0;
	}

	@Override
	public Integer modificar(Publicacion t) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer eliminar(Publicacion t) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Publicacion> listar() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Publicacion listarPorId(Publicacion t) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Publicacion> listarPublicacionesPorPublicador(Persona publicador) throws Exception {
		return dao.listarPublicacionesPorPublicador(publicador);
	}

	@Override
	public List<Publicacion> listarPublicacionesDeSeguidores(Persona per) {
		return dao.listarPublicacionesDeSeguidores(per);
	}
}

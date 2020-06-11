package com.skolarajak.dao;

import java.sql.SQLException;
import java.util.List;

import com.skolarajak.exceptions.dao.ResultNotFoundException;
import com.skolarajak.model.Vlasnik;

public interface VlasnikDAO {
	Vlasnik create(Vlasnik vlasnik) throws SQLException;

	Vlasnik read(String brojVozackeDozvole) throws ResultNotFoundException;

	Vlasnik update(Vlasnik vlasnik);

	void delete(String brojVozackeDozvole);

	List<Vlasnik> getAll() throws ResultNotFoundException;
	List<Vlasnik> getAll(int pageNumber) throws ResultNotFoundException;
	List<Vlasnik> getAllBezVozila(int pageNumber) throws ResultNotFoundException;
	
	long count() throws ResultNotFoundException ;
	
	List<Vlasnik> getAllVlasniciAktivnihVozila() throws ResultNotFoundException; 
	Vlasnik readBezVozila(String brojVozackeDozvole) throws ResultNotFoundException, SQLException; 
}

package com.um.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.um.dto.*;

/**
 * @author Sangeethkumar
 * IDao interface is allows to perform similar operations in different Dao classes.
 *
 */
public interface IDao {
	
     public void addAircraft(AircraftDto dto) throws SQLException;
     public void addSector(SectorDto dto) throws SQLException;
     public ArrayList<AircraftDto>viewAircraft() throws SQLException;
     public ArrayList<SectorDto>viewSector() throws SQLException;
     public ArrayList<String>getAircraftCode() throws SQLException;
}



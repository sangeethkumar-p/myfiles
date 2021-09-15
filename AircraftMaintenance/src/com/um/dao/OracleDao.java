package com.um.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.data.DataConnect;
import com.um.dto.*;

/**
 * @author Sangeethkumar
 *
 */
public class OracleDao implements IDao{
	
	/**
	 * getAircraftCode() method is to return aircraft code from aircraft table.
	 */
	public ArrayList<String> getAircraftCode()throws SQLException {
		Connection con=DataConnect.getDbConnection();
		String sql="SELECT aircraft_code FROM aircraft";
		PreparedStatement pst=con.prepareStatement(sql);
		ResultSet res=pst.executeQuery();
		ArrayList<String>list=new ArrayList<>();
		while(res.next()) {
			list.add(res.getString(1));
		}
		return list;
	}
	
	/**
	 *viewAircraft() method is to return aircraft details in a Arraylist format.
	 */
	public ArrayList<AircraftDto>viewAircraft() throws SQLException{
		ArrayList<AircraftDto>list=new ArrayList<>();
        AircraftDto dto=null;
		Connection con = DataConnect.getDbConnection();
		String sqlQuery = "select * FROM aircraft";
	    Statement st = con.createStatement();
		ResultSet rs =  st.executeQuery(sqlQuery);
		
		
		String aircraft_code;
		String description;
		
		while(rs.next()){
			dto=new AircraftDto();
			aircraft_code=rs.getString(1);
			dto.setAircraftCode(aircraft_code);
			description=rs.getString(2);
			dto.setDescription(description);
			list.add(dto);
		}
		return list;
	}
	
	/**
	 *addAircraft() method is to add aircraft in the existing aircraft table.
	 */
	public void addAircraft(AircraftDto dto) throws SQLException{
		Connection con=DataConnect.getDbConnection();
		String sql="INSERT INTO aircraft VALUES (?,?)";
		PreparedStatement pst=con.prepareStatement(sql);
		pst.setString(1,dto.getAircraftCode());
		pst.setString(2, dto.getDescription());
		
		int rowsUpdated=pst.executeUpdate();
		System.out.println("Rows Updated :"+rowsUpdated);
	}
	
	/**
	 *addSector() method is to add new Sector for the aircraft.
	 */
	public void addSector(SectorDto dto) throws SQLException{
		Connection con =DataConnect.getDbConnection();
		String sql="INSERT INTO sector VALUES(?,?,?,?,?,?)";
		PreparedStatement pst=con.prepareStatement(sql);
		pst.setString(1, dto.getSectorId());
		pst.setString(2, dto.getAircraftCode());
		pst.setString(3, dto.getFromStation());
		pst.setString(4, dto.getToStation());
		pst.setString(5, dto.getScheduleDate());
		pst.setInt(6, dto.getScheduleTime());
		
		int rowsUpdated=pst.executeUpdate();
		System.out.println("Rows Updated :"+rowsUpdated);
	}
	
	/**
	 *viewSector() method is to return sector details.
	 */
	public ArrayList<SectorDto> viewSector() throws SQLException{
		ArrayList<SectorDto>list=new ArrayList<>();
		SectorDto dto=null;
		Connection con=DataConnect.getDbConnection();
			String sql="SELECT * FROM sector ";
			Statement st=con.createStatement();
			ResultSet res=st.executeQuery(sql);
			
			String sector_id;
			String aircraft_code;
			String from_station;
			String to_station;
			String schedule_date;
			int schedule_time;
			while(res.next()) {
				dto=new SectorDto();
				sector_id=res.getString(1);
				dto.setSectorId(sector_id);
				aircraft_code=res.getString(2);
				dto.setAircraftCode(aircraft_code);
				from_station=res.getString(3);
				dto.setFromStation(from_station);
				to_station=res.getString(4);
				dto.setToStation(to_station);
				schedule_date=res.getString(5);
				dto.setScheduleDate(schedule_date);
				schedule_time=res.getInt(6);
				dto.setScheduleTime(schedule_time);
				list.add(dto);	
			}
		return list;
	}
}
	
		

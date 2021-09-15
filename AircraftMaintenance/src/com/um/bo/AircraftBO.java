package com.um.bo;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import com.um.dao.*;
import com.um.dto.*;
import com.um.factory.AbstractFactory;
import com.um.utility.Scan;

/**
 * @author Sangeethkumar
 * Aircraft business class is to managing the aircraft by giving choices to the user
 * for performing crud operations(create,read,update and delete)
 *
 */

public class AircraftBO {
	
	/**
	 * AircraftSystem() method is to maintaining the aircraft system.
	 */
	public void aircraftSystem() {
		AbstractFactory factory=AbstractFactory.getFactory(1);
		IDao dao=factory.getDao();
		int choice = 0;
		Scanner scan = Scan.getScannerInstance();
		do{
			System.out.println("1. Register Aircraft ");
			System.out.println("2. Register Sector");
			System.out.println("3. view Aircraft ");
			System.out.println("4. view Sector ");
			System.out.println("5. Exit");
			System.out.println("Enter your Choice: ");
			choice = scan.nextInt();
			System.out.println("---------------------------------");
		}while(choice==0);
		switch(choice) {
		case 1:
			registerAircraft(dao);
			break;
		case 2:
			registerSector(dao);
			break;
		case 3:
			viewAircraft(dao);
			break;
		
		case 4:
			viewSector(dao);
			break;
		case 5:
			return;
		}
		aircraftSystem();
	}
	
	/**
	 * @param dao   
	 * registerAircraft() method is to register new aircraft.
	 */
	public void registerAircraft(IDao dao){
		System.out.println("How many aircrafts registered? ");
		int n=Scan.getScannerInstance().nextInt();
		ArrayList<AircraftDto>dto=new ArrayList<>();
		dto = getAircraftDetails(n);
		for(int i=0;i<n;i++) {
			try {
				dao.addAircraft(dto.get(i));
			
			} catch (SQLException e) {
			System.out.println(e.getMessage());
			}
		}
	}
	
	/**
	 * @param n
	 * @return
	 */
	private ArrayList<AircraftDto>getAircraftDetails(int n){
	    Scanner scan=Scan.getScannerInstance();
		ArrayList<AircraftDto>dto=new ArrayList<>();
		for(int i=0;i<n;i++) {
			dto.add(new AircraftDto());
			System.out.println("Enter an AircraftCode : ");
            dto.get(i).setAircraftCode(scan.next());
			System.out.println("Enter the Description : ");
			dto.get(i).setDescription(scan.next());
			
		}
		return dto;
	}
	
	/**
	 * @param dao
	 * viewAircraft() method helps to view all the aircraft details.
	 */
	public void viewAircraft(IDao dao) {
		try {
			ArrayList<AircraftDto>dto=new ArrayList<>();
			dto.addAll(dao.viewAircraft());
			for(int i=0;i<dto.size();i++) {
				System.out.println("Row ==>"+(i+1));
				System.out.println("AircraftCode         :"+dto.get(i).getAircraftCode());
				System.out.println("Aircraft Description :"+dto.get(i).getDescription());
			    System.out.println("-------------------------------------------");
			}
		}catch(SQLException e) {
			return;
		}
		
	}
	
	/**
	 * @param dao
	 * registerSector() method is to register new Sector for aircrafts.
	 * 
	 */
	public void registerSector(IDao dao) {
		viewAircraft(dao);
		System.out.println("How many sectors registered?");
		int n=Scan.getScannerInstance().nextInt();
		ArrayList<SectorDto>dto=new ArrayList<>();
		dto=getSectorDetails(n);
		for(int i=0;i<n;i++) {
			try {
				dao.addSector(dto.get(i));	
			}catch(SQLException e) {
				return ;
			}
		}
	}
	
	/**
	 * @param n
	 * @return
	 */
	private ArrayList<SectorDto>getSectorDetails(int n){
		Scanner scan=Scan.getScannerInstance();
		ArrayList<SectorDto>dto=new ArrayList<>();
		for(int i=0;i<n;i++) {
			dto.add(new SectorDto());
			
			System.out.println("Enter SectorId        : ");
            dto.get(i).setSectorId(scan.next());
            
			System.out.println("Enter an AircraftCode : ");
			dto.get(i).setAircraftCode(scan.next());
			
			System.out.println("From Station          : ");
			dto.get(i).setFromStation(scan.next());
			
			System.out.println("To Station            : ");
			dto.get(i).setToStation(scan.next());
			
			System.out.println("Enter ScheduleDate    : ");
			dto.get(i).setScheduleDate(scan.next());
			
			System.out.println("Enter ScheduledTime   :");
			dto.get(i).setScheduleTime(scan.nextInt());
			
		}
		return dto;
	}
	
	/**
	 * @param dao
	 * viewSector() method helps to view all the sector details of the aircraft.
	 */
	public void viewSector(IDao dao) {
		
		try {
			ArrayList<String>str=new ArrayList<>();
			str.addAll(dao.getAircraftCode());
			ArrayList<SectorDto>dto=new ArrayList<>();
			dto.addAll(dao.viewSector());
			for(int i=0;i<dto.size();i++) {
				for(int j=0;j<str.size();j++) {
					if(dto.get(i).getAircraftCode().contains(str.get(j))) {
						System.out.println("Row ==>"+(i+1));
						System.out.println("SectorId           :"+dto.get(i).getSectorId());
						System.out.println("Aircraft Code      :"+dto.get(i).getAircraftCode());
						System.out.println("From station       :"+dto.get(i).getFromStation());
						System.out.println("To station         :"+dto.get(i).getToStation());
						System.out.println("Schedule Date      :"+dto.get(i).getScheduleDate());
						System.out.println("Schedule Time      :"+dto.get(i).getScheduleTime());
						System.out.println("-------------------------------------------");
				}
			}
		}
		}catch(SQLException e) {
			return;
		}
	}
	
}  

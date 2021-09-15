package com.um.factory;

import com.um.dao.IDao;

public abstract class AbstractFactory {
	/**
	 * @return
	 */
	public abstract IDao getDao();
	
	/**
	 * @param choice
	 * @return
	 * getFactory() method is to select the required factory to the user by giving choices. 
	 */
	public static AbstractFactory getFactory(int choice){
		AbstractFactory factory = null;
		if(choice ==1 ){
			factory = new OracleFactory();
		}else if(choice ==2){
			factory = new FileSystemFactory();
		}
		return factory;
	}
}

package com.um.factory;

import com.um.dao.IDao;
import com.um.dao.OracleDao;

public class OracleFactory extends AbstractFactory {

	public IDao getDao() {
		return new OracleDao();
	}

}

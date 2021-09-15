package com.um.factory;

import com.um.dao.FileSystemDao;
import com.um.dao.IDao;

public class FileSystemFactory extends AbstractFactory {

	public IDao getDao() {

		return new FileSystemDao();
	}

}

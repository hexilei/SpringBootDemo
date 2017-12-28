package com.rmbin.dao;

import org.apache.log4j.Logger;

public class DaoException extends Exception {
	
	private Logger logger = Logger.getLogger(DaoException.class);
	
	public DaoException()
	{
		super();
	}
	
	public DaoException(Throwable throwable)
	{
		super(throwable);
	}
	
	public DaoException(String message)
	{
		super(message);
		logger.info(message);
	}

}

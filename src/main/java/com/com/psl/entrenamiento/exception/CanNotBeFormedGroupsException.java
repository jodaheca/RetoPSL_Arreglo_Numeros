package com.com.psl.entrenamiento.exception;

/**
 * Clase con la que se controlan las excepciones cuando no se pueden armar los grupos 
 * @author dhernandezc
 *
 */
public class CanNotBeFormedGroupsException  extends Exception{
	
	public CanNotBeFormedGroupsException(String string) {
		super(string);
	}

	public CanNotBeFormedGroupsException(String string, Throwable e) {
		super(string, e);
	}

	public CanNotBeFormedGroupsException(Throwable e) {
		super(e);
	}
}

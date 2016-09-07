package co.com.psl.entrenamiento.arreglo_numeros;

import static org.junit.Assert.*;

import java.util.ArrayList;
import org.junit.Test;

import org.apache.commons.lang3.StringUtils;

import com.com.psl.entrenamiento.exception.CanNotBeFormedGroupsException;

import junit.framework.TestCase;

public class EvaluadorTest {

	private Evaluador evaluador;
	private ArrayList<Integer> dataSet;
	private ArrayList<String> arrayResultadoEsperado;
	private String esperadoGrupo1;
	private String esperadoGrupo2;
	
	@Test
	public void evaluarArregloConDosNumerosIguales() throws CanNotBeFormedGroupsException{
		esperadoGrupo1 = "1";
		esperadoGrupo2 = "1";
		evaluador = new Evaluador();
		dataSet = new ArrayList<Integer>();
		dataSet.add(1);
		dataSet.add(1);
		arrayResultadoEsperado = evaluador.evaluarArreglo(dataSet);
		assertTrue(StringUtils.equals(esperadoGrupo1, arrayResultadoEsperado.get(0)));
		assertTrue(StringUtils.equals(esperadoGrupo2, arrayResultadoEsperado.get(1)));
	}
	
	@Test (expected = CanNotBeFormedGroupsException.class)
	public void evaluarArregloCuandoNoSePuendenArmarLosGrupos() throws CanNotBeFormedGroupsException{
		esperadoGrupo1 = "1";
		esperadoGrupo2 = "1";
		evaluador = new Evaluador();
		dataSet = new ArrayList<Integer>();
		dataSet.add(1);
		dataSet.add(2);
		arrayResultadoEsperado = evaluador.evaluarArreglo(dataSet);
		assertTrue(StringUtils.equals(esperadoGrupo1, arrayResultadoEsperado.get(0)));
		assertTrue(StringUtils.equals(esperadoGrupo2, arrayResultadoEsperado.get(1)));
	}
}

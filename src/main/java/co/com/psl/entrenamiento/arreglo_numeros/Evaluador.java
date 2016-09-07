package co.com.psl.entrenamiento.arreglo_numeros;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import com.com.psl.entrenamiento.exception.CanNotBeFormedGroupsException;

/**
 */
public class Evaluador {

	public ArrayList<String> evaluarArreglo(ArrayList<Integer> dataSet) throws CanNotBeFormedGroupsException {
		ArrayList<Integer> dataSetOrdenado = ordernarArregloMayorAMenor(dataSet);
		int sumatoria = sumarElementos(dataSetOrdenado);
		if (sumatoria %2 != 0) {
			throw new CanNotBeFormedGroupsException("No se pueden formar los grupos");
		}
		
		return new ArrayList<String>();
	}
	
	
	/**
	 * Función en la cual se obtiene el total de la suma de todos los números del arreglo;
	 * @param dataSetOrdenado
	 * 			{@link ArrayList} Contiene los números que se van a sumar
	 * @return {@link Integer} Sumatoria de los elementos
	 * @author dhernandezc
	 */
	private int sumarElementos(ArrayList<Integer> dataSetOrdenado) {
		int totalSuma = 0;
		for (int i : dataSetOrdenado) {
			totalSuma += i;
		}
		return totalSuma;
	}


	/**
	 * Función en la cual se ordena el arreglo de enteros de Mayor a Menor
	 * @param dataSet
	 * 			{@link ArrayList} Que contiene los numeros
	 * @return {@link ArrayList} con los números ordenados
	 * @author dhernandezc
	 */
	private ArrayList<Integer> ordernarArregloMayorAMenor(ArrayList<Integer> dataSet){
		Collections.sort(dataSet);
		Comparator<Integer> comparador = Collections.reverseOrder();
		Collections.sort(dataSet, comparador);
		return dataSet;
	}

}

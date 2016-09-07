package co.com.psl.entrenamiento.arreglo_numeros;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import com.com.psl.entrenamiento.exception.CanNotBeFormedGroupsException;

/**
 */
public class Evaluador {

	public ArrayList<String> evaluarArreglo(ArrayList<Integer> dataSet) throws CanNotBeFormedGroupsException {
		int sumatoria = sumarElementos(dataSet);
		if (sumatoria %2 != 0) {
			throw new CanNotBeFormedGroupsException("No se pueden formar los grupos");
		}
		ArrayList<Integer> dataSetOrdenado = ordernarArregloMayorAMenor(dataSet);
		return obtenerGrupos(dataSetOrdenado, sumatoria/2); 
	}
	
	
	private ArrayList<String> obtenerGrupos(ArrayList<Integer> dataSetOrdenado, int totalDeUnGrupo) {
		String primerGrupo;
		String grupoUno = "";
		String grupoDos = "";
		ArrayList<String> gruposFinales = new ArrayList<String>();
		int numeroEvaluado;
		int cantidadElementos = dataSetOrdenado.size(); 
		for (int i = 0; i < cantidadElementos; i++) {
			numeroEvaluado = dataSetOrdenado.get(i);
			if (numeroEvaluado == totalDeUnGrupo) {
				grupoUno = Integer.toString(numeroEvaluado);
				dataSetOrdenado.remove(i);
				grupoDos = dataSetOrdenado.toString();
				grupoDos = grupoDos.substring(1, grupoDos.length()-1);
				break;
			}
		}
		gruposFinales.add(grupoUno);
		gruposFinales.add(grupoDos);
		return gruposFinales;
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

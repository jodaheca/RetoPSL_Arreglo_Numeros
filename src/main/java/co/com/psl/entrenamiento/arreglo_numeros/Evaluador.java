package co.com.psl.entrenamiento.arreglo_numeros;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import com.com.psl.entrenamiento.exception.CanNotBeFormedGroupsException;

/**
 */
public class Evaluador {
	
	private String grupoUno = "";
	private String grupoDos = "";
	private ArrayList<String> gruposFinales = new ArrayList<String>();
	private int numeroEvaluado;
	private int totalPrimerGrupo = 0;
	
	public ArrayList<String> evaluarArreglo(ArrayList<Integer> dataSet) throws CanNotBeFormedGroupsException {
		int sumatoria = sumarElementos(dataSet);
		if (sumatoria %2 != 0) {
			throw new CanNotBeFormedGroupsException("No se pueden formar los grupos");
		}
		ArrayList<Integer> dataSetOrdenado = ordernarArregloMayorAMenor(dataSet);
		return obtenerGrupos(dataSetOrdenado, sumatoria/2); 
	}
	
	/**
	 * Función recursiva mediante la cual se obtiene los grupos formados
	 * @param dataSetOrdenado
	 * @param totalDeUnGrupo
	 * @return
	 * @author dhernandezc
	 */
	private ArrayList<String> obtenerGrupos(ArrayList<Integer> dataSetOrdenado, int totalDeUnGrupo) {
		int cantidadElementos = dataSetOrdenado.size(); 
		for (int i = 0; i < cantidadElementos; i++) {
			numeroEvaluado = dataSetOrdenado.get(i);
			if (numeroEvaluado == totalDeUnGrupo) {
				grupoUno = Integer.toString(numeroEvaluado);
				dataSetOrdenado.remove(i);
				grupoDos = dataSetOrdenado.toString();
				grupoDos = grupoDos.substring(1, grupoDos.length()-1);
				gruposFinales.add(grupoUno);
				gruposFinales.add(grupoDos);
				return gruposFinales;
			}else if (totalPrimerGrupo + numeroEvaluado == totalDeUnGrupo) {
				totalPrimerGrupo += numeroEvaluado;
				grupoUno = new StringBuilder(grupoUno).append(", ").append(numeroEvaluado).toString();
				dataSetOrdenado.remove(i);
				grupoDos = dataSetOrdenado.toString();
				grupoDos = grupoDos.substring(1, grupoDos.length()-1);
				gruposFinales.add(grupoUno);
				gruposFinales.add(grupoDos);
				return gruposFinales;
			}else if (totalPrimerGrupo + numeroEvaluado < totalDeUnGrupo) {
				grupoUno = new StringBuilder(grupoUno).append(", ").append(numeroEvaluado).toString();
				dataSetOrdenado.remove(i);
				obtenerGrupos(dataSetOrdenado, totalDeUnGrupo);
			}else {
				obtenerGrupos(dataSetOrdenado, totalDeUnGrupo);
			}
		}
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

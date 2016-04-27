package ej6;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Carreras {
	public class MyQuickSort {
	     
	    private int array[];
	    private int length;
	 
	    public void sort(int[] inputArr) {
	         
	        if (inputArr == null || inputArr.length == 0) {
	            return;
	        }
	        this.array = inputArr;
	        length = inputArr.length;
	        quickSort(0, length - 1);
	    }
	 
	    private void quickSort(int lowerIndex, int higherIndex) {
	         
	        int i = lowerIndex;
	        int j = higherIndex;
	        // calculate pivot number, I am taking pivot as middle index number
	        int pivot = array[lowerIndex+(higherIndex-lowerIndex)/2];
	        // Divide into two arrays
	        while (i <= j) {
	            /**
	             * In each iteration, we will identify a number from left side which
	             * is greater then the pivot value, and also we will identify a number
	             * from right side which is less then the pivot value. Once the search
	             * is done, then we exchange both numbers.
	             */
	            while (array[i] < pivot) {
	                i++;
	            }
	            while (array[j] > pivot) {
	                j--;
	            }
	            if (i <= j) {
	                exchangeNumbers(i, j);
	                //move index to next position on both sides
	                i++;
	                j--;
	            }
	        }
	        // call quickSort() method recursively
	        if (lowerIndex < j)
	            quickSort(lowerIndex, j);
	        if (i < higherIndex)
	            quickSort(i, higherIndex);
	    }
	 
	    private void exchangeNumbers(int i, int j) {
	        int temp = array[i];
	        array[i] = array[j];
	        array[j] = temp;
	    }
	
	}
	public int[] solve(int[] entrada){
		int[] resultado = new int[1];
		/*for(int i = 0; i < entrada.length;i++){
			System.out.println(entrada[i]);
		}
		System.out.println("---------");
		*/
		if(entrada[0] < 1)	throw new IllegalArgumentException();
		int[] pilas = new int[entrada.length - 2];
		for(int i = 0; i < entrada[0]; i++){
			pilas[i] = entrada[2+i];
		}
		MyQuickSort sorter = new MyQuickSort();
	    sorter.sort(pilas);
	
	     /*for(int i = 0; i < pilas.length;i++){
				System.out.println(pilas[i]);
			}
			System.out.println("---------");
	     */
	     
	    int indice_inferior = 0;
	    int indice_superior = pilas.length - 1;
	    int coches = 0;
	    
	    while(indice_inferior < indice_superior){
	    	if(pilas[indice_inferior] + pilas[indice_superior] >= entrada[1]){
	    		coches = coches + 1;
	    		indice_inferior++;
	    		indice_superior--;
	    	}
	    	else{
	    		indice_inferior++;
	    	}
	    }
	    resultado[0] = coches;
		return resultado;
	}
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new FileReader("entrada_coches"));
		String aux1 = bf.readLine();
		int numero_de_casos = Integer.parseInt(aux1);
		
		for(int i = 0; i < numero_de_casos; i++){
			String aux2 = bf.readLine();
			String palabrasSeparadas[] = aux2.split(" ");
			int numero_de_pilas = Integer.parseInt(palabrasSeparadas[0]);
			int voltaje = Integer.parseInt(palabrasSeparadas[1]);
			
			String aux3 = bf.readLine();
			String pilasSeparadas[] = aux3.split(" ");
			
			int[] entrada = new int[2 + pilasSeparadas.length];
			entrada[0] = numero_de_pilas;
			entrada[1] = voltaje;
			for(int j = 0; j < numero_de_pilas;j++){
				entrada[2 + j] = Integer.parseInt(pilasSeparadas[j]);
			}
			
			Carreras a = new Carreras();
			a.solve(entrada);
		}
	}
}

package ej4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;

public class Polinomios {

	public class Polinomio{
		private int[] coeficientes;
		
		public Polinomio(int[] coeficientes){
			this.coeficientes = coeficientes;
			
		}
		public int evaluar(int n){
			int resultado = 0;
			int tamaño = coeficientes.length;
			
			for(int i = 0; i < tamaño - 1; i++){
				resultado = resultado + (int) Math.pow(n, tamaño-i-1) * coeficientes[i];
				//System.out.println(resultado);
			}
			resultado = resultado + coeficientes[tamaño-1];
			return resultado;
		}
	}
	public int[] solve(int[] entrada){
		/*for (int i = 0; i < entrada.length; i++){
			System.out.println(entrada[i]);
		}
		System.out.println("----------");
		*/
		int[] resultado = new int[entrada.length - (1 + entrada[0] + 1)];
		//System.out.println(resultado.length);
		int[] coeficientes = new int[entrada[0] + 1];
		for(int i = 0; i < entrada[0] + 1;i++){
			coeficientes[i] = entrada[i + 1];
		}
		Polinomio poli = new Polinomio(coeficientes);
		for(int i = 0; i < resultado.length;i++){
			resultado[i] = poli.evaluar(entrada[1 + entrada[0] + 1 + i]);
			//System.out.println(entrada[1 + entrada[0] + 1 + i]);
			//System.out.println(resultado[i]);
		}
		return resultado;
		
	}
	public static void main(String[] args) throws IOException {
	/*	int[] entrada = new int[3];
		entrada[0] = 0;	entrada[1] = 0;	entrada[2] = 7;
		Polinomios a = new Polinomios();
		//System.out.println(a.solve(entrada)[0]);
		 * 
		 */
		BufferedReader bf = new BufferedReader(new FileReader("entrada_polinomios"));
		
		try{
			while(true){
				
				String aux1 = bf.readLine();
				int grado = Integer.parseInt(aux1);
				String aux2 = bf.readLine();
				int[] coeficientes = new int[grado + 1];
				String palabrasSeparadas[] = aux2.split(" ");
				for(int i = 0; i < grado + 1;i++){
					coeficientes[i] = Integer.parseInt(palabrasSeparadas[i]);
				}
				//System.out.println("holiwi");
				Vector<Integer> v_aux = new Vector();
				String aux3 = bf.readLine();
				//System.out.println(aux3);
				String valores_a_evaluar[] = aux3.split(" ");
				int valor = Integer.parseInt(valores_a_evaluar[0]);
				int i = 1;
				while(valor != 0){

					v_aux.add(valor);
					valor = Integer.parseInt(valores_a_evaluar[i]);
					i++;
				}
				
				int[] entrada = new int[1 + grado + 1 + v_aux.size()];
				entrada[0] = grado;
				//System.out.println(entrada.length + "," + coeficientes.length);
				for(int j = 0; j < grado + 1; j++){
					entrada[j+1] = coeficientes[j];
				}
				for(int j = 0; j < v_aux.size(); j++){
					entrada[1 + grado + 1 +j] = v_aux.get(j);
				}
				
				Polinomios a = new Polinomios();
				a.solve(entrada);
			}
		}
		catch(Exception e){
			System.out.println(e);
		}
	
	}
	
}

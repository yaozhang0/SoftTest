package gisa1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ParesImpares {

	public int[] solve(int[] entrada){
		int[] resultado;
		
		int p = -1;
		boolean imparEncontrado = false;
		boolean parEncontrado = false;
		int i = 0;
		
		while(!imparEncontrado && i < entrada.length -1){
			if(entrada[i+1] %2 != 0){ 
				imparEncontrado = true;
				p = i;
			}
			else i++;
		}
		
		while(!parEncontrado && i < entrada.length -1){
			if(entrada[i+1] %2 == 0){ 
				parEncontrado = true;
			}
			else i++;
		}
		if(i == entrada.length -1 && imparEncontrado){
			resultado = new int[2];
			resultado[0] = 1;
			resultado[1] = p;
			
			//System.out.println(resultado[0] + "," + resultado[1]);
		}
		else{
			resultado = new int[1];
			resultado[0] = 0;
			//System.out.println(resultado[0]);
		}
		
		return resultado;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new FileReader("entrada_paresimpares"));
		int numero_de_casos = Integer.parseInt(bf.readLine());
		
		for(int i = 0; i < numero_de_casos; i++){
			
			String aux1 = bf.readLine();
			int numero_elementos = Integer.parseInt(aux1);
			int[] entrada = new int[1+numero_elementos];
			String aux2 = bf.readLine();
			String elementos_separados[] = aux2.split(" ");
			for(int j = 0; j < numero_elementos;j++){
				entrada[j+1] = Integer.parseInt(elementos_separados[j]);
			}
			
			ParesImpares a = new ParesImpares();
			a.solve(entrada);
		}
	}
}

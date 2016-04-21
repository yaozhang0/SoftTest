package ej10;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Rosa {
	public int[] solve(int[] entrada){
		int[] resultado = new int[entrada[1]];
		int pagina_inicial = entrada[0];
		int pagina_final = entrada[1];
		
		int digitos_totales = 0;
		for(int i = pagina_inicial; i <= pagina_final; i++){
			digitos_totales = (int) (digitos_totales + Math.log10(i)+1);
		}
		boolean encontrado = false;
		boolean restar = false;
		int digitos_a_escribir = digitos_totales / 2;
		int i = pagina_inicial;
		int contador = 0;
		while(!encontrado){
			contador = (int) (contador + Math.log10(i)+1);
			if(contador == digitos_a_escribir) encontrado = true;
			else if(contador > digitos_a_escribir){
				encontrado = true;
				i--;
			}
			else i++;
		}

		//System.out.println(i);
		resultado[0] = i;
		return resultado;
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new FileReader("entrada_rosa"));
		
		boolean encontrado = false;
		while(!encontrado){
		String aux1 = bf.readLine();
		String palabrasSeparadas[] = aux1.split(" ");
		
		int pagina_inicial = Integer.parseInt(palabrasSeparadas[0]);
		int pagina_final = Integer.parseInt(palabrasSeparadas[1]);
		
		if(pagina_inicial == 0 && pagina_final == 0){
			encontrado = true;
		}
		else{
			int[] entrada = new int[2];
			entrada[0] = Integer.parseInt(palabrasSeparadas[0]);
			entrada[1] = Integer.parseInt(palabrasSeparadas[1]);
			
			Rosa a = new Rosa();
			a.solve(entrada);
		}
	}
	}
}

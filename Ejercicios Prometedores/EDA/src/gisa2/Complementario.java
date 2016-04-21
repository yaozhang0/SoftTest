package gisa2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Complementario {

	public int[] solve(int[] entrada){
		int[] resultado = new int[1];
		int numero = entrada[0];
		int length = (int)(Math.log10(numero)+1);
		int[] numero_en_vector = new int[length];
		
		for(int i = 0; i < length; i++){
			numero_en_vector[i] = numero / (int) Math.pow(10, length-i-1);
			numero = (int) (numero - numero_en_vector[i] * Math.pow(10, length-i-1));
			//System.out.println(numero_en_vector[i]);
		}
		//System.out.println(length);
		
		int[] complementario_en_vector = new int[length];
		for (int i = 0; i < length; i++){
			complementario_en_vector[i] = 9 - numero_en_vector[i];
			//System.out.println(complementario_en_vector[i]);
		}
		int complementario = 0;
		for(int i = 0; i < length; i++){
			complementario = (int) (complementario + complementario_en_vector[i] * Math.pow(10, length-i-1));
		}
		resultado[0] = complementario;
		//System.out.println(complementario);
		return resultado;
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new FileReader("entrada_complementario"));
		boolean encontrado = false;

		
		while(!encontrado){
			String aux1 = bf.readLine();
			int numero = Integer.parseInt(aux1);
			if(numero == -1) encontrado = true;
			else{
				int[] entrada = new int[1];
				entrada[0] = numero;
				Complementario a = new Complementario();
				int[] r = a.solve(entrada);
				System.out.println(r[0]);
			}
		}
	}
}

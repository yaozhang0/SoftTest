package dg2b;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Salvados9 {
	
	public int[] solve(float[] entrada){
		int[] resultado = new int[1];
		
		if(entrada[0] == 0) throw new IllegalArgumentException();
		/*for(int i = 0; i < entrada.length;i++){
			System.out.println(entrada[i]);
		}
		System.out.println("----");
		*/
		boolean alguncero=false;
		boolean algunnueve=false;
		
		int i = 1;
		while(!algunnueve && i < entrada.length){
			if(entrada[i] == 0) alguncero=true;
			else if(entrada[i] >= 9) algunnueve=true;
			i++;
		}

		if(alguncero && !algunnueve) resultado[0] = 0;
		else{
			resultado[0] = 1;
		}
		
		return resultado;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new FileReader("entrada_9"));
		
		String aux1 = bf.readLine();
		int numero_de_Casos = Integer.parseInt(aux1);
		
		for(int i = 0; i < numero_de_Casos; i++){
			String aux2 = bf.readLine();
			int numero_de_notas = Integer.parseInt(aux2);
			float[] entrada = new float[numero_de_notas + 1];
			entrada[0] = numero_de_notas;
			String aux3 = bf.readLine();
			String palabrasSeparadas[] = aux3.split(" ");
			for(int j = 0; j < numero_de_notas; j++){
				entrada[j+1] = Float.parseFloat(palabrasSeparadas[j]); 
			}
			
			Salvados9 a = new Salvados9();
			int[] b = a.solve(entrada);
			
			System.out.println(b[0]);
		}
	}
}

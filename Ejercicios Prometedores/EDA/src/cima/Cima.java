package cima;

import gic2.HotelPico;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Cima {

	public int[] solve(int[] entrada){
		
	/*	for(int i = 0; i < entrada.length;i++){
			System.out.println(entrada[i]);
		}
		System.out.println("------------");*/
		int[] resultado = null;
		int i=2;
		boolean encontrado_menor = false;
		int q = 0;
		boolean result = true;
		while(i < entrada.length && !encontrado_menor && result){
			if(entrada[i] == entrada[i-1])	result = false;
			else if(entrada[i] < entrada[i-1]){
				encontrado_menor = true;
				q = i;
			}
			
			i++;
		}
		
		if(!result || i == entrada.length-1){
			resultado = new int[1];
			resultado[0] = 0;
		}
		else{
			int j = q+1;
			boolean encontrado_mayor = false;
			while(j < entrada.length && !encontrado_mayor){
				if(entrada[j] >= entrada[j-1]) encontrado_mayor=true;
				j++;
			}
			if(!encontrado_mayor){
				resultado = new int[2];
				resultado[0] = 1;
				resultado[1] = q-2;
			}
			else{
				resultado = new int[1];
				resultado[0] = 0;
			}
		}
		
		return resultado;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new FileReader("entrada_cima"));
		int numero_de_casos;
		numero_de_casos = Integer.parseInt(bf.readLine());
		
		for(int i = 0; i < numero_de_casos;i++){
			int numero_de_elementos;
			numero_de_elementos = Integer.parseInt(bf.readLine());
			int[] entrada = new int[numero_de_elementos + 1];
			entrada[0] = numero_de_elementos;
			String aux = bf.readLine();
			String[] aux2 = aux.split(" ");
			for(int j = 0; j < numero_de_elementos;j++){
				entrada[j+1] = Integer.parseInt(aux2[j]);			
			}
			
			Cima a = new Cima();
			//System.out.println(a.solve(entrada)[1]);
			int resultado[] = a.solve(entrada);
			if(resultado.length == 2){
				System.out.println("Si " + resultado[1]);
			}
			else{
				System.out.println("No");
			}
			
		}
		
	}

}

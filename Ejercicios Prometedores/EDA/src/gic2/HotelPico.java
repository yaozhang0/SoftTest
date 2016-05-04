package gic2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class HotelPico {

	public int ingresosFinal(int[] v,int a,int b,int precio,int acu){
		  if (a >= b) return acu;
		  else {
		    return ingresosFinal(v,a+1,b-1,precio*2,acu + precio*v[a] + precio*v[b]);
		  }
		}
	public int[] solve(int[] entrada){
		int[] resultado = new int[1];
		
		resultado[0] = ingresosFinal(entrada,1,entrada.length-1,1,0);
		return resultado;
	}
	
	public static void main(String[] args) throws IllegalArgumentException, IOException {
		BufferedReader bf = new BufferedReader(new FileReader("entrada_hotel"));
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
			
			HotelPico a = new HotelPico();
			System.out.println(a.solve(entrada)[0]);
		}
		
	}
}

package gisa2b;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Cola {

	public int[] solve(int[] entrada){
		int[] resultado = new int[1];
		
		/*for(int i = 0; i < entrada.length;i++){
			System.out.println(entrada[i]);
		}
		System.out.println("----");*/
		
		int personas_en_cola = entrada[0];
		
		Queue<Integer> q = new Queue<Integer>();
		for(int i = 0; i < personas_en_cola;i++){
			q.enqueue(entrada[i + 1]);
		}
		
		int valor_anterior = q.dequeue();
		int colones = 0;
		for(int i = 0; i < personas_en_cola - 1; i++){
			int persona = q.dequeue();
			if (persona < valor_anterior) colones++;
			valor_anterior = persona;
		}
		
		resultado[0] = colones;
		//System.out.println(colones);
		return resultado;
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new FileReader("entrada_cola"));
		
		int numero_de_casos = Integer.parseInt(bf.readLine());
		
		for(int i = 0; i < numero_de_casos; i++){
			String aux1 = bf.readLine();
			int personas_en_cola = Integer.parseInt(aux1);
			if(personas_en_cola > 0 ){
				int[] entrada = new int[personas_en_cola + 1];
				
				entrada[0] = personas_en_cola;
				String aux2 = bf.readLine();
				String[] personas_separadas = aux2.split(" ");
				
				for(int j = 0; j < personas_en_cola; j++){
					entrada[j+1] = Integer.parseInt(personas_separadas[j]);
				}
				
				Cola a = new Cola();
				System.out.println(a.solve(entrada)[0]);
			}
			else{
				System.out.println("0");
			}
		}
	}	
	
}

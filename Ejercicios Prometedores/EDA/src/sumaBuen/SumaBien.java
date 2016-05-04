package sumaBuen;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class SumaBien {

	public int[] solve(int[] entrada){
		int[] resultado = new int[1];
		int result = 0;
		int contador = 1;
		
		for(int i = 0; i < entrada.length-1;i++){
			if(entrada[i+1] == contador)	result = result + entrada[i+1];
			contador = contador*2;
		}
		resultado[0] = result;
		return resultado;
		
	}
	public static void main(String[] args) throws IllegalArgumentException, IOException {
		BufferedReader bf = new BufferedReader(new FileReader("entrada_buenos"));
		int numero_de_casos;
		numero_de_casos = Integer.parseInt(bf.readLine());
		
		for(int i = 0; i < numero_de_casos;i++){
			
			String aux1 = bf.readLine();
			int numero_elementos = Integer.parseInt(aux1);
			if(numero_elementos == 0){
				int[] entrada = new int[1];
				entrada[0] = 0;
				SumaBien a = new SumaBien();
				System.out.println(a.solve(entrada)[0]);
			}
			else{
				int[] entrada = new int[numero_elementos+1];
				entrada[0] = numero_elementos;
				String aux2 = bf.readLine();
				String palabrasSeparadas[] = aux2.split(" ");
				for(int j = 0; j < numero_elementos;j++){
					entrada[j+1] = Integer.parseInt(palabrasSeparadas[j]);
				}
				
				SumaBien a = new SumaBien();
				System.out.println(a.solve(entrada)[0]);
			}
		}
	}

}

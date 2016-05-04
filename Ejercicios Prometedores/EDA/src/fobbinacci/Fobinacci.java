package fobbinacci;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Fobinacci {

	private int fob(int x,int y, int n){
		if(n == 0) return x;
		else if (n == 1) return y;
		  else {
		    return fob(x,y,n-1) + fob(x,y,n-2);
		  }
		}
	
	public int[] solve(int[] entrada){
		int[] resultado = new int[1];
		
		/*for(int i = 0; i < entrada.length;i++){
			System.out.println(entrada[i]);
		}
		System.out.println("------------");*/
		int n = entrada[0];
		int x = entrada[1];
		int y = entrada[2];
		

		int result = fob(x,y,n);
		
		resultado[0] = result;
		return resultado;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new FileReader("entrada_fob"));

		boolean fin_de_ej = false;
		while(!fin_de_ej){
			String aux = bf.readLine();
			String[] aux2 = aux.split(" ");
			
			if(Integer.parseInt(aux2[0]) == -1 && aux2.length == 1){
				fin_de_ej = true;
			}
			else{
				int[] entrada = new int[aux2.length];
				for(int i = 0; i < entrada.length;i++){
					entrada[i] = Integer.parseInt(aux2[i]);
				}
				
				Fobinacci a = new Fobinacci();
				System.out.println(a.solve(entrada)[0]);
			}
		}
	}

}

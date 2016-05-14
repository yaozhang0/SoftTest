package eda_paresImpares;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class Parse_Pares_impares {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
	//32 casos
			BufferedReader bf = new BufferedReader(new FileReader("entrada_paresImpares"));
			PrintWriter writer = new PrintWriter("ParesImpares_in_adaptadas", "UTF-8");
			writer.println("32");

			String str;
			while((str=bf.readLine())!=null){
				String aux2[] = str.split(" ");
				writer.println(aux2.length-1);
				
				for(int i = 1; i < aux2.length;i++){
					writer.print(aux2[i]);
					if(i != aux2.length - 1) writer.print(" ");
					
				}
				writer.println();
			}
			writer.close();
		}
}

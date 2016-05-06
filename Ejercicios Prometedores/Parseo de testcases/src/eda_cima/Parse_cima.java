package eda_cima;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class Parse_cima {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
//88 casos
		BufferedReader bf = new BufferedReader(new FileReader("entrada_cima"));
		PrintWriter writer = new PrintWriter("cima_in_adaptadas", "UTF-8");
		writer.println("88");

		String str;
		while((str=bf.readLine())!=null){
			String aux2[] = str.split(" ");
			writer.println(aux2.length-2);
			
			for(int i = 1; i < aux2.length;i++){
				writer.print(aux2[i]);
				if(i != aux2.length - 1) writer.print(" ");
				
			}
			writer.println();
		}
		writer.close();
	}

}

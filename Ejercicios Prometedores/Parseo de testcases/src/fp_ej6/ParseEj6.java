package fp_ej6;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class ParseEj6 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
//126 casos
		BufferedReader bf = new BufferedReader(new FileReader("entrada_carreras"));
		PrintWriter writer = new PrintWriter("carreras_in_adaptadas", "UTF-8");
		writer.println("126");

		String str;
		while((str=bf.readLine())!=null){
			String aux2[] = str.split(" ");
			writer.println(aux2[0] + " " + aux2[1]);
			
			for(int i = 2; i < aux2.length;i++){
				writer.print(aux2[i]);
				if(i != aux2.length - 1) writer.print(" ");
				
			}
			writer.println();
		}
		writer.close();
	}

}

package eda_parentesis;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class Parse_parentesis {

	public static void main(String[] args) throws IOException {

		//Finaliza la entrada con un ".".
			BufferedReader bf = new BufferedReader(new FileReader("entrada_parentesis"));
			PrintWriter writer = new PrintWriter("parentesis_in_adaptadas", "UTF-8");

			String str;
			while((str=bf.readLine())!=null){
				String aux2[] = str.split(" ");
				
				for(int i = 1; i < aux2.length;i++){
					char ch;
					int myInt = Integer.parseInt(aux2[i]);
					if(myInt != 1){
						ch = (char) Integer.parseInt(aux2[i]);
						writer.print(ch);
					}
					else{
						writer.print("a");
					}
				}
				writer.println();
			}
			writer.print(".");
			writer.close();
		}
}
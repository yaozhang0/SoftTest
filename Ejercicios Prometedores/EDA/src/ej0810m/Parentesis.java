package ej0810m;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Parentesis {

	public int[] solve(int[] entrada){
	int[] respuesta = new int[1];
	MyStack stack = new MyStack(entrada.length);
	
	int i = 0;
	boolean condicion = true;
	while (condicion && i < entrada.length){
		if(entrada[i] == '(' || entrada[i] == '[' || entrada[i] == '{' ){
			stack.push(entrada[i]);
			i++;
		}
		else{
			if(entrada[i] == ')'){
				if(!stack.isEmpty() && stack.peek() == '('){
					stack.pop();
					i++;
				}
				else{
					condicion = false;
				}
			}
			else{
				if(entrada[i] == ']' ){
					if(!stack.isEmpty() && stack.peek() == '['){
						stack.pop();
						i++;
					}
					else{
						condicion = false;
					}
				}
				else{
					if(entrada[i] == '}'){
						if(!stack.isEmpty() && stack.peek() == '{'){
							stack.pop();
							i++;
						}
						else{
							condicion = false;
						}
					}
					else{
						i++;
					}
				}
			}
		}
	}
	/*for(int i = 0; i < entrada.length;i++){
		System.out.println(entrada[i]);
	}
	
	System.out.println("-----------");
	*/
	if(condicion && stack.isEmpty()) respuesta[0] = 1;
	else respuesta[0] = 0;
	return respuesta;
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new FileReader("entrada_parentesis"));
		boolean fin_bucle = false;
		while(!fin_bucle){
			String aux1 = bf.readLine();
			if(aux1.length() == 1 && aux1.charAt(0) == '.'){
				fin_bucle = true;
			}
			else{
				int[] entrada = new int[aux1.length()];
				for(int i = 0; i < aux1.length();i++){
					entrada[i] = aux1.charAt(i);
				}
				Parentesis a = new Parentesis();
				System.out.println(a.solve(entrada)[0]);
			}
		}
		
		//System.out.println("Holaaa");
		
	}
	
	

}

package ej5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Mandelbrot {

	private class Complejo{
		private float real;
		private float imaginaria;
		
		public Complejo(float real, float imaginaria){
			this.real = real;
			this.imaginaria = imaginaria;
		}
		public Complejo suma(Complejo op2){
			
			float real_aux = this.getReal() + op2.getReal();
			float imaginaria_aux = this.getImaginaria() + op2.getImaginaria();
			Complejo resultado = new Complejo(real_aux,imaginaria_aux);
			
			return resultado;
		}
		

		public Complejo producto(Complejo op2){
			float real_aux = this.getReal() *(op2.getReal() - this.getImaginaria())*op2.getImaginaria();
			float imaginaria_aux = this.getReal() * op2.getImaginaria() + op2.getReal() * this.getImaginaria();
			Complejo resultado = new Complejo(real_aux,imaginaria_aux);
			
			return resultado;
		}
		
		public float modulo(){
			
			float resultado = (float) Math.sqrt(this.getReal() * this.getReal() + this.getImaginaria()*this.getImaginaria());
			return resultado;
		}
		
		public float getReal(){
			return real;
		}
		public float getImaginaria(){
			return imaginaria;
		}
	}
	
	
	public int[] solve(float[] entrada){
		
		int[] salida = new int[1];

		boolean encontrado = false;
		float iteraciones = entrada[2];
		Complejo c = new Complejo(entrada[0],entrada[1]);
		Complejo complejo0 = new Complejo(0,0);
		Complejo complejo1 = new Complejo(0,0);
		int i = 0;
		while(!encontrado && i < iteraciones){
			
			complejo1 = complejo0.producto(complejo0).suma(c);
			//System.out.println(complejo1.getReal() + "," + complejo1.getImaginaria());
			if(complejo1.modulo() > 2){
				encontrado = true;
			}
			else{
				complejo0 = complejo1;
			}
			i++;
		}
		if(encontrado) salida[0] = 0;
		else salida[0] = 1;

		return salida;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new FileReader("entrada_mandelbrot"));
		int numero_casos;
		
		numero_casos = Integer.parseInt(bf.readLine());
		
		for(int i = 0; i < numero_casos;i++){
			float[] entrada = new float[3];
			
			String aux1 = bf.readLine();
			String palabrasSeparadas[] = aux1.split(" ");
			float parte_real = Float.parseFloat(palabrasSeparadas[0]);
			//System.out.println(palabrasSeparadas[0] + "," + palabrasSeparadas[1]);
			float parte_imaginaria = Float.parseFloat(palabrasSeparadas[1]);
			int iteraciones = Integer.parseInt(palabrasSeparadas[2]);
			
			entrada[0] = parte_real;
			entrada[1] = parte_imaginaria;
			entrada[2] = iteraciones;
			//System.out.println(parte_real + "," + parte_imaginaria + "," + iteraciones);
			Mandelbrot aux = new Mandelbrot();
			int[] resultado = aux.solve(entrada);
			
			System.out.println(resultado[0]);
		}
	}
}

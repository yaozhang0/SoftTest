package ej1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Vector;

public class Trenes {
	
	private class Hora{
		private int segundos;
		
		public Hora(int horas, int minutos, int segundos){
			if(horas >= 24 || horas < 0 || minutos >= 60 || minutos < 0 || segundos >= 60 || segundos < 0){
				throw new IllegalArgumentException();
			}
			this.segundos = horas * 3600 + minutos * 60 + segundos;
		}
		public int getSegundos(){
			return segundos;
		}
		
		public boolean less_than(Hora hora){
			return segundos < hora.getSegundos();
			
		}
	}
	public int[] solve(int[] entrada){
		Vector<Hora> Horas = new Vector<Hora>();
		int resultado[] = new int[3* entrada[1]];
		for(int i = 0; i < entrada[0];i++){
			Horas.add(new Hora(entrada[2 + 3*i],entrada[2+ 3*i +1],entrada[2 + 3*i + 2]));
			//System.out.println(entrada[2 + 3*i] + "," + entrada[2+ 3*i +1] +","+entrada[2 + 3*i + 2]);
		}

		for(int i = 0; i < entrada[1];i++){
			try{
				Hora hora = new Hora(entrada[2 + 3*entrada[0] + 3*i],entrada[2 + 3*entrada[0] + 3*i + 1],entrada[2 + 3*entrada[0] + 3*i + 2]);
				int segundos_inferior = 0;
				int segundos_superior = Horas.size()-1;
				int centro;
				if(Horas.get(Horas.size() - 1).getSegundos() < hora.getSegundos()){
					resultado[3*i] = -1;
					resultado[3*i+1] = -1;
					resultado[3*i+2] = -1;
				}
				else{
					boolean encontrado = false;
					while(!encontrado & segundos_inferior<=segundos_superior){
						
						centro=(segundos_superior+segundos_inferior)/2;
						//System.out.println(segundos_superior + "," + segundos_inferior);
						//if(horas[centro]==dato) return centro;
						if(hora.getSegundos() == Horas.get(centro).getSegundos()){
							encontrado = true;
							resultado[3*i] = Horas.get(centro).getSegundos() / 3600;
							resultado[3*i+1] = (Horas.get(centro).getSegundos() - resultado[3*i] * 3600) / 60;
							resultado[3*i+2] = (Horas.get(centro).getSegundos() - resultado[3*i] * 3600) - resultado[3*i +1] * 60;
						}
						if (Horas.get(centro).less_than(hora) && hora.less_than(Horas.get(centro + 1))){
							encontrado = true;
							resultado[3*i] = Horas.get(centro + 1).getSegundos() / 3600;
							resultado[3*i+1] = (Horas.get(centro + 1).getSegundos() - resultado[3*i] * 3600) / 60;
							resultado[3*i+2] = (Horas.get(centro + 1).getSegundos() - resultado[3*i] * 3600) - resultado[3*i +1] * 60;
						}
						else{
							if(Horas.get(centro).less_than(hora)){
								segundos_inferior = centro;
							}
							else{
								//System.out.println("hola");
								segundos_superior = centro;
							}
						}
					}
				}
				
			}
			catch(Exception e){
				resultado[3*i] = 404;
				resultado[3*i+1] = 404;
				resultado[3*i+2] = 404;
			}
			//Consultas.add(new Hora(entrada[2 + 3*entrada[0] + 3*i],entrada[2 + 3*entrada[0] + 3*i + 1],entrada[2 + 3*entrada[0] + 3*i + 2]));
			//System.out.println(entrada[2 + 3*i] + "," + entrada[2+ 3*i +1] +","+entrada[2 + 3*i + 2]);
		}

		
		/*
		System.out.println(resultado.length);
		for (int z = 0; z < resultado.length;z++){
			System.out.println(resultado[z]);
		}
		*/
		return resultado;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new FileReader("entrada_trenes"));
		boolean fin_algoritmo = false;
		
		do{
			
			String aux1 = bf.readLine();
			String palabrasSeparadas[] = aux1.split(" ");
			int numero_de_trenes = Integer.parseInt(palabrasSeparadas[0]);
			int numero_de_consultas = Integer.parseInt(palabrasSeparadas[1]);
			
			if(numero_de_trenes == 0 && numero_de_consultas == 0){
				fin_algoritmo = true;
			}
			else{
				int entrada[] = new int[2 + 3*numero_de_trenes + 3*numero_de_consultas];
				entrada[0] = numero_de_trenes;
				entrada[1] = numero_de_consultas;
				
				String linea_horas = bf.readLine();
				String horasSeparadas[] = linea_horas.split(" ");
				for (int i = 0; i < numero_de_trenes; i++){
					String hora[] = horasSeparadas[i].split(":");
					for (int j = 0; j < 3 ; j++){
						entrada[2 + 3*i + j] = Integer.parseInt(hora[j]);
					}
				}
				for(int k = 0; k < numero_de_consultas; k++){
					String hora_consulta = bf.readLine();
					String consulta_separada[] = hora_consulta.split(":");
					for(int l = 0; l < 3; l++){
						
						entrada[2 + 3 * numero_de_trenes + k * 3 + l] = Integer.parseInt(consulta_separada[l]);
					}
				}
				/*
				for (int z = 0; z < entrada.length;z++){
					System.out.println(entrada[z]);
				}
				*/
				Trenes a = new Trenes();
				a.solve(entrada);
			}
			
			
		}while(!fin_algoritmo);
		
	}
}

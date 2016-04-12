import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ej3 {

	public int[] solve(int[] entrada){
		int[]resultado = {0,0};
		int ancho = entrada[0] * 100,
			largo = entrada[1] * 100,
			alto = entrada[2] * 100,
			ancho_caja = entrada[3],
			largo_caja = entrada[4],
			alto_caja = entrada[5];
		
		int resultado1 = (ancho / ancho_caja) * (largo/largo_caja) * (alto /alto_caja);
		int resultado2 = (ancho / largo_caja) * (largo / ancho_caja) * (alto / alto_caja);
		
		if (resultado1 == resultado2){
			resultado[0] = resultado1;
			resultado[1] = 1;
		}
		else if(resultado1 > resultado2){
			resultado[0] = resultado1;
			resultado[1] = 2;
		}
		else{
			resultado[0] = resultado2;
			resultado[1] = 3;
		}
		return resultado;
		
	}
	public static void main(String[] args) throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader (isr);
		int numero_de_casos = 0;
		Ej3 aux = new Ej3();
		
		int[] operandos = {0,0,0,0,0,0};

		numero_de_casos = Integer.parseInt(br.readLine());

		
		for(int i = 0; i < numero_de_casos;i++){
			String aux1 = br.readLine();
			String palabrasSeparadas[] = aux1.split(" ");
			
			for (int j=0; j < palabrasSeparadas.length; j++){
				operandos[j] = Integer.parseInt(palabrasSeparadas[j]);
			}
			int [] resultado = aux.solve(operandos);
			System.out.print(resultado[0]);
			if(resultado[1] == 1){
				System.out.println(" DA IGUAL");
			}
			else if(resultado[1] == 2){
				System.out.println(" EN PARALELO");
			}
			else{
				System.out.println(" EN PERPENDICULAR");
			}
		}
	}

}

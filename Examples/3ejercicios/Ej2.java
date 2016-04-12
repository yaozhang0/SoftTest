import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ej2 {

	public int[] solve(int[] entrada){
		int[]resultado = {0};
		int ancho = entrada[0] * 100,
			largo = entrada[1] * 100,
			alto = entrada[2] * 100,
			ancho_caja = entrada[3],
			largo_caja = entrada[4],
			alto_caja = entrada[5];
		
		resultado[0] = (ancho / ancho_caja) * (largo/largo_caja) * (alto /alto_caja);
		return resultado;
		
	}
	public static void main(String[] args) throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader (isr);
		int numero_de_casos = 0;
		Ej2 aux = new Ej2();
		
		int[] operandos = {0,0,0,0,0,0};

		numero_de_casos = Integer.parseInt(br.readLine());

		
		for(int i = 0; i < numero_de_casos;i++){
			String aux1 = br.readLine();
			String palabrasSeparadas[] = aux1.split(" ");
			
			for (int j=0; j < palabrasSeparadas.length; j++){
				operandos[j] = Integer.parseInt(palabrasSeparadas[j]);
			}
			System.out.println(aux.solve(operandos)[0]);
		}
	}

}

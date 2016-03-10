package prueba;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.xpath.XPath;

@SuppressWarnings("deprecation")
public class Tfg {
	
	public String Jpet(File f){
		try {
			File folder = new File("pet-testcases");
			if(!folder.isDirectory())
				folder.mkdir();
			String s, a ="",clase= f.getName().substring(0, f.getName().toString().length() - 6);
			String cmd = "./pet " + ""+ clase +".solve([I)[I" + " -cp " + f.getPath().substring(0, f.getPath().length() - 1 - f.getName().length())
					+ " " +  "-c bck 2  -td num  -d 0 10  -l ff  -v 2  -tr statements -cc yes -xml " +
					"pet-testcases/" + clase + ".solve([I)[I[TC].xml";
			System.out.println(cmd);
			Process p = Runtime.getRuntime().exec(cmd);
			//return parseXML(ruta);
			BufferedReader haha = new BufferedReader(new InputStreamReader(p.getInputStream()));
			 while ((s = haha.readLine()) != null) {
                 System.out.println(s);
                 a += s+"\n";
			 }
			 return parseXML(clase + ".solve([I)[I[TC].xml") + "\nArchivo xml guardado en pet-testcases, nombre: " + clase + ".solve([I)[I[TC].xml";
		} catch (IOException ioe) {
			System.out.println (ioe);
			return "fallo";
		}
	}
	
	public String parseXML(String ruta){
		// Creamos el builder basado en SAX  
		SAXBuilder builder = new SAXBuilder();  
		String cadena = "", metodo="", resultado="";
		// Construimos el arbol DOM a partir del fichero xml  
		try {
			Document documentJDOM = builder.build(new FileInputStream("pet-testcases/"+ ruta));
			// Obtenemos la etiqueta raíz  
			Element raiz = documentJDOM.getRootElement();  
			// Recorremos los hijos de la etiqueta raíz  
			List<Element> hijosRaiz = raiz.getChildren("test_case");  
			int vuelta = 0, vueltaExcepcion = 0;
			String[] entrada = new String[hijosRaiz.size()];
			String[] salida = new String[hijosRaiz.size()];
			boolean[] excepciones = new boolean[hijosRaiz.size()];
			for(int i = 0; i < entrada.length; i++){
				entrada[i] = "";
				salida[i] = "";
			}
			for(Element hijo: hijosRaiz){
				List<Element> nieto = hijo.getChild("args_in").getChildren("data");
				if(nieto.size() != 0){
					cadena = "";
					for(Element data: nieto){
						cadena += data.getText() + " ";
					}
					if(cadena.length() > 0)
						entrada[vuelta] = cadena.substring(0, cadena.length()-1);
				}
				else{
					nieto = hijo.getChild("heap_in").getChildren("elem");
					for(Element elem: nieto){
						cadena = "";
						for(Element array: elem.getChild("array").getChild("args").getChildren("arg")){
							cadena += array.getText() + " ";
						}
					}
					if(cadena.length() > 0)
						entrada[vuelta] = cadena.substring(0, cadena.length()-1);
				}
				nieto = hijo.getChild("heap_out").getChildren("elem");
				if(nieto.size() != 0){
					String nieto2 = hijo.getChild("return").getText();
					if(nieto2.length()==1){
						cadena = hijo.getChild("exception_flag").getText()+ " ";
						excepciones[vuelta] = true;
						vueltaExcepcion++;
					}else{
						nieto2 = nieto2.substring(4, nieto2.length()-1);
						for(Element elem: nieto){
							if(elem.getChild("num").getText().equals(nieto2)){
								cadena = "";
								try{
									for(Element array: elem.getChild("array").getChild("args").getChildren("arg")){
										cadena += array.getText() + " ";
									}
								}catch (NullPointerException e){
									
								}
							}
						}
					}
					if(cadena.length() > 0)
						salida[vuelta] = cadena.substring(0, cadena.length()-1); 
				}else{
					salida[vuelta] = hijo.getChild("return").getText();
				}
				vuelta++;
				//metodo = hijo.getChild("method").getText();
			}
			
			String[] entrada2 = new String[entrada.length - vueltaExcepcion];
			String[] salida2 = new String[salida.length - vueltaExcepcion];
			resultado = "Entrada: \n";
			int a = 0;
			for(int i = 0; i <vuelta; i++){
				if(!excepciones[i]){
					System.out.println(entrada[i]);
					resultado += entrada[i]+ "\n";
					entrada2[a] = entrada[i];
					a++;
				}
			}
			resultado += "Salida: \n";
			System.out.println("");
			a = 0;
			for(int i = 0; i <vuelta; i++){
				if(!excepciones[i]){
					System.out.println(salida[i]);
					resultado += salida[i]+ "\n";
					salida2[a] = salida[i];
					a++;
				}
			}
			metodo = ruta.substring(0, ruta.length()-4);
			resultado += crearDocs(metodo, entrada2, salida2);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JDOMException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultado;
	}
	
	public String crearDocs(String metodo, String[] entrada, String[] salida){
		File folder = new File("InOut");
		if(!folder.isDirectory())
			folder.mkdir();
		String rutaIn = "InOut/" + metodo + ".in";
		String rutaOut = "InOut/" + metodo + ".out";
        File archivoIn = new File(rutaIn);
        File archivoOut = new File(rutaOut);
        BufferedWriter bw;
        try {
        	bw = new BufferedWriter(new FileWriter(archivoIn));
        	for(int i = 0; i < entrada.length; i++)
        		bw.write(entrada[i] + "\r\n");
        	bw.close();
        	bw = new BufferedWriter(new FileWriter(archivoOut));
        	for(int i = 0; i < salida.length; i++)
        		bw.write(salida[i] + "\r\n");
			bw.close();
			return "Archivos IN and OUT generados satisfactoriamente en el fichero InOut, nombres: "
					+ metodo + ".in, " + metodo + ".out";
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "Fallo en la conversion IN and out";
		}
	}

}

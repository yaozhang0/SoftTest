package prueba;

public class otra {

	public int expInt(int a, int b){
		int h = 1;
		if(b >= 0){
			for(int i = 0; i < b; i++){
				h = h * a;
			}
		}else
			return 0;
		return h;
	}
	
	public int exp2(int a, int b){
		return a;
	}
	
	public int exp(int a){
		return a;
	}
	
	public void exp1(int a){
		a = 1;
	}
	
	public String burbujaS(String entr){
        int i, j, aux;
        String[] arrayString = entr.split(" ");
        int[] A=  new int[arrayString.length];
        for(int a = 0; a < arrayString.length; a++){
        	A[a] = Integer.parseInt(arrayString[a]);
        }
        String cadena = "";
        for(i=0;i<A.length-1;i++)
             for(j=0;j<A.length-i-1;j++)
                  if(A[j+1]<A[j]){
                     aux=A[j+1];
                     A[j+1]=A[j];
                     A[j]=aux;
                  }
        for(i=0;i<A.length-1;i++)
        	cadena +=  Integer.toString(A[i]);
        return cadena;
	}
	
	public String burbujaS(int [] A){
        int i, j, aux;
        String cadena = "";
        for(i=0;i<A.length-1;i++)
             for(j=0;j<A.length-i-1;j++)
                  if(A[j+1]<A[j]){
                     aux=A[j+1];
                     A[j+1]=A[j];
                     A[j]=aux;
                  }
        for(i=0;i<A.length-1;i++)
        	cadena +=  Integer.toString(A[i]);
        return cadena;
	}
	
	//'prueba/otra.solve([I)[I'
	public int[] solve(int [] A){
        int i, j, aux;
        for(i=0;i<A.length-1;i++)
             for(j=0;j<A.length-i-1;j++)
                  if(A[j+1]<A[j]){
                     aux=A[j+1];
                     A[j+1]=A[j];
                     A[j]=aux;
                  }
        return A;
	}
}

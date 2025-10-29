public class OrdenarJuegos{
    //Atributos
    private String[] juego;
    private String[] genero;
    private int[] calificacion;

    //Metodo constructor sin parametros
    public OrdenarJuegos(){
	this.juego = juego;
	this.genero = genero;
	this.calificacion = calificacion;
    }
    //Metodos asignadores
    public void cambiaJuego(String[] juego){
	this.juego = juego;
    }
    public void cambiaGenero(String[] genero){
	this.genero = genero;
    }
    public void cambiaCalificacion(int[] calificacion){
	this.calificacion = calificacion;
    }
    //Metodos observadores
    public String[] obtenJuego(){
	return this.juego;
    }
    public String[] obtenGenero(){
	return this.genero;
    }
    public int[] obtenCalificacion(){
	return this.calificacion;
    }
    //Calculadores
    //ordenarPorNombre
    public void ordenarPorNombre(String[] nombre, int numLibro){
	for(int i=0; i<numLibro - 1; i++){
	    for(int j= 0; j<numLibro-1 -i; j++){
		if(nombre[j].compareTo(nombre[j+1])>0){
		    //Nombre
		    String nom = nombre[j];
		    nombre[j] = nombre[j+1];
		    nombre[j+1] = nom;
		    //Genero
		    String gen = genero[j];
		    genero[j] = genero[j+1];
		    genero[j+1] = gen;
		    //Calificacion
		    int cal = calificacion[j];
		    calificacion[j] = calificacion[j+1];
		    calificacion[j+1] = cal;
		}//Fin del if
	    }//Fin del for anidado
	}//Fin del for
	//Imprimir arreglo
	for(int i = 0; i<numLibro; i++){
	    System.out.println(nombre[i]+" " + genero[i] + " "+calificacion[i]);
	}
    }//Fin del metodo
    //metodo para ordenar por calificacion
    public void ordenarPorCalificacion(int[] calificacion, int numLibro){
	for(int i=0; i<numLibro - 1; i++){
	    for(int j= 0; j<numLibro-1 -i; j++){
		if(calificacion[j] < calificacion[j+1]){
		    //Nombre
		    String nom = juego[j];
		    juego[j] = juego[j+1];
		    juego[j+1] = nom;
		    //Genero
		    String gen = genero[j];
		    genero[j] = genero[j+1];
		    genero[j+1] = gen;
		    //Calificacion
		    int cal = calificacion[j];
		    calificacion[j] = calificacion[j+1];
		    calificacion[j+1] = cal;
		}//Fin del if
	    }//Fin del for anidado
	}//Fin del for
	//Imprimir arreglo
	for(int i = 0; i<numLibro; i++){
	    System.out.println(juego[i]+" " + genero[i] + " "+calificacion[i]);
	}
    }//Fin del metodo
    //metodo para ordenar por Genero
    public void ordenarPorGenero(String[] genero, int numLibro){
	for(int i=0; i<numLibro - 1; i++){
	    for(int j= 0; j<numLibro-1 -i; j++){
		if(genero[j].compareTo(genero[j+1])>0){
		    //Nombre
		    String nom = juego[j];
		    juego[j] = juego[j+1];
		    juego[j+1] = nom;
		    //Genero
		    String gen = genero[j];
		    genero[j] = genero[j+1];
		    genero[j+1] = gen;
		    //Calificacion
		    int cal = calificacion[j];
		    calificacion[j] = calificacion[j+1];
		    calificacion[j+1] = cal;
		}//Fin del if
	    }//Fin del for anidado
	}//Fin del for
	//Imprimir arreglo
	for(int i = 0; i<numLibro; i++){
	    System.out.println(juego[i]+" " + genero[i] + " "+calificacion[i]);
	}
    }//Fin del metodo
    //Metodo peorCalificado
    public void peorCalificado(int numLibro){
	for(int i=0 ; i<numLibro; i++){
	    for(int j=0;i<numLibro-1-i; i++){
		if(calificacion[j] > calificacion[j+1]){
		    String nom = juego[j];
		    juego[j] = juego[j+1];
		    juego[j+1] = nom;
		    //Genero
		    String gen = genero[j];
		    genero[j] = genero[j+1];
		    genero[j+1] = gen;
		    //Calificacion
		    int cal = calificacion[j];
		    calificacion[j] = calificacion[j+1];
		    calificacion[j+1] = cal;
		}//Fin del if
	    }//Fin del for anidado
	}//Fin del for
	
	System.out.println("El juego peor calificado es: "+juego[0]+ " | "+ genero[0] +" | "+ calificacion[0]);
    }//Fin del metodo
    //Metodo mejorCalificado
    public void mejorCalificado(int numLibro){
	for(int i=0 ; i<numLibro; i++){
	    for(int j=0;i<numLibro-1-i; i++){
		if(calificacion[j] < calificacion[j+1]){
		    String nom = juego[j];
		    juego[j] = juego[j+1];
		    juego[j+1] = nom;
		    //Genero
		    String gen = genero[j];
		    genero[j] = genero[j+1];
		    genero[j+1] = gen;
		    //Calificacion
		    int cal = calificacion[j];
		    calificacion[j] = calificacion[j+1];
		    calificacion[j+1] = cal;
		}//Fin del if
	    }//Fin del for anidado
	}//Fin del for
	
	System.out.println("El juego mejor calificado es: "+juego[0] + " | "+genero[0] +" | "+ calificacion[0]);
    }//Fin del metodo

}//Fin de la clase

import java.util.Random;
public class TableroBatallaNaval{
    private int coordX;
    private int coordY;
    private char[][] tableroVisible = new char[10][10];
    private char[][] tableroIA = new char[10][10];
    private Random rand = new Random();
    private char barco = 'b';
    private char fallido = 'x';
    private char acertado = 'o';
    private char[][] tableroJugador = new char[10][10];

    public TableroBatallaNaval(int x, int y){
	this.coordX = x;
	this.coordY = y;
    }
    //Metodos asignadores
    public void cambiaX(int x){
	this.coordX = x;
    }
    public void cambiaY(int y){
	this.coordY = y;
    }
    //Métodos observadores
    public int obtenX(){
	return this.coordX;
    }
    public int obtenY(){
	return this.coordY;
    }

    //Métodos calculadores
    
    public void barcoDeIa(int tamaño){
	int columna, fila;
	boolean colocado = false;
	do{//Inicio del do
	    int orientacion = rand.nextInt(2);
	    boolean libre = true, cabe = false;
	    fila = rand.nextInt(10);
	    columna = rand.nextInt(10);
	    //Verificar que no se salga del tablero
	    if(orientacion == 0){
		if(columna <10- tamaño){
		    cabe = true;
		}//Final del if anidado
	    }else{
		if(fila<10-tamaño){
		    cabe = true;
		}
	    }//FInal del else
	    //Verificar si no estan ocupado
	    if(cabe == true){
	    for(int i=0; i<tamaño; i++){
		if(orientacion == 0){
		    if(tableroIA[fila][columna+i]!=0 ){
			libre = false;
			break;
		    }//FInal de if anidado
		}else{
		    if(tableroIA[fila+i][columna]!=0 ){
			libre = false;
			break;
		    }//FInal de if anidado
		}//Final del else
	    }//Final de for
	    }//FIn del if
		if(libre && cabe){
		    for(int i = 0; i<tamaño; i++){
			if(orientacion == 0){//En caso de que sea horizontal  
			    tableroIA[fila][columna+i] = barco;
			}else{ //Vertical
			    tableroIA[fila + i][columna] = barco;
			}//Fin del else
		    }//Fin del for
		    colocado = true;
		}//FIn del if

	}while(!colocado);//Fin del do inicial
    }//FIn del metodo
    public void tableroVisible(){
	System.out.print("   ");
        for (int i = 0; i < tableroVisible[0].length; i++) {
            System.out.print((i+1)+ "  ");
        }
	System.out.print("\n");
	for(int i=0; i<tableroVisible[0].length; i++){
	    System.out.print((i+1) + " ");
	    for(int j= 0; j<tableroVisible[0].length; j++){
		int celda = tableroVisible[i][j];
		if(celda == 0){
		    System.out.print(" ¬ ");
		}else{
		    System.out.print(" "+ tableroVisible[i][j]+" ");
		}
	    }
	    System.out.println();
	}
    }//Fin del metodo
    public void tableroIA(){
	System.out.print("   ");
        for (int i = 0; i < tableroIA[0].length; i++) {
            System.out.print((i + 1)+ "  ");
        }
	System.out.print("\n");
	for(int i = 0; i<tableroIA[0].length; i++){
	    System.out.print((i+1) + " ");
	    for(int j=0; j<tableroIA[0].length; j++){
		System.out.print(" "+ tableroIA[i][j]+ " ");
	    }
	    System.out.println();
	}
    }//Fin del metodo

    public boolean espacioTablero(int fila, int columna, int orientacion, int tamaño){
	if(orientacion == 1){
	    return columna + tamaño>10; 
	}else{
		return fila + tamaño>10;
	}//FInal del else
    }//FIn del metodo
    public boolean espacioOcupado(int fila, int columna, int orientacion, int tamaño){
	for(int i=0; i<tamaño; i++){
	    if(orientacion == 1){
		if(tableroJugador[fila][columna+i]!=0 ){
		    return true;
		}else{
		    return false;
		}
	    }else{
		if(tableroJugador[fila+i][columna]!=0 ){
		    return true;
		}else{
		    return false;
		}
	    }//Final del else
	}//Final de for
	return false;
    }//Fin del metodo
    public void barcoJugador(int fila, int columna, int orientacion, int tamaño){
	boolean colocado = false;
	do{//Inicio del do
		    for(int i = 0; i<tamaño; i++){
			if(orientacion == 1){//En caso de que sea horizontal  
			    tableroJugador[fila][columna+i] = barco;
			}else{ //Vertical
			    tableroJugador[fila + i][columna] = barco;
			}//Fin del else
		    }//Fin del for
		    colocado = true;

	}while(!colocado);//Fin del do inicial
    }
    public void imprimirTableroJugador(){
	System.out.print("   ");
        for (int i = 0; i < tableroVisible[0].length; i++) {
            System.out.print((i + 1)+ "  ");
        }
	System.out.println();
	for(int i = 0; i<tableroJugador[0].length; i++){
	    System.out.print((i+1) + " ");
	    for(int j=0; j<tableroJugador[0].length; j++){
		int celda = tableroJugador[i][j];
			if(celda == 0){
			    System.out.print(" ¬ ");
			}else{
			    System.out.print(" " + tableroJugador[i][j]+ " ");
			}
	    }//Fin del for anidado
	    System.out.println();
	}//Fin del for

    }//Fin del metodo
    public boolean disparoIA(){
	int fila, columna;
	do{
	fila = rand.nextInt(10); //Para la primera coordenada
	columna = rand.nextInt(10); //Para la segunda coordenada
	}while(tableroJugador[fila][columna] == 'o' || tableroJugador[fila][columna] == 'x');
	if(tableroJugador[fila][columna] == 'b'){
	    tableroJugador[fila][columna] = 'o';
	    return true;
	}else{
	    tableroJugador[fila][columna] = 'x';
	    return false;
	}
	       
    }//Fin del metodo
    public boolean disparoJugador(int fila, int columna){
	if(tableroIA[fila][columna] == 'b'){
	    tableroVisible[fila][columna] = 'o';
	    tableroIA[fila][columna] = 'o'; //Para mas adelante
	    return true;
	}else{
	    tableroVisible[fila][columna] = 'x';
	    return false;
	}
    }//FIn del metodo
    public boolean dispararMismoLugar(int fila,int columna){
	return tableroIA[fila][columna] == 'o' || tableroIA[fila][columna] == 'x';
    }

}//Fin de la clase

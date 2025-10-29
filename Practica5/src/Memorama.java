import java.util.Scanner;

public class Memorama{
    public static void main(String[] args){
	//Declaracion de variables
	int coordenadaX1=0, coordX2, coordY2, coordenadaY1=0;
	int intentos = 1;
	//Declaracion de objetos
	Scanner scan = new Scanner(System.in);
	TableroMemorama tablero = new TableroMemorama(coordenadaX1,coordenadaY1);
	//Crear tablero inicial
	tablero.tableroNuevo();
	tablero.tableroAleatorio();
	// Para revisar las posiciones descubiertas unicamente en caso de error
	//tablero.tableroReal();
	// Repetir el juego hasta terminar, no olvidar sumar el numero de intentos
	do{
	System.out.println("Para empezar seleccione la primera coordenada que guste: ");
	coordenadaX1 = scan.nextInt()- 1;
	coordenadaY1 = scan.nextInt()-1;
	//Obtener dichas coordenadas
	tablero.cambiaCoordenadaX(coordenadaX1);
	tablero.cambiaCoordenadaY(coordenadaY1);
	//Obtener el tablero con el simbolo
	tablero.destapar(coordenadaX1, coordenadaY1);
	tablero.tableroMemorama();
	System.out.println("Ahora elija la segunda pieza que guste voltear:");
	coordX2 = scan.nextInt()-1;
	coordY2 = scan.nextInt() -1;
	tablero.destapar(coordX2, coordY2);
	tablero.tableroMemorama();
	if(tablero.pareja(coordX2, coordY2)){
	    tablero.noSonPareja(coordX2, coordY2);
	    tablero.tableroMemorama();
	}
	
	intentos ++;
	}while(tablero.casillasFinales());
	System.out.println("Felicidades, El numero de intentos en total fue de: " + intentos);
    }//Fin del main
}//Fin del programa

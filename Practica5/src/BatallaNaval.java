import java.util.Scanner;
import java.util.Random;
public class BatallaNaval{
    public static void main(String[] args){
	//Declaracion de variables, matrices y arreglos
	int[][] tableroJugador = new int[10][10];
	int[][] tableroIA = new int[10][10];
	int[] barco = {4,3,3,2};
	int barcosJugador = 12, barcosIA = 12;
	int fila = 0,columna =0, orientacion, numBarco=0;
	boolean acerto;
	//Declaracion de objetos
	TableroBatallaNaval tablero = new TableroBatallaNaval(fila,columna);
	Scanner scan = new Scanner(System.in);
	Random rand = new Random();
	
	System.out.println("Barco de IA:");
	tablero.barcoDeIa(4);
	tablero.barcoDeIa(3);
	tablero.barcoDeIa(3);
	tablero.barcoDeIa(2);
	
	//En caso de que quiera conocer la posicion aproximada que elige la IA tablero.tableroIA();
	//Do que se encargue de verificar que la posicion de los barcos es correcta
	while(numBarco < barco.length){
	    int tamaño = barco[numBarco];
	    do{ //Repetir en caso de algun error en las coordenadas
		System.out.println("Eliga la posicion de su barco de "+tamaño+" casillas: ");
		columna = scan.nextInt()-1;
		fila= scan.nextInt()-1;
		System.out.println("Gusta que este en 1-Horizontal o 2-Vertical");
		orientacion = scan.nextInt();
	    }while(tablero.espacioOcupado(fila, columna, orientacion, tamaño)|| tablero.espacioTablero(fila,columna,orientacion, tamaño));
	    System.out.println("Salio bien el while o no");
	    tablero.barcoJugador(fila, columna, orientacion, tamaño);
	    //Imprimir el tablero
	    tablero.imprimirTableroJugador();
	    numBarco ++;
	}
	//Una vez elegidos los barcos de ambos jugadores empieza a jugar, el turno se elije de manera aleatorio
	// 0-Le toca a la IA, 1-Le toca al jugador
	int turno = rand.nextInt(2);
	do{ //Repetir hasta que uno de los dos gane
	    if(turno == 0){
		//Utilizamos el metodo para que la IA dispare a un lado de la posicion del jugador
		acerto = tablero.disparoIA();
		if(acerto == true){
		    barcosJugador --;
		}
		System.out.println("Tablero del jugador");
		tablero.imprimirTableroJugador();
		turno =1;
	    }else{
		//Utilizamos metodo para el jugador y ademas un booleano para verificar que no dispare dos veces en la misma casilla
		do{
		    System.out.println("Disparo del jugador");
		    System.out.println("Digite las coordenadas de su disparo (sin comas, solo con espacio)");
		    columna = scan.nextInt()-1;
		    fila = scan.nextInt()-1;
		}while(tablero.dispararMismoLugar(fila, columna));
		acerto = tablero.disparoJugador(fila, columna);
		
		if(acerto == true){
		    barcosIA --;
		}
		System.out.println("Tablero de la IA");
		tablero.tableroVisible();
		turno = 0;
	    }
	}while(barcosIA>0 && barcosJugador>0);

	if(barcosIA == 0){
	    System.out.println("Gano el jugador!!!!!");
	}else{
	    System.out.println("Te gano la IA, primero esto luego el trabajo");
	}

    }//Fin del main




}

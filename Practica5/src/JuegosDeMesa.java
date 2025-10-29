import java.util.Scanner;

public class JuegosDeMesa{
    public static void main(String[] args){
	//Creacion de variables
	String[] juegos = new String[100];
	String nombre, gen;
	String[] genero = new String[100];
	int[] calificacion = new int[100];
	int calif, numLibro= 0, nuevoLibro, opc, formaDeOrdenar;
	boolean continuar = false, terminar = true;
	//Creacion de objetos
	Scanner scan = new Scanner(System.in);
	OrdenarJuegos ordenar = new OrdenarJuegos();
	
	do{ //Mantener el flujo del programa, en caso de querer realizar diferentes acciones varias veces	    
	    System.out.print("Escriba un juego de mesa: ");
	    nombre = scan.nextLine();
	    System.out.print("¿Qué calificacion tiene? ");
	    calif = scan.nextInt();
	    System.out.print("¿Qué género es? ");
	    scan.nextLine(); //limpiar scan
	    gen = scan.nextLine();
	    //Cada vez que se repita esta parte crear un contador para el nuevo libro
	    //Guardamos cada opc del usuario en los arrays deseados, y despues en la clase de ordenar
	    juegos[numLibro] = nombre;
	    ordenar.cambiaJuego(juegos);
	    calificacion[numLibro] = calif;
	    ordenar.cambiaCalificacion(calificacion);
	    genero[numLibro] = gen;
	    ordenar.cambiaGenero(genero);
	    numLibro ++;
	    //Preguntamos si se quiere repetir el proceso con un segundo libro
	    System.out.println("Gustas guardar otro libro, ingresar la opc numerica: 1-Si 2-No");
	    nuevoLibro = scan.nextInt();
	    scan.nextLine();
	    if(nuevoLibro == 1){
		continuar = true;
	    }else{
		continuar = false;
	    }
	    
	}while(continuar);
	do{
	System.out.println("Gusta 1-Ordenar por alguna característica, 2-Ver el juego peor calificado o 3-Ver el juego mejor calificado, 4-Salir");
	opc = scan.nextInt();
	switch(opc){
	    //1 opcion para ordenar, preguntar de que manera y llamar a la clase
	case 1:
	    System.out.println("Excelente, de que forma le gustaría ordenarlos. 1-Nombre, 2-Calificacion, 3-Genero. Usar la opc numerica");
	    formaDeOrdenar = scan.nextInt();
	    scan.nextLine();
	    switch(formaDeOrdenar){
	    case 1:
		ordenar.ordenarPorNombre(juegos, numLibro);
		break;
	    case 2:
		ordenar.ordenarPorCalificacion(calificacion, numLibro);
		break;
	    case 3:
		ordenar.ordenarPorGenero(genero, numLibro);
	    default:
		break;
	    }//Fin del switch interno, para el ordenamiento
	    //case 2, para el juego peor calificado, usando el metodo peorCalificado
	case 2:
	    System.out.print("El juego peor calificado es: ");
	    ordenar.peorCalificado(numLibro);
	    break;
	    //Case 3, para el mejor calificado, usando el metodo mejorCalificado
	case 3:
	    System.out.print("El juego mejor calificado es: ");
	    ordenar.mejorCalificado(numLibro);
	    break;
	    //Terminar el programa, cambiando el valor booleano a falso
	case 4:
	    terminar = false;
	    break;
	}//Fin del switch
	}while(terminar);
    }//FIn del main
}//FIn de la clase

import java.util.Scanner; // Clase para recibir valores del usuario

public class Primos{

    public static void main(String[] args){
	/**
	 *Declaracion de variables:
	 int:
	    numero: Numero que elija el usuario, define la cantidad de veces a realizar la operacion
	    Resultado: Guarda los diferentes valores que devuelve la operacion
	 boolean:
	    esPrimo: Para saber si el resultado de la operacion es primo o no
	 */
	int numero;
	int Resultado;
	boolean esPrimo;
	/*
	  Declaracion de objetos:
	  operacion: 
	  scan:
	  nPrimo
	 */
	SumaN operacion = new SumaN(2, 1);
	Scanner scan = new Scanner(System.in);
	Primo nPrimo = new Primo();
	
	System.out.print("Hola, introduce un numero porfavor: "); //Bienvenida y peticion del numero
	numero = scan.nextInt();//Guarda el numero escrito

	if(numero == 0 || numero == 1){ //Si es 0 o 1 detener el programa
	    return;
	}else if(numero < 0){ // Si el numero elegido es menor a cero, sacar su valor absoluto
	    numero = Math.abs(numero);
	}
	/*
	  bucle que va a repetirse hasta que un numero n que empieza en 1, sea menor o igual al valor elegido por el usuario
	 */
	for (int n = 1; n <= numero; n++){
	    Resultado = operacion.evalua(n); //Guardar el valor del metodo evalua() en la var Resultado

	    esPrimo = nPrimo.esPrimo(Resultado); // Evaluar el valor resultado con el metodo esPrimo, devuelve un verdadero o falso, de si es primo             o no
	    if(esPrimo == true){ //En caso de ser verdadero, si es un numero primo.
		                 //Entonces imprimir el resultado y un mensaje indicando que es primo
		System.out.println(Resultado + " Es primo " );
	    }else{//Caso contrario unicamente imprimir el resultado
		System.out.println(Resultado);
	    }
	}
	
	
    }


}

//Declaracion de bibliotecas
import java.util.Scanner; //Leer lo que escriba el usuario
import java.util.Random; // Clase para generar numero aleatorio
public class PPT{
    public static void main(String[] args){
	/*Declaracion inicial
	  Objeto scan -- Para lo que escriba el usuario
	  Objeto rand -- Para llamar al metodo Random
	  valorU -- valor de Piedra, Papel, Tijeras en enteros
	           Piedra - 0 , Papel - 1 , Tijeras - 2
	  PuntComp -- Puntos que lleva la computadora
	  PuntUsu -- Puntos que lleva el usuario
	  boolean -- En caso de escribir mal una de las palabras
	*/
	Scanner scan = new Scanner(System.in);
	Random rand = new Random();
	int valorU=3;
	int puntComp=0;
	int puntUsu=0;
	int ronda= 0;
	boolean Validacion = true;
	
	
	// Bienvenida al programa
	System.out.println("Bienvenido a Piedra, Papel o Tijeras!!!");
	System.out.println("Gana el mejor de 3 rondas");
	do{
        //variabel entera para que la computadora elija un numero aleatorio (del 0 al 2)
	int valorM = rand.nextInt(3);
	 do{
	     //Aviso de la manera de escribir de las opciones, ademas de guardar lo elegido en un objeto. Este en forma de cadena
	     System.out.println("Elige TEXTUALMENTE una y solo una de estas opciones: Piedra, Papel o Tijeras: ");
	     String eleccionUsua = scan.next();
	     // Casos en base a cada eleccion del usuario. Dependiendo la opcion la variable tiene un valor diferente
	     switch(eleccionUsua){
	     case "Piedra":
		 valorU = 0;
		 Validacion = true;
		 break;
	     case "Papel":
		 valorU = 1;
		 Validacion = true;
		 break;
	     case "Tijeras":
		 valorU = 2;
		 Validacion = true;
		 break;
	     default:
		 //En caso de escribir mal la opcion se cambia el valor de la validacion
		 System.out.println("Estas mal amigo. Introduce bien la opcion xdxdxdxd");
		 Validacion = false;	    
	     }
	 }while(Validacion == false); //En caso de ser falsa la validacion volver a las instrucciones de seleccion

	 /* Condiciones para comparar el numero que dio la computadora, con la digitada por el usuario
	    como se menciono antes: 0 - Piedra, 1- Papel, 2- Tijeras.
	    Segun las reglas del juego, el if se explica de la siguiente forma:
	    0 empata con 0, 0 le pierde a 1 y 0 gana contra 2
	    1 empata con 1, 1 gana contra 0 y 1 pierde contra 2
	    2 empata con 2, 2 pierde contra 0 y 2 gana contra 1
	 */
	 if(valorM == 0){ // Este primer if analiza los casos donde la computadora eligio 0- "Piedra"
		if(valorU == valorM){
		    System.out.println("Empate");
		    System.out.println("Llevas: " + puntUsu + " Y la computadora: " + puntComp);
		    
	        
		}else if(valorU == 1){
		    System.out.println("Ganaste");
		    puntUsu ++;
		    System.out.println("Llevas: " + puntUsu +" Y la computadora: " + puntComp);
		    
		}else if(valorU == 2){
		    System.out.println("Perdiste");
		    puntComp ++;
		    System.out.println("Llevas: " + puntUsu +" Y la computadora: " + puntComp);
		    
		}
		
	 } //Este segundo if analiza los casos donde la computadora eligio 1- "Papel"
	if(valorM == 1){
		   if(valorU == valorM){
		       System.out.println("Empate");
		       System.out.println("Llevas: " + puntUsu +" Y la computadora: " + puntComp);
		       
		   }else if(valorU == 0){
		       System.out.println("Pierdes");
		       puntComp ++;
		       System.out.println("Llevas: " + puntUsu +" Y la computadora: " + puntComp);
		       
		
		   }else if(valorU ==2){
		       System.out.println("Ganaste");
		       puntUsu ++;
		       System.out.println("Llevas: " + puntUsu +" Y la computadora: " + puntComp);
		      
		   }
		   
	}
	if(valorM == 2){ //Este tercer if analiza los casos donde la computadora eligio 2- "Tijeras"
	    
		  if(valorU == valorM){
		      System.out.println("Empate");
		      System.out.println("Llevas: " + puntUsu +" Y la computadora: " + puntComp);
		      
		  }else if(valorU == 0){
		      System.out.println("Ganaste");
		      puntUsu ++;
		      System.out.println("Llevas: " + puntUsu +" Y la computadora: " + puntComp);
		      
		
		  }else if(valorU == 1){
		      System.out.println("Perdiste");
		      puntComp ++;
		      System.out.println("Llevas: " + puntUsu +" Y la computadora: " + puntComp);
		      
		  }
		  
       }
	ronda ++;
	}while(ronda <3); //Este while hace que se repita lo anterior hasta las instrucciones, hasta que el usuario o la
	//computadora consigan 2 puntos
	/*Este if y else if anuncian al ganador basado en los puntos obtenidos*/
	if(puntUsu >= 2){
	System.out.println("El ganador fue: el usuario ehhhhhhhhh");
	}else if(puntComp >= 2){
	    System.out.println("El ganador fue: La computadora, como eres malo");
	}else {
	    System.out.println("Ninguno de los dos consiguio dos puntos");
	}
	

    }

}

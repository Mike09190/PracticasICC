import java.util.Scanner;

public class Biblio{
    public static void main(String[] args){
	//Declaracion de variables
	String isbn, titulo, autor, generos; //Datos del libro
	String buscarLibrosAut,buscarLibrosTit, buscarLibrosGen;
	int opc, buscador, buscarLibrosOpc;
	int n=0;//Para repetir el programa hasta que se seleccione salida
	int masGenero = 1; //Para poner varios generos en un libro
	//Declaracion de objetos
	Scanner scan = new Scanner(System.in); //objeto de la clase scanner
	Biblioteca biblio = new Biblioteca(); //objeto de la clase biblioteca
	TextoColor colorResultadoV = new TextoColor(); //objeto de la clase color, para los resultados existan
	TextoColor colorTitulo = new TextoColor(); //Objeto color para el titulo
	TextoColor colorInstrucciones = new TextoColor(); //Objeto para el color de las instrucciones
	TextoColor colorResultadoF = new TextoColor();//objeto para los resultados que no pueden mostrar
	// en el siguiente apartado guardo los colores en strings con los metodos y usando los objetos antes declarados
	colorTitulo.cambiaColor("\u001b[35m");
	colorInstrucciones.cambiaColor("\u001B[31m");
	colorResultadoV.cambiaColor("\u001B[34m");
	colorResultadoF.cambiaColor("\u001B[33m");
	String amarillo = colorResultadoF.obtenColor();
	String morado = colorTitulo.obtenColor();
	String rojo = colorInstrucciones.obtenColor();
	String azul = colorResultadoV.obtenColor();
	//Titulo de la biblioteca
	System.out.println(colorTitulo.daColorTexto("Bienvenido al Fondo de Cultura Economica", morado));
	
	while(n == 0){ //Repetir el programa despues de cada caso, exceptuando el default
	    System.out.println(colorInstrucciones.daColorTexto("Para empezar seleccione una de las siguientes opciones, usando el numero correspondiente:\n 1-Registrar Libro    2-Buscar Libro    3-Lista completa de libros  4-Salir", rojo));
	    opc = scan.nextInt(); //Gurdamos una de las opciones de manera numerica
	    scan.nextLine();
	    switch (opc){
	    case 1: //Registrar los nuevos libros
		System.out.println(colorInstrucciones.daColorTexto("Registrar nuevo libro", morado));
		System.out.print(colorInstrucciones.daColorTexto("Escribe su ISBN: ", morado));
		isbn = scan.nextLine(); //Guardar lo escrito en el isbn
		if(biblio.obtenLibroPorISBN(isbn) != null){ //Verificar que el isbn escrito no este repetido
		    System.out.println(colorResultadoF.daColorTexto("Ya hay un isbn igual registrado", amarillo));
		   break;
		}
		System.out.print(colorInstrucciones.daColorTexto("Escribe el titulo del libro: ", morado)); 
		titulo = scan.nextLine(); //Guardar lo escrito en titulo
		System.out.print(colorInstrucciones.daColorTexto("Escribe el autor  del libro: ", morado)); 
		autor = scan.nextLine(); //Guardar lo escrito en autor
		Libro libro = new Libro(isbn, titulo, autor, ""); //Guardar los valores anteriores en un objeto libro, dejamos en blanco en genero por el momento
		do{
		    System.out.print(colorInstrucciones.daColorTexto("Escribe el genero/s del libro: ", morado));
		    generos = scan.nextLine(); //Guardamos el genero del libro
		    libro.agregaGenero(generos); // usamos el metodo para agregar el genero que nos faltaba al objeto libro
		    System.out.println(colorInstrucciones.daColorTexto("¿Quieres poner otro genero para el libro? Seleccione usando el numero asignado 1-Si 2-No", morado));
		    masGenero = scan.nextInt(); //Se pregunta si se va a agregar un otro genero al libro.
		    scan.nextLine();
		}while(masGenero == 1); //while que se va a repetir hasta que queramos dejar de agregar elementos al libro
		biblio.agregaLibro(libro);
		break;
	    case 2: // buscar libro
	        System.out.println("Buscador de libros");
		System.out.println(colorInstrucciones.daColorTexto("Para empezar elija la forma de busqueda:\n 1-Buscar libro por ISBN  2-Buscar libros por autor, titulo o genero", morado));
		/*el sistem de arriba se encarga de separar la busqueda en dos casos,										  buscar un solo libro por el isbn o buscar libros asociados a uno de los 3 datos.*/
		buscador = scan.nextInt(); //guardar la opcion elegida 
		scan.nextLine();
		switch(buscador){ //switch de una de las dos opciones (isbn o buscador de libros)
		case 1: // ISBN
		    System.out.println(colorInstrucciones.daColorTexto("Ingrece el isbn a buscar: ", morado));
			isbn = scan.nextLine(); //Guardar el ISBN escrito
			System.out.print(colorResultadoV.obtenColor());
		        Libro buscarLibro = biblio.obtenLibroPorISBN(isbn); // crear metodo para buscar libros por el isbn escrito por el usuario
			if(buscarLibro != null){ //Si el resultado de esa busqueda devuelve algo imprimir todos los datos del libro
			    System.out.println(buscarLibro); 
			}else{ // Caso contrario no se encuentran libros 
			    System.out.println(colorResultadoF.daColorTexto("NO se encuentra libro asociado al ISBN" , amarillo)); 
				break;
			    } 
			    break; //Fin del caso 1
		case 2: // Buscar libros por autor, titulo o genero
		    System.out.println(colorInstrucciones.daColorTexto("Lo quieres buscar por 1-autor, 2-titulo o 3-genero: ", morado));
		    buscarLibrosOpc = scan.nextInt(); //Guardar por cual de los 3 casos quiere buscar los libros
		    scan.nextLine();
		    if(buscarLibrosOpc==1){  //Por autor
			System.out.println(colorInstrucciones.daColorTexto("Escriba el nombre del autor: ", morado));
			buscarLibrosAut = scan.nextLine(); //Guardar el nombre del autor
			if(biblio.filtraPor(biblio.AUTOR, buscarLibrosAut, "")== null) { //revisar si no existe ese autor asociado a un libro
			   System.out.println(colorResultadoF.daColorTexto("No hay libros asociados al autor", amarillo));
			}else{ // caso contrario mostrar los libros asociados a ese autor
			    System.out.print(colorResultadoV.obtenColor()); //poner color amarillo a lo siguiente
			    System.out.println(biblio.filtraPor(biblio.AUTOR, buscarLibrosAut, "")); //mostrar los libros asociados al autor
			      }
		    }//fin del If
		    else if(buscarLibrosOpc==2){ //opcion buscar libros por titulo
			System.out.println(colorInstrucciones.daColorTexto("Escriba el titulo del libro: ", morado));
			buscarLibrosTit = scan.nextLine(); //guardar el titulo del libro
			if(biblio.filtraPor(biblio.TITULO, buscarLibrosTit, "")!= null){ //verificar si exsite titulo asociado a un libro o varios
			    System.out.print(colorResultadoV.obtenColor()); //cambiar el color a amarillo lo siguiente 
			    System.out.println(biblio.filtraPor(biblio.TITULO, buscarLibrosTit, "")); // mostrar los libros con ese titulo
			      }else{
				  System.out.println(colorResultadoF.daColorTexto("No hay titulo asociado a ningun libro", amarillo));
				  //NO existen libros asociados a ese titulo
			      }
		    }//fin del else if
		    else if(buscarLibrosOpc==3){ //opcion de buscar por generos 
			System.out.println(colorInstrucciones.daColorTexto("Escriba el genero del libro: ", morado)); 
			buscarLibrosGen = scan.nextLine(); //guardar el genero escrito por el usuario
			if(biblio.filtraPor(biblio.GENERO, buscarLibrosGen, "")!=null){ // verificar si existe ese genero asociado a libros
			    System.out.print(colorResultadoV.obtenColor()); // cambiar el color a amarillo
			    System.out.println(biblio.filtraPor(biblio.GENERO, buscarLibrosGen, "")); // mostrar los libros asociados al genero
			      }else{
				  System.out.println(colorResultadoF.daColorTexto("No hay ningun genero asociado a ningun libro", amarillo));
				  //mostrar mensaje de error, no hay libros asociados
			      }	      
		    }
		    else{
			System.out.println(colorInstrucciones.daColorTexto("Escribe una de las opciones, no otra cosa", morado));
			//en caso de que selecciones otra cosa
			break;
		    }
		    
		    
		}//Fin del switch
		break;
	    case 3: //Para mostrar la lista de libros disponibles
		System.out.println("Aqui estan todos lis libros que existen en la biblioteca");
		if(biblio.obtenTodosLosLibros("")!=null){ // verificar si existe algun libro para lista
		    System.out.print(colorResultadoV.obtenColor()); //cambiar color a azul
		    System.out.println(biblio.obtenTodosLosLibros("")); //mostrar los libros
		break;
		}
		else{ //no hay libros para la lista
		    System.out.print(colorResultadoF.obtenColor()); //cambiar color a amarillo
		    System.out.println("No se ha creado ningun libro para la lista"); //mostrar mensaje de error
		    break;
		}
	    default: //en cuanto se seleccione salir o una opcion no valida
		System.out.println(""); 
		n = 1;
		break;
	    }//Fin del switch
	}//Fin del while
	
	

    }//Fin del main

}//Fin de la clase

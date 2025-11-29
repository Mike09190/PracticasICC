import java.util.Scanner;
import java.util.Date;

public class PaginaVuelos {
    public static void main(String[] args){
	//Declaracion de variables
	int opc, opcApellido;
	String nombre="", apellidoP="", apellidoM="";
	String nacionalidad, pais;
	int identificacion=0;
	boolean certiSalud = false, edadValida = false;
	
	//Declaracion de objetos
	Scanner scan = new Scanner(System.in);
	Internacional internacional = new Internacional(nombre, apellidoP, identificacion);
	Estratosfericos estra = new Estratosfericos(nombre, apellidoP, identificacion);
	System.out.println("Bienvenido al sistema de vuelo avanzado full HD 4k");
	System.out.println("Seleccione el tipo de vuelo que desea realizar: ");
	System.out.println("1-Vuelo internacional, 2-Vuelo Estratosferico 3-Vuelo Interplanetario :  ");
	opc = scan.nextInt();


	//switch con las 3 opc
	switch(opc){
	case 1:
	    //Pedir los datos como nombre y toda la vaina esa
	    while(true){
		try{
		    System.out.println("Escriba su nombre: ");
		    nombre = scan.nextLine();
		    internacional.cambiaNombre(nombre); //GUardar en el asignador con la excepcion en nombre
		    System.out.println("Escriba su apellido paterno: ");
		    apellidoP = scan.nextLine();
		    internacional.cambiaApellidoP(apellidoP); //GUardar en el asignador con la excepcion en apellidoP
		    System.out.println("Gusta añadir su apellido materno? 1-SI, 2-NO");
		    opcApellido = scan.nextInt();
		    scan.nextLine();
		    if(opcApellido == 1){
			System.out.println("Escriba su apellido Materno: ");
			apellidoM = scan.nextLine();
			internacional.cambiaApellidoM(apellidoM); //GUardar en el asignador con la excepcion en apellidoM
		    }
		    break; //Terminar el while
		}catch(NombreInvalidoException e){
		    System.out.println(e); //los 3 datos usan la misma excepcion NombreInvalidoexception
		}
	    }//FIn del while del nombre y apellidos
	    
	//Pedir identificacion correcta
	    while(true){
		try{
		    System.out.println("Ingrese el año de su identificacion: YYYY");
		    int año = scan.nextInt();
		    scan.nextLine();//Limpiar scan
		    System.out.println("Ingrese el mes de su identificacion: MM");
		    int mes = scan.nextInt();
		    scan.nextLine();//Limpiar scan
		    System.out.println("Ingrese el dia de su identificacion: DD");
		    int dia = scan.nextInt();
		    scan.nextLine(); //Limpiar scan
		    Date fecha = new Date(año - 1900, mes - 1, dia);		
		    internacional.cambiaFechaIdentificacion(fecha); //Revisar la fecha, hay un excepcion ahi
		    System.out.println("Ingrese el num de identificacion");
		    int numIdentificacion = scan.nextInt();
		    scan.nextLine(); //Limpiar scan
		    internacional.cambiaNumIdentificacion(numIdentificacion); //get pra la identificacion
		    break;
		}catch(FechaInvalidaException e){
		    System.out.println(e);
		}
	    }
	    //While para verificar la nacionalidad
	    while(true){
		try{
		    System.out.println("Escriba su nacionaliad (solos sus primeras dos letras en mayusculas)");
		    nacionalidad = scan.nextLine();
		    internacional.cambiaNacionalidad(nacionalidad);
		    System.out.println("Esciba el pais de origen (solos sus primeras dos letras en mayusculas): ");
		    pais = scan.nextLine();
		    internacional.cambiaPaisOrigen(pais);
		    break;
		}catch(NacionalidadInvalida o){
		    System.out.println(o);
		}	    
	    }//Fin del while

	    //Lugar de viaje
	    while(true){
		try{
		    System.out.println("Eliga su lugar de destino: ");
		    String destino = scan.nextLine();
		    boolean destinoValido = internacional.destino(destino);
		    System.out.println("Eligar la fecha de su viaje:");
		    System.out.println("Ingrese el año de su identificacion: YYYY");
		    int año = scan.nextInt();
		    scan.nextLine();//Limpiar scan
		    System.out.println("Ingrese el mes de su identificacion: MM");
		    int mes = scan.nextInt();
		    scan.nextLine();//Limpiar scan
		    System.out.println("Ingrese el dia de su identificacion: DD");
		    int dia = scan.nextInt();
		    scan.nextLine(); //Limpiar scan
		    Date fechaViaje = new Date(año - 1900, mes - 1, dia);
		    boolean fechaValida = internacional.fechaPartida(fechaViaje);
		    if(destinoValido && fechaValida){
			System.out.println("El viaje es valido en: " + destino);	
		    }
		    break;
		}catch(DestinoInvalido e){
		    System.out.println(e);
		}catch(FechaInvalidaException o){
		    System.out.println(o);
		}
	    }//Fin del while
	    break;
	case 2:
	    //Vuelos estratosfericos
	    //Pedir los datos como nombre y toda la vaina esa
	    while(true){
		try{
		    System.out.println("Escriba su nombre: ");
		    nombre = scan.nextLine();
		    estra.cambiaNombre(nombre); //GUardar en el asignador con la excepcion en nombre
		    System.out.println("Escriba su apellido paterno: ");
		    apellidoP = scan.nextLine();
		    estra.cambiaApellidoP(apellidoP); //GUardar en el asignador con la excepcion en apellidoP
		    System.out.println("Gusta añadir su apellido materno? 1-SI, 2-NO");
		    opcApellido = scan.nextInt();
		    scan.nextLine();
		    if(opcApellido == 1){
			System.out.println("Escriba su apellido Materno: ");
			apellidoM = scan.nextLine();
			estra.cambiaApellidoM(apellidoM); //GUardar en el asignador con la excepcion en apellidoM
		    }
		    break; //Terminar el while
		}catch(NombreInvalidoException e){
		    System.out.println(e); //los 3 datos usan la misma excepcion NombreInvalidoexception
		}
	    }//FIn del while del nombre y apellidos
	    
	//Pedir identificacion correcta
	    while(true){
		try{
		    System.out.println("Ingrese el año de su identificacion: YYYY");
		    int año = scan.nextInt();
		    scan.nextLine();//Limpiar scan
		    System.out.println("Ingrese el mes de su identificacion: MM");
		    int mes = scan.nextInt();
		    scan.nextLine();//Limpiar scan
		    System.out.println("Ingrese el dia de su identificacion: DD");
		    int dia = scan.nextInt();
		    scan.nextLine(); //Limpiar scan
		    Date fecha = new Date(año - 1900, mes - 1, dia);		
		    estra.cambiaFechaIdentificacion(fecha); //Revisar la fecha, hay un excepcion ahi
		    System.out.println("Ingrese el num de identificacion");
		    int numIdentificacion = scan.nextInt();
		    scan.nextLine(); //Limpiar scan
		    estra.cambiaNumIdentificacion(numIdentificacion); //get pra la identificacion
		    break;
		}catch(FechaInvalidaException e){
		    System.out.println(e);
		}
	    }
	    //While para verificar la nacionalidad
	    while(true){
		try{
		    System.out.println("Escriba su nacionaliad (solos sus primeras dos letras en mayusculas)");
		    nacionalidad = scan.nextLine();
		    estra.cambiaNacionalidad(nacionalidad);
		    System.out.println("Esciba el pais de origen (solos sus primeras dos letras en mayusculas): ");
		    pais = scan.nextLine();
		    estra.cambiaPaisOrigen(pais);
		    break;
		}catch(NacionalidadInvalida o){
		    System.out.println(o);
		}	    
	    }//Fin del while

	    //Lugar de viaje
	    while(true){
		try{
		    System.out.println("Eliga su lugar de destino: ");
		    String destino = scan.nextLine();
		    boolean destinoValido = estra.destino(destino);
		    System.out.println("Eligar la fecha de su viaje:");
		    System.out.println("Ingrese el año de su identificacion: YYYY");
		    int año = scan.nextInt();
		    scan.nextLine();//Limpiar scan
		    System.out.println("Ingrese el mes de su identificacion: MM");
		    int mes = scan.nextInt();
		    scan.nextLine();//Limpiar scan
		    System.out.println("Ingrese el dia de su identificacion: DD");
		    int dia = scan.nextInt();
		    scan.nextLine(); //Limpiar scan
		    Date fechaViaje = new Date(año - 1900, mes - 1, dia);
		    boolean fechaValida = estra.fechaPartida(fechaViaje);
		    break;
		}catch(DestinoInvalido e){
		    System.out.println(e);
		}catch(FechaInvalidaException o){
		    System.out.println(o);
		}
	    }//Fin del while

	    //Verificar certificado de salud
	     while(true){
		try{
		    System.out.println("Ingrese el certificado de Salud con la siguiente nom: CS-NOMBRE-APELLIDO-AÑO-MES-DIA-CLAVESALUD-TIPOVIAJE");
		    System.out.println("En el apartado de Clavesalud puede poner A si es apto o NA si no lo es.");
		    System.out.println("En el apartado TIPOVIAJE poner E (Estratosferico) o P (InterPLanetario)");
		    String certiSaludTexto = scan.nextLine();
		    certiSalud = estra.certificadoSaludValido(certiSaludTexto);
		    break;
		}catch(CertificadoSaludException e){
		    System.out.println(e);
		}
	    }//Fin del while
	    while(true){
		try{
		    System.out.println("Ingrese su edad: ");
		    int edad = scan.nextInt();
		    scan.nextLine(); //Limpiar el scan
		    
		    edadValida = estra.edad(edad);
		    break;
		}catch(EdadException o){
			System.out.println(o);
		}
	    }//Fin del while
	    if(edadValida && certiSalud){
		System.out.println("Puedes viajar sin problemas.");
	    }else{
		System.out.println("No eres apto para viajar");
	    }
	   	
	    break;
	case 3:
	    //Vuelos interplanetarios
	    InterPlanetarios vueloPlane = null;
	    //Para empezar preguntar el planeta de partida y de origen
	    while(true){
		try{
		    System.out.println("Escribir el planeta de partida (Tiene que ser del sistema solar): ");
		    String planetaPartida = scan.nextLine();
		    System.out.println("Escribir el planeta de origen (Del sistema solar): ");
		    String planetaOrigen = scan.nextLine();
		    vueloPlane = new InterPlanetarios(nombre, apellidoP, identificacion, planetaPartida, planetaOrigen);
		    break;
		}catch(PlanetaInvalido e){
		    System.out.println(e);
		}

	    }//Fin del while
	    	    //Pedir los datos como nombre y toda la vaina esa
	    while(true){
		try{
		    System.out.println("Escriba su nombre: ");
		    nombre = scan.nextLine();
		    vueloPlane.cambiaNombre(nombre); //GUardar en el asignador con la excepcion en nombre
		    System.out.println("Escriba su apellido paterno: ");
		    apellidoP = scan.nextLine();
		    vueloPlane.cambiaApellidoP(apellidoP); //GUardar en el asignador con la excepcion en apellidoP
		    System.out.println("Gusta añadir su apellido materno? 1-SI, 2-NO");
		    opcApellido = scan.nextInt();
		    scan.nextLine();
		    if(opcApellido == 1){
			System.out.println("Escriba su apellido Materno: ");
			apellidoM = scan.nextLine();
			vueloPlane.cambiaApellidoM(apellidoM); //GUardar en el asignador con la excepcion en apellidoM
		    }
		    break; //Terminar el while
		}catch(NombreInvalidoException e){
		    System.out.println(e); //los 3 datos usan la misma excepcion NombreInvalidoexception
		}
	    }//FIn del while del nombre y apellidos
	    
	//Pedir identificacion correcta
	    while(true){
		try{
		    System.out.println("Ingrese el año de su identificacion: YYYY");
		    int año = scan.nextInt();
		    scan.nextLine();//Limpiar scan
		    System.out.println("Ingrese el mes de su identificacion: MM");
		    int mes = scan.nextInt();
		    scan.nextLine();//Limpiar scan
		    System.out.println("Ingrese el dia de su identificacion: DD");
		    int dia = scan.nextInt();
		    scan.nextLine(); //Limpiar scan
		    Date fecha = new Date(año - 1900, mes - 1, dia);		
		    vueloPlane.cambiaFechaIdentificacion(fecha); //Revisar la fecha, hay un excepcion ahi
		    System.out.println("Ingrese el num de identificacion");
		    int numIdentificacion = scan.nextInt();
		    scan.nextLine(); //Limpiar scan
		    vueloPlane.cambiaNumIdentificacion(numIdentificacion); //get pra la identificacion
		    break;
		}catch(FechaInvalidaException e){
		    System.out.println(e);
		}
	    }//Fin del while

	    while(true){
		try{
		    System.out.println("Eliga su lugar de destino: ");
		    String destino = scan.nextLine();
		    boolean destinoValido = vueloPlane.destino(destino);
		    System.out.println("Eligar la fecha de su viaje:");
		    System.out.println("Ingrese el año de su identificacion: YYYY");
		    int año = scan.nextInt();
		    scan.nextLine();//Limpiar scan
		    System.out.println("Ingrese el mes de su identificacion: MM");
		    int mes = scan.nextInt();
		    scan.nextLine();//Limpiar scan
		    System.out.println("Ingrese el dia de su identificacion: DD");
		    int dia = scan.nextInt();
		    scan.nextLine(); //Limpiar scan
		    Date fechaViaje = new Date(año - 1900, mes - 1, dia);
		    boolean fechaValida = vueloPlane.fechaPartida(fechaViaje);
		    break;
		}catch(DestinoInvalido e){
		    System.out.println(e);
		}catch(FechaInvalidaException o){
		    System.out.println(o);
		}
	    }//Fin del while

	    //Verificacion de certificado de salud y edad
	    //Verificar certificado de salud
	     while(true){
		try{
		    System.out.println("Ingrese el certificado de Salud con la siguiente nom: CS-NOMBRE-APELLIDO-AÑO-MES-DIA-CLAVESALUD-TIPOVIAJE");
		    System.out.println("En el apartado de Clavesalud puede poner A si es apto o NA si no lo es.");
		    System.out.println("En el apartado TIPOVIAJE poner E (Estratosferico) o P (InterPLanetario)");
		    String certiSaludTexto = scan.nextLine();
		    certiSalud = vueloPlane.certificadoSaludValido(certiSaludTexto);
		    break;
		}catch(CertificadoSaludException e){
		    System.out.println(e);
		}
	    }//Fin del while
	    while(true){
		try{
		    System.out.println("Ingrese su edad: ");
		    int edad = scan.nextInt();
		    scan.nextLine(); //Limpiar el scan
		    
		    edadValida = vueloPlane.edad(edad);
		    break;
		}catch(EdadException o){
			System.out.println(o);
		}
	    }//Fin del while
	    if(edadValida && certiSalud){
		System.out.println("Puedes viajar sin problemas.");
	    }else{
		System.out.println("No eres apto para viajar");
	    }
	   	
	    break;

	}
    }




}//Fin de la clase

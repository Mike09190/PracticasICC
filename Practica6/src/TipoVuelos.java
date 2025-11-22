import java.util.Scanner;
import java.util.Date;

public class TipoVuelos{
    public static void main(String[] args){
	//Declaracion de var
	String nombre;
	String apellidoP;
	String apellidoM = "";
	String nacionalidad;
	String pais;
	String destino, certiSalud = "";
	String planetaPartida, planetaOrigen;
	int numIdentificacion;
	int opcApellido, edad = 0;
	int opc;
	//Declaracion de objetos
	Scanner scan = new Scanner(System.in);
	
	VuelosInternacionales cliente = new VuelosInternacionales();
	Estratosfericos vueloEstra = new Estratosfericos();
	//Verficar si los datos son correctos con excepciones
	//Con while hasta que esten bien los datos
	while(true){
	    try{
		System.out.println("Escriba su nombre: ");
		nombre = scan.nextLine();
		cliente.cambiaNombre(nombre); //GUardar en el asignador con la excepcion en nombre
		System.out.println("Escriba su apellido paterno: ");
		apellidoP = scan.nextLine();
		cliente.cambiaApellidoP(apellidoP); //GUardar en el asignador con la excepcion en apellidoP
		System.out.println("Gusta añadir su apellido materno? 1-SI, 2-NO");
		opcApellido = scan.nextInt();
		scan.nextLine();
		if(opcApellido == 1){
		    System.out.println("Escriba su apellido Materno: ");
		    apellidoM = scan.nextLine();
		    cliente.cambiaApellidoM(apellidoM); //GUardar en el asignador con la excepcion en apellidoM
		}
		break; //Terminar el while
	    }catch(NombreInvalidoException e){
		System.out.println(e); //los 3 datos usan la misma excepcion NombreInvalidoexception
	    }
	}//FIn del while del nombre y apellidos
	//While para verificar la nacionalidad
	while(true){
	    try{
		System.out.println("Escriba su nacionaliad (solos sus primeras dos letras en mayusculas)");
		nacionalidad = scan.nextLine();
		cliente.cambiaNacionalidad(nacionalidad);
		System.out.println("Esciba el pais de origen (solos sus primeras dos letras en mayusculas): ");
		pais = scan.nextLine();
		cliente.cambiaPaisOrigen(pais);
		break;
	    }catch(NacionalidadInvalida o){
		System.out.println(o);
	    }
	    
	}//Fin del while
	//While para verificar los datos de vencimiento identificacion
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
		cliente.cambiaFechaIdentificacion(fecha); //Revisar la fecha, hay un excepcion ahi
		System.out.println("Ingrese el num de identificacion");
		numIdentificacion = scan.nextInt();
		scan.nextLine(); //Limpiar scan
		cliente.cambiaNumIdentificacion(numIdentificacion); //get pra la identificacion
		break;
	    }catch(FechaInvalidaException e){
		System.out.println(e);
	    }
	}

	//Opc de los tipos de vuelos
	System.out.println("Que tipo de vuelo desea realizar, 1-Internacional 2-Estratosfericos 3-InterPlanetarios");
	opc = scan.nextInt();
	scan.nextLine(); //Limpiar el scanner
	switch(opc){
	case 1: //Vuelos Internacionales
	    //Empezar preguntando el destino en un while igual que arriba por errores del usuario
	    while(true){
		try{
		    System.out.println("Ingrese el destino de su viaje (solos sus primeras dos letras en mayusculas): ");
		    destino = scan.nextLine();
		    cliente.cambiaDestino(destino);
		    break;
		}catch(DestinoInvalido e){
		    System.out.println(e);
		}
		
	    }
	    while(true){
		try{
		    System.out.println("Ingrese el año de su viaje: YYYY");
		    int añoV = scan.nextInt();
		    scan.nextLine();//Limpiar scan
		    System.out.println("Ingrese el mes de su viaje: MM");
		    int mesV = scan.nextInt();
		    scan.nextLine();//Limpiar scan
		    System.out.println("Ingrese el dia de su viaje: DD");
		    int diaV = scan.nextInt();
		    scan.nextLine(); //Limpiar scan
		    Date fecha = new Date(añoV - 1900, mesV - 1, diaV);
		    cliente.cambiaFechaPartida(fecha);
		    break;
		}catch(FechaInvalidaException e){
		    System.out.println(e);
		}
	    }//Fin del while
	    System.out.println("Vuelo marcado con exito...");
	    break;
	case 2:
	    //Vuelos estratosfericos, preguntar primero el destino y fecha del viaje
	    while(true){
		try{
		    System.out.println("Ingrese el destino de su viaje (solos sus primeras dos letras en mayusculas): ");
		    destino = scan.nextLine();
		    vueloEstra.cambiaDestino(destino);
		    break;
		}catch(DestinoInvalido e){
		    System.out.println(e);
		}
		
	    }
	    while(true){
		try{
		    System.out.println("Ingrese el año de su viaje: YYYY");
		    int añoV = scan.nextInt();
		    scan.nextLine();//Limpiar scan
		    System.out.println("Ingrese el mes de su viaje: MM");
		    int mesV = scan.nextInt();
		    scan.nextLine();//Limpiar scan
		    System.out.println("Ingrese el dia de su viaje: DD");
		    int diaV = scan.nextInt();
		    scan.nextLine(); //Limpiar scan
		    Date fecha = new Date(añoV - 1900, mesV - 1, diaV);
		    vueloEstra.cambiaFechaPartida(fecha);
		    break;
		}catch(FechaInvalidaException e){
		    System.out.println(e);
		}
	    }//Fin del while
	    //Pedir el Certificado de Salud
	    while(true){
		try{
		    System.out.println("Ingrese el certificado de Salud con la siguiente nom: CS-NOMBRE-APELLIDO-AÑO-MES-DIA-CLAVESALUD-TIPOVIAJE");
		    System.out.println("En el apartado de Clavesalud puede poner A si es apto o NA si no lo es.");
		    System.out.println("En el apartado TIPOVIAJE poner E (Estratosferico) o P (InterPLanetario)");
		    certiSalud = scan.nextLine();
		    vueloEstra.cambiaNumCertificadoSalud(certiSalud);
		    break;
		}catch(CertificadoSaludException e){
		    System.out.println(e);
		}
	    }//Fin del while
	    while(true){
		try{
		    System.out.println("Ingrese su edad: ");
		    edad = scan.nextInt();
		    scan.nextLine(); //Limpiar el scan
		    if(vueloEstra.verificarEdad()){ //Si es menor a 18 o mayor a 75 no se puede viajar
			System.out.println("Eres menor a 18 o mayor a 75 para viajar");
			continue;
		    }
		    vueloEstra.cambiaEdad(edad);
		    break;
		}catch(EdadException o){
			System.out.println(o);
		}
	    }//Fin del while
	    if(vueloEstra.verificarApto() && vueloEstra.tipoVueloEstra()){
		System.out.println("Puedes viajar sin problemas.");
	    }else{
		System.out.println("No eres apto para viajar");
	    }
	    break;
	    
	    
	case 3:
	    //Vuelos InterPlanetario
	    VuelosInterplanetarios vueloPlane = null;
	    //Para empezar preguntar el planeta de partida y de origen
	    while(true){
		try{
		    System.out.println("Escribir el planeta de partida (Tiene que ser del sistema solar): ");
		    planetaPartida = scan.nextLine();
		    System.out.println("Escribir el planeta de origen (Del sistema solar): ");
		    planetaOrigen = scan.nextLine();
		    vueloPlane = new VuelosInterplanetarios(planetaPartida, planetaOrigen);
		    break;
		}catch(PlanetaInvalido e){
		    System.out.println(e);
		}

	    }//Fin del while
	    //Ahora pedir el destino
	    while(true){
		try{
		    System.out.println("Destino, el planeta tiene que ser del sistema solar: ");
		    destino = scan.nextLine();
		    vueloPlane.cambiaDestino(destino);
		    break;
		}catch(DestinoInvalido e){
		    System.out.println(e);
		}
	    }//FIn del while
	    //Verificar si tiene certificado de salud ya creado, en caso negativo crear uno
	    if(certiSalud.equals("")){
		while(true){
		    try{
			System.out.println("Ingrese el certificado de Salud con la siguiente nom: CS-NOMBRE-APELLIDO-AÑO-MES-DIA-CLAVESALUD-TIPOVIAJE");
			System.out.println("En el apartado de Clavesalud puede poner A si es apto o NA si no lo es.");
			System.out.println("En el apartado TIPOVIAJE poner E (Estratosferico) o P (InterPLanetario)");
			certiSalud = scan.nextLine();
			vueloEstra.cambiaNumCertificadoSalud(certiSalud);
			break;
		    }catch(CertificadoSaludException e){
			System.out.println(e);
		    }
		}//Fin del while
	    }//FIn del if
	    //Verificar si es apto para viajar
	    if(vueloEstra.verificarApto() && vueloEstra.tipoVueloInter()){
		System.out.println("Puedes viajar sin problemas.");
	    }else{
		System.out.println("No puedes viajar");
	    }
	    break;
	}//Fin del switch
	
    }//FIn del main
}

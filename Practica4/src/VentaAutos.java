import java.util.Scanner; // Scanner para la lectura de opciones		

public class VentaAutos{
    public static void main(String[] args){
	// variables para diferentes atributos del auto
	String marcaOpc, transmicion, color, acabado, ventana, llantas;
	int tamañoLlantas, material, frenos;
	int camara, pantalla, sensor, espejo;
	int año, lugar, tipoDeAuto, opc;
	double precioFinal;
	// Definicion de objetos
	Scanner scan = new Scanner(System.in);
	MarcaAutomovil marca = new MarcaAutomovil();
	Automovil auto = new Automovil();
	Chasis chasi = new Chasis();
	Llanta llanta = new Llanta();
	SistemaElectronico sistema = new SistemaElectronico();
	//Bienvenida al usuario
	System.out.println("Bienvenido usuario, a continuacion le muestro las opciones para elegir su nuevo carro");
	System.out.print("Para empezar eliga la marca del auto (Honda, BYD, Wolswagen, Toyota, Nissan): ");
	marcaOpc = scan.nextLine(); //Guardamos la marca
	marca.cambiaMarca(marcaOpc); // Método para extrar la marca escrita por el usuario
	System.out.println("Ahora el lugar de Fabricacion cada uno tiene un costo diferente: ");
	marca.listaLugares(marcaOpc); //Método para obtener una lista con los lugares asociados a la marca
	lugar = scan.nextInt(); // Guardar la opcion del lugar
	marca.cambiaLugar(lugar); //Cambiar el lugar base al escrito por el usuario
	marca.guardarPrecio(); //Método para guardar el costo de las anteriores opciones
	System.out.println("Lleva en total: "+ marca.obtenPrecio()); //Mostrar el precio final hasta el momento
	scan.nextLine(); //borrar lo escrito en el scan
	System.out.print("A continuacion seleccione cual de las dos transmiciones gusta (escribir la palabra), Automatica(80,000MXN) o Manual(40,000mxn): ");
	transmicion = scan.nextLine(); //Guardar la seleccion de la transmicion
	auto.cambiaTransmicion(transmicion);
	auto.precioTransmicion(transmicion); //utilizar el metodo precioTransmicion para obtener el precio asociado a la opcion
	auto.precioFinal(marca, chasi, llanta, sistema); //Mostrar precio Final hasta el momento
	System.out.println("Ahora seleccione el tipo de auto que guste, seleccionando el numero asociado: ");
	System.out.println("1-Compacto (40,000mxn), 2- Semicompacto (80,000mxn), 3-Sedán (120,000mxn), 4-Deportivo (200,000mxn)");
	tipoDeAuto = scan.nextInt(); //Guardar el tipo de auto en int
	auto.cambiaTipoAuto(tipoDeAuto);
	auto.precioTipoAuto(tipoDeAuto); //metodo para guardar el precio asociado al tipo de auto
	auto.precioFinal(marca, chasi, llanta, sistema); //Mostrar precio final hasta el momento
	/*
	  A continuacion se preguntara el año, se guardara el precio dependiendo del año y se mostrara
	  el precio total hasta el momento
	*/
	System.out.println("Eliga el año de su auto: 2023 (30,000MXN), 2024(40,000MXN), 2025(50,000MXN):  ");
	año = scan.nextInt();
	auto.cambiaAño(año);
	auto.precioAño(año);
	auto.precioFinal(marca, chasi, llanta, sistema); //Mostrar precio final hasta el momento

	/*
	  Ahora sigue el color del chasis y el acabado, se usara el objeto de la clase chasis y los metodos obtenerChasis y precioChasis
	  al Igual que el precio Final nuevamente
	*/
	System.out.println("Eliga el color que guste para su chasis (Favor de no poner acentos): ");
	System.out.println("Marron, oro, gris, blanco, rojo, negro, verde, azul, amarillo");
	scan.nextLine(); //limpiar el scan
	color = scan.nextLine();
	chasi.cambiaColor(color);
	auto.precioFinal(marca, chasi, llanta, sistema);//Mostrar precio final hasta el momento
	System.out.println("Eliga el tipo de acabado del color del chasis (Igual sin acento la opcion): mate (Sin costo), brillante (10,000MXN), metalico(15,000MXN)");
	acabado = scan.nextLine();
	chasi.cambiaAcabado(acabado); //Metodo para cambiar el acabado al puesto por el usuario
	chasi.precioAcabado(); // Metodo para obtener el precio
	auto.precioFinal(marca, chasi, llanta, sistema); // mostrar precio final hasta el momento
	/*
	  Haremos algo similar con la opcion del vidrio, usaremo el metodo precioVidrios para obtener el precio dep de la opc.
	*/
	System.out.println("Le gustaria agregar película anti-asalto? Si (4,000MXN), No");
	ventana = scan.nextLine();
	chasi.cambiaVentanas(ventana);
	chasi.precioVidrios(ventana); //Método para obtener el precio de la ventana
	auto.precioFinal(marca, chasi, llanta, sistema); //Precio final hasta el momento
	/*
	  Preguntar la marca de las llantas, guardar el resultado y mostrar el precio final
	*/
	System.out.println("Elija la marca de sus llantas: ");
	System.out.println("Yokohama (5,000mxn), Firestone(8,000mxn), Pirelli(6,500mxn), GoodYear(6,000mxn), Michelin(10,000mxn)");
	llantas = scan.nextLine();
	llanta.cambiaMarca(llantas);
	llanta.precioLlantas(llantas); //Guardar el precio de la llantas, por le opc del usuario
	auto.precioFinal(marca, chasi, llanta, sistema); //Mostrar precio final hasta el momento

	/*
	  Preguntar tamaño del rin y material del rin, guardar el resultado y mostrar el precio Final
	 */
	System.out.println("Elija el tamaño del Rin: (15,16,17 y 18 pulgadas) ");
	tamañoLlantas = scan.nextInt();
	llanta.cambiaTamaño(tamañoLlantas);
	scan.nextLine(); //limpar el scanner
	auto.precioFinal(marca, chasi, llanta, sistema); //Mostrar precio final hasta el momento
	System.out.println("Elija el material del Rin, con el numero correspondiente: 1-Aluminio (8,000mxn), 2-acero (3,000mxn)");
	material = scan.nextInt();
	llanta.cambiaMaterial(material);
	llanta.precioMaterial(material);
	auto.precioFinal(marca, chasi, llanta, sistema); //Mostrar precio final hasta el momento
	/*
	  Preguntar tipo de frenos, guardar el resultado y mostrar el precio total hasta el momento
	 */
	scan.nextLine(); //Limpiar scan
	System.out.println("Elija el tipo de frenos que desea, con el num asociado: 1-Disco(3,200mxn), 2-Tambor(2,100mxn)");
	frenos = scan.nextInt();
	llanta.cambiaFrenos(frenos);
	llanta.precioFrenos(frenos);
	auto.precioFinal(marca, chasi, llanta, sistema); //Mostrar precio final hasta el momento
	/*
	  Preguntar si desea pantalla digital, guardar el resultado y mostrar el precio, repetir lo mismo para
	  espejos, electricos, sensor de reversa, camara
	 */
	//Pantalla
	System.out.println("Gusta pantalla digital en lugar del radio? 1.Si (3,000mxn), 2.No");
	pantalla = scan.nextInt();
	sistema.cambiaPantalla(pantalla);
	sistema.precioPantalla(pantalla);
	auto.precioFinal(marca, chasi, llanta, sistema); //Mostrar precio final hasta el momento
	//Espejos
	System.out.println("Gusta añadir Espejos Electrónicos? 1.Si (5,000mxn), 2.NO");
	espejo = scan.nextInt();
	sistema.precioEspejo(espejo);
	sistema.cambiaEspejo(espejo);
	auto.precioFinal(marca, chasi, llanta, sistema); //Mostrar precio final hasta el momento
	//Camara
	System.out.println("Gusta añadir camara de reversa? 1.Si (7,000mxn), 2.No");
	camara = scan.nextInt();
	sistema.cambiaCamara(camara);
	sistema.precioCamara(camara);
	auto.precioFinal(marca, chasi, llanta, sistema); //Mostrar precio final hasta el momento
	//Sensor
	System.out.println("Gusta añadir sensor de reversa? 1.Si (4,000mxn), 2.No");
	sensor = scan.nextInt();
	sistema.cambiaSensor(sensor);
	sistema.precioSensor(sensor);
	auto.precioFinal(marca, chasi, llanta, sistema); //Mostrar precio final hasta el momento
	//Mostrar todo lo seleccionado por el usuario, junto con su precio
	System.out.println(marca);
	System.out.println(auto);
	System.out.println(chasi);
	System.out.println(llanta);
	System.out.println(sistema);
	auto.precioFinal(marca, chasi, llanta, sistema);

	System.out.println("Gusta comprarlo? 1-Si, 2-No");
	opc = scan.nextInt();
	if(opc == 1){
	    System.out.println("Agradecemos su compra");
	}else{
	    System.out.println("Esperamos que le gustará la página");
	}
    }//Fin del main
}//Fin del programa

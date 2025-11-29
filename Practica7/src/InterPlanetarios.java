import java.util.Date;
public class InterPlanetarios extends Vuelos implements InterfazDeSalud{
//Atributos
    private String planetaPartida;
    private String planetaOrigen;
    private String nombre;
    private String apellidoP;
    private int identificacion;
    public InterPlanetarios(String nombre, String apellidoP, int identificacion, String planetaPartida , String planetaOrigen) throws PlanetaInvalido{
	super(nombre,apellidoP, identificacion);
	boolean resultado = false;
	boolean resultado2 = false;
	String planetas[] = {"Mercurio", "Venus","Tierra","Marte", "Jupiter", "Saturno", "Urano", "Neptuno"};
	for(int i=0; i<planetas.length; i++){
	    if(planetaPartida.equalsIgnoreCase(planetas[i])){
		resultado = true;
		break;
	    }

	}//Fin del for
	for(int i=0; i<planetas.length; i++){
	    if(planetaOrigen.equalsIgnoreCase(planetas[i])){
		resultado2 = true;
		break;
	    }
	}//Fin del for
	if(!resultado){
	    throw new PlanetaInvalido("El planeta de partida no es parte del sistema solar");
	}
	if(!resultado2){
	    throw new PlanetaInvalido("El planeta de origen no es parte del sistema solar");
	}
	this.planetaPartida = planetaPartida;
	this.planetaOrigen = planetaOrigen;
    }

    //Asignadores
    public void cambiaPlanetaPartida(String planetaPartida){
	this.planetaPartida = planetaPartida;
    }
    public void cambiaPlanetaOrigen(String planetaOrigen){
	this.planetaOrigen = planetaOrigen;
    }
    //Observadores
    public String obtenPlanetaPartida(){
	return this.planetaPartida;
    }
    public String obtenPlanetaOrigen(){
	return this.planetaOrigen;
    }
     //Obtiene las posibles excepciones del destino como escribir mal y devuelve true en caso de que no alla problemas con el destino
    public boolean destino(String destino) throws DestinoInvalido{
        boolean resultado = false;
	String planetas[] = {"Mercurio", "Venus","Tierra","Marte", "Jupiter", "Saturno", "Urano", "Neptuno"};
	for(int i=0; i<planetas.length; i++){
	    if(destino.equalsIgnoreCase(planetas[i])){
		resultado = true;
		break;
	    }
	}
	if(destino.equals(obtenPlanetaPartida())) {
	    throw new DestinoInvalido("Esta tratando de viajar al mismo lugar del cual partes chispas");
	}
	return true;
    }
    //Obtiene las posibles excepciones de la fecha como que estes escribiendo antes de la fecha "actual", en caso de no alla problema regresa true
    public boolean fechaPartida(Date fecha) throws FechaInvalidaException{
	Date hoy = new Date(3050, 01, 01);
	if(!fecha.after(hoy)){
	    throw new FechaInvalidaException("La fecha ingresada tiene que ser mayor a la actual");
	    
	}
	return true;
	     
    }

       //Excepciones posibles del certificado, devuelve true si es apto para volar y su certificado tiene el vuelo estratosferico
    public boolean certificadoSaludValido(String numCertidicadoSalud) throws CertificadoSaludException{
	String[] cs = numCertidicadoSalud.split("-");
	boolean apto = false;
	boolean vuelo = false; 
	if( !cs[0].equals("CS")){
	    throw new CertificadoSaludException("Hay un error, no pusiste o pusiste mal el CS inicial"); 
	}
	if(cs.length <7){
	    throw new CertificadoSaludException("Faltan valores");
	}
	if(!cs[1].equals(nombre.toUpperCase())){
	    throw new CertificadoSaludException("Hay un error, en el nombre de usuario");   
	}
	if(!cs[2].equals(apellidoP.toUpperCase())){
	    throw new CertificadoSaludException("Hay un error, en el apellido del usuario");   
	}
	if(!cs[6].equals("A") && !cs[6].equals("NA")){
	    throw new CertificadoSaludException("No se puso correctamente si es apto o no");   
	}
	if(!cs[7].equals("E") && !cs[6].equals("P")){
	    throw new CertificadoSaludException("Hay un error, en el tipo de vuelo");   
	}
	if(cs[6].equals("A")){
	    apto = true;
	}
	if(cs[7].equals("P")){
	    vuelo = true;
	}
	if(apto && vuelo){
	    return true;
	}
	return false;
    }
    public boolean edad(int edad) throws EdadException{
	if(edad <1 || edad > 130){
	    throw new EdadException("O tienes 0 años o tienes mas de 130 lo cual no creo que sea muy valido");
	}
	if(edad <18){
	    return false;
	}
	if(edad >75){
	    return false;
	}
	return true;
    }

}

import java.util.Date;

public class Estratosfericos extends Vuelos implements InterfazDeSalud{
    String nombre;
    String apellidoP;
    String apellidoM;
    Date vencimientoIdentificacion;
    int identificacion;
    String pais;
    String nacionalidad;
    
    public Estratosfericos(String nombre, String apellidoP, int identificacion){
	super(nombre, apellidoP, identificacion);
	this.pais = "";
	this.nacionalidad = nacionalidad;
    }
        public void cambiaNacionalidad(String nacionalidad) throws NacionalidadInvalida{
	//Pais: Solos dos letras mayusculas
	if(nacionalidad.length() !=2 || !nacionalidad.equals(nacionalidad.toUpperCase())){
	    throw new NacionalidadInvalida("La nacionalidad no tiene la entrada correcta.");
	}
	this.nacionalidad = nacionalidad;
    }

    public void cambiaPaisOrigen(String pais) throws NacionalidadInvalida{
	if(pais.length() !=2 || !pais.equals(pais.toUpperCase())){
	    throw new NacionalidadInvalida("EL pais de origen no tiene el formato adecuado");
	}
	this.pais = pais;
    }

    //Observadores
    public String obtenacionalidad(){
	return this.nacionalidad;
    }
    public String  obtenPaisOrigen(){
	return this.pais;
    }



    
    //Obtiene las posibles excepciones del destino como escribir mal y devuelve true en caso de que no alla problemas con el destino
    public boolean destino(String destino) throws DestinoInvalido{
	if(destino.length() !=2 || !destino.equals(destino.toUpperCase())){
	    throw new DestinoInvalido("Escribio mal el destino, consta de solo 2 letras mayusculas");
	    
	}
	if(destino.equals(obtenPaisOrigen())) {
	    throw new DestinoInvalido("Esta tratando de viajar al mismo lugar del cual parte chispas");
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
	if(cs[7].equals("E")){
	    vuelo = true;
	}
	if(apto && vuelo){
	    return true;
	}
	return false;
    }
    //Regresa true en caso de que la edad es correcta y false en caso de no tener la edad para volar
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

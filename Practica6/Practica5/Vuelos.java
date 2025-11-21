
import java.util.Date;

public class Vuelos{
    //Atributos
    private String pais;
    private String nombre;
    private String apellidoP;
    private String apellidoM;
    private String nacionalidad;
    private Date vencimientoIdentificacion;
    private int numIdentificacion;
    private Date fechaViaje;
    //Objetos
    
    //Metodo constructor pidiento como parametros todo menos la nacionalidad y el materno
    public Vuelos(String nombre, String apellidoP, Date vencimientoIdentificacion,String nacionalidad ,int numIdentificacion) throws PaisInvalidoException, FechaInvalidaException, NacionalidadInvalida{
	Date hoy = new Date;
	//Hacer las excepciones necesarias para los datos
	//Pais: Solos dos letras mayusculas
	
	if(nacionalidad.length() != 2 || !nacionalidad.equals(nacionalidad.toUpperCase())){
	    throw new PaisInvalidoException("La escritura del pais es incorrecta, unicamente pueden ser dos letras mayusculas");
	}
	//Excepcion para la fecha actual
	if(vencimientoIdentificacion.before(hoy)){
	    throw new FechaInvalidaException("La fecha ingresada es menor a la fecha actual, favor de verificar.");
	}
	//Excepcion para la nacionalidad, solo permitir dos letras mayusculas
	if(nacionalidad.length() !=2 || !nacionalidad.equals(nacionalidad.toUpperCase())){
	    throw new NacionalidadInvalida("La nacionalidad no tiene la entrada correcta.");
	}
	this.nombre = nombre;
	this.apellidoP = apellidoP;
	this.apellidoM = "";
	this.vencimientoIdentificacion = vencimientoIdentificacion;
	this.nacionalidad = nacionalidad;
	this.numIdentificacion = numIdentificacion;
	
    }//Fin del constructor
    //Metodos asignadores
    public void cambiaNombre(String nombre){
	this.nombre = nombre;
    }
    public void cambiaApellidoP(String apellidoP){
	this.apellidoP = apellidoP;
    }
    public void cambiaApellidoM(String apellidoM){
	this.apellidoM = apellidoM;
    }
    public void cambiaFechaIdentificacion(Date vencimientoIdentificacion){
	this.vencimientoIdentificacion = vencimientoIdentificacion;
    }
    public void cambiaNacionalidad(String nacionalidad){
	this.nacionalidad = nacionalidad;
    }
    public void cambiaNumIdentificacion(int numIdentificacion){
	this.numIdentificacion = numIdentificacion;
    }
    //Metodos observadores
    public String obtenNombre(){
	return this.nombre;
    }
    public String cambiaApellidoP(){
	return this.apellidoP;
    }
    public String obtenApellidoM(){
	return this.apellidoM;
    }
    public Date obtenFechaIdentificacion(){
	return this.vencimientoIdentificacion;
    }
    public String obtenNacionalidad(){
	return this.nacionalidad;
    }
    public int obtenNumIdentificacion(){
	return this.numIdentificacion;
    }
    


}//Fin de la clase 

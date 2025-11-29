import java.util.Date;
public abstract class Vuelos{
    String nombre;
    String apellidoP;
    String apellidoM;
    Date vencimientoIdentificacion;
    int identificacion;
    //Constructor
    public Vuelos(String nombre, String apellidoP, int identificacion){
	this.nombre = nombre;
	this.apellidoP = apellidoP;
	this.apellidoM = "";
	this.vencimientoIdentificacion = null;
	this.identificacion = identificacion;

    }//Fin del constructor
    //Metodos asignadores
    public void cambiaNombre(String nombre) throws NombreInvalidoException{
	//Excepcion por si pones algun entero
	if (!nombre.matches("[A-Za-z]+")) {
	    throw new NombreInvalidoException("El nombre no puede tener números.");
	}
	this.nombre = nombre;
    }
    public void cambiaApellidoP(String apellidoP) throws NombreInvalidoException{
	//Misma excepcion de nombre
	if (!apellidoP.matches("[A-Za-z]+")) {
	    throw new NombreInvalidoException("El apellido paterno no puede tener números.");
	}
	this.apellidoP = apellidoP;
    }
    public void cambiaApellidoM(String apellidoM) throws NombreInvalidoException{
	//misma exepcion que nombre
	if (!apellidoM.matches("[A-Za-z]+")) {
	    throw new NombreInvalidoException("El apellido materno no puede tener números.");
	}
	this.apellidoM = apellidoM;
    }
    public void cambiaFechaIdentificacion(Date vencimientoIdentificacion) throws FechaInvalidaException{
	Date hoy = new Date();
	//Excepcion para la fecha actual
	if(vencimientoIdentificacion.before(hoy)){
	    throw new FechaInvalidaException("La fecha ingresada es menor a la fecha actual, favor de verificar.");
	}
	this.vencimientoIdentificacion = vencimientoIdentificacion;
    }
    public void cambiaNumIdentificacion(int numIdentificacion){
	this.identificacion = numIdentificacion;
    }

    //Metodos observadores
    public String obtenNombre(){
	return this.nombre;
    }
    public String obtenApellidoP(){
	return this.apellidoP;
    }
    public String obtenApellidoM(){
	return this.apellidoM;
    }
    public Date obtenFechaIdentificacion(){
	return this.vencimientoIdentificacion;
    }
    public int obtenNumIdentificacion(){
	return this.identificacion;
    }
    //Metodos abstractos
    abstract boolean destino(String destino) throws DestinoInvalido;

    abstract boolean fechaPartida(Date fecha) throws FechaInvalidaException;

}//fin de la clase abstract

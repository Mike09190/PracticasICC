
import java.util.Date;

public class Vuelos{
    //Atributos
    protected String nombre;
    protected String apellidoP;
    protected String apellidoM;
    private String nacionalidad;
    private Date vencimientoIdentificacion;
    private int numIdentificacion;
    private String pais;

    protected String destino;
    private Date fechaPartida;
    //Metodo constructor pidiento como parametros todo menos la nacionalidad y el materno
    public Vuelos() {
	this.nombre = "";
	this.apellidoP = "";
	this.apellidoM = "";
	this.vencimientoIdentificacion =null;
	this.nacionalidad = "";
	this.numIdentificacion = 0;
	this.pais = "";
	this.destino = "";
	this.fechaPartida = null;
	
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
    public void cambiaNumIdentificacion(int numIdentificacion){
	this.numIdentificacion = numIdentificacion;
    }

    public void cambiaFechaPartida(Date fechaPartida) throws FechaInvalidaException{
	Date hoy = new Date();
	if(!fechaPartida.after(hoy)){
	    throw new FechaInvalidaException("La fecha ingresada tiene que ser mayor a la actual");
	}
	this.fechaPartida = fechaPartida;
    }
    public void cambiaDestino(String destino) throws DestinoInvalido{
	if(destino.length() !=2 || !destino.equals(destino.toUpperCase())){
	    throw new DestinoInvalido("Destino invalido");
	}
	if(destino.equals(obtenPaisOrigen())) {
	    throw new DestinoInvalido("Detino invalido");
	}
	this.destino = destino;
    }
    public Date obtenFechaPartida() {
	return this.fechaPartida;
    }
    
    public String obtenDestino() {
	return this.destino;
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
    public String obtenNacionalidad(){
	return this.nacionalidad;
    }
    public int obtenNumIdentificacion(){
	return this.numIdentificacion;
    }
    public String obtenPaisOrigen(){
	return this.pais;
    }
    


}//Fin de la clase 

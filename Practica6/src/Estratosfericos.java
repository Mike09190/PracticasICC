import java.util.Date;

public class Estratosfericos extends Vuelos{
    private String numCertidicadoSalud;
    private int edad;
    private String destino;
    private Date fechaPartida;
    public Estratosfericos() {
	super();
	
	this.edad = 0;
	this.numCertidicadoSalud = numCertidicadoSalud;
	this.destino = destino;
	this.fechaPartida = null;
    }

    public void cambiaEdad(int edad) throws EdadException{
	if(edad <1 || edad > 130){
	    throw new EdadException("O tienes 0 años o tienes mas de 130 lo cual no creo que sea muy valido");
	}
	this.edad = edad;
    }
    public void cambiaNumCertificadoSalud(String numCertidicadoSalud) throws CertificadoSaludException{
	String[] cs = numCertidicadoSalud.split("-");
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
	this.numCertidicadoSalud = numCertidicadoSalud;
    }
    public int obtenEdad(){
	return this.edad;
    }
    public String obtenNumCertificadoSalud(){
	return this.numCertidicadoSalud;
    }

    //Sobre escritura
    @Override
    public void cambiaFechaPartida(Date fechaPartida) throws FechaInvalidaException{
	Date hoy = new Date();
	if(!fechaPartida.after(hoy)){
	    throw new FechaInvalidaException("La fecha ingresada tiene que ser mayor a la actual");
	}
	super.cambiaFechaPartida(fechaPartida);
    }
    @Override
    public void cambiaDestino(String destino) throws DestinoInvalido{
	if(destino.length() !=2 || !destino.equals(destino.toUpperCase())){
	    throw new DestinoInvalido("EL pais de destino no tiene el formato adecuado");
	}
	if(destino.equals(obtenPaisOrigen())) {
	    throw new DestinoInvalido("EL pais de destino no puede ser igual al de origen");
	}
	super.cambiaDestino(destino);
    }
    //Calculadores
    //Obtener un booleano donde inidque si es o no apto para volar
    public boolean verificarApto(){
	String[] apto = this.numCertidicadoSalud.split("-");
	return apto[6].equals("A");
	//Si es apto entonces devolvera true
    }
    public boolean tipoVueloEstra(){
	String[] vuelo = this.numCertidicadoSalud.split("-");
	return vuelo[7].equals("E");
    }
    public boolean tipoVueloInter(){
	String[] vuelo = this.numCertidicadoSalud.split("-");
	return vuelo[7].equals("E");
    }
    public boolean verificarEdad(){
	if(this.edad <18){
	    return true;
	}
	if(this.edad >75){
	    return true;
	}
	return false;
    }


}//Fin de la subclase

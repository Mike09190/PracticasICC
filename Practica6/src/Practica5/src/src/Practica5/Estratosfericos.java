public class Estratosfericos extends Vuelos{
    private String numCertidicadoSalud;
    private int edad;
    public class(String nombre, String apellidoP, Date vencimientoIdentificacion, String nacionalidad, int numIdentificacion, String numCertidicadoSalud) throws CertificadoSaludException{
	super(nombre, apellidoP, apellidoM, vencimientoIdentificacion, nacionalidad, numIdentificacion);
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
	
	this.edad = 0;
	this.numCertidicadoSalud = numCertidicadoSalud;
    }

    public void cambiaEdad(int edad){
	this.edad = edad;
    }
    public void cambiaNumCertificadoSalud(String numCertidicadoSalud){
	this.numCertidicadoSalud = numCertidicadoSalud;
    }
    public int obtenEdad(){
	return this.edad;
    }
    public String obtenNumCertificadoSalud(){
	return this.numCertidicadoSalud;
    }
    //Calculadores
    //Obtener un booleano donde inidque si es o no apto para volar
    public boolean verificarApto(){
	String[] apto = this.numCertidicadoSalud.split("-");
	return apto[6].equals("A");
	//Si es apto entonces devolvera true
    }
    public boolean verificarEdad(){
	if(this.edad <18){
	    return false;
	}
	if(this.edad >75){
	    return false;
	}
	return true;
    }


}//Fin de la subclase

import java.util.Date;

public class Internacional extends Vuelos{
    String nombre;
    String apellidoP;
    String apellidoM;
    Date vencimientoIdentificacion;
    int identificacion;
    
    String nacionalidad;
    String pais;
    
    public Internacional(String nombre, String apellidoP, int identificacion){
	super(nombre, apellidoP, identificacion);
	this.nacionalidad = "";
	this.pais = "";
    }//Fin del constructor
    //Asignadores
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
    //Calculadores
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


}//Fin de la clase

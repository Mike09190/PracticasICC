import java.util.Date;
public class VuelosInternacionales extends Vuelos{
    
    public VuelosInternacionales(){
	super();
    }
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
    

}

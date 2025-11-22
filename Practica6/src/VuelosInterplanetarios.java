import java.util.Date;

public class VuelosInterplanetarios extends Vuelos{
    //Atributos
    private String planetaPartida;
    private String planetaOrigen;

    public VuelosInterplanetarios(String planetaPartida , String planetaOrigen) throws PlanetaInvalido{
	super();
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

    //Hacer la sobreescritura
    @Override
    public void cambiaDestino(String destino) throws DestinoInvalido {
	if (destino.equalsIgnoreCase(this.planetaOrigen)) {
	    throw new DestinoInvalido("El planeta de destino no puede ser igual al de origen");
	}
	super.cambiaDestino(destino);
    }
    @Override
    public void cambiaFechaPartida(Date fechaPartida) throws FechaInvalidaException{
	Date hoy = new Date();
	if(!fechaPartida.after(hoy)){
	    throw new FechaInvalidaException("La fecha ingresada tiene que ser mayor a la actual");
	}
	super.cambiaFechaPartida(fechaPartida);
    }



}

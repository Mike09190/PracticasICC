public class Automovil{
    private String transmicion;
    private int tipoDeAuto;
    private int precioTransmicion, precioTipoAuto, precioAño;
    private int precioFinal;
    private int año;
    private MarcaAutomovil marca;
    private Llanta llanta;
    private SistemaElectronico electrico;
    //private Chasis chasi;
    public Automovil(){
	this.transmicion = "";
	this.tipoDeAuto = 0;
	this.año = 0;
    }
    public void cambiaTransmicion(String transmicion){
	this.transmicion = transmicion;
    }
    public void cambiaTipoAuto(int tipoDeAuto){
	this.tipoDeAuto = tipoDeAuto;
    }
    /*public void cambiaPrecio(int precio){
	this.precio = precio;
	}*/
    public void cambiaAño(int año){
	this.año = año;
    }
    public String obtenTransmicion(){
	return this.transmicion;
    }
    public int obtenTipoAuto(){
	return this.tipoDeAuto;
    }
    /*public int obtenPrecio(){
	return this.precio;
	}*/
    public int obtenAño(){
	return this.año;
    }
    public void precioTransmicion(String transmicion){
	transmicion = transmicion.toUpperCase();
	if(transmicion.equals("AUTOMATICA")){
	    precioTransmicion += 80000;
	}else if(transmicion.equals("MANUAL")){
	    precioTransmicion += 40000;
	}else{
	    System.out.print("No se encontro la opcion");
	}	
    }
    public void precioTipoAuto(int tipoDeAuto){
	switch(tipoDeAuto){
	case 1:
	    precioTipoAuto +=40000;
	    break;
	case 2:
	    precioTipoAuto += 80000;
	    break;
	case 3:
	    precioTipoAuto +=120000;
	    break;			
	case 4:
	    precioTipoAuto +=200000;
	default:
	    return;
	}
    }
    public void precioAño(int año){
	switch(año){
	case 2023:
	    precioAño +=30000;
	    break;
	case 2024:
	    precioAño +=40000;
	    break;
	case 2025:
	    precioAño +=50000;
	    break;
	default:
	    System.out.print("No tenemos un auto de ese año");
	    break;
	}
    }
    public String nombretipoDeAuto(){
	int tipodeAuto = tipoDeAuto;
	if(tipodeAuto == 1){
	    return "Compacto";
	}else if(tipodeAuto == 2){
	    return "SemiCompacto";
	}else if(tipodeAuto == 3){
	    return "Sedán";
	}else if(tipodeAuto == 4){
	    return "Deportivo";
	}else{
	    return "No identificado";
	}
    }
    
    public void precioFinal(MarcaAutomovil marca, Chasis chasi, Llanta llanta, SistemaElectronico electrico){
	double precioCombinado = precioAño + precioTransmicion + precioTipoAuto;
	double precio = precioCombinado + marca.obtenPrecio() + chasi.precioChasis()+ llanta.precioTotal() + electrico.precioTotal();;
	System.out.println("El total hasta el momento es: " + precio);
    }
    public String toString(){
	return "\nTransmicion: " + transmicion + "  -- Precio de Transmicion: " + precioTransmicion + "\nTipo de Auto: " + nombretipoDeAuto() + "  -- Precio del tipo de Auto: " + precioTipoAuto + "\nAño del auto: " +año+ "  -- Precio del año: " +precioAño; 

    }
}//Fin de la clase

public class Chasis{
    private String color;
    private String acabado;
    private int precio;
    private int precioAcabado, precioVidrios;
    private String ventana;

    //Constructor
    public Chasis(){
	this.color = "";
	this.acabado = "";
	this.precio = 0;
	this.ventana = "No";
    }
    //Metodos de asignacion
    public void cambiaColor(String color){
	this.color = color;
    }
    public void cambiaAcabado(String acabado){
	this.acabado = acabado;
    }
    public void cambiaPrecio(int precio){
	this.precio = precio;
    }
    public void cambiaVentanas(String ventana){
	this.ventana = ventana;
    }
    //Métodos de obtencion
    public String obtenColor(){
	return this.color;
    }
    public String obtenAcabado(){
	return this.acabado;
    }
    public int obtenPrecio(){
	return this.precio;
    }
    public String obtenVentana(){
	return this.ventana;
    }
    public void precioAcabado(){
	acabado = acabado.toUpperCase();
	switch(acabado){
	case "MATE":
	    precioAcabado +=0;
	    break;
	case "BRILLANTE":
	    precioAcabado +=10000;
	    break;
	case "METALICO":
	    precioAcabado +=15000;
	    break;
	default:
	    System.out.println("Error");
	    break;
	}
    }//Fin del metodo
    public void precioVidrios(String ventana){
	ventana = ventana.toUpperCase();
	if(ventana.equals("SI")){
	    precioVidrios +=4000;
	}else if(ventana.equals("NO")){
	    precioVidrios +=0;
	}else{
	    return;
	}
	    
    }//Fin del metodo
    public double precioChasis(){
	return precio = precioAcabado + precioVidrios;
    }

	public String toString() {
	    return "\nColor: "+ color + "\nAcabado: " +acabado + "  -- Precio Acabado: " +precioAcabado + "\nVentanas Anti-Asalto: "+ ventana + "  -- Precio Ventanas: " + precioVidrios;
}



}//Fin de la clase

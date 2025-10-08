public class Llanta{
    private String marca;
    private int tamaño, material, precio, frenos;
    private int precioMarca, precioMaterial, precioFrenos;

    public Llanta(){
	this.marca = "";
	this.tamaño = 0;
	this.material = 0;
	this.precio = 0;
	this.frenos = 0;
    }
    //Metodos asignacion
    public void cambiaMarca(String marca){
	this.marca = marca;
    }
    public void cambiaTamaño(int tamaño){
	this.tamaño = tamaño;
    }
    public void cambiaMaterial(int material){
	this.material = material;
    }
    public void cambiaPrecio(int precio){
	this.precio = precio;
    }
    public void cambiaFrenos(int frenos){
	this.frenos = frenos;
    }
    //Métodos de obtencion
    public String obtenMarca(){
	return this.marca;
    }
    public int obtenTamaño(){
	return this.tamaño;
    }
    public int obtenMaterial(){
	return this.material;
    }
    public int obtenPrecio(){
	return this.precio;
    }
    public int obtenFrenos(){
	return this.frenos;
    }
    public void precioLlantas(String marca){
	marca = marca.toUpperCase();
	switch(marca){
	case "YOKOHAMA":
	    precioMarca +=5000;
	    break;
	case "FIRESTONE":
	    precioMarca +=8000;
	    break;
	case "PIRELLI":
	    precioMarca +=6500;
	    break;
	case "GOODYEAR":
	    precioMarca +=6000;
	    break;
	case "MICHELIN":
	    precioMarca +=10000;
	    break;
	default:
	    System.out.println("Error");
	    break;
	}//Fin del switch
    }//Fin del metodo
    public void precioMaterial(int material){
	if(material == 1){
	    precioMaterial +=8000;
	}else if(material == 2){
	    precioMaterial +=3000;
	}else{
	    return;
	}
    }//Fin del metodo
    public void precioFrenos(int frenos){
	switch(frenos){
	case 1:
	    precioFrenos +=3200;
	    break;
	case 2:
	    precioFrenos +=2100;
	    break;
	default:
	    break;
	}//Fin del switch
    }//Fin del metodo

    public String nombreMaterial(){
	int mat = material;
	if(mat == 1){
	    return "Aluminio";
	}else if(mat == 2){
	    return "Acero";
	}else{
	    return "Error";
	}
    }
    public String nombreFrenos(){
	int freno = frenos;
	if(material == 1){
	    return "Disco";
	}else if(material == 2){
	    return "Tambor";
	}else{
	    return "Error";
	}
    }//Fin del metodo
    public double precioTotal(){
	return precio = precioMarca + precioMaterial + precioFrenos;
    }
    public String toString(){
	return "\nMarca de las llantas es: " + marca + "  -- El precio de la marca es: " + precioMarca + "\nTamaño del rin es: " + tamaño + "\nel material es:  " + nombreMaterial() + "  -- El precio del material es: " + precioMaterial + "\nlos frenos son: "  + nombreFrenos() + "  -- El precio de los frenos es: " + precioFrenos;
    }
}//Fin de la clase

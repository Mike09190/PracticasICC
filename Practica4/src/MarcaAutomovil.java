 public class MarcaAutomovil{
    private String marca;
    private int lugar;
    private int precio;
     public MarcaAutomovil(){
	this.marca = "";
	this.lugar = 0;
	this.precio = 0;
    }
    public void cambiaMarca(String marca){
	this.marca = marca;
    }
    public String obtenMarca(){
	return this.marca;
    }
    public void cambiaLugar(int lugar){
	this.lugar = lugar;
    }
    public int obtenLugar(){
	return this.lugar;
    }
     public void cambiaPrecio(int precio){
	 this.precio = precio;
     }
     public double obtenPrecio(){
	 return this.precio;
     }
     public void listaLugares(String marca){
	 marca = marca.toUpperCase();
	 if(marca.equals("HONDA")){
	     System.out.println("1-México - 25,000MXN,2-Japón - 105,000MXN,3-India - 55,000mxn");
	 }else if(marca.equals("BYD")){
	     System.out.println("1-China - 30,000MXN");
	 }else if(marca.equals("WOLSWAGEN")){
	     System.out.println("1-México - 15,000MXN, 2-Alemania - 80,000MXN, 3-China - 32,000MXN, 4-Brasil - 42,000MXN");
	 }else if(marca.equals("TOYOTA")){
	     System.out.println("1-México - 20,000MXN, 2-Estados Unidos - 40,000MXN, 3-Brasil - 40,000MXN, 4-Francia - 90,000MXN");
	 }else if(marca.equals("NISSAN")){
	     System.out.println("1-Japón - 100,000MXN, 2-México - 18,000MXN");
	 }else{
	     System.out.println("No tenemos ninguna marca asociada a ese nombre");
	     return;
	 }
     }
     public void guardarPrecio(){
	 marca = marca.toUpperCase();
	 if(marca.equals("HONDA")){
	     switch(lugar){
	     case 1:
		 precio = 25000;
		 break;
	     case 2:
		 precio = 105000;
		 break;
	     case 3:
		 precio = 55000;
		 break;
	     default:
		 break;
	     }
	 }else if(marca.equals("BYD")){
	     switch(lugar){
	     case 1:
		 precio = 30000;
		 break;
	     default:
		 break;
	     }
	 }else if(marca.equals("WOLSWAGEN")){
	     switch(lugar){
	     case 1:
		 precio = 15000;
		 break;
	     case 2:
		 precio = 80000;
		 break;
	     case 3:
		 precio = 32000;
		 break;
	     case 4:
		 precio = 42000;
		 break;
	     default:
		 break;
	     }
	 }else if(marca.equals("TOYOTA")){
	     switch(lugar){
	     case 1:
		 precio = 20000;
		 break;
	     case 2:
		 precio = 40000;
		 break;
	     case 3:
		 precio = 40000;
		 break;
	     case 4:
		 precio = 90000;
		 break;
	     default:
		 break;
	     }
	 }else if(marca.equals("NISSAN")){
	      switch(lugar){
	     case 1:
		 precio = 100000;
		 break;
	     case 2:
		 precio = 18000;
		 break;
	     default:
		 break;
	     }
	 }
     }//Fin del metodo
     public String nombreLugar() {
	 String m = marca.toUpperCase();
	 switch (m) {
	 case "HONDA":
            switch (lugar) {
                case 1:
		    return "México";
                case 2:
		    return "Japón";
                case 3:
		    return "India";
            }
            break;
        case "BYD":
            if (lugar == 1){
		return "China";
	    }
            break;
        case "WOLSWAGEN":
            switch (lugar) {
                case 1:
		    return "México";
                case 2:
		    return "Alemania";
                case 3:
		    return "China";
                case 4:
		    return "Brasil";
            }
            break;
        case "TOYOTA":
            switch (lugar) {
                case 1:
		    return "México";
                case 2:
		    return "Estados Unidos";
                case 3:
		    return "Brasil";
                case 4:
		    return "Francia";
            }
            break;
    case "NISSAN":
	switch (lugar) {
	case 1:
	    return "Japón";
	case 2:
	    return "México";
        }
	break;
    }
    return "Desconocido";
}

     public String toString(){
	 return "\nMarca del coche: " + marca + "\nLugar de Fabricacion: " + nombreLugar() + "\nPrecio: " + precio;
     }

}//Fin de la clase

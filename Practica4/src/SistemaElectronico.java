public class SistemaElectronico{
    private int pantalla, espejo, sensor, camara, precio;
    private int precioPantalla, precioEspejo, precioSensor, precioCamara;

    public SistemaElectronico(){
	this.pantalla = 2;
	this.espejo = 2;
	this.sensor = 2;
	this.camara = 2;
	this.precio = 0;
    }
    public void cambiaPantalla(int pantalla ){
	this.pantalla = pantalla;
    }
    public void cambiaEspejo(int espejo){
	this.espejo = espejo;
    }
    public void cambiaSensor(int sensor){
	this.sensor = sensor;
    }
    public void cambiaCamara(int camara){
	this.camara = camara;
    }
    public void cambiaPrecio(int precio){
	this.precio = precio;
    }
    //metodos de obtencion
    public int obtenPantalla(){
	return this.pantalla;
    }
    public int obtenEspejo(){
	return this.espejo;
    }
    public int obtenSensor(){
	return this.sensor;
    }
    public int obtenCamara(){
	return this.camara;
    }
    public int obtenPrecio(){
	return this.precio;
    }
    public void precioPantalla(int pantalla){
	if(pantalla == 1){
	    precioPantalla +=3000;
	}else{
	    precioPantalla +=0;
	}
    }//Fin del metodo
    public void precioEspejo(int espejo){
	if(espejo == 1){
	    precioEspejo +=5000;
	}else{
	    precioEspejo +=0;
	}
    }//Fin del metodo
    public void precioCamara(int camara){
	if(camara == 1){
	    precioEspejo +=7000;
	}else{
	    precioEspejo +=0;
	}
    }//Fin del metodo
    public void precioSensor(int sensor){
	if(sensor == 1){
	    precioSensor +=4000;
	}else{
	    precioSensor +=0;
	}
    }//Fin del metodo

    public String nombrePantalla(){
	int pan = pantalla;
	if(pan == 1){
	    return "Pantalla Dgital";
	}else if(pan == 2){
	    return "Radio";
	}else{
	    return "Error";
	}
    }//Fin del metodo
    public String nombreEspejo(){
	int esp = espejo;
	if(esp == 1){
	    return "Espejos Electronicos";
	}else if(esp == 2){
	    return "Normal";
	}
	else{
	    return "Error";
	}
    }//Fin del metodo
    public String nombreSensor(){
	int sen = sensor;
	if(sen == 1){
	    return "Reversa";
	}else if(sen == 2){
	    return "Normal";
	}else{
	    return "Error";
	}
    }//Fin del metodo
    public String nombreCamara(){
	int cam = camara;
	if(cam == 1){
	    return "Camara reversa";
	}else if(cam == 2){
	    return "No";
	}else{
	    return "Error";
	}
    }
    public double precioTotal(){
	return precio = precioPantalla + precioEspejo + precioSensor + precioCamara;
    }//fin del metodo
    public String toString(){
	return "\nLa pantalla es: " + nombrePantalla() + "  -- Su precio es: " + precioPantalla + "\nEl espejo es: "+ nombreEspejo() + "  -- Su precio es de: " + precioEspejo + "\nEl sensor es de:" +nombreSensor() +"  -- Su precio es de: " +precioSensor + "\nLa camara es: "+ nombreCamara() + "  -- Su precio es de: "+ precioCamara;

    }





}//Fin de la clase

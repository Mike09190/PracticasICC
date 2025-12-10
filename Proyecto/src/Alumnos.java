import java.util.Random;

public class Alumnos{
    //Atributos
    private String nombre;
    private int edad;
    private String escuela;
    private String identificador;
    private int numCursos;

    public Alumnos(String nombre, int edad, String escuela) throws NombreInvalidoException, EdadException, EscuelaException{
	if (!nombre.matches("[A-Za-z]+")) {
	    throw new NombreInvalidoException("El nombre no puede tener números.");
	}
	if(edad < 0){
	    throw new EdadException("Como vas a tener menos que 0 años y quieres ingresar a un curso?");
	}else if(edad >100){
	    throw new EdadException("Ya estas en otros años para eso de tomar clases");
	}
	this.nombre = nombre;
	this.edad = edad;
	this.escuela = escuela;
	Random random = new Random();
	int idNumerico = random.nextInt(99999 - 10000 + 1) + 10000;
        
        // Convertir el número a String
        String nuevoID = String.valueOf(idNumerico);
	this.identificador = nuevoID;
	this.numCursos= 0;
    }//Fin del constructor
    public String obtenNombre() {
	return nombre;
    }

    public void cambiaNombre(String nombre) {
	this.nombre = nombre;
    }

    public int obtenEdad() {
	return edad;
    }

    public void cambiaEdad(int edad) {
	this.edad = edad;
    }
    
    public String obtenEscuela() {
	return escuela;
    }

    public void cambiaEscuela(String escuela) {
	this.escuela = escuela;
    }

    public String obtenIdentificador() {
	return identificador;
    }
    
    public void cambiaIdentificador(String identificador) {
	this.identificador = identificador;
    }
    public void nuevoCurso(int curso){
	this.numCursos +=curso;
    }
    public int numCursosActivos(){
	return this.numCursos; 
    }

    @Override
    public String toString() {
	return "nombre: " + nombre +
	    "\nedad: " + edad +
	    "\nescuela: " + escuela +
	    "\nidentificador: " + identificador +
	    "\nnumCursos: " + numCursos;
    }




}//Fin de la clase

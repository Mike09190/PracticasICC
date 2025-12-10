import java.util.Random;
import java.util.Scanner;

public class Alumnos{
    //Atributos
    private String nombre;
    private int edad;
    private String escuela;
    private String identificador;
    private int numCursos;
    private Scanner scan = new Scanner(System.in);

    public Alumnos(){
	this.nombre = "";
	this.edad = 0;
	this.escuela = "";
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

    public void cambiaNombre(String nombre) throws NombreInvalidoException{
	if (!nombre.matches("[A-Za-z]+")) {
	    throw new NombreInvalidoException("El nombre no puede tener números.");
	}
	this.nombre = nombre;
    }

    public int obtenEdad() {
	return edad;
    }

    public void cambiaEdad(int edad) throws EdadException{
	if(edad < 0){
	    throw new EdadException("Como vas a tener menos que 0 años y quieres ingresar a un curso?");
	}else if(edad >100){
	    throw new EdadException("Ya estas en otros años para eso de tomar clases");
	}
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
    public void editarAlumno() throws NombreInvalidoException, EdadException{
	boolean continuar = false;
	do{
	    System.out.println("Nuevo nombre: ");
	    String nombre = scan.nextLine();
	    cambiaNombre(nombre);
	    
	    System.out.println("Nueva edad: ");
	    int edad = scan.nextInt();
	    scan.nextLine();
	    cambiaEdad(edad);
	    
	    System.out.println("Escuela de procedencia: ");
	    String escuela = scan.nextLine();
	    cambiaEscuela(escuela);
	    continuar = true;
	}while(!continuar);
	    System.out.println("Datos actualizados con exito");
	    System.out.println("Su identificador es: "+obtenIdentificador());
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

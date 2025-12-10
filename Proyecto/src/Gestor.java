import java.util.List;
import java.util.ArrayList;
import java.util.Date;
import java.io.Serializable;
public class Gestor implements Serializable{
    //Listas con los 3 tipos de datos necesarios
    private List<Cursos> cursosActivos;
    private List<Profesores> profesores;
    private List<Alumnos> alumnos;
    //Persistencia
    private String archivo = "ProyectoFinal.ser";
    public Gestor(){
	this.cursosActivos = new ArrayList<>();
	this.profesores = new ArrayList<>();
	this.alumnos = new ArrayList<>();
    }

// Clase GestorCursos

    public  Gestor cargarDatos() {
	Gestor gestor = null;
	

	try (java.io.FileInputStream fileIn = new java.io.FileInputStream(archivo);
	     java.io.ObjectInputStream in = new java.io.ObjectInputStream(fileIn)) {
        
        gestor = (Gestor) in.readObject(); 
        
	} catch (java.io.FileNotFoundException f) {
	    // El archivo no existe: se crea un gestor nuevo
	    gestor = new Gestor();
	} catch (java.io.IOException | ClassNotFoundException i) {
	    // Error de lectura/serialización: se crea un gestor nuevo por seguridad
	    i.printStackTrace();
	    gestor = new Gestor(); 
    }
    
	return gestor;
}

    public void guardarDatos() {
	final String NOMBRE_ARCHIVO = "datos_gestor.ser";
	
	try (java.io.FileOutputStream fileOut = new java.io.FileOutputStream(archivo);
	     java.io.ObjectOutputStream out = new java.io.ObjectOutputStream(fileOut)) {
	    
	    out.writeObject(this); 
        
	} catch (java.io.IOException i) {
	    System.err.println("Error al guardar datos: " + i.getMessage());
	}
    }
   
    public void agregarCurso(Cursos curso) {
	cursosActivos.add(curso);
    }
    public void agregarProfesor(Profesores profesor){
	profesores.add(profesor);
    }
    public void agregarAlumnos(Alumnos alumno){
	alumnos.add(alumno);
    }
    /**
       Regresar curso, este se encarga de la lista de objetos cursos regresas uno especifico basados en su id
     */
    public Cursos regresarCurso(String identificador) {
	for (Cursos c : cursosActivos) { //Buscar si existe ese profesor o num de identificacion
	    if (c.obtenIdentificador().equals(identificador)) {
		return c;
	    }
	}
	return null;
    }
    /*
      Regresar profesores, de la lista de obj profesores regresar especifico mediante su id
    */
    public Profesores regresarProfesor(String identificador){
	for(Profesores p : profesores){
	    if(p.obtenIdentificador().equals(identificador)){
		return p;
	    }
	}
	return null;
    }
    //regresarAlumnos, metodo que obtiene de la lista de alumnos un alumno en especifico
    public Alumnos regresarAlumnos(String identificador){
	for(Alumnos a : alumnos){
	    if(a.obtenIdentificador().equals(identificador)){
		return a;
	    }
	}
	return null;

    }
    /**
       @param eleminarProfesor, aqui se guarda el profesor asociado al identificador dado por el usuario
       Busca en un primer for si existe un profesor asosciado en caso de encontrarlo guardar en la var
       en la primera condicion en caso de no encontrar nada regresa una excepcion
       en el segundo for busca si ese profesor esta asociado a un curso, caso afirmativo manda que no se puede eliminar
       en caso contrario borra de la lista de profesores.
     */
    public void eliminarProfesor(String identificador) throws EliminarException{
	Profesores eliminarProfesor = regresarProfesor(identificador);
	
	if(eliminarProfesor == null){
	    throw new EliminarException("No se encontro ningun profesor con dicho ID");
	}
	
	for(Cursos c: cursosActivos){
	    if (c.obtenProfesor() != null && c.obtenProfesor().equals(eliminarProfesor)) {
            
		// Verificación de Actividad (Curso ACTIVO: fecha de fin futura)
		if (c.obtenFin().after(new Date())) {
		    throw new EliminarException("El profesor no se puede eliminar, dado que esta dando el curso activo: " + c.obtenNombre());
		}
		throw new EliminarException("El profesor esta impartiendo un curso, no se puede eliminar");
	    }
	}//Fin del for
	System.out.println("Se ha eliminado con exito");
	profesores.remove(eliminarProfesor);
	
    }//fin del metodo

    /**
       @param eliminarAlumno se guarda el obj alumno con el identificador asociado
       en el condicial en caso de que no se encontro obj asociado regresar expcecion
       BUscar en cursos en su lista si el alumno existe, en caso de que si no eliminar
       verificar si el curso no ha finalizado

     */
    public void eliminarAlumno(String identificador) throws EliminarException{
	Alumnos eliminarAlumno = regresarAlumnos(identificador);
	
	if(eliminarAlumno == null){
	    throw new EliminarException("No se encontro ningun alumno con dicho ID");
	}
	
	for(Cursos c: cursosActivos){
	    if (c.obtenAlumnos() != null && c.obtenAlumnos().contains(eliminarAlumno)) {
		// Verificación de Actividad (Curso ACTIVO: fecha de fin futura)
		if (c.obtenFin().after(new Date())) {
		    throw new EliminarException("El alumno no se puede eliminar, dado que esta dando el curso activo: " + c.obtenNombre());
		}
		throw new EliminarException("El alumno esta dado de alta en un curso, no se puede eliminar");
	    }
	}//Fin del for
	System.out.println("Se ha eliminado con exito");
	alumnos.remove(eliminarAlumno);
    }//Fin del metodo
    public boolean encontrarCurso(String identificador){
	for(Cursos c: cursosActivos){
	    if(c.obtenIdentificador().equals(identificador)){
		return c.editarCurso();
	    }
	}
	return false;
    }

    public void eliminarCurso(String identificador) throws EliminarException{
	Cursos eliminarCurso = regresarCurso(identificador);
	if(eliminarCurso == null){
	    throw new EliminarException("No se encontro ningun curso con dicho ID");
	}
	if(!eliminarCurso.obtenFin().before(new Date()) || eliminarCurso.obtenAlumnos().size() == 0){
	    throw new EliminarException("No se puede eliminar el curso, porque tiene mas de un estudiante o aun no termina");
	}
	System.out.println("Se ha eliminado con exito");
	cursosActivos.remove(eliminarCurso); 
    }
    public void verCursos(){
	for(Cursos c: cursosActivos){
	    System.out.println(c.toString());
	    System.out.println();
	}
    }
    public void verAlumnos(String identificador) throws EliminarException{
        Cursos cursoEncontrado = regresarCurso(identificador);
	
	if(cursoEncontrado == null){
	    throw new EliminarException("No se encontro ningun curso con dicho ID");
	}
	List<Alumnos> alumnos = cursoEncontrado.obtenAlumnos();
	
	if (alumnos.isEmpty()) {
	    System.out.println("El curso no tiene alumnos inscritos.");
	    return;
	}
	
	for (Alumnos a : alumnos) {
	    System.out.println(a.toString());
	    System.out.println();
	}
    }
}//FIn de la clase

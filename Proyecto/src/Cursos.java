import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;
public class Cursos{
    //Atributos
    private String nombre;
    private String categoria;
    private String nivel;
    private String plataforma;
    private String descripcion;
    private int hora;
    private Date fechaInscripcion;
    private Date inicio;
    private Date fin;
    private int numEstudiantes;
    private String identificador;


    private Profesores profesor;
    private List<Alumnos> alumnosInscritos; //Lista de los alumnos
    //Constructor
    /*
      Constructor con todas las posibles excepciones, como el pasar datos incorrectos
      @param categorias, arreglo de las posibles opciones
      @param niveles, arreglo con los posibles niveles de estudios
      @param resultado1,2,3 opc booleanas para las iteraciones de los for para las categorias, niveles y plataformas
      @param fechaActual obj con la fecha actual
     */
    public Cursos(String nombre, String categoria, String nivel,int hora, String plataforma,int numEstudiantes, String descripcion, Date fechaInscripcion, Date inicio, Date fin)throws NombreInvalidoException, CategoriaException, NivelException, HoraException, PlataformaException{
	String niveles[] = {"preparatoria", "licenciatura", "posgrado"};
	boolean resultado = false, resultado2 = false, resultado3 = false;
	String plataformas[] ={"meet", "zoom", "jitsi", "Skype"};

	Date fechaActual = new Date();
	if (!nombre.matches("[A-Za-z]+")) {
	    throw new NombreInvalidoException("El nombre no puede tener números.");
	}
	//Verifcacion para la categoria

	for(int i=0; i<niveles.length; i++){
	    if(nivel.equalsIgnoreCase(niveles[i])){
		resultado2 = true;
		break;
	    }
	}//Fin del for
	for(int i=0; i<plataformas.length; i++){
	    if(plataforma.equalsIgnoreCase(plataformas[i])){
		resultado3 = true;
		break;
	    }
	}//Fin del for
	if(!resultado3){
	    throw new PlataformaException("La categoria ingresada con coincide con las opc");
	}
	if(!resultado2){
	    throw new NivelException("El nivel ingresado no coincide con las opc dadas");
	}
	
	if(hora< 7 || hora> 21){
	    throw new HoraException("Esta ingresando una hora fuera de lo establecido, tiene que ser entre 7am y 9pm");
	}
	if(fechaInscripcion.before(fechaActual)){
	    throw new HoraException("la fecha de inscripcion no puede ser antes que la fecha actual");
	}
	if(inicio.before(fechaActual)){
	    throw new HoraException("La fecha de inicio del curso no puede ser antes que la fecha actual");
	}else if(inicio.before(fechaInscripcion)){
	    throw new HoraException("La fecha de inicio no puede ser antes que la fecha de inscripcion");
	}
	if(fin.before(fechaActual)){
	    throw new HoraException("La fecha de termino no puede ser menor que la fecha actual");
	}else if(fin.before(inicio)){
	    throw new HoraException("La fecha de termino no puede ser menor que la fecha de inicio");
	}
	this.nombre = nombre;
	this.categoria = categoria;
	this.nivel = nivel;
	this.hora = hora;
	this.plataforma = plataforma;
	this.numEstudiantes = numEstudiantes;
	this.descripcion = descripcion;
	this.fechaInscripcion = fechaInscripcion;
	this.inicio = inicio;
	this.fin = fin;

	Random random = new Random();
	int idNumerico = random.nextInt(99999 - 10000 + 1) + 10000;
        
        // Convertir el número a String
        String nuevoID = String.valueOf(idNumerico);
	this.identificador =nuevoID;
	this.profesor = null;

	this.alumnosInscritos = new ArrayList<>();
	    
    }//Fin del constructor
    public String obtenNombre() {
	return nombre;
    }
    
    public void cambiaNombre(String nombre) {
	this.nombre = nombre;
    }
    
    public String obtenCategoria() {
	return categoria;
    }
    
    public void cambiaCategoria(String categoria) {
	this.categoria = categoria;
    }

    public String obtenNivel() {
    return nivel;
    }
    
    public void cambiaNivel(String nivel) {
	this.nivel = nivel;
    }
    
    public String obtenPlataforma() {
	return plataforma;
    }

    public void cambiaPlataforma(String plataforma) {
	this.plataforma = plataforma;
    }
    
    public String obtenDescripcion() {
	return descripcion;
    }
    
    public void cambiaDescripcion(String descripcion) {
	this.descripcion = descripcion;
    }
    
    public int obtenHora() {
	return hora;
    }
    
    public void cambiaHora(int hora) {
	this.hora = hora;
    }

    public Date obtenFechaInscripcion() {
	return fechaInscripcion;
    }
    
    public void cambiaFechaInscripcion(Date fechaInscripcion) {
	this.fechaInscripcion = fechaInscripcion;
    }
    
    public Date obtenInicio() {
	return inicio;
    }
    
    public void cambiaInicio(Date inicio) {
	this.inicio = inicio;
    }
    
    public Date obtenFin() {
	return fin;
    }
    
    public void cambiaFin(Date fin) {
	this.fin = fin;
    }
    
    public int obtenNumEstudiantes() {
	return numEstudiantes;
    }
    public Profesores obtenProfesor(){
	return this.profesor;
    }
    public void cambiaProfesor(Profesores profesor){
	this.profesor = profesor;
    }
    
    public void cambiaNumEstudiantes(int numEstudiantes) {
	this.numEstudiantes = numEstudiantes;
    }
    
    public String obtenIdentificador() {
	return identificador;
    }

    public void cambiaIdentificador(String identificador) {
	this.identificador = identificador;
    }

    public List<Alumnos> obtenAlumnos() {
        return alumnosInscritos;
    }
    //Asignar maestro
    public void asignarProfesor(Profesores profesor)throws AsignacionException{
	if(!profesor.obtenNivel().equals(this.nivel)){
	    throw new AsignacionException("El profesor no tiene el nivel para dar este curso");
	}
	if(!profesor.obtenCategoria().equals(this.categoria)){
	    throw new AsignacionException("El profesor no imparte esta categoria");
	}
	if(this.inicio.before(new Date())){
	    throw new AsignacionException("El curso ya ha iniciado");
	}
	if(this.profesor != null){
	    throw new AsignacionException("El grupo ya tiene un profesor asignado");
	}
	this.profesor = profesor;
    }
    public void reasignarProfesor(Profesores Profesor) throws ReasignacionException{
	if(!profesor.obtenNivel().equals(this.nivel)){
	    throw new ReasignacionException("El profesor no tiene el nivel para dar este curso");
	}
	if(!profesor.obtenCategoria().equals(this.categoria)){
	    throw new ReasignacionException("El profesor no imparte esta categoria");
	}
	if(this.fin.after(new Date())){
	    throw new ReasignacionException("EL curso ya ha terminado");
	}
	if(this.profesor == null){
	    throw new ReasignacionException("El grupo no tiene ningun profesor");
	}
	this.profesor = profesor;
    }

    public void inscribirAlumno(Alumnos alumno) throws InscripcionInvalidaException {
	Date hoy = new Date();
	
	// Validar que la fecha de inscripción esté abierta
	if (hoy.before(this.fechaInscripcion) || hoy.after(this.obtenInicio())) {
	    throw new InscripcionInvalidaException("La fecha de inscripción está cerrada para este curso.");
	}
	
	// Validar que el alumno no esté ya inscrito en el curso
	if (this.alumnosInscritos.contains(alumno)) {
	    throw new InscripcionInvalidaException("El alumno ya se encuentra inscrito en este curso.");
	}

	// Validar que el alumno no tenga más de 6 materias inscritas
	if (alumno.numCursosActivos() >= 6) {
	    throw new InscripcionInvalidaException("El alumno ya tiene el máximo (6) de materias inscritas que están en curso.");
	}
	this.alumnosInscritos.add(alumno); // Agrega el alumno a la lista del curso.
    }
    public void quitarAlumno(Alumnos alumno) throws EliminarException{
	if(this.fin.before(new Date())){
	    throw new EliminarException("EL curso ya ha concluido");
	}
	if(alumnosInscritos.contains(alumno)){
	    alumnosInscritos.remove(alumno);
	}else{
	    throw new EliminarException("El alumno no se encuentra en este curso");
	}

	
    }//Fin del metodo
    public boolean editarCurso(){
	if(this.inicio.after(new Date()) || this.fin.before(new Date()) || alumnosInscritos.size() <3){
	    return false;
	    
	}
	return true;
    }
    @Override 
    public String toString(){
	return "nombre: " + nombre +
           "\ncategoria: " + categoria +
           "\nnivel: " + nivel +
           "\nplataforma: " + plataforma +
           "\ndescripcion: " + descripcion +
           "\nhora: " + hora +
           "\nfechaInscripcion: " + fechaInscripcion +
           "\ninicio: " + inicio +
           "\nfin: " + fin +
           "\nnumEstudiantes: " + numEstudiantes +
           "\nidentificador: " + identificador;

    }
}//Fin de la clase

import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
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
    private Scanner scan = new Scanner(System.in);
    private List<Alumnos> alumnosInscritos; //Lista de los alumnos
    //Constructor
    /*
      Constructor con todas las posibles excepciones, como el pasar datos incorrectos
      @param categorias, arreglo de las posibles opciones
      @param niveles, arreglo con los posibles niveles de estudios
      @param resultado1,2,3 opc booleanas para las iteraciones de los for para las categorias, niveles y plataformas
      @param fechaActual obj con la fecha actual
     */
    public Cursos(){
	
	String plataformas[] ={"meet", "zoom", "jitsi", "Skype"};

	this.nombre = "";
	this.categoria = "";
	this.nivel = "";
	this.hora = 0;
	this.plataforma = "";
	this.numEstudiantes = 0;
	this.descripcion = "";
	this.fechaInscripcion = null;
	this.inicio = null;
	this.fin = null;

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
    
     public void cambiaNombre(String nombre)throws NombreInvalidoException {
	if (!nombre.matches("[A-Za-z]+")) {
	    throw new NombreInvalidoException("El nombre no puede tener números.");
	}
	this.nombre = nombre;
	}
    
    public String obtenCategoria() {

	return categoria;
    }
    
    public void cambiaCategoria(String categoria) throws CategoriaException{
	if (!categoria.matches("[A-Za-z]+")) {
	    throw new CategoriaException("La categoria no puede tener números.");
	}
	this.categoria = categoria;
    }

    public String obtenNivel() {
    return nivel;
    }
    
    public void cambiaNivel(String nivel) throws NivelException{
	String niveles[] = {"preparatoria", "licenciatura", "posgrado"};
	boolean resultado2 = false;
	for(int i=0; i<niveles.length; i++){
	    if(nivel.equalsIgnoreCase(niveles[i])){
		resultado2 = true;
		break;
	    }
	}
	if(!resultado2){
		throw new NivelException("El nivel ingresado no coincide con las opc dadas");
	    }    
	this.nivel = nivel;
    }
    
    public String obtenPlataforma() {
	return plataforma;
    }

    public void cambiaPlataforma(String plataforma) throws PlataformaException{
	boolean resultado3 = false;
	String plataformas[] ={"meet", "zoom", "jitsi", "Skype"};
	for(int i=0; i<plataformas.length; i++){
	    if(plataforma.equalsIgnoreCase(plataformas[i])){
		resultado3 = true;
		break;
	    }
	}//Fin del for
	if(!resultado3){
	    throw new PlataformaException("La categoria ingresada con coincide con las opc");
	}
	
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
    
    public void cambiaHora(int hora) throws HoraException{
	if(hora< 7 || hora> 21){
	    throw new HoraException("Esta ingresando una hora fuera de lo establecido, tiene que ser entre 7am y 9pm");
	}
	this.hora = hora;
    }

    public Date obtenFechaInscripcion() {
	return fechaInscripcion;
    }
    
    public void cambiaFechaInscripcion(Date fechaInscripcion) throws HoraException{
	Date fechaActual = new Date();
	if(fechaInscripcion.before(fechaActual)){
	    throw new HoraException("la fecha de inscripcion no puede ser antes que la fecha actual");
	}
	this.fechaInscripcion = fechaInscripcion;
    }
    
    public Date obtenInicio() {
	return inicio;
    }
    
    public void cambiaInicio(Date inicio) throws HoraException{
	Date fechaActual = new Date();
	if(inicio.before(fechaActual)){
	    throw new HoraException("La fecha de inicio del curso no puede ser antes que la fecha actual");
	}else if(inicio.before(fechaInscripcion)){
	    throw new HoraException("La fecha de inicio no puede ser antes que la fecha de inscripcion");
	}
	this.inicio = inicio;
    }
    
    public Date obtenFin() {
	return fin;
    }
    
    public void cambiaFin(Date fin) throws HoraException{
	Date fechaActual = new Date();
	if(fin.before(fechaActual)){
	    throw new HoraException("La fecha de termino no puede ser menor que la fecha actual");
	}else if(fin.before(inicio)){
	    throw new HoraException("La fecha de termino no puede ser menor que la fecha de inicio");
	}
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
	if(profesor == null){
	    throw new AsignacionException("El profesor no fue encontrado");
	}
	if(this.profesor != null){
	    throw new AsignacionException("El grupo ya tiene un profesor asignado");
	}
	System.out.println("Profesor asignado");
	this.profesor = profesor;
    }
    public void reasignarProfesor(Profesores profesor) throws ReasignacionException{
	if(!profesor.obtenNivel().equals(this.nivel)){
	    throw new ReasignacionException("El profesor no tiene el nivel para dar este curso");
	}
	if(!profesor.obtenCategoria().equals(this.categoria)){
	    throw new ReasignacionException("El profesor no imparte esta categoria");
	}
	if(this.fin.after(new Date())){
	    throw new ReasignacionException("EL curso ya ha terminado");
	}
	if(profesor == null){
	    throw new ReasignacionException("No se encontro ningun profesor con dicho ID");
	}
	if(this.profesor == null){
	    throw new ReasignacionException("El grupo no tiene ningun profesor");

	}
	System.out.println("Profesor reasignado con exito");
	this.profesor = profesor;
    }

    public void inscribirAlumno(Alumnos alumno) throws InscripcionInvalidaException {
	Date hoy = new Date();
	
	// Validar que la fecha de inscripción esté abierta
	if (hoy.before(this.fechaInscripcion) || hoy.after(this.obtenInicio())) {
	    throw new InscripcionInvalidaException("La fecha de inscripción está cerrada para este curso.");
	}
	//Validar si el obj alumno no es vacio
	if(alumno  == null){
	    throw new InscripcionInvalidaException("No se encontro al alumno al cual quiere inscribir");
	}
	
	// Validar que el alumno no esté ya inscrito en el curso
	if (this.alumnosInscritos.contains(alumno)) {
	    throw new InscripcionInvalidaException("El alumno ya se encuentra inscrito en este curso.");
	}

	// Validar que el alumno no tenga más de 6 materias inscritas
	if (alumno.numCursosActivos() >= 6) {
	    throw new InscripcionInvalidaException("El alumno ya tiene el máximo (6) de materias inscritas que están en curso.");
	}
	System.out.println("Alumno inscrito con exito");
	this.alumnosInscritos.add(alumno); // Agrega el alumno a la lista del curso.
    }
    public void quitarAlumno(Alumnos alumno) throws EliminarException{
	if(this.fin.before(new Date())){
	    throw new EliminarException("EL curso ya ha concluido");
	}
	if(alumno == null){
	    throw new EliminarException("No se encontro al alumno con dicho ID");
	}
	if(alumnosInscritos.contains(alumno)){
	    System.out.println("Alumno removido con exito");
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
    public void edicionCuros() throws NombreInvalidoException, CategoriaException, NivelException, HoraException, PlataformaException{
	boolean resultado = false;
	do{
		System.out.print("Nuevo Nombre: ");
		String nombre = scan.nextLine();
		cambiaNombre(nombre);
		System.out.print("Nueva categoria: ");
		String categoria = scan.nextLine();
		cambiaCategoria(categoria);
		System.out.print("Nuevo Nivel (Preparatoria, Licenciatura, Posgrado): ");
		String nivel = scan.nextLine();
		cambiaNivel(nivel);
		System.out.print("Nuevo hora");
		int hora = scan.nextInt();
		scan.nextLine();
		cambiaHora(hora);
		System.out.print("Nueva Plataforma (meet, zoom, jitsi, Skype): ");
		String plataforma = scan.nextLine();
		cambiaPlataforma(plataforma);
		System.out.print("Nueva Hora de Clase (HH:mm, entre 07:00 y 21:00): ");
		int numEstudiantes = scan.nextInt();
		scan.nextLine();
		
		System.out.println("num de estudiantes: ");
		numEstudiantes = scan.nextInt();
		scan.nextLine();
		cambiaNumEstudiantes(numEstudiantes);
		System.out.println("Descripcion: ");
		descripcion = scan.nextLine();
		cambiaDescripcion(descripcion);
		//Fechas
		System.out.println("Ingrese el año de inscripcion: YYYY");
		int año = scan.nextInt();
		scan.nextLine();//Limpiar scan
		System.out.println("Ingrese el mes de inscripcion: MM");
		int mes = scan.nextInt();
		scan.nextLine();//Limpiar scan
		System.out.println("Ingrese el dia de inscripcion: DD");
		int dia = scan.nextInt();
		scan.nextLine(); //Limpiar scan
		Date inscripcion = new Date(año - 1900, mes - 1, dia);
		cambiaFechaInscripcion(inscripcion);
		//Inicio
		System.out.println("Ingrese el año de inicio: YYYY");
		año = scan.nextInt();
		scan.nextLine();//Limpiar 
		System.out.println("Ingrese el mes de inicio: MM");
		mes = scan.nextInt();
		scan.nextLine();//Limpiar scan
		System.out.println("Ingrese el dia de inicio: DD");
		dia = scan.nextInt();
		scan.nextLine(); //Limpiar scan
		Date inicio = new Date(año - 1900, mes - 1, dia);
		cambiaInicio(inicio);
		//fin
		System.out.println("Ingrese el año de fin: YYYY");
		año = scan.nextInt();
		scan.nextLine();//Limpiar 
		System.out.println("Ingrese el mes de fin: MM");
		mes = scan.nextInt();
		scan.nextLine();//Limpiar scan
		System.out.println("Ingrese el dia de fin: DD");
		dia = scan.nextInt();
		scan.nextLine(); //Limpiar scan
		Date fin = new Date(año - 1900, mes - 1, dia);
		cambiaFin(fin);
		System.out.println("Obj creado con exito");
		System.out.println("Su identificador es: "+ obtenIdentificador());
		resultado = true;	    
	}while(!resultado);
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

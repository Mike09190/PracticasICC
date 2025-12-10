import java.util.Date;
import java.util.Random;
import java.util.Scanner;
public class Profesores{
    private String nombre;
    private String categoria;
    private String nivel;
    private String titulo;
    private String identificador;
    private int año;
    private Scanner scan = new Scanner(System.in);

    public Profesores(){
	this.nombre = "";
	this.nivel = "";
	this.categoria = "";
	this.titulo = "";
	this.año = 0;
	Random random = new Random();
	int idNumerico = random.nextInt(99999 - 10000 + 1) + 10000;
        
        // Convertir el número a String
        String nuevoID = String.valueOf(idNumerico);
	this.identificador = nuevoID;
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

    public String obtenCategoria() {
	return categoria;
    }

    public void cambiaCategoria(String categoria) throws CategoriaException{
	String categorias[] = {"COMPUTACION", "MATEMATICAS", "FISICA", "QUIMICA", "BIOLOGIA", "ECONOMIA", "DEPORTE", "LITERATURA", "FILOSOFIA", "HISTROIA", "Otro"};
	boolean resultado = false;
	for(int i=0; i<categorias.length; i++){
	    if(categoria.equalsIgnoreCase(categorias[i])){
		resultado = true;
		break;
	    }
	}//FIn del for

	if(!resultado){
	    throw new CategoriaException("La categoria ingresada con coincide con las opc");
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
	}//Fin del for
	if(!resultado2){
	    throw new NivelException("El nivel ingresado no coincide con las opc dadas");
	}
	this.nivel = nivel;
    }

    public String obtenTitulo() {
	return titulo;
    }

    public void cambiaTitulo(String titulo) throws TituloException{
	String titulos[] = {"bachiller", "tecnico", "licenciatura"};
	boolean resultado3 = true;
	for(int i=0; i<titulos.length; i++){
	    if(titulo.equalsIgnoreCase(titulos[i])){
		resultado3 = true;
		break;
	    }
	}
	if(!resultado3){
	    throw new TituloException("El titulo que tiene no coincide con alguno de los solicitados");
	}
	this.titulo = titulo;
    }

    public String obtenIdentificador() {
	return identificador;
    }

    public void cambiaIdentificador(String identificador) {
	this.identificador = identificador;
    }

    public int obtenAño() {
	return año;
    }

    public void cambiaAño(int año) throws HoraException{
	Date horaActual = new Date();
	if(año> horaActual.getYear()){
	    throw new HoraException("El año de tu titulo es mayor al año actual osea como");
	}
	this.año = año;
    }
    public void editarProfesor() throws NombreInvalidoException, CategoriaException, NivelException, TituloException, HoraException {
	boolean continuar = false;
	do{ 
	    System.out.println("Escriba el nuevo nombre: ");
	    String nuevoNombre = scan.nextLine();
	    cambiaNombre(nuevoNombre);
	    System.out.println("Nivel: (Preparatoria, Licenciatura, Posgrado)");
	    String nuevoNivel = scan.nextLine();
	    cambiaNivel(nuevoNivel);
	    System.out.println("Categoria: ");
	    String nuevaCategoria = scan.nextLine();
	    cambiaCategoria(nuevaCategoria);
	    System.out.println("Titulo: ");
	    String nuevoTitulo = scan.nextLine();
	    cambiaTitulo(nuevoTitulo);
	    System.out.print("Año del Título: ");
	    int nuevoAño = scan.nextInt();
	    cambiaAño(nuevoAño);
	    scan.nextLine(); 
    
    
	    System.out.println("Datos del profesor actualizados con éxito.");
	    System.out.println("Su identificador es: "+obtenIdentificador());
	    continuar = true;
	}while(!continuar);
}
    
}//Fin de la clase

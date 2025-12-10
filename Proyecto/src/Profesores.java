import java.util.Date;
import java.util.Random;
public class Profesores{
    private String nombre;
    private String categoria;
    private String nivel;
    private String titulo;
    private String identificador;
    private int año;

    public Profesores(String nombre, String nivel, String categoria, String titulo, int año) throws NombreInvalidoException, CategoriaException, NivelException, TituloException, HoraException{
	if (!nombre.matches("[A-Za-z]+")) {
	    throw new NombreInvalidoException("El nombre no puede tener números.");
	}
	String categorias[] = {"COMPUTACION", "MATEMATICAS", "FISICA", "QUIMICA", "BIOLOGIA", "ECONOMIA", "DEPORTE", "LITERATURA", "FILOSOFIA", "HISTROIA", "Otro"};
	String niveles[] = {"preparatoria", "licenciatura", "posgrado"};
	String titulos[] = {"bachiller", "tecnico", "licenciatura"};
	Date horaActual = new Date();
	boolean resultado = false, resultado2 = false, resultado3 = false; 

	//Verifcacion para la categoria
	for(int i=0; i<categorias.length; i++){
	    if(categoria.equalsIgnoreCase(categorias[i])){
		resultado = true;
		break;
	    }
	}//FIn del for
	for(int i=0; i<niveles.length; i++){
	    if(nivel.equalsIgnoreCase(niveles[i])){
		resultado2 = true;
		break;
	    }
	}//Fin del for
	for(int i=0; i<titulos.length; i++){
	    if(titulo.equalsIgnoreCase(titulos[i])){
		resultado = true;
		break;
	    }
	}

	if(!resultado){
	    throw new CategoriaException("La categoria ingresada con coincide con las opc");
	}
	if(!resultado2){
	    throw new NivelException("El nivel ingresado no coincide con las opc dadas");
	}
	if(!resultado3){
	    throw new TituloException("El titulo que tiene no coincide con alguno de los solicitados");
	}
	if(año> horaActual.getYear()){
	    throw new HoraException("El año de tu titulo es mayor al año actual osea como");
	}

	this.nombre = nombre;
	this.nivel = nivel;
	this.categoria = categoria;
	this.titulo = titulo;
	this.año = año;
	Random random = new Random();
	int idNumerico = random.nextInt(99999 - 10000 + 1) + 10000;
        
        // Convertir el número a String
        String nuevoID = String.valueOf(idNumerico);
	this.identificador = nuevoID;
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

    public String obtenTitulo() {
	return titulo;
    }

    public void cambiaTitulo(String titulo) {
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

    public void cambiaAño(int año) {
	this.año = año;
    }



}//Fin de la clase

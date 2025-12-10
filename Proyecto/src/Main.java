import java.util.Scanner;
import java.util.Date;
public class Main{
    public static void main(String[] args){
	//variables
	int opc;
	boolean salir = false;
	boolean continuar = false, continuar2 = false, continuar3 = false;
	String nombre, categoria, nivel, plataforma, descripcion;
	String titulo;
	int numEstudiantes;
	int añoTitulo;
	int edad;
	String escuela;
	
	//objetos
	Scanner scan = new Scanner(System.in);
	Date fecha = new Date();
	System.out.println("Bienvenido a continuacion eliga una de las sig. opc");

	do{
            System.out.println("1. Crear nuevo curso,alumno o profesor");
            System.out.println("2. Inscribir alumnos, asignar profesor o reasignar profesor");
            System.out.println("3. Guardar Datos");
            System.out.print("4. Salir ");
	    opc = scan.nextInt();
	    scan.nextLine();
	    switch(opc){
	    case 1:
		System.out.println("Que gusta crear: 1-Curso, 2-Alumno, 3-Profesor");
		opc = scan.nextInt();
		switch(opc){
		case 1:
		    do{
			try{
			    System.out.println("Escriba el nombre: ");
			    nombre = scan.nextLine();
			    System.out.println("Escriba la categoria: (Computaci ́on, Matematicas, Fısica, Quımica, Biologıa, Economıa, Deporte, Literatura, Filosofıa, Historia, Otro)");
			    categoria = scan.nextLine();
			    System.out.println("Escriba el nivel: ");
			    nivel = scan.nextLine();
			    System.out.println("Horario de 7am a 21pm: ");
			    int horas = scan.nextInt();
			    horas = scan.nextInt();
			    
			    System.out.println("Plataforma: ");
			    plataforma = scan.nextLine();
			    System.out.println("num de estudiantes: ");
			    numEstudiantes = scan.nextInt();
			    scan.nextLine();
			    System.out.println("Descripcion: ");
			    descripcion = scan.nextLine();
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
			    Cursos curso = new Cursos( nombre,  categoria,  nivel, horas, plataforma,numEstudiantes, descripcion, inscripcion, inicio, fin);
			    continuar = true;
			}catch(NombreInvalidoException e){
			    System.out.println(e);
			}catch(CategoriaException o){
			    System.out.println(o);
			}catch(NivelException e){
			    System.out.println(e);
			}catch(HoraException o){
			    System.out.println(o);
			}catch(PlataformaException e){
			    System.out.println(e);
			}catch(Exception e){
			    System.out.println("hubo un error inesperado");
			}
		    }while(!continuar);
		case 2:
		    System.out.println("Registrar Profesor");
		    do{
			try{
			    System.out.println("Escriba el nombre: ");
			    nombre = scan.nextLine();
			    System.out.println("Nivel: (Preparatoria, Licenciatura, Posgrado)");
			    nivel = scan.nextLine();
			    System.out.println("Categoria: ");
			    categoria = scan.nextLine();
			    System.out.println("Titulo: ");
			    titulo = scan.nextLine();
			    System.out.println("Año: ");
			    añoTitulo = scan.nextInt();
			    scan.nextLine();
			    Profesores profe = new Profesores(nombre, nivel, categoria, titulo, añoTitulo);
			}catch(NombreInvalidoException e){
			    System.out.println(e);
			}catch(CategoriaException o){
			    System.out.println(o);
			}catch(NivelException e){
			    System.out.println(e);
			}catch(TituloException e){
			    System.out.println(e);
			}catch(HoraException o){
			    System.out.println(o);
			}catch(Exception e){
			    System.out.println("Hubo un dato mal puesto no esperado");
			}
		    }while(!continuar2);
		case 3:
		    do{
			try{
			    System.out.println("Nombre: ");
			    nombre = scan.nextLine();
			    System.out.println("Edad: ");
			    edad = scan.nextInt();
			    System.out.println("Escuela de procedencia: ");
			    escuela = scan.nextLine();
			    Alumnos alumno = new Alumnos(nombre, edad, escuela);
			}catch(NombreInvalidoException e){
			    System.out.println(e);
			}catch(EdadException e){
			    System.out.println(e);
			}catch(EscuelaException e){
			    System.out.println(e);
			}
		    }while(!continuar3);
		default:
		    System.out.println("La opc no esta bro");
		    break;
		}
		break;
	    case 2:
		System.out.println("Que gusta inscribir: 1-Alumnos, 2-Profesor, 3-Reasignar un profesor");
		
		break;
	    case 3:
		System.out.println("Bienvenido al sistema para guardar o cargar datos, que gusta realizar. 1-Guardar, 2-Cargar");
		break;
	    case 4:
		salir = true;
		break;
	    default:
		System.out.println("Pusiste una opc inexistente lamentable");
	    }//Fin del switch



	}while(!salir);
    }//Fin del main


}

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
	String idAlumno, idProfesor, idCurso;
	int numEstudiantes;
	int añoTitulo;
	int edad;
	String escuela;
	
	//objetos
	Scanner scan = new Scanner(System.in);
	Date fecha = new Date();
	Gestor gestor = new Gestor();
	Cursos curso = new Cursos();
	Profesores profe = new Profesores();
	Alumnos alumno = new Alumnos();
	System.out.println("Bienvenido a continuacion eliga una de las sig. opc");

	do{
            System.out.println("1. Crear nuevo curso,alumno o profesor");
            System.out.println("2. Inscribir alumnos, asignar profesor o reasignar profesor");
            System.out.println("3. Editar o eliminar algun estudiante, profesor o curso");
	    System.out.println("4. Guardar Datos");
            System.out.println("5. Salir ");
	    opc = scan.nextInt();
	    scan.nextLine();
	    switch(opc){
	    case 1:
		System.out.println("Que gusta crear: 1-Curso, 2-Profesor, 3-Alumno");
		opc = scan.nextInt();
		scan.nextLine();
		switch(opc){
		case 1:
		    boolean crearCurso = false;
		    do{
			try{
			    curso.edicionCuros();
			    gestor.agregarCurso(curso);
			    crearCurso = true;
			}catch(NombreInvalidoException e){
			    System.out.println(e);
			}catch(CategoriaException e){
			    System.out.println(e);
			}catch(NivelException e){
			    System.out.println(e);
			}catch(HoraException e){
			    System.out.println(e);
			}catch(PlataformaException e){
			    System.out.println(e);
			}
		    }while(!crearCurso);
		    break;
		case 2:
		    System.out.println("Registrar Profesor");
		    do{
			try{
			    profe.editarProfesor();
			    gestor.agregarProfesor(profe);
			    continuar = true;
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
		case 3:// Alumnos
		    do{
			try{
			    alumno.editarAlumno();
			    gestor.agregarAlumnos(alumno);
			    continuar3 = true;
			}catch(NombreInvalidoException e){
			    System.out.println(e);
			}catch(EdadException e){
			    System.out.println(e);
			}
		    }while(!continuar3);
		default:
		    System.out.println("La opc no esta bro");
		    break;
		}
		break;
	    case 2:
		System.out.println("Que gusta inscribir: 1-Alumnos, 2-Profesor, 3-Reasignar un profesor, 4.Desinscribir a un alumno");
		opc = scan.nextInt();
		switch(opc){
		case 1: //Inscribir alumno
		    boolean inscripcion = false;
		    do{
			try{
			    System.out.println("Ingrese el id del estudiante: ");
			    idAlumno = scan.nextLine();
			    Alumnos alumnoInscrito = gestor.regresarAlumnos(idAlumno);
			    System.out.println("Ingrese el id del curso");
			    idCurso = scan.nextLine();
			    Cursos cursoEncontrado = gestor.regresarCurso(idCurso);
			    if(cursoEncontrado == null){
				throw new InscripcionInvalidaException("El curso no ha sido encontrado");
			    }
			    cursoEncontrado.inscribirAlumno(alumnoInscrito);
			    inscripcion = true;
			}catch(InscripcionInvalidaException e){
			    System.out.println(e);
			}
		    }while(!inscripcion);
		    break;
		case 2: //Asignar profesor
		    boolean inscripcion2 = false;
		    do{
			try{
			    System.out.println("Ingrese el id del profesor: ");
			    idProfesor = scan.nextLine();
			    Profesores profesorAsignado = gestor.regresarProfesor(idProfesor);
			    System.out.println("Ingrese el id del curso");
			    idCurso = scan.nextLine();
			    Cursos cursoEncontrado = gestor.regresarCurso(idCurso);
			    if(cursoEncontrado == null){
				throw new AsignacionException("El curso no ha sido encontrado");
			    }
			    cursoEncontrado.asignarProfesor(profesorAsignado);
			    inscripcion2 = true;
			}catch(AsignacionException e){
			    System.out.println(e);
			}
		    }while(!inscripcion2);
		    break;

		case 3:
		    boolean reasignacion = false;
		    do{
			try{
			    System.out.println("Ingrese el id del profesor: ");
			    idProfesor = scan.nextLine();
			    Profesores profesorAsignado = gestor.regresarProfesor(idProfesor);
			    System.out.println("Ingrese el id del curso");
			    idCurso = scan.nextLine();
			    Cursos cursoEncontrado = gestor.regresarCurso(idCurso);
			    if(cursoEncontrado == null){
				throw new ReasignacionException("El curso no ha sido encontrado");
			    }
			    cursoEncontrado.reasignarProfesor(profesorAsignado);
			    reasignacion = true;
			}catch(ReasignacionException e){
			    System.out.println(e);
			}
		    }while(!reasignacion);
		    break;
		case 4: //Quitar a un alumno
		    boolean quitar = false;
		    do{
			try{
			    System.out.println("Ingrese el id del estudiante: ");
			    idAlumno = scan.nextLine();
			    Alumnos alumnoInscrito = gestor.regresarAlumnos(idAlumno);
			    System.out.println("Ingrese el id del curso");
			    idCurso = scan.nextLine();
			    Cursos cursoEncontrado = gestor.regresarCurso(idCurso);
			    if(cursoEncontrado == null){
				throw new EliminarException("El curso no ha sido encontrado");
			    }
			    cursoEncontrado.quitarAlumno(alumnoInscrito);
			    quitar = true;
			}catch(EliminarException e){
			    System.out.println(e);
			}
		    }while(!quitar);
		    break;
		}//Fin del sub-switch
		break;
	    case 3:
		System.out.println("Que gusta hacer, editar o eliminar algun dato: 1-Editar, 2-Eliminar");
		int opcion = scan.nextInt();
		scan.nextLine();
		if(opcion == 1){
		    System.out.println("A quien gusta editar: 1-Alumno, 2-Profesor, 3-Curso");
		    int editar = scan.nextInt();
		    scan.nextLine();
		    switch(editar){
		    case 1:
			boolean edit = false;
			do{
			    try{
				System.out.println("Ingrese el id del alumno");
				idAlumno = scan.nextLine();
				Alumnos alumnoEditar = gestor.regresarAlumnos(idAlumno); //alumno encontrado
				alumnoEditar.editarAlumno();
				if(alumnoEditar  == null){
				    throw new NombreInvalidoException("No se encontro al alumno por su id");
				}
				edit = true;
			    }catch(NombreInvalidoException e){
				System.out.println(e);
			    }catch(EdadException e){
				System.out.println(e);
			    }
			}while(!edit);
			break;
		    case 2: //Profesor
			boolean profesor = false;
			do{
			    try{
				System.out.println("Ingrese el id del profesor");
				idProfesor = scan.nextLine();
				Profesores profesorEditar = gestor.regresarProfesor(idProfesor); //alumno encontrado
				profesorEditar.editarProfesor();
				if(profesorEditar  == null){
				    throw new NombreInvalidoException("No se encontro al profesor por su id");
				}
				
				profesor = true;
			    }catch(NombreInvalidoException e){
				System.out.println(e);
			    }catch(CategoriaException e){
				System.out.println(e);
			    }catch(NivelException e){
				System.out.println(e);
			    }catch(TituloException o ){
				System.out.println(o);
			    }catch(HoraException o){
				System.out.println(o);
			    }
			    
			}while(!profesor);
			break;
		    case 3: //Editar curso
			boolean editCurso = false;
			    do{
				try{
				    System.out.println("Ingrese el id del curso");
				    idCurso = scan.nextLine();
				    Cursos cursoEditar = gestor.regresarCurso(idCurso); //Curso Encontrado
				    if(cursoEditar.editarCurso()){
					cursoEditar.edicionCuros();
				    }else{
					break;
				    }
				    if(cursoEditar  == null){
					throw new NombreInvalidoException("No se encontro al profesor por su id");
				    }
				    editCurso = true;
				}catch(NombreInvalidoException e){
				    System.out.println(e);
				}catch(CategoriaException e){
				    System.out.println(e);
				}catch(NivelException e){
				    System.out.println(e);
				}catch(PlataformaException o ){
				    System.out.println(o);
				}catch(HoraException o){
				    System.out.println(o);
				}
			    }while(!editCurso);
				    
			
			break;
		    }//Fin del switch

		}//Fin del if
		else if(opcion == 2){
		    //ELiminar
		    System.out.println("Que gusta eliminar. 1-Alumno, 2-Profesor, 3-Curso");
		    int eliminar = scan.nextInt();
		    scan.nextLine();
		    if(eliminar  == 1){
			try{
			    System.out.println("Ingrese el id del alumno para eliminar: ");
			    idAlumno = scan.nextLine();
			    gestor.eliminarAlumno(idAlumno);
			}catch(EliminarException e){
			    System.out.println(e);
			}finally{
			    break;
			}
			    
		    }
		    else if(eliminar  == 2){
			try{
			    System.out.println("Ingrese el id del profesor para eliminar: ");
			    idProfesor = scan.nextLine();
			    gestor.eliminarProfesor(idProfesor);
			}catch(EliminarException e){
			    System.out.println(e);
			}finally{
			    break;
			}
		    }//FIn del segundo if
		    else if(eliminar == 3){
			try{
			    System.out.println("Ingrese el id del curso para eliminar: ");
			    idCurso = scan.nextLine();
			    gestor.eliminarCurso(idCurso);
			}catch(EliminarException e){
			    System.out.println(e);
			}finally{
			    break;
			}
		    }

		}
	       
		break;
	    case 4:
		System.out.println("Bienvenido al sistema para guardar o cargar datos, que gusta realizar. 1-Guardar, 2-Cargar");
		opc = scan.nextInt();
		scan.nextLine();
		if(opc == 1){
		    System.out.println("Informacion guardada");
		    gestor.guardarDatos();
		}
		else if(opc == 2){
		    System.out.println("Informacion cargada");
		    gestor.cargarDatos();
		}
		break;
	    case 5:
		salir = true;
		break;
	    default:
		System.out.println("Pusiste una opc inexistente lamentable");
	    }//Fin del switch



	}while(!salir);
    }//Fin del main


}

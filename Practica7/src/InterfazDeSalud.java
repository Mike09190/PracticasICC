public interface InterfazDeSalud{

    boolean certificadoSaludValido(String numCertidicadoSalud) throws CertificadoSaludException;
    boolean edad(int edad) throws EdadException;

}

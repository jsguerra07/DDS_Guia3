/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad Ean (Bogotá - Colombia)
 * Departamento de Tecnologías de la Información y Comunicaciones
 * Licenciado bajo el esquema Academic Free License version 2.1
 * <p>
 * Proyecto Central de Pacientes.
 * Adaptado de CUPI2 (Uniandes)
 * Fecha: Febrero 2021
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package centralPacientes.mundo;

import java.util.ArrayList;

/**
 * Esta clase representa una central en la que se maneja una lista de pacientes
 */
public class CentralPacientes {
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Lista de pacientes
     */
    private ArrayList<Paciente> pacientes;

    /**
     * Vector de clínicas manejadas por la central
     */
    private ArrayList<String> listaClinicas;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Crea una nueva central sin pacientes y con una lista predefinida de clínicas
     */
    public CentralPacientes() {
        pacientes = new ArrayList<>();

        listaClinicas = new ArrayList<>();
        listaClinicas.add("Clínica del Country");
        listaClinicas.add("Clínica Palermo");
        listaClinicas.add("Clínica Reina Sofía");
        listaClinicas.add("Clínica El Bosque");
        listaClinicas.add("Clínica San Ignacio");
        listaClinicas.add("Otra");
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Retorna el número de pacientes de la clínica
     *
     * @return El número de pacientes de la clínica
     */
    public int darNumeroPacientes() {
        return pacientes.size();
    }

    /**
     * Adiciona un paciente al principio de la lista
     *
     * @param pac El paciente a ser agregado al comienzo de la lista. <br>
     *            pac!=null y no existe un paciente con código igual a pac.codigo
     */
    public void agregarPacienteAlComienzo(Paciente pac) {
        // TODO: Realiar el método que agrega al principio
        if (pac == null || localizar(pac.darCodigo()) != null) {
            throw new IllegalArgumentException("Paciente inválido o ya existe.");
        }
        pacientes.add(0, pac);
    }

    /**
     * Adiciona un paciente al final de la lista. Si la lista está vacía el paciente queda de primero
     *
     * @param pac El paciente a ser agregado al final la lista. <br>
     *            pac!=null y no existe un paciente con código igual a pac.codigo
     */
    public void agregarPacienteAlFinal(Paciente pac) {
        // TODO: Agragar un paciente al final de la lista
        if (pac == null || localizar(pac.darCodigo()) != null) {
            throw new IllegalArgumentException("Paciente inválido o ya existe.");
        }
        pacientes.add(pac);
    }

    /**
     * Adiciona un paciente a la lista de pacientes antes del paciente con el código especificado. <br>
     */
    public void agregarPacienteAntesDe(int cod, Paciente pac) throws NoExisteException {
        // TODO: Agrega un paciente después del paciente con el código dado
        if (pac == null) {
            throw new IllegalArgumentException("Paciente inválido.");
        }

        int index = encontrarIndicePaciente(cod);
        if (index == -1) {
            throw new NoExisteException(cod);
        }
        if (localizar(pac.darCodigo()) != null) {
            throw new IllegalArgumentException("Ya existe un paciente con el código " + pac.darCodigo());
        }
        pacientes.add(index, pac);

    }

    /**
     * Adiciona un paciente a la lista de pacientes después del paciente con el código especificado.
     */
    public void agregarPacienteDespuesDe(int cod, Paciente pac) throws NoExisteException {
        // TODO: Agrega un paciente después del paciente con el código cod
        if (pac == null) {
            throw new IllegalArgumentException("Paciente inválido.");
        }

        int index = encontrarIndicePaciente(cod);
        if (index == -1) {
            throw new NoExisteException(cod);
        }
        if (localizar(pac.darCodigo()) != null) {
            throw new IllegalArgumentException("Ya existe un paciente con el código " + pac.darCodigo());
        }
        pacientes.add(index + 1, pac);
    }

    /**
     * Busca el paciente con el código dado en la lista de pacientes.
     */
    public Paciente localizar(int codigo) {
        // TODO: Completar el método
        for (Paciente p : pacientes) {
            if (p.darCodigo() == codigo) {
                return p;
            }
        }
        return null;
    }

    /**
     * Elimina el paciente con el código especificado.
     */
    public void eliminarPaciente(int cod) throws NoExisteException {
        // TODO: Si no existe el paciente con el código dado, genera la excepción
        int index = encontrarIndicePaciente(cod);
        if (index == -1) {
            throw new NoExisteException(cod);
        }
        pacientes.remove(index);
    }

    /**
     * Devuelve una lista con los pacientes de la central
     */
    public ArrayList<Paciente> darPacientes() {
        return pacientes;
    }

    /**
     * Retorna la lista de clínicas manejadas por la central
     */
    public ArrayList<String> darListaClinicas() {
        return listaClinicas;
    }

    /**
     * Retorna la longitud de la lista
     */
    private int darLongitud() {
        return pacientes.size();
    }

    private int encontrarIndicePaciente(int codigo) {
        for (int i = 0; i < pacientes.size(); i++) {
            if (pacientes.get(i).darCodigo() == codigo) {
                return i;
            }
        }
        return -1;
    }

    // -----------------------------------------------------------------
    // Puntos de Extensión
    // -----------------------------------------------------------------

    /**
     * Retorna la cantidad de hombres que hay en la lista
     */
    public int cantHombres() {
        // TODO: Completar
        int count = 0;
        ArrayList<Paciente> pacientesList = darPacientes();
        for (Paciente pac : pacientesList) {
            if (pac.darSexo()!= 2 ) {
                count++;
            }
        }
        return count;
        //return 0;
    }

    /**
     * Retorna la cantidad de mujeres que hay en la lista
     */
    public int cantMujeres() {
        // TODO: Completar
        int count = 0;
        ArrayList<Paciente> pacientesList = darPacientes();
        for (Paciente pac : pacientesList) {
            if (pac.darSexo()!= 1 ) {
                count++;
            }
        }
        return count;
        //return 0;
    }

    /**
     * De las 6 opciones de clínicas que tiene la central
     * ¿Cuál es el nombre de la más ocupada, la que tiene más pacientes?
     *
     * @return nombre de la clínica
     */
    public String metodo4() {
        // TODO: Completar
        return "Respuesta 4";
    }


}

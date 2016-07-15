package modelo;


/**
 * @version 1.0
 * @created 14-Jul.-2016 8:20:46 p. m.
 */
public class Departamento {

	private String id_departamento;
	private String nombre_dep;
	private int estado;
	public Empleado m_Empleado;

	public Departamento(){

	}

        public Departamento(String id_departamento, String nombre_dep, int estado, Empleado m_Empleado) {
            this.id_departamento = id_departamento;
            this.nombre_dep = nombre_dep;
            this.estado = estado;
            this.m_Empleado = m_Empleado;
        }

        public String getId_departamento() {
            return id_departamento;
        }

        public void setId_departamento(String id_departamento) {
            this.id_departamento = id_departamento;
        }

        public String getNombre_dep() {
            return nombre_dep;
        }

        public void setNombre_dep(String nombre_dep) {
            this.nombre_dep = nombre_dep;
        }

        public int getEstado() {
            return estado;
        }

        public void setEstado(int estado) {
            this.estado = estado;
        }

        public Empleado getM_Empleado() {
            return m_Empleado;
        }

        public void setM_Empleado(Empleado m_Empleado) {
            this.m_Empleado = m_Empleado;
        }

        
        
	public void finalize() throws Throwable {

	}

}
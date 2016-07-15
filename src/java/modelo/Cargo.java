package modelo;


/**
 * @author Wendy_Andres
 * @version 1.0
 * @created 14-Jul.-2016 8:18:47 p. m.
 */
public class Cargo {

	private String id_cargo;
	private String nombre_cargo;
	private float salario;
	private int estado;
	public Departamento m_Departamento;

	public Cargo(){

	}

        public Cargo(String id_cargo, String nombre_cargo, float salario, int estado, Departamento m_Departamento) {
            this.id_cargo = id_cargo;
            this.nombre_cargo = nombre_cargo;
            this.salario = salario;
            this.estado = estado;
            this.m_Departamento = m_Departamento;
        }

        public String getId_cargo() {
            return id_cargo;
        }

        public void setId_cargo(String id_cargo) {
            this.id_cargo = id_cargo;
        }

        public String getNombre_cargo() {
            return nombre_cargo;
        }

        public void setNombre_cargo(String nombre_cargo) {
            this.nombre_cargo = nombre_cargo;
        }

        public float getSalario() {
            return salario;
        }

        public void setSalario(float salario) {
            this.salario = salario;
        }

        public int getEstado() {
            return estado;
        }

        public void setEstado(int estado) {
            this.estado = estado;
        }

        public Departamento getM_Departamento() {
            return m_Departamento;
        }

        public void setM_Departamento(Departamento m_Departamento) {
            this.m_Departamento = m_Departamento;
        }

        
        
	public void finalize() throws Throwable {

	}

}
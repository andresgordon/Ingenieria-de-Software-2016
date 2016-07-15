package modelo;


/**
 * @author Wendy_Andres
 * @version 1.0
 * @created 14-Jul.-2016 8:21:09 p. m.
 */
public class Area {

	private String id_area;
	private String nombre_area;
	private int estado;
	public Departamento m_Departamento;

	public Area(){

	}

        public Area(String id_area, String nombre_area, int estado, Departamento m_Departamento) {
            this.id_area = id_area;
            this.nombre_area = nombre_area;
            this.estado = estado;
            this.m_Departamento = m_Departamento;
        }

        public String getId_area() {
            return id_area;
        }

        public void setId_area(String id_area) {
            this.id_area = id_area;
        }

        public String getNombre_area() {
            return nombre_area;
        }

        public void setNombre_area(String nombre_area) {
            this.nombre_area = nombre_area;
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
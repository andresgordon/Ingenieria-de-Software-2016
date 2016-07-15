package modelo;


/**
 * @version 1.0
 * @created 14-Jul.-2016 8:20:29 p. m.
 */
public class Empleado {

	private String idEmpleado;
	private String nombreEmpleado;
	private int estado;
	private String correo;
	private String usuario;
	private String password;
	public Actividad m_Actividad;
	public Cargo m_Cargo;

	public Empleado(){

	}

        public Empleado(String idEmpleado, String nombreEmpleado, int estado, String correo, String usuario, String password, Actividad m_Actividad, Cargo m_Cargo) {
            this.idEmpleado = idEmpleado;
            this.nombreEmpleado = nombreEmpleado;
            this.estado = estado;
            this.correo = correo;
            this.usuario = usuario;
            this.password = password;
            this.m_Actividad = m_Actividad;
            this.m_Cargo = m_Cargo;
        }

        public String getIdEmpleado() {
            return idEmpleado;
        }

        public void setIdEmpleado(String idEmpleado) {
            this.idEmpleado = idEmpleado;
        }

        public String getNombreEmpleado() {
            return nombreEmpleado;
        }

        public void setNombreEmpleado(String nombreEmpleado) {
            this.nombreEmpleado = nombreEmpleado;
        }

        public int getEstado() {
            return estado;
        }

        public void setEstado(int estado) {
            this.estado = estado;
        }

        public String getCorreo() {
            return correo;
        }

        public void setCorreo(String correo) {
            this.correo = correo;
        }

        public String getUsuario() {
            return usuario;
        }

        public void setUsuario(String usuario) {
            this.usuario = usuario;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public Actividad getM_Actividad() {
            return m_Actividad;
        }

        public void setM_Actividad(Actividad m_Actividad) {
            this.m_Actividad = m_Actividad;
        }

        public Cargo getM_Cargo() {
            return m_Cargo;
        }

        public void setM_Cargo(Cargo m_Cargo) {
            this.m_Cargo = m_Cargo;
        }

	public void finalize() throws Throwable {

	}

}
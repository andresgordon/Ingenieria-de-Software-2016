/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Wendy_Andres
 */
public class Consultas extends Conexion{
    
    public boolean autenticacion (String usuario, String contrasena){
        PreparedStatement pst = null;
        ResultSet rs= null;
        try {
            String consulta = "select * from usuarios where nombre = ? and pass = ?";
            pst = getConexion().prepareStatement(consulta);
            pst.setString(1, usuario);
            pst.setString(2, contrasena);
            rs = pst.executeQuery();
            if (rs.absolute(1)){
                return true;
            }
        } catch (Exception e) {
            System.err.println("Error "+e);
        }finally{
            try{
                if (getConexion() != null ) getConexion().close();
                if (pst != null) pst.close();
                if (rs != null) rs.close();
            }catch (Exception e) {
                System.err.println("Error "+e);
            }
        }
        return false;
    }

    public boolean registrar (String nombre, String contrasena){
        PreparedStatement pst = null;
        try {
            String consulta = "insert into usuarios (nombre, pass) values (?,?) ";
            pst = getConexion().prepareStatement(consulta);
            pst.setString(1, nombre);
            pst.setString(2, contrasena);
            if (pst.executeUpdate() == 1){
                return true;
            }
        } catch (Exception e) {
            System.err.println("Error "+e);
        }finally{
            try{
                if (getConexion() != null ) getConexion().close();
                if (pst != null) pst.close();
            }catch (Exception e) {
                System.err.println("Error "+e);
            }
        }
        return false;
    }


}
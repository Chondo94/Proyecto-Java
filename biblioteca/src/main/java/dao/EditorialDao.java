/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Editorial;

/**
 *
 * @author estua
 */
public class EditorialDao {

    /**
     * metodo para registrar las categorias
     */
    public static boolean registrar(Editorial e) {
        try {
            String SQL = "INSERT INTO editoriales(nit,nombre,telefono,direccion,email,sitioweb) "
                    + "values(?,?,?,?,?,?);";
            /**
             * aca vamos a llamar a la conexion, para eso creamos esta variable.
             * aca lo que estamos diciendo es que cuando se conecte, esa conexion la aguarde en la variable con.
             * seria nuestra conexion a la base de datos.
            */
            Connection con = Conexion.getConexion();
            /**
             * aca vamos a preparar nuestra consulta.
             */
            PreparedStatement st = con.prepareStatement(SQL);
            /**
             * aca lo que estamos haciendo es enviarle el parametro a la consulta SQL de arriba.
            * que en este caso empezamos con nit, nombre, telefono, direccion, etc.
            * para enviarlo lo hacemos de la siguiente manera, linea 34 o siguiente a esta.
            */
            st.setString(1, e.getNit());
            st.setString(2, e.getNombre());
            st.setString(3, e.getTelefono());
            st.setString(4, e.getDireccion());
            st.setString(5, e.getEmail());
            st.setString(6, e.getSitioweb());
            if (st.executeUpdate() > 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException ex) {
            return false;
        }
    }

    /**
     * metodo para listar las editoriales
     *listar nos sirva para ver la lista de todas las categorias y para eso usamos el arrayList.
     */
    public static ArrayList<Editorial> listar() {
        try {
            //con esta linea lo que decimos es que queremos consultar todas la editoriales.
            String SQL = "select *FROM editoriales";
            //aca vamos a llamar a la conexion, para eso creamos esta variable.
            //aca lo que estamos diciendo es que cuando se conecte, esa conexion la aguarde en la variable con.
            //lo cual nos sirve esta linea, para conectarnos a la base de datos.
            Connection con = Conexion.getConexion();
            //aca vamos a preparar nuestra consulta.
            PreparedStatement st = con.prepareStatement(SQL);
            //aca lo que estamos haciendo es enviarle el parametro a la consulta SQL de arriba.
            //st.setString(1, cat.getNombre());
            //aca en esta linea guardo el resultado de la consulta en la variable consulta.
            ResultSet resultado = st.executeQuery();
            ArrayList<Editorial> lista = new ArrayList<>();
            //aca se creo un objeto llamado Editorial
            Editorial edi;
            //aca lo que le decimos es que mientras resultado encuentre uno nuevo o siguiente
            //que cree una nueva categoria y que asigne el codigo y nombre que hay en ese registro de esa base de datos.
            //el lista.add quiere decir que agregue a la lista esa nueva editorial.
            while (resultado.next()) {
                edi = new Editorial();
                edi.setNit(resultado.getString("nit"));
                edi.setNombre(resultado.getString("nombre"));
                edi.setTelefono(resultado.getString("telefono"));
                edi.setDireccion(resultado.getString("direccion"));
                edi.setEmail(resultado.getString("email"));
                edi.setSitioweb(resultado.getString("sitioweb"));
                lista.add(edi);
            }
            return lista;
        } catch (SQLException ex) {
            return null;
        }
    }

    //este metodo nos sirve para pedir el nombre de la editorial    
    public static String getEditorial(String nit) {
        try {
            //con esta linea lo que decimos es que queremos consultar nombre de la editorial.
            String SQL = "select nombre editoriales where nit=?";
            //aca vamos a llamar a la conexion, para eso creamos esta variable.
            //aca lo que estamos diciendo es que cuando se conecte, esa conexion la aguarde en la variable con.
            //lo cual nos sirve esta linea, para conectarnos a la base de datos.
            Connection con = Conexion.getConexion();
            //aca vamos a preparar nuestra consulta.
            PreparedStatement st = con.prepareStatement(SQL);
            //aca lo que estamos haciendo es enviarle el parametro a la consulta SQL de arriba.
            //st.setString(1, cat.getNombre());
            //aca en esta linea guardo el resultado de la consulta en la variable consulta.
            ResultSet resultado = st.executeQuery();
            //aca lo que le estamos diciendo que si encuentra una editorial que retorno su nombre
            //si no
            if (resultado.next()) {
                return resultado.getString("nombre");
            }
            return "--";
        } catch (SQLException ex) {
            return "--";
        }
    }

}

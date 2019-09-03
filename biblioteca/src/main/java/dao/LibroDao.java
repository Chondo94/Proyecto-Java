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
import model.Libro;

/**
 *
 * @author estua
 */
public class LibroDao {
    //metodo para registrar los Libros

    public static boolean registrar(Libro l) {
        try {
            String SQL = "INSERT INTO libros values(?, ?, ?, ?, ?, (select now()), ?,?)";
            /**
             * aca vamos a llamar a la conexion, para eso creamos esta variable.
             *aca lo que estamos diciendo es que cuando se conecte, esa conexion la aguarde en la variable con.
             *seria nuestra conexion a la base de datos.
             */
            Connection con = Conexion.getConexion();
            /**
             * aca vamos a preparar nuestra consulta.
             */
            PreparedStatement st = con.prepareStatement(SQL);
            /**
             *aca lo que estamos haciendo es enviarle el parametro a la consulta SQL de arriba.
             *que en este caso empezamos con nit, nombre, telefono, direccion, etc.
             *para enviarlo lo hacemos de la siguiente manera, linea 34 o siguiente a esta.
             */
            st.setString(1, l.getIsbn());
            st.setString(2, l.getTitulo());
            st.setString(3, l.getDescripcion());
            st.setString(4, l.getNombre_autor());
            st.setString(5, l.getFecha_registro());
            st.setInt(6, l.getCodigo_categoria());
            st.setString(7, l.getNit_editorial());
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
     * metodo para listar las categorias
     *listar nos sirva para ver la lista de todas las categorias y para eso usamos el arrayList.
     */
    public static ArrayList<Libro> listar() {
        try {
            /**
             * con esta linea lo que decimos es que queremos consultar todas la categorias.
             */
            String SQL = "select *FROM libros";
            /**
             * aca vamos a llamar a la conexion, para eso creamos esta variable.
             *aca lo que estamos diciendo es que cuando se conecte, esa conexion la aguarde en la variable con.
             *lo cual nos sirve esta linea, para conectarnos a la base de datos.
            */
            Connection con = Conexion.getConexion();
            /**
             * aca vamos a preparar nuestra consulta.
             */
            PreparedStatement st = con.prepareStatement(SQL);
            /**aca lo que estamos haciendo es enviarle el parametro a la consulta SQL de arriba.
             *st.setString(1, cat.getNombre());
             *aca en esta linea guardo el resultado de la consulta en la variable consulta.
            */
            ResultSet resultado = st.executeQuery();
            ArrayList<Libro> lista = new ArrayList<>();
            /**
             * aca se creo un objeto llamado categoria
             */
            Libro l;
            /**
            * aca lo que le decimos es que mientras resultado encuentre uno nuevo o siguiente
            * que cree una nueva categoria y que asigne el codigo y nombre que hay en ese registro de esa base de datos.
            * el lista.add quiere decir que agregue a la lista esa nueva categoria.
            */
            while (resultado.next()) {
                l = new Libro();
                l.setIsbn(resultado.getString("isbn"));
                l.setTitulo(resultado.getString("titulo"));
                l.setNombre_autor(resultado.getString("nombre_autor"));
                l.setDescripcion(resultado.getString("descripcion"));
                l.setFecha_registro(resultado.getString("fecha_registro"));
                l.setPublicacion(resultado.getString("publicacion"));
                l.setNit_editorial(resultado.getString("nit_editorial"));
                l.setCodigo_categoria(resultado.getInt("codigo_categoria"));
                lista.add(l);
            }
            return lista;
        } catch (SQLException ex) {
            return null;
        }
    }

}

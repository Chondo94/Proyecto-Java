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
import model.Categoria;

/**
 *
 * @author estua
 */
public class CategoriaDao {

    //metodo para registrar las categorias
    public static boolean registrar(Categoria cat) {
        try {//aca estoy realizando una consulta
            String SQL = "INSERT INTO categorias(nombre) values(?);";
            //aca vamos a llamar a la conexion, para eso creamos esta variable.
            //aca lo que estamos diciendo es que cuando se conecte, esa conexion la aguarde en la variable con.
            Connection con = Conexion.getConexion();
            //aca vamos a preparar nuestra consulta.
            PreparedStatement st = con.prepareStatement(SQL);
            //aca lo que estamos haciendo es enviarle el parametro a la consulta SQL de arriba.
            st.setString(1, cat.getNombre());
            //con esta condicional, digo que si se crea la categoria, que actualiza de lo 
            //contrario que returne a falo.
            if (st.executeUpdate() > 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException ex) {
            return false;
        }
    }

    //metodo para listar las categorias
    //listar nos sirva para ver la lista de todas las categorias y para eso usamos el arrayList.
    public static ArrayList<Categoria> listar() {
        try {
            //con esta linea lo que decimos es que queremos consultar todas la categorias.
            String SQL = "select *FROM categorias;";
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
            ArrayList<Categoria> lista = new ArrayList<>();
            //aca se creo un objeto llamado categoria
            Categoria cat;
            //aca lo que le decimos es que mientras resultado encuentre uno nuevo o siguiente
            //que cree una nueva categoria y que asigne el codigo y nombre que hay en ese registro de esa base de datos.
            //el lista.add quiere decir que agregue a la lista esa nueva categoria.
            while (resultado.next()) {
                cat = new Categoria();
                cat.setCodigo(resultado.getInt("codigo"));
                cat.setNombre(resultado.getString("nombre"));
                lista.add(cat);
            }
            return lista;
        } catch (SQLException ex) {
            return null;
        }
    }

    public static String getCategoria(int cod) {
        try {
            //con esta linea lo que decimos es que queremos consultar el nombre la categorias.
            String SQL = "select nombre from categorias where codigo=?";
            //aca vamos a llamar a la conexion, para eso creamos esta variable.
            //aca lo que estamos diciendo es que cuando se conecte, esa conexion la aguarde en la variable con.
            //lo cual nos sirve esta linea, para conectarnos a la base de datos.
            Connection con = Conexion.getConexion();
            //aca vamos a preparar nuestra consulta.
            PreparedStatement st = con.prepareStatement(SQL);
            //aca lo que estamos haciendo es enviarle el parametro a la consulta SQL de arriba.
            //st.setString(1, cat.getNombre());
            //aca en esta linea guardo el resultado de la consulta en la variable consulta.
            st.setInt(1, cod);
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

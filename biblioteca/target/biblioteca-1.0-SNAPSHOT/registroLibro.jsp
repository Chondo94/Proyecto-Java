<%-- 
    Document   : registroLibro
    Created on : 22/03/2019, 05:39:45 PM
    Author     : estua
--%>

<%@page import="dao.CategoriaDao"%>
<%@page import="model.Categoria"%>
<%@page import="dao.EditorialDao"%>
<%@page import="model.Editorial"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="estilo.css"/>
        <title>JSP Page</title>
    </head>
    <body>
        <h1 class="o">Registrar de Libro</h1>
        <div>
            <!--el nombre del action, es el nombre que va o tiene que llevar el servlets,
            ya que por medio del action se envia y este es el servlet que recibe los datos-->
            <form action="LibroControl" method="post" class="alinear">
                <div class="form-group">
                    <label class="o">
                        ISBN:
                    </label>
                    <div class="o">
                        <input type="text" name="isbn" value="" placeholder="isbn del libro"/>
                    </div>

                </div><br>

                <div class="o">
                    <label class="col-sm-3 control-label no-padding-right">
                        Titulo:
                    </label> 
                    <div class="o">
                        <input type="text" name="titulo" value="" placeholder="Titulo de libro"/>
                    </div> 

                </div><br>

                <div class="form-group">
                    <label class="o">
                        Autor;
                    </label>
                    <div class="col-sm-9">
                        <input type="text" name="autor" value="" placeholder="Autor del libro"/>
                    </div>   
                </div><br>

                <div class="form-group">
                    <label class="o">
                        Fecha Publicacion:
                    </label> 
                    <div class="col-sm-9">
                        <input type="text" name="publicacion" value="" placeholder="2019-03-25"/>
                    </div>   
                </div><br>

                <div class="form-group">
                    <label class="o">
                        Categoria;
                    </label> 
                    <div class="col-sm-9">
                        <select name="categoria">
                            <option value="0">Seleccione una categoria</option>
                            <% for (Categoria c : CategoriaDao.listar()) {%>
                            <option value="<%= c.getCodigo()%>"><%= c.getNombre()%></option>
                            <%}%>
                        </select>   
                    </div> <br> 
                </div>
                <div class="form-group">
                    <label class="o">
                        Editorial;
                    </label> 
                    <div class="col-sm-9">
                        <select name="editorial">
                            <option value="0">Seleccione una editorial</option>
                            <% for (Editorial c : EditorialDao.listar()) {%>
                            <option value="<%= c.getNit()%>"><%= c.getNombre()%></option>
                            <%}%>
                        </select> 
                    </div><br>
                </div>
                <div class="form-group">
                    <label class="o">
                        Descripcion;
                    </label> 
                    <div class="coll-sm-9">
                        <textarea name="descripcion" rows="4" cols="20"></textarea>
                    </div>
                </div><br>
                <input class="alinear2" type="submit" name="accion"  value="Registrar">
                
                <!--<button name="accion" class="btn btn-danger" type="submit">
                    <i class="fa fa-clock-o"></i>
                    Eliminar
                </button>-->
                <div>
                    <!--usamos un if corto(condicional corto) el mensae es que si
                    el mensaje es nulo que imprima nada, de lo contrario que imprima lo que mensaje trae-->
                    <%=(request.getAttribute("mensaje") != null ? request.getAttribute("mensaje") : "")%>
                </div>
            </form>
        </div><br>
        <a href="index.jsp"><button class="alinear">Menu principal</button></a>
    </body>
</html>

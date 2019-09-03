<%-- 
    Document   : listaLibros
    Created on : 24/03/2019, 11:32:01 PM
    Author     : estua
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="estilo.css"/>
        <title>JSP Page</title>
    </head>
    <body>

        <h1 class="o">Bienvenido a la plataforma de Inventario de Libros JE</h1>
        <div class="form-group">
            <a href="registroCategoria.jsp"><button class="alinear">Registrar Categoria</button></a><br><br>
            <a href="registroEditorial.jsp"><button class="alinear">Registrar Editorial</button></a><br><br>
            <a href="registroLibro.jsp"><button class="alinear">Registrar Libro</button></a>
        </div>
        <br>
        <div>
            <table border="2px" id="tabla">
                <thead>
                    <tr class="tab">
                        <th>ISBN</th>
                        <th>Titulo</th>
                        <th>Autor</th>
                        <th>Fecha Publicacion</th>
                        <th>Categoria</th>
                        <th>Nit</th>
                    </tr>
                </thead>

                <tbody>
                    <tr class="tab">
                        <td>01A</td>
                        <td>Mundo de oportunidades</td>
                        <td>Jhon</td>
                        <td>2019-01-23</td>
                        <td>Motivacion</td>
                        <td>7914014-9</td>
                    </tr>
                </tbody>
            </table>
        </div>
    </body>
</html>

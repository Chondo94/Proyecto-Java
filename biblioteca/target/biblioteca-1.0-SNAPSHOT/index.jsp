<%-- 
    Document   : index
    Created on : 22/03/2019, 03:42:15 PM
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
        <h1>Bienvenido Inventario Libros JE</h1>
        <%-- lo que estamos diciendo con esta linea es que cuando se ejecute el index
        que nos redireccione a el jsp indicado y lo comente solo por el momento--%>
        <%--<jsp:forward page="registroCategoria.jsp"></jsp:forward>--%>
        <a href="registroCategoria.jsp"><button>Registrar Categoria</button></a><br><br>
        <a href="registroEditorial.jsp"><button>Registrar Editorial</button></a><br><br>
        <a href="registroLibro.jsp"><button>Registrar Libro</button></a>
        <jsp:forward page="listaLibros.jsp"></jsp:forward>
    </body>
</html>

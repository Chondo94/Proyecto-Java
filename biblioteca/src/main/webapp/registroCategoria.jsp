<%-- 
    Document   : registroCategoria
    Created on : 22/03/2019, 04:20:47 PM
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
        <h1 class="o">Registrar Categoria</h1>
        <div>
            <form action="CategoriaControl" method="post" class="alinear">
                <div class="form-group">
                    <label class="o">
                        Codigo:
                    </label> 
                    <div class="col-sm-9">
                        <input type="text" name="codigo" value="" placeholder="codigo de la categoria"/>
                    </div>

                </div><br>

                <div class="form-group">
                    <label class="o">
                        Nombre:
                    </label> 
                    <div class="col-sm-9">
                        <input type="text" name="nombre" value="" placeholder="Nombre de la categoria"/>
                    </div>   
                </div><br>
                <button class="alinear2" type="submit">
                    <i class="fa fa-save"></i>
                    Registrar
                </button>
                <div>
                    <%/*usamos un if corto(condicional corto) el mensae es que si
                                                                                            el mensaje es nulo que imprima nada, de lo contrario que imprima lo que mensaje trae*/%>
                    <%=(request.getAttribute("mensaje") != null ? request.getAttribute("mensaje") : "")%>
                </div>
            </form>
        </div><br>
        <a href="index.jsp"><button class="alinear">Menu principal</button></a>
    </body>
</html>

<%-- 
    Document   : registroEditorial
    Created on : 22/03/2019, 05:00:05 PM
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
        <h1 class="o">Registrar Editorial</h1>
        <div>
            <!--el nombre del action, es el nombre que va o tiene que llevar el servlets, ya que por medio del action se envia y este es el servlet que recibe los datos-->
            <form action="EditorialControl" method="post" class="alinear">
                <div class="form-group">
                    <label class="o">
                        Nit:
                    </label> 
                    <div class="col-sm-9">
                        <input type="text" name="nit" value="" placeholder="Nit de la editorial"/>
                    </div>

                </div><br>

                <div class="form-group">
                    <label class="o">
                        Nombre:
                    </label> 
                    <div class="col-sm-9">
                        <input type="text" name="nombre" value="" placeholder="Nombre de la editorial"/>
                    </div>   
                </div><br>

                <div class="form-group">
                    <label class="o">
                        Telefono:
                    </label> 
                    <div class="col-sm-9">
                        <input type="text" name="telefono" value="" placeholder="Numero de telefono"/>
                    </div>   
                </div><br>

                <div class="form-group">
                    <label class="o">
                        Direccion;
                    </label> 
                    <div class="col-sm-9">
                        <input type="text" name="direccion" value="" placeholder="Direccion de oficina"/>
                    </div>   
                </div><br>

                <div class="form-group">
                    <label class="o">
                        Email:
                    </label> 
                    <div class="col-sm-9">
                        <input type="text" name="email" value="" placeholder="correo electronico"/>
                    </div>   
                </div><br>

                <div class="form-group">
                    <label class="o">
                        Sitio Web:
                    </label> 
                    <div class="col-sm-9">
                        <input type="text" name="sitioweb" value="" placeholder="Nombre del sitio web"/>
                    </div>   
                </div><br>
                <button type="submit" class="alinear2">
                    <i class="o"></i>
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

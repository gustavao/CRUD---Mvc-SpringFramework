<%-- 
    Document   : editar
    Created on : 9/12/2019, 05:20:25 PM
    Author     : Gustavo Espindola
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
    </head>
    <body>
                <div class="container mt-4 col-lg-4">
            <div class="card border-info">
                <div class="card-header bg-info">
                    <h4>Actualizar Registro</h4>
                </div>
                <div class="card-body">
                    <form method="POST">
                        <label>Nombre</label>
                        <input type="text" name="nom" class="form-control" value="${lista[0].Nombres}">
                        <label>Correo</label>
                        <input type="text" name="correo" class="form-control" value="${lista[0].Correo}">
                        <label>Nacionalidad</label>
                        <input type="text" name="nacio" class="form-control" value="${lista[0].Nacionalidad}">
                        <br>
                        <input type="submit" value="Actualizar" class="btn btn-success" value="">
                        <a href="index.htm">Regresar</a>
                    </form>
                </div>
            </div>
        </div>  
    </body>
</html>

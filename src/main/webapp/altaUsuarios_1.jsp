<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!-- Le agrego esta linea para que copie la plantilla del index -->
<%@ include file="Components/header.jsp"%>
<%@ include file="Components/body1.jsp"%>

<h1>Alta Usuarios</h1>

<form class="user" action="SvUsuarios" method="POST">
    <div class="form-group col">
        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user" id="nombre_usuario" name="nombre_usuario"
                   placeholder="Nombre">
        </div>
        <div class="col-sm-6 mb-3" >
            <input type="password" class="form-control form-control-user" id="password" name="password"
                   placeholder="password">
        </div>
        <div class="col-sm-6 mb-3">
            <input type="rol" class="form-control form-control-user" id="rol" name="rol"
                   placeholder="Rol">
        </div>
    </div>

    <!-- Llamo al Servlet -->
    <button class="btn btn-primary btn-user btn-block" type="submit">
        Crear Usuario
    </button>


</form>

<%@ include file="Components/body2.jsp"%>
<%@page import="logica.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!-- Le agrego esta linea para que copie la plantilla del index -->
<%@ include file="Components/header.jsp"%>
<%@ include file="Components/body1.jsp"%>

<h1>Editar Usuarios</h1>
<p>Este apartado es para modificar un usuario del sistema</p>

<%Usuario usu = (Usuario) request.getSession().getAttribute("usuEditar");

    String nombre = usu.getNombre_usuario();
    String password = usu.getPassword();
    String rol = usu.getRol();

%>

<form class="user" action="SvEditUsuarios" method="POST">
    <div class="form-group col">
        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user" id="nombre_usuario" name="nombre_usuario"
                   placeholder="Nombre" value="<%=nombre%>">
        </div>
        <div class="col-sm-6 mb-3" >
            <input type="password" class="form-control form-control-user" id="password" name="password"
                   placeholder="password" value="<%=password%>">
        </div>
        <div class="col-sm-6 mb-3">
            <input type="rol" class="form-control form-control-user" id="rol" name="rol"
                   placeholder="Rol" value="<%=rol%>">
        </div>
    </div>

    <!-- Llamo al Servlet -->
    <button class="btn btn-primary btn-user btn-block" type="submit">
        Guardar Edicion
    </button>


</form>

<%@ include file="Components/body2.jsp"%>
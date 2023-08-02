<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!-- Le agrego esta linea para que copie la plantilla del index -->
<%@ include file="Components/header.jsp"%>
<%@ include file="Components/body1.jsp"%>

<h1>Alta Odontólogos</h1>

<form class="user">
    <div class="form-group row">
        <div class="col-sm-6 mb-3 mb-sm-0">
            <input type="text" class="form-control form-control-user" id="nombre"
                   placeholder="First Name">
        </div>
        <div class="col-sm-6">
            <input type="text" class="form-control form-control-user" id="apellido"
                   placeholder="Last Name">
        </div>
    </div>

    <div class="form-group row">
        <div class="col-sm-6 mb-3 mb-sm-0">
            <input type="text" class="form-control form-control-user"
                   id="dni" placeholder="DNI">
        </div>
        <div class="col-sm-6">
            <input type="text" class="form-control form-control-user"
                   id="telefono" placeholder="Telefono">
        </div>
    </div>

    <div class="form-group row">
        <div class="col-sm-6 mb-3 mb-sm-0">
            <input type="text" class="form-control form-control-user"
                   id="direccion" placeholder="direccion">
        </div>
        <div class="col-sm-6">
            <input type="text" class="form-control form-control-user"
                   id="fechanac" placeholder="fecha nacimiento">
        </div>
    </div>

    <!-- Acá va lo que respecta a horarios y usuarios-->

    <a href="#" class="btn btn-primary btn-user btn-block">
        Crear Odontólogo
    </a>
    <hr>

</form>

<%@ include file="Components/body2.jsp"%>
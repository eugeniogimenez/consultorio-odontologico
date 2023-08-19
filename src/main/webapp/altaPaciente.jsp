<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!-- Le agrego esta linea para que copie la plantilla del index -->
<%@ include file="Components/header.jsp"%>
<%@ include file="Components/body1.jsp"%>

<h1>Alta Pacientes</h1>
<p>Ingrese los datos solicitados para dar de alta al nuevo paciente</p>

<form class="user" action="SvPaciente" method="POST">
    <div class="form-group col">
        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user" id="nombre" name="nombre"
                   placeholder="Nombre">
        </div>
        <div class="col-sm-6 mb-3" >
            <input type="text" class="form-control form-control-user" id="password" name="apellido"
                   placeholder="Apellido">
        </div>
        <div class="form-check form-check-inline">
            <label class="form-check-label mr-2" for="obra_social">Marque la casilla si tiene obra social </label>
            <input type="checkbox" class="form-check-input ml-2" id="obra_social" name="obra_social">
        </div>
    </div>

    <!-- Llamo al Servlet -->
    <button class="btn btn-primary btn-user btn-block" type="submit">
        Crear Paciente
    </button>


</form>

<%@ include file="Components/body2.jsp"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!-- Le agrego esta linea para que copie la plantilla del index -->
<%@ include file="Components/header.jsp"%>
<%@ include file="Components/body1.jsp"%>

<h1>Alta Odontólogos</h1>

<form class="odonto" action="SvOdontologo" method="POST">
    <div class="form-group row">
        <div class="col-sm-6 mb-3 mb-sm-0">
            <input type="text" class="form-control form-control-user" id="nombre" name="nombre"
                   placeholder="Nombre">
        </div>
        <div class="col-sm-6">
            <input type="text" class="form-control form-control-user" id="apellido" name="apellido"
                   placeholder="Apellido">
        </div>
    </div>



    <!-- Acá va lo que respecta a horarios y usuarios-->

    <!-- Llamo al Servlet -->
    <button class="btn btn-primary btn-user btn-block" type="submit">
        Crear Odontólogo
    </button>

</form>

<%@ include file="Components/body2.jsp"%>
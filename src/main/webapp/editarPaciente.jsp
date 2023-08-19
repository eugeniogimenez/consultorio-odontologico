<%@page import="logica.Paciente"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!-- Le agrego esta linea para que copie la plantilla del index -->
<%@ include file="Components/header.jsp"%>
<%@ include file="Components/body1.jsp"%>

<h1>Editar Pacientes</h1>
<p>Este apartado es para modificar un pacientario del sistema</p>

<%Paciente pacient = (Paciente) request.getSession().getAttribute("pacientEditar");

    String nombre = pacient.getNombre();
    String apellido = pacient.getApellido();
    boolean obraSocial = pacient.isTiene_OS();

%>

<form class="user" action="SvEditPaciente" method="POST">
    <div class="form-group col">
        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user" id="nombre" name="nombre"
                   placeholder="Nombre" value="<%=nombre%>">
        </div>
        <div class="col-sm-6 mb-3" >
            <input type="text" class="form-control form-control-user" id="apellido" name="apellido"
                   placeholder="password" value="<%=apellido%>">
        </div>
        <div class="form-check form-check-inline">
            <label class="form-check-label mr-2" for="obra_social">Marque la casilla si tiene obra social </label>
            <input type="checkbox" class="form-check-input ml-2" id="obra_social" name="obra_social">
        </div>
    </div>

    <!-- Llamo al Servlet -->
    <button class="btn btn-primary btn-user btn-block" type="submit">
        Guardar Edicion
    </button>


</form>

<%@ include file="Components/body2.jsp"%>
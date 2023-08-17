<%@page import="logica.Odontologo"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!-- Le agrego esta linea para que copie la plantilla del index -->
<%@ include file="Components/header.jsp"%>
<%@ include file="Components/body1.jsp"%>

<h1>Editar Odontólogo</h1>

<%Odontologo odonto = (Odontologo) request.getSession().getAttribute("odontoEditar");

    String nombre = odonto.getNombre();
    String apellido = odonto.getApellido();

%>

<form class="odonto" action="SvEditarOdontologo" method="POST">
    <div class="form-group row">
        <div class="col-sm-6 mb-3 mb-sm-0">
            <input type="text" class="form-control form-control-user" id="nombre" name="nombre"
                   placeholder="Nombre" value="<%=nombre%>">
        </div>
        <div class="col-sm-6">
            <input type="text" class="form-control form-control-user" id="apellido" name="apellido"
                   placeholder="Apellido" value="<%=apellido%>">
        </div>
    </div>



    <!-- Acá va lo que respecta a horarios y odontoarios-->

    <!-- Llamo al Servlet -->
    <button class="btn btn-primary btn-user btn-block" type="submit">
        Guardar Cambios
    </button>

</form>

<%@ include file="Components/body2.jsp"%>
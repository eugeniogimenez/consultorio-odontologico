<%@page import="logica.Odontologo"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!-- Le agrego esta linea para que copie la plantilla del index -->
<%@ include file="Components/header.jsp"%>
<%@ include file="Components/body1.jsp"%>

<h1>Alta Turno</h1>

<form class="user" action="SvTurnos" method="POST">
    <div class="form-group col">
        <div class="col-sm-6 mb-3">
            <input type="date" class="form-control form-control-user" id="fecha" name="fecha"
                   placeholder="Fecha">
        </div>
        <div class="col-sm-6 mb-3" >
            <input type="time" class="form-control form-control-user" id="hora" name="hora"
                   placeholder="Hora">
        </div>
        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user" id="afeccion" name="afeccion"
                   placeholder="afeccion">
        </div>
    </div>

    <div class="col-sm-6 mb-3">
        <label for="odontologo">Seleccionar Odontólogo</label>
        <select class="form-control" id="odontologo" name="odontologo">
            <% List<Odontologo> listaOdontologos = (List<Odontologo>) request.getSession().getAttribute("listaOdontologos");
                for (Odontologo odonto : listaOdontologos) {%>
            <option value="<%= odonto.getId()%>"><%= odonto.getNombre() + " " + odonto.getApellido()%></option>
            <% }%>
        </select>
    </div>

    <div class="col-sm-6 mb-3">
        <label for="paciente">Seleccionar Paciente</label>
        <select class="form-control" id="paciente" name="paciente">
            <option value="1">Paciente 1</option>
            <option value="2">Paciente 2</option>
            <!-- Agrega más opciones de pacientes aquí -->
        </select>
    </div>


    <!-- Llamo al Servlet -->
    <button class="btn btn-primary btn-user btn-block" type="submit">
        Crear Turno
    </button>


</form>

<%@ include file="Components/body2.jsp"%>
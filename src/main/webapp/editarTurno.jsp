<%@page import="java.time.LocalTime"%>
<%@page import="java.util.Date"%>
<%@page import="logica.Turno"%>
<%@page import="logica.Paciente"%>
<%@page import="logica.Odontologo"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>



<!-- Le agrego esta linea para que copie la plantilla del index -->
<%@ include file="Components/header.jsp"%>
<%@ include file="Components/body1.jsp"%>

<h1>Editar Turno</h1>
<p>Modifique los datos necesarios y luego presione "Guardar Cambios"</p>

<%    // Llamar a los servlets para obtener las listas de odontólogos y pacientes
    request.getRequestDispatcher("SvOdontologo").include(request, response);
    request.getRequestDispatcher("SvPaciente").include(request, response);
%>


<%
    Turno turno = (Turno) request.getSession().getAttribute("turnoEditar");

    Date fecha = turno.getFecha_turno();
    LocalTime hora = turno.getHora_turno();
    String afeccion = turno.getAfeccion();

%>

<form class="user" action="SvEditTurno" method="POST">

    <div class="form-group col">
        <div class="col-sm-6 mb-3">
            <input type="date" class="form-control form-control-user" id="fecha" name="fecha"
                   placeholder="Fecha" value="<%=fecha%>">
        </div>
        <div class="col-sm-6 mb-3" >
            <input type="time" class="form-control form-control-user" id="hora" name="hora"
                   placeholder="Hora" value="<%=hora%>">
        </div>
        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user" id="afeccion" name="afeccion"
                   placeholder="afeccion" value="<%=afeccion%>">
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
                <% List<Paciente> listaPacientes = (List<Paciente>) request.getSession().getAttribute("listaPacientes");
                    for (Paciente paciente : listaPacientes) {%>
                <option value="<%= paciente.getId()%>"><%= paciente.getNombre() + " " + paciente.getApellido()%></option>
                <% }%>
            </select>
        </div>
    </div>


</div>


<!-- Llamo al Servlet -->
<button class="btn btn-primary btn-user btn-block" type="submit">
    Guardar Cambios
</button>


</form>


<%@ include file="Components/body2.jsp"%>
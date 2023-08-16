<%@page import="logica.Paciente"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!-- Le agrego esta linea para que copie la plantilla del index -->
<%@ include file="Components/header.jsp"%>
<%@ include file="Components/body1.jsp"%>


<!-- Begin Page Content -->
<div class="container-fluid">

    <!-- Page Heading -->
    <h1 class="h3 mb-2 text-gray-800">Ver Pacientes</h1>
    <p class="mb-4">A continuación podrá visualizar la lista completa de Pacientes</p>

    <!-- DataTales Example -->
    <div class="card shadow mb-4">
        <div class="card-header py-3">
            <h6 class="m-0 font-weight-bold text-primary">DataTables Example</h6>
        </div>
        <div class="card-body">
            <div class="table-responsive">
                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">

                    <thead>
                        <tr>
                            <th>id</th>
                            <th>Nombre</th>
                            <th>Apellido</th>
                            <th>Obra Social</th>
                            <th>Lista de Turnos</th>
                            <th style="width: 210px">Acción</th>
                        </tr>
                    </thead>

                    <tfoot>
                        <tr>
                            <th>id</th>
                            <th>Nombre</th>
                            <th>Apellido</th>
                            <th>Obra Social</th>
                            <th>Lista de Turnos</th>
                            <th style="width: 210px">Acción</th>
                        </tr>
                    </tfoot>

                    <%                        List<Paciente> listaPacientes = (List) request.getSession().getAttribute("listaPacientes");
                    %>

                    <tbody>
                        <%
                            for (Paciente pacient : listaPacientes) {
                        %>
                        <tr>
                            <td><%=pacient.getId()%></td>
                            <td><%=pacient.getNombre()%></td>
                            <td><%=pacient.getApellido()%></td>
                            <td><%=pacient.isTiene_OS()%></td>
                            <td><%=pacient.getListaTurnos()%></td>

                            <td style="display:flex; width: 230px;">

                                <form name="eliminar" action="SvElimPacientes" method="POST"> <!-- Para mandar el codigo al Servlet -->
                                    <button type="submit" class="btn btn-primary btn-user btn-block" style="background-color: red; margin-right: 5px;">
                                        <i class="fas fa-trash-alt"></i>Eliminar
                                    </button>
                                    <input type="hidden" name="id" value="<%=pacient.getId()%>"> <!-- Para mandar el codigo al Servlet -->
                                </form>

                                <form name="editar" action="SvEditPacientes" method="GET"> <!-- Para mandar el codigo al Servlet -->
                                    <button type="submit" class="btn btn-primary btn-user btn-block" style="margin-left:5px;">
                                        <i class="fas fa-pen-alt"></i>Editar
                                    </button>
                                    <input type="hidden" name="id" value="<%=pacient.getId()%>"> <!-- Para mandar el codigo al Servlet -->
                                </form>

                            </td>

                        </tr>

                        <%
                            }
                        %>
                    </tbody>

                </table>
            </div>
        </div>
    </div>

</div>
<!-- /.container-fluid -->

</div>
<!-- End of Main Content -->


<!-- Page level custom scripts -->
<script src="js/demo/datatables-demo.js"></script>


<%@ include file="Components/body2.jsp"%>
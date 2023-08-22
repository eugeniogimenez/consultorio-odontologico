package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logica.ControladoraLogica;
import logica.Paciente;

@WebServlet(name = "SvEditPaciente", urlPatterns = {"/SvEditPaciente"})
public class SvEditPaciente extends HttpServlet {

    ControladoraLogica controlLogica = new ControladoraLogica();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    //GET
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        Paciente pacient = controlLogica.traerPaciente(id);

        HttpSession miSession = request.getSession();
        miSession.setAttribute("pacientEditar", pacient);

        response.sendRedirect("editarPaciente.jsp");

    }

    //POST
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");

        String obraSocialStr = request.getParameter("obraSocial");
        boolean obraSocial = obraSocialStr != "";
        //boolean obraSocial = Boolean.parseBoolean(obraSocialStr);

        Paciente pacient = (Paciente) request.getSession().getAttribute("pacientEditar");
        pacient.setNombre(nombre);
        pacient.setApellido(apellido);
        pacient.setTiene_OS(obraSocial);

        controlLogica.editarPaciente(pacient);

        response.sendRedirect("SvPaciente");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}

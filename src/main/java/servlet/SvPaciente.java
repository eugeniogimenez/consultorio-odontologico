package servlet;

import java.io.IOException;
import java.util.ArrayList;

import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logica.ControladoraLogica;
import logica.Paciente;
import logica.Turno;

@WebServlet(name = "SvPaciente", urlPatterns = {"/SvPaciente"})
public class SvPaciente extends HttpServlet {

    ControladoraLogica controlLogica = new ControladoraLogica();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    //GET
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Paciente> listaPacientes = new ArrayList<Paciente>();

        listaPacientes = controlLogica.getPacientes();

        HttpSession miSession = request.getSession();
        miSession.setAttribute("listaPacientes", listaPacientes);

        if (listaPacientes.isEmpty()) {
            // Manejo de caso cuando la lista está vacía
            System.out.println("La lista de pacientes está vacía.");
        }

        response.sendRedirect("verPacientes.jsp");
    }

    //POST
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");

        // Obtener el valor del parámetro de obra social
        String obraSocialStr = request.getParameter("obraSocial");
        boolean obraSocial = Boolean.parseBoolean(obraSocialStr);

        // Obtener la lista de turnos del paciente
        //List<Turno> listaTurnos = controlLogica.getListaDeTurnos();
        // controlLogica.crearPaciente(nombre, apellido, obraSocial, listaTurnos);
        response.sendRedirect("verPacientes.jsp");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}

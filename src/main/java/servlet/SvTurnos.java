package servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logica.ControladoraLogica;
import logica.Odontologo;
import logica.Paciente;
import logica.Turno;

@WebServlet(name = "SvTurnos", urlPatterns = {"/SvTurnos"})
public class SvTurnos extends HttpServlet {

    ControladoraLogica controlLogica = new ControladoraLogica();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    //GET
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Turno> listaTurnos = new ArrayList<Turno>();

        listaTurnos = controlLogica.getTurnos();

        HttpSession miSession = request.getSession();
        miSession.setAttribute("listaTurnos", listaTurnos);

        if (listaTurnos.isEmpty()) {
            // Manejo de caso cuando la lista está vacía
            System.out.println("La lista de turnos está vacía.");
        }

        response.sendRedirect("verTurnos.jsp");

    }

    //POST
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String hora = request.getParameter("hora_turno");
        String afeccion = request.getParameter("afeccion");

        int odontoId = Integer.parseInt(request.getParameter("odontologo"));
        int pacienteId = Integer.parseInt(request.getParameter("paciente"));

        Odontologo odonto = controlLogica.traerOdontologo(odontoId);
        Paciente pacient = controlLogica.traerPaciente(pacienteId);

        //Tratamiento del typo Date
        String fechaStr = request.getParameter("fecha_turno");

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date fecha = null;
        try {
            fecha = dateFormat.parse(fechaStr);
        } catch (ParseException ex) {
            Logger.getLogger(SvTurnos.class.getName()).log(Level.SEVERE, null, ex);
        }

        controlLogica.crearTurno(fecha, hora, afeccion);

        response.sendRedirect("verTurnos.jsp");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}

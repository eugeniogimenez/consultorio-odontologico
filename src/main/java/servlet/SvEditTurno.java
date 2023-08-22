package servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
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

@WebServlet(name = "SvEditTurno", urlPatterns = {"/SvEditTurno"})
public class SvEditTurno extends HttpServlet {

    ControladoraLogica controlLogica = new ControladoraLogica();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    //GET
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        Turno turno = controlLogica.traerTurno(id);

        HttpSession miSession = request.getSession();
        miSession.setAttribute("turnoEditar", turno);

        System.out.println("El turno es: " + turno.getId_turno());
        response.sendRedirect("editarTurno.jsp");

    }

    //POST
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //Fecha
        String fechaStr = request.getParameter("fecha");

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        java.util.Date fecha = null;
        try {
            fecha = dateFormat.parse(fechaStr);
        } catch (ParseException ex) {
            Logger.getLogger(SvTurnos.class.getName()).log(Level.SEVERE, null, ex);
        }

        //Hora
        String horaStr = request.getParameter("hora");
        LocalTime hora = LocalTime.parse(horaStr);

        //Afeccion
        String afeccion = request.getParameter("afeccion");

        //Odontologo
        int odontoId = Integer.parseInt(request.getParameter("odontologo"));
        Odontologo odonto = controlLogica.traerOdontologo(odontoId);
        System.out.println("SvTurno doPost odontoId: " + odontoId);
        System.out.println("SvTurno doPost odonto: " + odonto);

        //Paciente
        String pacienteParam = request.getParameter("paciente");
        System.out.println("SvTurno doPost Valor del parámetro 'paciente': " + pacienteParam);

        int pacienteId = Integer.parseInt(request.getParameter("paciente"));
        Paciente pacient = controlLogica.traerPaciente(pacienteId);

        //
        Turno turno = (Turno) request.getSession().getAttribute("turnoEditar");
        turno.setFecha_turno(fecha);
        turno.setHora_turno(hora);
        turno.setAfeccion(afeccion);
        turno.setOdonto(odonto);
        turno.setPacient(pacient);

        controlLogica.editarTurno(turno);

        response.sendRedirect("SvTurnos");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}

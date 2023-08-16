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
import logica.Odontologo;
import logica.Turno;
import logica.Usuario;

@WebServlet(name = "SvOdontologo", urlPatterns = {"/SvOdontologo"})
public class SvOdontologo extends HttpServlet {

    ControladoraLogica controlLogica = new ControladoraLogica();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    //GET
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Odontologo> listaOdontologos = new ArrayList<Odontologo>();

        listaOdontologos = controlLogica.getOdontologos();

        HttpSession miSession = request.getSession();
        miSession.setAttribute("listaOdontologos", listaOdontologos);

        System.out.println("Odontologo: " + listaOdontologos.get(0));

        response.sendRedirect("verOdontologos.jsp");

    }

    //POST
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String nombre = request.getParameter("nombre_usuario");
        String password = request.getParameter("password");

        List<Turno> turno = controlLogica.getTurnos();

        int usuarioId = Integer.parseInt(request.getParameter("usuario"));
        Usuario usuario = controlLogica.traerUsuario(usuarioId);

        controlLogica.crearOdontologo(nombre, password, turno, usuario);

        response.sendRedirect("verOdontologos.jsp");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}

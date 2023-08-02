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
import logica.Usuario;

@WebServlet(name = "SvUsuarios", urlPatterns = {"/SvUsuarios"})
public class SvUsuarios extends HttpServlet {

    ControladoraLogica controlLogica = new ControladoraLogica();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    //GET
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Usuario> listaUsuarios = new ArrayList<Usuario>();

        listaUsuarios = controlLogica.getUsuarios();

        HttpSession miSession = request.getSession();
        miSession.setAttribute("listaUsuarios", listaUsuarios);

        System.out.println("Usuario: " + listaUsuarios.get(0));

        response.sendRedirect("verUsuarios.jsp");

    }

    //POST
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String nombre = request.getParameter("nombre_usuario");
        String password = request.getParameter("password");
        String rol = request.getParameter("rol");

        controlLogica.crearUsuario(nombre, password, rol);

        response.sendRedirect("verUsuarios.jsp");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}

package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logica.ControladoraLogica;
import logica.Usuario;

@WebServlet(name = "SvEditUsuarios", urlPatterns = {"/SvEditUsuarios"})
public class SvEditUsuarios extends HttpServlet {

    ControladoraLogica controlLogica = new ControladoraLogica();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    //GET
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        Usuario usu = controlLogica.traerUsuario(id);

        HttpSession miSession = request.getSession();
        miSession.setAttribute("usuEditar", usu);

        System.out.println("El usuario es: " + usu.getNombre_usuario());
        response.sendRedirect("editarUsuarios.jsp");

    }

    //POST
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String nombre = request.getParameter("nombre_usuario");
        String password = request.getParameter("password");
        String rol = request.getParameter("rol");

        Usuario usu = (Usuario) request.getSession().getAttribute("usuEditar");
        usu.setNombre_usuario(nombre);
        usu.setPassword(password);
        usu.setRol(rol);

        controlLogica.editarUsuario(usu);

        response.sendRedirect("SvUsuarios");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}

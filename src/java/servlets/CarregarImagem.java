package servlets;

import controller.SessionController;
import dao.UsuarioDetalhesDAO;
import java.io.IOException;
import java.io.OutputStream;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Usuario;
import model.UsuarioDetalhes;

@WebServlet(name = "CarregarImagem", urlPatterns = {"/CarregarImagem"})
public class CarregarImagem extends HttpServlet {
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF8");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);

        Usuario user = SessionController.getCurrent_user();
        UsuarioDetalhes userDetalhes;
        UsuarioDetalhesDAO userDAO = new UsuarioDetalhesDAO();
        userDetalhes = userDAO.readUsuarioDetalhes(user.getUsuario_id());
        
        byte[] imagemStream = userDetalhes.getFoto();
        response.setContentType("image/" + userDetalhes.getFormatoFoto());  
        OutputStream out = response.getOutputStream();  
        out.write(imagemStream);  
        out.flush();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}

package servlets;

import controller.SessionController;
import dao.UsuarioDetalhesDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Usuario;
import model.UsuarioDetalhes;

@WebServlet(name = "RemoverImagem", urlPatterns = {"/RemoverImagem"})
public class RemoverImagem extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF8");

        UsuarioDetalhes userDetalhes = new UsuarioDetalhes();

        Usuario user = SessionController.getCurrent_user();
        userDetalhes.setFoto(null);
        userDetalhes.setFormatoFoto(null);
        userDetalhes.setIdUsuario(user.getUsuario_id());

        String sucesso = new UsuarioDetalhesDAO().updateImagem(userDetalhes);
        if (!sucesso.equals("Sucesso")) {
            request.setAttribute("retorno", "*Não foi possível remover a imagem, tente novamente mais  tarde.");
        }
        request.getRequestDispatcher("/usuarioDetalhes.jsp").forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

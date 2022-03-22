package servlets;

import controller.SessionController;
import dao.UsuarioDetalhesDAO;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import model.Usuario;
import model.UsuarioDetalhes;

@MultipartConfig
@WebServlet(name = "UploadImagem", urlPatterns = {"/UploadImagem"})
public class UploadImagem extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF8");

        try {
            Part foto = request.getPart("imagem");
            if ((foto == null) || (foto.getSubmittedFileName() == "")) {
                request.setAttribute("retorno", "*Selecione uma imagem.");
                request.getRequestDispatcher("/usuarioDetalhes.jsp").forward(request, response);
            }
            String formatoFoto = foto.getSubmittedFileName().substring(foto.getSubmittedFileName().lastIndexOf(".") + 1, foto.getSubmittedFileName().length());
            InputStream conteudoImagem = foto.getInputStream();
            ByteArrayOutputStream output = new ByteArrayOutputStream();
            byte[] buffer = new byte[10240];
            for (int length = 0; (length = conteudoImagem.read(buffer)) > 0;) {
                output.write(buffer, 0, length);
            }
            Usuario user = SessionController.getCurrent_user();
            UsuarioDetalhes userDetalhes = new UsuarioDetalhes();

            userDetalhes.setFoto(output.toByteArray());
            userDetalhes.setFormatoFoto(formatoFoto);
            userDetalhes.setIdUsuario(user.getUsuario_id());

            String sucesso = new UsuarioDetalhesDAO().updateImagem(userDetalhes);
            if (!sucesso.equals("Sucesso")) {
                request.setAttribute("retorno", "*A imagem excedeu o tamanho máximo.");
            }
        } catch (Exception e) {
            request.setAttribute("retorno", "*Selecione uma imagem.");
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

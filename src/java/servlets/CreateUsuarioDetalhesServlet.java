package servlets;

import controller.SessionController;
import dao.UsuarioDetalhesDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Usuario;
import model.UsuarioDetalhes;

@WebServlet(name = "CreateUsuarioDetalhesServlet", urlPatterns = {"/CreateUsuarioDetalhesServlet"})
public class CreateUsuarioDetalhesServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        System.out.println("teste");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CreateVagaServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            
            String msg;
            Usuario user = SessionController.getCurrent_user();             
            UsuarioDetalhesDAO userDAO = new UsuarioDetalhesDAO();
            UsuarioDetalhes usuarioDetalhes = new UsuarioDetalhes();   
            UsuarioDetalhes UsuarioDetalhesVerificar = new UsuarioDetalhes();
            usuarioDetalhes.setNome(request.getParameter("nome"));          
            String[] temp = request.getParameter("datanascimento").split("-");            
            Calendar cal = Calendar.getInstance();
            cal.set(Integer.parseInt(temp[0]),
                    Integer.parseInt(temp[1])-1,
                    Integer.parseInt(temp[2]));            
            usuarioDetalhes.setDataNascimento(new Date(cal.getTimeInMillis()));           
            usuarioDetalhes.setSexo(request.getParameter("sexo"));
            usuarioDetalhes.setEmail(request.getParameter("email"));
            usuarioDetalhes.setCurriculoResumido(request.getParameter("curriculo"));
            
            UsuarioDetalhesVerificar = userDAO.readUsuarioDetalhes(user.getUsuario_id());
            if(UsuarioDetalhesVerificar != null){
                usuarioDetalhes.setIdUsuarioDetalhes(UsuarioDetalhesVerificar.getIdUsuarioDetalhes());
                msg = userDAO.updateUsuarioDetalhes(usuarioDetalhes);
            } else {               
                usuarioDetalhes.setIdUsuario(user.getUsuario_id());
                msg = userDAO.createUsuarioDetalhes(usuarioDetalhes);
            }
            
            if(msg.equals("Sucesso")){
                response.sendRedirect("usuarioDetalhes.jsp");
            } 
            else response.sendRedirect("usuarioDetalhes.jsp?Erro="+"1");
            out.println("</body>");
            out.println("</html>");
        }
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

package servlets;

import controller.VagaController;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.Calendar;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Vagas;

@WebServlet(name = "UpdateVagaServlet", urlPatterns = {"/UpdateVagaServlet"})
public class UpdateVagaServlet extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet UpdateVagaServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            
            Vagas vaga = new Vagas();
            vaga.setIdVaga(Integer.parseInt(request.getParameter("idvaga")));
            vaga.setCargo(request.getParameter("cargo"));
            
            String[] temp = request.getParameter("dataini").split("-");            
            Calendar cal = Calendar.getInstance();
            cal.set(Integer.parseInt(temp[0]),
                    Integer.parseInt(temp[1])-1,
                    Integer.parseInt(temp[2]));
            vaga.setDataIni(new Date(cal.getTimeInMillis()));
            String[] temp2 = request.getParameter("datafim").split("-");            
            Calendar cal2 = Calendar.getInstance();
            cal2.set(Integer.parseInt(temp2[0]),
                    Integer.parseInt(temp2[1])-1,
                    Integer.parseInt(temp2[2]));
            vaga.setDataFim(new Date(cal2.getTimeInMillis()));
            vaga.setFuncao(request.getParameter("funcao"));
            vaga.setObservacao(request.getParameter("observacao"));
            vaga.setRequisitos(request.getParameter("requisitos"));
            vaga.setRequisitos_desejaveis(request.getParameter("requisitosdesejaveis"));
            vaga.setIdEmpresa(Integer.parseInt(request.getParameter("idempresa")));            
            VagaController ctrl = new VagaController();
            String msg = ctrl.alterarVaga(vaga);
            if(msg.equals("Sucesso")) {
                response.sendRedirect("listagem.jsp");
            }
            
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

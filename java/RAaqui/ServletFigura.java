/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RAaqui;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import negocio.IFigura;
import negocio.Retangulo;
import negocio.Triangulo;

@WebServlet(name = "ServletFigura", urlPatterns = {"/ServletFigura"})
public class ServletFigura extends HttpServlet {

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
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Figura</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Resultado dos cálculos</h1>");
            
            // verifica se os inputs foram preenchidos
            if (request.getParameter("base") != null &&
                request.getParameter("altura") != null &&
                request.getParameter("base").length() > 0 &&
                request.getParameter("altura").length() > 0){
            
                float base = Float.parseFloat(request.getParameter("base"));
                float altura = Float.parseFloat(request.getParameter("altura"));
                //float tp = 0, media = 0;
                //Media objMedia = new Media();
                IFigura triangulo = new Triangulo(base, altura);
                IFigura retangulo = new Retangulo(base, altura);
                
                //objMedia.calcularMedia(p1, p2);
                float areaDoTriangulo = triangulo.calcularArea();
                float perimetroDoTriangulo = triangulo.calcularPerimetro();
                
                float areaDoRetangulo = retangulo.calcularArea();
                float perimetroDoRetangulo = retangulo.calcularPerimetro();
                
                
                // recupera dispatcher para fazer encaminhamento
                RequestDispatcher rd = request.getRequestDispatcher("exibeResultado.jsp");
                // inclui o resultado da média como atributo do "request"
                request.setAttribute("resultAreaTriangulo", areaDoTriangulo);
                request.setAttribute("resultPerimetroTriangulo", perimetroDoTriangulo);
                request.setAttribute("resultAreaRetangulo", areaDoRetangulo);
                request.setAttribute("resultPerimetroRetangulo", perimetroDoRetangulo);
                // encaminha para a página a apresentar o resultado
                rd.forward(request, response);
                
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

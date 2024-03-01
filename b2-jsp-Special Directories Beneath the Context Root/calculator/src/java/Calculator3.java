

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns = {"/calculator3"})
public class Calculator3 extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        //để mà lấy giá trị từ request ta dùng getParamter(String name): trả về String
//        double num1 = Double.parseDouble(request.getParameter("num1"));
//        double num2 = Double.parseDouble(request.getParameter("num2"));
        double num1 = request.getParameter("num1").isEmpty() ? 0 : Double.parseDouble(request.getParameter("num1"));
        double num2 = request.getParameter("num2").isEmpty() ? 0 : Double.parseDouble(request.getParameter("num2"));
        String op = request.getParameter("op");
        Object result = 0; 
        switch(op){
            case "Add":
                result = num1 + num2;
                break;
            case "Sub":
                result = num1 - num2;
                break;
            case "Mul":
                result = num1 * num2;
                break;
            case "Div":
                if(num2 == 0){
                    result = "Can't divide by zero";
                }else{
                   result = num1 / num2; 
                }
                break;
        }
        request.setAttribute("result", result);
        //chuyển request và reponce cho calculator3.jsp xửa lí
        request.getRequestDispatcher("/calculator3.jsp").forward(request, response);
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

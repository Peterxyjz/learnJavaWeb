package controllers;

import db.Toy;
import db.ToyFacede;
import java.io.IOException;
import java.util.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author HUY
 */
@WebServlet(name = "ToyController", urlPatterns = {"/toy"})
public class ToyController extends HttpServlet {

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
        String controller = (String) request.getAttribute("controller");
        String action = (String) request.getAttribute("action");

        switch (action) {
            case "index":
                //hiện trang index của toy
                index(request, response);
                break;
            //create: hiện form để điền thông tin ==> xử lí thông tin
            case "create":
                //hiện form create
                create(request, response);
                break;
            case "create_handler":
                //xử lí form
                create_handler(request, response);
                break;
            //edit: hiện form để sửa thông tin ==> xử lí thông tin
            case "edit":
                //hiện form edit
                edit(request, response);
                break;
            case "edit_handler":
                //xử lí edit
                edit_handler(request, response);
                break;
            //delete: hiện form hỏi ngta có muốn xóa hay không ==> xử lí 
//            case "delete":
//                //hiện form edit
//                delete(request, response);
//                break;
//            case "delete_handler":
//                //xử lí edit
//                delete_handler(request, response);
//                break;
        }

    }

    protected void index(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String layout = (String) request.getAttribute("layout");
        try {
            ToyFacede tf = new ToyFacede();
            List<Toy> list = tf.select();
            request.setAttribute("list", list);
        } catch (SQLException e) {
            e.printStackTrace(); //in chi tiết của ngoại lệ (dành cho lập trình viên)
            request.setAttribute("errMsg", "Error when reading toy data");
        }
        request.getRequestDispatcher(layout).forward(request, response);

    }

    protected void create(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String layout = (String) request.getAttribute("layout");
        request.getRequestDispatcher(layout).forward(request, response);
    }

    protected void create_handler(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String layout = (String) request.getAttribute("layout");
        try {
            ToyFacede tf = new ToyFacede();
            //Lấy dữ liệu từ client:
            String id = request.getParameter("id");
            String name = request.getParameter("name");
            double price = Double.parseDouble(request.getParameter("price"));
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date expDate = sdf.parse(request.getParameter("expDate"));
            String brand = request.getParameter("brand");
            //tạo đối tượng toy:
            Toy toy = new Toy();
            toy.setId(id);
            toy.setName(name);
            toy.setPrice(price);
            toy.setExpDate(expDate);
            toy.setBrand(brand);
            //Lưu vào db
            tf.create(toy);
            //chuyển trang về trang index.do
            request.getRequestDispatcher("/toy/index.do").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace(); //in lỗi ở output giống sout
//            request.setAttribute("errMsg", e.toString());
            request.setAttribute("errMsg", "Error when inserting toy data");
            //Cho hiện lại trang create:
            request.setAttribute("action", "create");
            request.getRequestDispatcher(layout).forward(request, response);
        }    
    }
    
    protected void edit(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String layout = (String) request.getAttribute("layout");
        try {
            //Lấy id 
            String id = request.getParameter("id");
            //đọc đối tượng toy từ db
            ToyFacede tf = new ToyFacede();
            Toy toy = tf.select(id);
            request.setAttribute("toy", toy);
        } catch (Exception e) {
            e.printStackTrace(); 
            request.setAttribute("errMsg", "Error when reading toy data");
        }
        request.getRequestDispatcher(layout).forward(request, response);
    }
    
    protected void edit_handler(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String layout = (String) request.getAttribute("layout");
        try {
            ToyFacede tf = new ToyFacede();
            //Lấy dữ liệu từ client:
            String id = request.getParameter("id");
            String name = request.getParameter("name");
            double price = Double.parseDouble(request.getParameter("price"));
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date expDate = sdf.parse(request.getParameter("expDate"));
            String brand = request.getParameter("brand");
            //tạo đối tượng toy:
            Toy toy = new Toy();
            toy.setId(id);
            toy.setName(name);
            toy.setPrice(price);
            toy.setExpDate(expDate);
            toy.setBrand(brand);
            //Lưu toy vào request để hiện lên khi bị ngoại lệ
            request.setAttribute("toy", toy);
            
            //Lưu vào db
            tf.update(toy);
            //chuyển trang về trang index.do
//            request.getRequestDispatcher("/toy/index.do").forward(request, response);
            response.sendRedirect(request.getContextPath() + "/toy/index.do");
        } catch (Exception e) {
            e.printStackTrace(); //in lỗi ở output giống sout
//            request.setAttribute("errMsg", e.toString());
            request.setAttribute("errMsg", "Error when editing toy data");
            //Cho hiện lại trang create:
            request.setAttribute("action", "edit");
            request.getRequestDispatcher(layout).forward(request, response);
        }    
    }
    
//    protected void delete(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        String layout = (String) request.getAttribute("layout");
//        String id = request.getParameter("")
//        request.getRequestDispatcher(layout).forward(request, response);
//    }
//    
//    protected void edit_handler(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        String layout = (String) request.getAttribute("layout");
//        try {
//            ToyFacede tf = new ToyFacede();
//            //Lấy dữ liệu từ client:
//            String id = request.getParameter("id");
//            String name = request.getParameter("name");
//            double price = Double.parseDouble(request.getParameter("price"));
//            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//            Date expDate = sdf.parse(request.getParameter("expDate"));
//            String brand = request.getParameter("brand");
//            //tạo đối tượng toy:
//            Toy toy = new Toy();
//            toy.setId(id);
//            toy.setName(name);
//            toy.setPrice(price);
//            toy.setExpDate(expDate);
//            toy.setBrand(brand);
//            //Lưu toy vào request để hiện lên khi bị ngoại lệ
//            request.setAttribute("toy", toy);
//            
//            //Lưu vào db
//            tf.update(toy);
//            //chuyển trang về trang index.do
////            request.getRequestDispatcher("/toy/index.do").forward(request, response);
//            response.sendRedirect(request.getContextPath() + "/toy/index.do");
//        } catch (Exception e) {
//            e.printStackTrace(); //in lỗi ở output giống sout
////            request.setAttribute("errMsg", e.toString());
//            request.setAttribute("errMsg", "Error when editing toy data");
//            //Cho hiện lại trang create:
//            request.setAttribute("action", "edit");
//            request.getRequestDispatcher(layout).forward(request, response);
//        }    
//    }    
    

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

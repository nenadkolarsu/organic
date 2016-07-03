/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import util.Dao;
import zaposleni.Zaposleni;

@WebServlet(name = "ZaposleniController", urlPatterns = {"/ZaposleniController"})
public class ZaposleniController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private static final String INSERT_OR_EDIT = "/zaposleni.jsp";
    private static final String LIST_USER = "/listaZaposlenih.jsp";    
    private Dao dao;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ZaposleniController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ZaposleniController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }

        //  super();
//        dao = new Dao();
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
//        processRequest(request, response);
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
        dao = new Dao();        
        String forward = "";
        String action = request.getParameter("action");

        if (action.equalsIgnoreCase("delete")) {
            int zaposleniId = Integer.parseInt(request.getParameter("Id"));
            dao.deleteZaposleni(zaposleniId);
            forward = LIST_USER;
            request.setAttribute("zaposleni", dao.getAllZaposleni());
        } else if (action.equalsIgnoreCase("edit")) {
            forward = INSERT_OR_EDIT;
            int Id = Integer.parseInt(request.getParameter("Id"));
            Zaposleni zaposleni = dao.getZaposleniById(Id);
            request.setAttribute("zaposleni", zaposleni);
        } else if (action.equalsIgnoreCase("listaZaposlenih")) {
            forward = LIST_USER;
            request.setAttribute("zaposleni", dao.getAllZaposleni());
        } else {
            forward = INSERT_OR_EDIT;
        }

        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
        
//        			RequestDispatcher rd=request.getRequestDispatcher("welcome");
//			rd.forward(request, response);

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
        // processRequest(request, response);
        
        Zaposleni zaposleni = new Zaposleni();
        zaposleni.setIme(request.getParameter("ime"));
        zaposleni.setAdresa(request.getParameter("adresa"));
        zaposleni.setStarost(Integer.parseInt(request.getParameter("starost")));
/*        try {
            Date dob = new SimpleDateFormat("MM/dd/yyyy").parse(request.getParameter("dob"));
            user.setDob(dob);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        */
        zaposleni.setZarada(Double.parseDouble(request.getParameter("zarada")));
        String zaposleniid = request.getParameter("id");
        if(zaposleniid == null || zaposleniid.isEmpty())
        {
            dao.addZaposleni(zaposleni);
        }
        else
        {
            zaposleni.setId(Integer.parseInt(zaposleniid));
            dao.updateZaposleni(zaposleni);
        }
        RequestDispatcher view = request.getRequestDispatcher(LIST_USER);
        request.setAttribute("zaposleni", dao.getAllZaposleni());
        view.forward(request, response);
    }        
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
//    @Override
//    public String getServletInfo() {
//        return "Short description";
//    }// </editor-fold>

// }

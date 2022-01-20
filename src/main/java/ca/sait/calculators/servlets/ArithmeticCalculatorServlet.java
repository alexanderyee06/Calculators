package ca.sait.calculators.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Alexander Yee
 */
public class ArithmeticCalculatorServlet extends HttpServlet {

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
        request.setAttribute("result", "---");
        getServletContext().getRequestDispatcher("/WEB-INF/arithmeticcalculator.jsp").forward(request, response);
        
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
        
        String firstInput = request.getParameter("firstNum");
        String secondInput = request.getParameter("secNum");
        String message;
        if (firstInput != null && secondInput != null)
        {
            try 
            {
                int firstNum = Integer.parseInt(firstInput);
                int secNum = Integer.parseInt(secondInput);

                if (request.getParameter("operation").equals("add"))
                {
                    request.setAttribute("result", firstNum + secNum); 
                }
                else if (request.getParameter("operation").equals("subtract"))
                {
                    request.setAttribute("result", firstNum - secNum); 
                }
                else if (request.getParameter("operation").equals("multiply"))
                {
                    request.setAttribute("result", firstNum * secNum); 
                }
                else if (request.getParameter("operation").equals("divide"))
                {
                    request.setAttribute("result", (double) firstNum / secNum); 
                }
            }
            catch (Exception ex)
            {
                request.setAttribute("result", "invalid");
            }
        }

        getServletContext().getRequestDispatcher("/WEB-INF/arithmeticcalculator.jsp").forward(request, response);

    }
}

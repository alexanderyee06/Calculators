package ca.sait.calculators.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Determines the next age of the person
 * @author Alexander Yee
 */
public class AgeCalculatorServlet extends HttpServlet {

    


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/WEB-INF/agecalculator.jsp").forward(request, response);
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

      String ageInput = request.getParameter("age");
        String message;
        if (ageInput != null)
        {
        try {
            int age = Integer.parseInt(ageInput);
            age++;
      
            message = String.format("Your age next birthday will be %d", age);
     
            request.setAttribute("message", message);
        }
        catch (Exception ex)
        {
            request.setAttribute("message", "You must give a valid number");
        }
        }
        else
        {
            request.setAttribute("message", "You must give your current age");
        }

        
        getServletContext().getRequestDispatcher("/WEB-INF/agecalculator.jsp").forward(request, response);
   
    }
}

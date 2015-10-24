package com.beat_software.javaweb.controller;

/** Servlet that creates some beans whose properties will
 *  be displayed with the JSP 2.0 expression language.
 *  <p>
 *  From <a href="http://courses.coreservlets.com/Course-Materials/">the
 *  coreservlets.com tutorials on servlets, JSP, Struts, JSF, Ajax, GWT, 
 *  Spring, Hibernate/JPA, and Java programming</a>.
 */


import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

import com.beat_software.javaweb.model.Company;
import com.beat_software.javaweb.model.Employee;
import com.beat_software.javaweb.model.Name;

public class BeanProperties extends HttpServlet {
  @Override
  public void doGet(HttpServletRequest request,
                    HttpServletResponse response)
      throws ServletException, IOException {
    Name name = new Name("Marty", "Hall");
    Company company =
      new Company("coreservlets.com", 
                  "Java EE Training and Consulting");
    Employee employee = new Employee(name, company);
    request.setAttribute("employee", employee);
    RequestDispatcher dispatcher =
      request.getRequestDispatcher("/WEB-INF/results/bean-properties.jsp");
    dispatcher.forward(request, response);
  }
}

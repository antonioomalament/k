package it.unisa.control;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class PageRedirectServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Ottieni il parametro 'page' dalla richiesta
        String page = request.getParameter("page");

        // Verifica se il parametro 'page' è nullo o vuoto
        if (page == null || page.isEmpty()) {
            response.sendRedirect("Home.jsp"); // Reindirizza ad una pagina di default
            return;
        }

        // Converti il valore del parametro in minuscolo per evitare problemi di case sensitivity
        String pageLowerCase = page.toLowerCase();

        // Verifica se il parametro 'page' indica un percorso verso META-INF/context.xml o WEB-INF/web.xml
        if (pageLowerCase.contains("meta-inf/context.xml") || pageLowerCase.contains("web-inf/web.xml")) {
            // Reindirizza ad un'altra pagina sicura
            response.sendRedirect("Home.jsp");
        } else {
            // Procedi con il reindirizzamento alla pagina richiesta
            response.sendRedirect(page);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Chiamare il metodo doGet per gestire le richieste POST come GET
        doGet(request, response);
    }
}

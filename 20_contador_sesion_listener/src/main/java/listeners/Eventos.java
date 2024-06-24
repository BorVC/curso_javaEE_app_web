package listeners;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;

@WebListener
public class Eventos implements ServletContextListener, HttpSessionListener {

	//Creamos 2 listener .Uno para el inicio de sesión y otro para el inicio de aplicación
    public void sessionCreated(HttpSessionEvent se)  { 
        //inicializar atributo de sesión contador
    	HttpSession session = se.getSession();
    	session.setAttribute("contador", 0);
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent se)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
  
    public void contextInitialized(ServletContextEvent sce)  { 
    	//inicializar atributo de aplicación global
         ServletContext context = sce.getServletContext();
         context.setAttribute("global", 0);
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    }
	
}

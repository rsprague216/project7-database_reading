package edu.acc.project7;

import javax.annotation.Resource;
import javax.annotation.sql.DataSourceDefinition;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.sql.DataSource;

/**
 * Web application lifecycle listener.
 *
 * @author Ryan Sprague
 */

@DataSourceDefinition(
        name = "java:app/jdbc/project7_DB",
        className = "org.apache.derby.jdbc.ClientDataSource",
        url = "jdbc:derby://localhost:1527/",
        databaseName = "project7_DB",
        user = "app",
        password = "app")

@WebListener
public class DBSetupListener implements ServletContextListener {
    @Resource(lookup = "java:app/jdbc/project7_DB")
    DataSource dataSource;
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        sce.getServletContext().setAttribute("manager", new BookManager(dataSource));
        System.out.println("++++++++++++++ BOOKS");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("-------------- BOOKS");
    }
}

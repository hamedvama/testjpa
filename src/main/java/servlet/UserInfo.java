package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Person;

@WebServlet(name = "userinfo", urlPatterns = { "/UserInfo" })

public class UserInfo extends HttpServlet {

	private EntityManager manager;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("mysql");
		this.manager = factory.createEntityManager();
		EntityTransaction tx = manager.getTransaction();
		tx.begin();

		createUser(request.getParameter("name"), request.getParameter("firstname"), request.getParameter("age"), "");

		tx.commit();
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		List<Person> listp = manager.createQuery("SELECT e FROM Person as e", Person.class).getResultList();
		out.println("<HTML>\n<BODY>\n" + "<H1>Recapitulatif des informations</H1>\n");

		for (Person person : listp) {
			out.println( "<UL>\n <LI>Prenom: " + person.getName() + " <LI>Prenom: " + person.getFirstname() + "\n" 
		+ " <LI>Age: " + person.getAge() + "\n" + "</UL>\n"+ "");
		}
		out.println("</BODY></HTML>");
		manager.close();
		factory.close();

	}

//	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
//		
//		response.setContentType("text/html");
//		PrintWriter out = response.getWriter();
//		
//		List<Person> listp = manager.createQuery("SELECT e FROM Person as e", Person.class).getResultList();
//		out.println("<HTML>\n<BODY>\n" + "<H1>Recapitulatif des informations</H1>\n" + "<UL>\n" + " <LI>Nom: "
//				+ request.getParameter("name") + "\n");
//
//		for (Person person : listp) {
//			out.println(" <LI>Prenom: " + person.getName() + "\n" + " <LI>Age: " + person.firstname + "\n" + "</UL>\n"
//					+ "");
//		}
//		out.println("</BODY></HTML>");
//	}

	public void createUser(String nom, String prenom, String age, String email) {
		Person user = new Person(nom, prenom, age, email);
		manager.persist(user);
	}
}

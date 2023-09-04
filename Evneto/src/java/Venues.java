import java.io.*;
import java.sql.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class Venues extends HttpServlet {
    
    public void doGet(HttpServletRequest req, HttpServletResponse res)throws IOException, ServletException
    {
        res.setContentType("text/html");
        PrintWriter pw1 = res.getWriter();
        int n=0;
        try
        {
            Class.forName("oracle.jdbc.driver.OracleDriver");//Registering the Type4 Driver
            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","SYSTEM","sandeep02");//last 2 are Id and Password & 3rd last is the version of oracle
            Statement stmt=con.createStatement();//to run a query from outside the database
            String q1 = "select * from provider where status2='false' and profession= 'Venues Selection'";
            ResultSet x = stmt.executeQuery(q1);
            pw1.println("<html><body><center><table width=100% border=2><tr><td>Name</td><td>City</td><td>Prev_Experiance</td><td>price</td><td>Send Request</td></tr>");
            
            while(x.next())// Dynamic fetching of data from database //this process is called dynamic fetch
            {
                n=Integer.parseInt(x.getString(9))+Integer.parseInt(x.getString(9))/10;
                pw1.println("<tr><td>"+x.getString(1)+"</td><td>"+x.getString(5)+"</td><td>"+x.getString(6)+"</td><td>"+n+"</td><td><a href=preq?id="+x.getString(2)+">Send Request</a></td></tr>");
            }
            pw1.println("</table></center></body></html>");
            con.close();
            
        }
        
        catch(Exception e)
        {
            pw1.println(e);
        }
    }
}                                
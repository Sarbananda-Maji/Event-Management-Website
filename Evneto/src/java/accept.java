import java.io.*;
import java.sql.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class accept extends HttpServlet
{
    public void doGet(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException
    {
        res.setContentType("text/html");
        PrintWriter pw1=res.getWriter();
        String eid=req.getParameter("id");  // performing url rewriting
        try
        {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","sandeep02");
            Statement stmt=con.createStatement();
            String q1="update provider set status2='true' where EMAIL_ID='"+eid+"'";
            int x=stmt.executeUpdate(q1);
            if(x>0)
            {
                pw1.println("Offer accepted <a href=provider_home.html>Go to home</a>");
            }
            else
            {
                pw1.println("Verification Failed");
            }
            con.close();
        }
        catch(Exception e)
        {
            pw1.println(e);
        }
    }
}
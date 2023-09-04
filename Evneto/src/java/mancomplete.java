import java.io.*;
import java.sql.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class mancomplete extends HttpServlet
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
            String q1="update manager set status2='false' where EMAIL_ID='"+eid+"'";
            int x=stmt.executeUpdate(q1);
            if(x>0)
            {
                /* pw1.println("<tr><td>"+y.getString(1)+"</td><td>"+y.getString(3)+"</td><td>"+y.getString(4)+
                        "</td><td>"+y.getString(5)+"</td><td><a href=accept?id="+y.getString(6)+">Accept</a></td></tr>");*/
             pw1.println("work completed successfully you can now get other works");
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
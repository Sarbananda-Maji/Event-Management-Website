import java.io.*;
import java.sql.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class admin_grandman extends HttpServlet
{
    public void doGet(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException
    {
        res.setContentType("text/html");
        PrintWriter pw=res.getWriter();
        String eid=req.getParameter("id");  // performing url rewriting
        try
        {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","sandeep02");
            Statement stmt=con.createStatement();
            String q="update manager set status4='true' where EMAIL_ID='"+eid+"'";
            int x1=stmt.executeUpdate(q);
            if(x1>0)
            {
                // This is dynamic updating the page so that only the not verified persons should be visible to admin
            String q1="select * from provider where status4='false'";
            ResultSet x=stmt.executeQuery(q1);
            pw.println("<html>\n" +
"<body>\n" +
"<table width=\"100%\" border=2>\n" +
"<tr>\n" +
"<td>Name</td>\n" +
"<td>Email</td>\n" +
"<td>Profession</td>\n" +
"<td>Previous Experience</td>\n" +
"<td>Wage</td>\n" +
"<td>Grant Permission</td>\n" +
"</tr>");
            while(x.next())
            {
                pw.println("<tr><td>"+x.getString(1)+"</td><td>"+x.getString(2)+"</td><td>"+x.getString(4)+
                        "</td><td>"+x.getString(6)+"</td><td>"+x.getString(9)+"</td><td><a href=admin_grant?id="+x.getString(2)+">Grant Permission</a></td></tr>");
            }
            pw.println("</table>");
            String q2="select * from manager where status4='false'";
            ResultSet x2=stmt.executeQuery(q2);
            pw.println("<table width=100% border=2>" +
"<p>Manager</p>" +
"<table width=\"100%\" border=2>\n" +
"<tr>\n" +
"<td>Name</td>\n" +
"<td>Email</td>\n" +
"<td>Previous Experience</td>\n" +
"<td>Wage</td>\n" +
"<td>Grant Permission</td>\n" +
"</tr>");
            while(x2.next())
            {
                pw.println("<tr><td>"+x2.getString(1)+"</td><td>"+x2.getString(2)+"</td><td>"+x2.getString(5)+
                        "</td><td>"+x2.getString(8)+"</td><td><a href=admin_grandman?id="+x2.getString(2)+">Grant Permission</a></td></tr>");
            }
            pw.println("</table></div></body></html>");
            con.close();
            }
        }
        catch(Exception e)
        {
            pw.println(e);
        }
    }
}
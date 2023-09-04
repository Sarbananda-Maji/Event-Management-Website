import java.io.*;
import java.sql.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class reject extends HttpServlet
{
    public void doGet(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException
    {
        res.setContentType("text/html");
        PrintWriter pw1=res.getWriter();
        String eid=req.getParameter("id");  // performing url rewriting
        try
        {
            HttpSession ses=req.getSession();
            String id1=(String)ses.getAttribute("nid");
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","sandeep02");
            Statement stmt=con.createStatement();
            String q1="update event set status1='false' where EMAILID='"+id1+"'";
            int x=stmt.executeUpdate(q1);
            if(x>0)
            {
                // This is dynamic updating the page so that only the not verified persons should be visible to admin
                String q2="select * from event where status2='false' and status1='"+eid+"'"; // we are updating the table which the admin is viewing
                ResultSet y=stmt.executeQuery(q2);
                pw1.println("<html>\n" +
"<head>\n" +
"<title>\n" +
"Event Details\n" +
"</title>\n" +
"</head>\n" +
"<body>\n" +
"<table width=\"100%\" border=2>\n" +
"<tr>\n" +
"<td>Name</td>\n" +
"<td>Event Venue</td>\n" +
"<td>Time</td>\n" +
"<td>Type of Event</td>\n" +
"<td>Accept</td>\n" +
"<td>Reject</td>\n" +
"</tr>");
             while(y.next())
             {
                 pw1.println("<tr><td>"+y.getString(2)+"</td><td>"+y.getString(4)+"</td><td>"+y.getString(5)+
                        "</td><td>"+y.getString(6)+"</td><td><a href=accept?id="+y.getString(7)+">Accept</a></td><td><a href=reject?id="+y.getString(7)+">Reject</a></td></tr>");
             }
             pw1.println("</table></body></html>");
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
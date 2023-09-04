import java.io.*;
import java.sql.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class provider_details extends HttpServlet
{
    public void doGet(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException
    {
        res.setContentType("text/html");
        PrintWriter pw=res.getWriter();
        String nm1=req.getParameter("n1");
        try
        {
            HttpSession ses=req.getSession();
            ses.setAttribute("nid", nm1);
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","sandeep02");
            Statement stmt=con.createStatement();
            String q1="select * from event where status2='false' and status1='"+nm1+"'";
            ResultSet x=stmt.executeQuery(q1);
            pw.println("<html>\n" +
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
            while(x.next())
            {
                pw.println("<tr><td>"+x.getString(2)+"</td><td>"+x.getString(4)+"</td><td>"+x.getString(5)+
                        "</td><td>"+x.getString(6)+"</td><td><a href=accept?id="+x.getString(7)+">Accept</a></td><td><a href=reject?id="+x.getString(3)+">Reject</a></td></tr>");
            }
            pw.println("</table></div></body></html>");
            con.close();
        }
        catch(Exception e)
        {
            pw.println(e);
        }
    }
}
import java.io.*;
import java.sql.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class admin_pay extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter pw1=resp.getWriter();
        try
        {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","sandeep02");
            Statement stmt=con.createStatement();
            String name = "",email="",venue="",date="",type="",svpEmail="";
            String q1="select * from event where status2='true' and status3='false'";
            String num="";
            ResultSet x=stmt.executeQuery(q1);
            pw1.println("<html>\n" +
"    <head>\n" +
"        <title>Admin Page</title>\n" +
"    </head>\n" +
"    <body>\n" +
"        <table width=\"100%\" border=\"2px\">\n" +
"            <tr>\n" +
"                <td>Name</td>\n" +
"                <td>Email</td>\n" +
"                <td>Event Venue</td>\n" +
"                <td>Date of Event</td>\n" +
"                <td>Event Type</td>\n" +
"                <td>Service Provider EmailId</td>\n" +
                    "<td>Amount</td>\n" +
"                <td>Payment</td>\n" +
"            </tr>");
                while(x.next()){
                    name=x.getString(2);
                    email=x.getString(3);
                    venue=x.getString(4);
                    date=x.getString(5);
                    type=x.getString(6);
                    svpEmail=x.getString(7);
                    String q2="Select * from provider where email_id='"+svpEmail+"'";
                    ResultSet x2=stmt.executeQuery(q2);
                    if(x2.next()){
                        num=x2.getString(9);
                    }
                    pw1.println("<tr><td>"+name+"</td><td>"+email+"</td><td>"+venue+
                        "</td><td>"+date+"</td><td>"+type+"</td><td>"+svpEmail+
                            "</td><td>"+num+"</td><td><a href=admin_pay1?id="+svpEmail+">Pay</a></td></tr>");
                }
                pw1.println("</table>\n" +
"    </body>\n" +
"</html>");
            con.close();
        }
        catch(Exception e)
        {
            pw1.println(e);
        }
    }
}
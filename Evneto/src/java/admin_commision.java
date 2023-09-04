import java.io.*;
import java.sql.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class admin_commision extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter pw1=resp.getWriter();
        try
        {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","sandeep02");
            Statement stmt=con.createStatement();
            String name = "",email="",venue="",date="",type="",mgEmail="";
            String q1="select * from event where status1!='false' and status2='true'";
            ResultSet x=stmt.executeQuery(q1);
            int num=0;
            pw1.println("<html>\n" +
"    <head>\n" +
"        <title>Generate Commission</title>\n" +
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
                    mgEmail=x.getString(7);
                    String q2="Select * from manager where email_id='"+mgEmail+"'";
                    ResultSet x2=stmt.executeQuery(q2);
                    if(x2.next()){
                        num=Integer.parseInt(x2.getString(8));
                        pw1.println("<tr><td>"+name+"</td><td>"+email+"</td><td>"+venue+
                        "</td><td>"+date+"</td><td>"+type+"</td><td>"+mgEmail+
                            "</td><td>"+num+"</td><td><a href=admin_generate?id="+mgEmail+">Generate Commission</a></td></tr>");
                    }
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
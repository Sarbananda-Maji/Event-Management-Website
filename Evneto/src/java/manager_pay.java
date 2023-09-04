import java.io.*;
import java.sql.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class manager_pay extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter pw1=resp.getWriter();
        try
        {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","sandeep02");
            Statement stmt=con.createStatement();
            String nm1 = req.getParameter("n1");
            String nm2 = req.getParameter("n2");
            String q1="Select * from manager where email_id='"+nm1+"' and password='"+nm2+"'";
            ResultSet x2=stmt.executeQuery(q1);
            if(x2.next()){
                String name = "",venue="",date="",type="",mgEmail="";
            String q2="select * from event where status1='"+nm1+"' and status2='true' and status3!='false'";
            ResultSet x=stmt.executeQuery(q2);
            int num=0;
            pw1.println("<html>\n" +
"    <head>\n" +
"        <title>Generate Commission</title>\n" +
"    </head>\n" +
"    <body>\n" +
"        <table width=\"100%\" border=\"2px\">\n" +
"            <tr>\n" +
"                <td>Name</td>\n" +
"                <td>Event Venue</td>\n" +
"                <td>Date of Event</td>\n" +
"                <td>Event Type</td>\n" +
                 "<td>Commission</td>\n" +
"                <td>Payment</td>\n" +
"            </tr>");
                while(x.next()){
                    name=x.getString(2);
                    venue=x.getString(4);
                    date=x.getString(5);
                    type=x.getString(6);
                    mgEmail=x.getString(7);
                    num=Integer.parseInt(x.getString(9));
                    String q3="Select * from manager where email_id='"+mgEmail+"'";
                    ResultSet x3=stmt.executeQuery(q3);
                    if(x3.next()){
                        pw1.println("<tr><td>"+name+"</td><td>"+venue+
                        "</td><td>"+date+"</td><td>"+type+"</td><td>"+num+"</td><td><a href=managerPay_toAdmin?id="+mgEmail+">Pay Commission</a></td></tr>");
                    }
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
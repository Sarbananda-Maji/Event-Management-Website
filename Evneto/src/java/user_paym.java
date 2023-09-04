import java.io.*;
import java.sql.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class user_paym extends HttpServlet
{
    public void doGet(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException
    {
        res.setContentType("text/html");
        PrintWriter pw=res.getWriter();
        String nm2="";
        String nm1=req.getParameter("id");
        String venue="",time="",type="";
        try
        {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","sandeep02");
            Statement stmt=con.createStatement();
            String q3="update event set status2 ='true' where Email_id ='"+nm1+"'";
            int x3=stmt.executeUpdate(q3);
            if(x3>0)
            {
                String q1="select * from event where status2='false' and status1 !='false' and Email_id='"+nm1+"'";
            ResultSet x=stmt.executeQuery(q1);
            /*if(x.next())
            {
                venue=x.getString(4);
                time=x.getString(5);
                type=x.getString(6);
            }*/
            
            pw.println("<html>\n" +
"<head>\n" +
"<title>\n" +
"Event Details\n" +
"</title>\n" +
"</head>\n" +
"<body>\n" +
"<table width=\"100%\" border=2>\n" +
"<tr>\n" +
"<td>Event Venue</td>\n" +
"<td>Time</td>\n" +
"<td>Type of Event</td>\n" +
"<td>Amount</td>\n" +
"<td>Service Provider name</td>\n" +
"<td>Pay</td>\n" +
"</tr>");
            while(x.next())
            {
                /*String q2="select * from event where status2='false' and status1 !='false' and Email_id='"+nm1+"'";
                ResultSet x2=stmt.executeQuery(q2);*/
                /*if(x2.next())
                {
                    nm2=x2.getString(7);
                }*/
                venue=x.getString(4);
                time=x.getString(5);
                type=x.getString(6);
                nm2=x.getString(7);
                String q="select * from provider where Email_id='"+nm2+"'";
                int num=0;
                String name="";
                ResultSet x1=stmt.executeQuery(q);
                if(x1.next())
                {
                    num=Integer.parseInt(x1.getString(9))+Integer.parseInt(x1.getString(9))/10;
                    name=x1.getString(1);
                    pw.println("<tr><td>"+venue+"</td><td>"+time+"</td><td>"+type+
                        "</td><td>"+num+"</td><td>"+name+"</td><td><a href=user_paym?id="+nm1+">Pay</a></td></tr>");
                }
                else
                {
                    String q2="select * from provider where Email_id='"+nm2+"'";
                    ResultSet x2=stmt.executeQuery(q2);
                    if(x2.next())
                    {
                        num=Integer.parseInt(x2.getString(9));
                        name=x1.getString(1);
                        pw.println("<tr><td>"+venue+"</td><td>"+time+"</td><td>"+type+
                        "</td><td>"+num+"</td><td>"+name+"</td><td>"+x1.getString(4)+"</td><td><a href=cancelllation?id="+nm1+">Cancel</a></td></tr>");
                    }
                }
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
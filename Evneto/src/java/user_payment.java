import java.io.*;
import java.sql.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class user_payment extends HttpServlet
{
    public void doGet(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException
    {
        res.setContentType("text/html");
        PrintWriter pw=res.getWriter();
        String nm2="";
        String nm1=req.getParameter("n1");
        String nm3=req.getParameter("n2");
        String venue="",time="",type="";
        try
        {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","sandeep02");
            Statement stmt=con.createStatement();
            
            String q4="select * from user1 where email_id='"+nm1+"' and password= '"+nm3+"'";
            ResultSet x4=stmt.executeQuery(q4);
            if(x4.next())
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
"<td>Service Provider/manager name</td>\n" +
"<td>address</td>\n" +
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
                    String q2="select * from manager where Email_id='"+nm2+"'";
                    ResultSet x2=stmt.executeQuery(q2);
                    if(x2.next())
                    {
                        num=Integer.parseInt(x2.getString(8));
                        name=x2.getString(1);
                        pw.println("<tr><td>"+venue+"</td><td>"+time+"</td><td>"+type+
                        "</td><td>"+num+"</td><td>"+name+"</td><td>"+x2.getString(4)+"</td><td><a href=user_paym?id="+nm1+">pay</a></td></tr>");
                    }
                }
            }
            pw.println("</table></div></body></html>");
            }
            else
            {
                pw.println("Wrong details");
            }
            con.close();
        }
        catch(Exception e)
        {
            pw.println(e);
        }
    }
}
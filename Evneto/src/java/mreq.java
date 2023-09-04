import java.io.*;
import java.sql.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class mreq extends HttpServlet{
    public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException
    {
        res.setContentType("text/html");
        PrintWriter pw=res.getWriter();
        String nm1=req.getParameter("id");
        try
        {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","SYSTEM","sandeep02");
                Statement st=con.createStatement();
                HttpSession ses=req.getSession();
                String ob=(String)ses.getAttribute("new");
                String q="update event set status1= '"+nm1+"' where Email_id='"+ob+"'";
                int x=st.executeUpdate(q);
                if(x>0)
                {
                    pw.println("Request sent successfully");
                }
                else
                {
                    pw.println("Request can't be sent");
                }
                pw.println("<a href=user_CHOOSE.html>Go back to event page</a>");
        }
        catch(Exception e){
            pw.print(e);
        }
    }
}
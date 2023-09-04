import java.io.*;
import java.sql.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class user_feedback extends HttpServlet{
    public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException
    {
        res.setContentType("text/html");
        PrintWriter pw=res.getWriter();
        String nm1=req.getParameter("name");
        String nm2=req.getParameter("email");
        String nm3=req.getParameter("phone");
        String nm4=req.getParameter("behaviour");
        String nm5=req.getParameter("Rating");
        String nm6=req.getParameter("message");
        try
        {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","SYSTEM","sandeep02");
            Statement st=con.createStatement();
            String q="Insert into feedback values ('"+nm1+"','"+nm2+"','"+nm3+"','"+nm4+"','"+nm5+"','"+nm6+"')";
            int x=st.executeUpdate(q);
            if(x>0)
            {
                pw.println("feedback sent successfully");
            }
            else
            {
                pw.println("feedback failed");
            }
            pw.println("<a href=user_home>Go to home page</a>");
        }
        catch(Exception e){
            pw.print(e);
        }
    }
}
import java.io.*;
import java.sql.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class user_signup extends HttpServlet
{
    public void doPost(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException
    {
        res.setContentType("text/html");
        PrintWriter pw=res.getWriter();
        String nm1=req.getParameter("name");
        String nm2=req.getParameter("email");
        String nm3=req.getParameter("pass");
        String nm4=req.getParameter("seq");
        String nm5=req.getParameter("answer");
        try
        {
            if(nm2.equals("sandeep@02") && nm3.equals("sandeep"))
            {
                pw.println("This email can't be used try another email <a href=Manager_sign_up>SIGN UP</a>");
            }
            else
            {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","sandeep02");
                Statement stmt=con.createStatement();
                String query="insert into user1 values ('"+nm1+"','"+nm2+"','"+nm3+"','"+nm4+"','"+nm5+"','"+false+"','"+false+"','"+false+"')";
                int x=stmt.executeUpdate(query);
                if(x>0)
                {
                    pw.println("Registration Successful");
                }
                else
                {
                    pw.println("Rgistration Unsuccessful");
                }
                con.close(); 
            }
        }
        catch(Exception e)
        {}
    }
}
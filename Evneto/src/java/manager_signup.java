import java.io.*;
import java.sql.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class manager_signup extends HttpServlet{
    public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException
    {
        res.setContentType("text/html");
        PrintWriter pw=res.getWriter();
        String nm1=req.getParameter("N1");
        String nm2=req.getParameter("N2");
        String nm3=req.getParameter("N3");
        String nm5=req.getParameter("N5");
        String nm6=req.getParameter("N6");
        String nm7=req.getParameter("N7");
        String nm8=req.getParameter("N8");
        String nm9=req.getParameter("N11");
        try
        {
            if(nm2.equals("sandeep@02") && nm3.equals("sandeep"))
            {
                pw.println("This email can't be used try another email <a href=Manager_sign_up>SIGN UP</a>");
            }
            else
            {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","SYSTEM","sandeep02");
                Statement st=con.createStatement();
                String q="Insert into manager values ('"+nm1+"','"+nm2+"','"+nm3+"','"+nm5+"','"+nm6+"','"+nm7+"','"+nm8+"','"+nm9+"','"+false+"','"+false+"','"+false+"')";
                int x=st.executeUpdate(q);
                if(x>0)
                {
                    pw.println("Manager Registration successful <a href=\"login.html\">Sign In</a>");
                }
                else
                {
                    pw.println("Registration failed");
                }
            }
        }
        catch(Exception e){
            pw.print(e);
        }
    }
}
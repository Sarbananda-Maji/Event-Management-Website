import java.io.*;
import java.sql.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class login1 extends HttpServlet{
    public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException
    {
        res.setContentType("text/html");
        PrintWriter pw=res.getWriter();
        String nm1=req.getParameter("n1");
        String nm2=req.getParameter("n2");
        //String nm3=req.getParameter("n3");
        try
        {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","SYSTEM","sandeep02");
            Statement st=con.createStatement();
            if(nm1.equals("sandeep@02") && nm2.equals("sandeep"))
            {
                pw.println("<!DOCTYPE html>\n" +
"<html lang=\"en\">\n" +
"    <head>\n" +
"        <meta charset=\"UTF-8\">\n" +
"        <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n" +
"        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
"        <title>Event Organize Gallery</title>\n" +
"\n" +
"        <link rel=\"stylesheet\" href=\"https://unpkg.com/swiper/swiper-bundle.min.css\" />\n" +
"\n" +
"        <!-- font awesome cdn link  -->\n" +
"        <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css\">\n" +
"\n" +
"        <!-- custom css file link  -->\n" +
"        <link rel=\"stylesheet\" href=\"adstyle.css\">\n" +
"\n" +
"    </head>\n" +
"    <body>\n" +
"        <header>\n" +
"            <div class=\"main\">\n" +
"                <div class=\"logo\">\n" +
"                    <img src=\"photo/logo2.png\">\n" +
"                </div>\n" +
"            </div>\n" +
"            <div class=\"main\">\n" +
"                <ul>\n" +
"                    <li class=\"active\"><a href=\"admin.html\">Home</a></li>\n" +
"                    <li><a href=\"services.html\">Services</a></li>\n" +
"                    <li><a href=\"gallery.html\">Gallery</a></li>\n" +
"                    <li><a href=\"index.html#about\">About US</a></li>\n" +
"                    <li><a href=\"index.html#contact\">Contact US</a></li>\n" +
"                </ul>\n" +
"            </div>\n" +
"        </header>\n" +
"        <section class=\"userlogin\" id=\"userlogin\">\n" +
"            <center>\n" +
"            <div class=\"username\">\n" +
"                <h1>Admin</h1>\n" +
"            </div>\n" +
"            <div class=\"details\">\n" +
"                <h2> Permission </h2>\n" +
"                <div class=\"but\">\n" +
"                    <ul>\n" +
"                        <li class=\"btn\"><a href=\"admin_show\">Validate</a></li>\n" +
"                    </ul>\n" +
"                </div>\n" +
"                <h2>Payment Status</h2>\n" +
"                <div class=\"but\">\n" +
"                    <ul>\n" +
"                        <li class=\"btn\"><a href=\"admin_pay\">Pay</a></li>\n" +
"                    </ul>\n" +
"                </div>\n" +
"                <h2>Generate Commission</h2>\n" +
"                <div class=\"but\">\n" +
"                    <ul>\n" +
"                    <li class=\"btn\"><a href=\"admin_commision\">Commission</a></li>\n" +
"                    </ul>\n" +
"                </div>\n" +
"                <h2>See Feedback</h2>\n" +
"                <div class=\"but\">\n" +
"                    <ul>\n" +
"                        <li class=\"btn\"><a href=\"admin_feedback\">Feedback</a></li>\n" +
"                    </ul>\n" +
"                </div>\n" +
"            </div>\n" +
"        </center>\n" +
"        </section>\n" +
"    </body>\n" +
"</html>");
            }
            else
            {
                String q2="select * from USER1 where Email_id='"+nm1+"' and password= '"+nm2+"'";
                ResultSet x2=st.executeQuery(q2);
                if(x2.next())
                {
                    pw.println("<!DOCTYPE html>\n" +
"<html lang=\"en\">\n" +
"    <head>\n" +
"        <meta charset=\"UTF-8\">\n" +
"        <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n" +
"        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
"        <title>Event Organise Gallery</title>\n" +
"\n" +
"        <link rel=\"stylesheet\" href=\"https://unpkg.com/swiper/swiper-bundle.min.css\" />\n" +
"\n" +
"        <!-- font awesome cdn link  -->\n" +
"        <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css\">\n" +
"\n" +
"        <!-- custom css file link  -->\n" +
"        <link rel=\"stylesheet\" href=\"flstyle.css\">\n" +
"\n" +
"    </head>\n" +
"    <body>\n" +
"        <header>\n" +
"            <div class=\"main\">\n" +
"                <div class=\"logo\">\n" +
"                    <img src=\"\">\n" +
"                </div>\n" +
"            </div>\n" +
"            <div class=\"main\">\n" +
"                <ul>\n" +
"                    <li class=\"active\"><a href=\"user_home\">Home</a></li>\n" +
"                    <li><a href=\"services.html\">Services</a></li>\n" +
"                    <li><a href=\"gallery.html\">Gallery</a></li>\n" +
"                    <li><a href=\"index.html#about\">About US</a></li>\n" +
"                    <li><a href=\"index.html#contact\">Contact US</a></li>\n" +
"                </ul>\n" +
"            </div>\n" +
"        </header>\n" +
"        <section class=\"userlogin\" id=\"userlogin\">\n" +
"            <center>\n" +
"            <div class=\"username\">\n" +
"                <h1>Welcome !!</h1>\n" +
"            </div>\n" +
"            <div class=\"details\">\n" +
"                <h2>Book Your Event </h2>\n" +
"                <div class=\"but\">\n" +
"                    <ul>\n" +
"                        <li class=\"btn\"><a href=\"user_CHOOSE.html\">Event Details</a></li>\n" +
"                    </ul>\n" +
"                </div>\n" +
"                <h2>Your Payment Status</h2>\n" +
"                <div class=\"but\">\n" +
"                    <ul>\n" +
"                        <li class=\"btn\"><a href=\"user_Pay_Email.html\">Payments</a></li>\n" +
"                    </ul>\n" +
"                </div>\n" +
"                <h2>Cancel your Event Booking</h2>\n" +
"                <div class=\"but\">\n" +
"                    <ul>\n" +
"                    <li class=\"btn\"><a href=\"user_Cancellation_Email.html\">Cancellation</a></li>\n" +
"                    </ul>\n" +
"                </div>\n" +
"                <h2>Your Feedback</h2>\n" +
"                <div class=\"but\">\n" +
"                    <ul>\n" +
"                        <li class=\"btn\"><a href=\"user_feedback.html\">Feedback</a></li>\n" +
"                    </ul>\n" +
"                </div>\n" +
"            </div>\n" +
"        </center>\n" +
"        </section>\n" +
"    </body>\n" +
"</html>");
                }
                else
                {
                    String q="select * from provider where Email_id='"+nm1+"' and password= '"+nm2+"' and status4='true'";
                    ResultSet x=st.executeQuery(q);
                    if(x.next())
                    {
                        pw.println("<!DOCTYPE html>\n" +
"<html lang=\"en\">\n" +
"    <head>\n" +
"        <meta charset=\"UTF-8\">\n" +
"        <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n" +
"        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
"        <title>Event Organise Gallery</title>\n" +
"\n" +
"        <link rel=\"stylesheet\" href=\"https://unpkg.com/swiper/swiper-bundle.min.css\" />\n" +
"\n" +
"        <!-- font awesome cdn link  -->\n" +
"        <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css\">\n" +
"\n" +
"        <!-- custom css file link  -->\n" +
"        <link rel=\"stylesheet\" href=\"pstyle.css\">\n" +
"\n" +
"    </head>\n" +
"    <body>\n" +
"        <header>\n" +
"            <div class=\"main\">\n" +
"                <div class=\"logo\">\n" +
"                    <img src=\"\">\n" +
"                </div>\n" +
"            </div>\n" +
"            <div class=\"main\">\n" +
"                <ul>\n" +
"                    <li><a href=\"provider_home.html\">Home</a></li>\n" +
"                    <li><a href=\"services.html\">Services</a></li>\n" +
"                    <li><a href=\"gallery.html\">Gallery</a></li>\n" +
"                    <li><a href=\"index.html#about\">About US</a></li>\n" +
"                    <li><a href=\"index.html#contact\">Contact US</a></li>\n" +
"                </ul>\n" +
"            </div>\n" +
"        </header>\n" +
"        <section class=\"userlogin\" id=\"userlogin\">\n" +
"            <center>\n" +
"            <div class=\"username\">\n" +
"                <h1>Welcome !!</h1>\n" +
"            </div>\n" +
"            <div class=\"details\">\n" +
"                <h2>Your Pending Requests </h2>\n" +
"                <div class=\"but\">\n" +
"                    <ul>\n" +
"                        <li class=\"btn\"><a href=\"provider_event.html\">Pending Requests</a></li>\n" +
"                    </ul>\n" +
"                </div>\n" +
"                <h2>Your work status</h2>\n" +
"                <div class=\"but\">\n" +
"                    <ul>\n" +
"                        <li class=\"btn\"><a href=\"provider_work.html\">Completed</a></li>\n" +
"                    </ul>\n" +
"                </div>\n" +
"                <h2>Work Page</h2>\n" +
"                <div class=\"but\">\n" +
"                    <ul>\n" +
"                        <li class=\"btn\"><a href=\"provider_service.html\">See Your Worklist</a></li>\n" +
"                    </ul>\n" +
"                </div>\n" +
"                </div>\n" +
"        </center>\n" +
"        </section>\n" +
"    </body>\n" +
"</html>");
                    }
                    else
                    {
                        String q1="select * from MANAGER where Email_id='"+nm1+"' and password= '"+nm2+"' and status4='true'";
                        ResultSet x1=st.executeQuery(q1);
                        if(x1.next())
                        {
                            pw.println("<!DOCTYPE html>\n" +
"<html lang=\"en\">\n" +
"    <head>\n" +
"        <meta charset=\"UTF-8\">\n" +
"        <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n" +
"        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
"        <title>Event Organize Gallery</title>\n" +
"\n" +
"        <link rel=\"stylesheet\" href=\"https://unpkg.com/swiper/swiper-bundle.min.css\" />\n" +
"\n" +
"        <!-- font awesome cdn link  -->\n" +
"        <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css\">\n" +
"\n" +
"        <!-- custom css file link  -->\n" +
"        <link rel=\"stylesheet\" href=\"mnstyle.css\">\n" +
"\n" +
"    </head>\n" +
"    <body>\n" +
"        <header>\n" +
"            <div class=\"main\">\n" +
"                <div class=\"logo\">\n" +
"                    <img src=\"\">\n" +
"                </div>\n" +
"            </div>\n" +
"            <div class=\"main\">\n" +
"                <ul>\n" +
"                    <li><a href=\"manager_page.html\">Home</a></li>\n" +
"                    <li><a href=\"services.html\">Services</a></li>\n" +
"                    <li><a href=\"gallery.html\">Gallery</a></li>\n" +
"                    <li><a href=\"index.html#about\">About US</a></li>\n" +
"                    <li><a href=\"index.html#contact\">Contact US</a></li>\n" +
"                </ul>\n" +
"            </div>\n" +
"        </header>\n" +
"        <section class=\"userlogin\" id=\"userlogin\">\n" +
"            <center>\n" +
"            <div class=\"username\">\n" +
"                <h1>Welcome !!</h1>\n" +
"            </div>\n" +
"            <div class=\"details\">\n" +
"                <h2>Your Pending Requests </h2>\n" +
"                <div class=\"but\">\n" +
"                    <ul>\n" +
"                        <li class=\"btn\"><a href=\"manager_event.html\">Pending Requests</a></li>\n" +
"                    </ul>\n" +
"                </div>\n" +
"                <h2>Your work status</h2>\n" +
"                <div class=\"but\">\n" +
"                    <ul>\n" +
"                        <li class=\"btn\"><a href=\"manager_workcom.html\">Completed</a></li>\n" +
"                    </ul>\n" +
"                </div>\n" +
"                <h2>Work Page</h2>\n" +
"                <div class=\"but\">\n" +
"                    <ul>\n" +
"                        <li class=\"btn\"><a href=\"manager_service.html\">See Your Worklist</a></li>\n" +
"                    </ul>\n" +
"                </div>\n" +
"                <h2>Pay commission</h2>\n" +
"                <div class=\"but\">\n" +
"                    <ul>\n" +
"                        <li class=\"btn\"><a href=\"manager_pay.html\">pay</a></li>\n" +
"                    </ul>\n" +
"                </div>\n" +
"                </div>\n" +
"        </center>\n" +
"        </section>\n" +
"    </body>\n" +
"</html>");
                        }
                        else
                        {
                            pw.println("Login failed"); 
                        }
                }
                }
            }
        }
        catch(Exception e){
            pw.print(e);
        }
    }
}
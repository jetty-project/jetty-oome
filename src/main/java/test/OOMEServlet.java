package test;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/")
public class OOMEServlet extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        try
        {
            System.out.print('x');
            byte buf[] = new byte[1024];
            Arrays.fill(buf,(byte)'a');
            while (true)
            {
                System.out.print('z');
                byte newbuf[] = new byte[buf.length * 2];
                Arrays.fill(newbuf,(byte)'x');
                System.arraycopy(buf,0,newbuf,0,buf.length);
                buf = newbuf;
            }
        }
        catch (Error e)
        {
            System.out.print("!");
            e.printStackTrace(System.err);
        }
    }
}

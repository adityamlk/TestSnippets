package test;
import com.adventnet.nms.util.*;
import com.adventnet.nms.util.RunProcessInterface;

public class Test implements RunProcessInterface
{
    public void callMain(String args[])
    {
	     System.out.println("===== Test started");
    }
    
    public boolean isInitialized()
    {
        return true;
    }
	public void shutDown()
    {
            try
            {
		    System.out.println("ShutDownHook called");
               if(System.getProperty("os.name").startsWith("Linux")) // Could be customized based on your requirement
	    {
	     String mysqlhome=System.getProperty("mysql.home");
	     String commandToExecute = mysqlhome+"/bin/mysqladmin -u --port=93306 root shutdown";
	     //mysqladmin.exe --port=33306 -u root shutdown
	     Runtime.getRuntime().exec(commandToExecute);
	    }
            }catch(Exception e)
            {
                System.err.println("Exception from ShutDownHook");
                e.printStackTrace();
            }

        }
    
}


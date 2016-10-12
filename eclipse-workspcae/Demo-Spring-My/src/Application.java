import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.cg.IService;

public class Application {

	public static void main(String[] args) {
		
		
		ApplicationContext appContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		System.out.println(appContext);
		
		ApplicationContext appContext2 = new FileSystemXmlApplicationContext("config/applicationContext.xml");
		System.out.println(appContext2);
		String msg = (String) appContext.getBean("message");
		System.out.println(msg.length());
		
		IService serviceRef = appContext.getBean("myService",IService.class);
		
		System.out.println(serviceRef.getMessages());
		
		
		System.out.println(appContext.getStartupDate());
		System.out.println(appContext.getDisplayName());
		
	}
}

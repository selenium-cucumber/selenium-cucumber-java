package webdriver.sqa;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.harmonia.qa.webdriver.utilities.BasicWebDriverManager;

/**
 * Provides a thread-safe proxied webdriver
 * 
 * @author jfoley
 */
public class ProxiedWebDriver {

	public static WebDriver getProxiedWebDriver(Object obj) {
		Class<?> klazz = obj.getClass();
		for (int i = 0; i < klazz.getInterfaces().length; i++) {
			System.out.println(klazz.getInterfaces()[i].getName());
		}

		return (WebDriver)Proxy.newProxyInstance(klazz.getClassLoader(), new Class[] { WebDriver.class }, new Handler());
	}

	static class Handler implements InvocationHandler {

		private BasicWebDriverManager manager = BasicWebDriverManager.get();

		@Override
		public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
			return method.invoke(manager.driver(), args);
		}
	}

}

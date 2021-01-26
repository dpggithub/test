package src.exception;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;


/**
 * 动态代理
 */
public class proxy {

    public static void main(String[] args) throws Throwable {
        InvocationHandler handler = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println(method);
                if (method.getName().equals("morning")) {
                    System.out.println("Good morning, " + args[0]);
                }
                return null;
            }
        };
        Hello hello = (Hello) Proxy.newProxyInstance(
                Hello.class.getClassLoader(), // 传入ClassLoader
                new Class[] { Hello.class }, // 传入要实现的接口
                handler); // 传入处理调用方法的InvocationHandler

        hello.morning("Bob");
    }
}

interface Hello {
    void morning(String name) throws Throwable;
}


/**
 * 静态代理
 */
class HelloDynamicProxy implements Hello {
    InvocationHandler handler;

    public HelloDynamicProxy(InvocationHandler handler) {
        this.handler = handler;
    }
    public void morning(String name) throws Throwable {
        handler.invoke(
                handler,
                Hello.class.getMethod("morning", String.class),
                new Object[] { name });
    }

    public static void main(String[] args) throws Throwable {
        Hello H=new HelloDynamicProxy(new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println(method);
                if (method.getName().equals("morning")) {
                    System.out.println("Good morning, " + args[0]);
                }
                return null;
            }
        });
        H.morning("bob");
    }
}


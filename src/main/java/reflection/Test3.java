package reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Test3 {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<Test2.Person> cls= (Class<Test2.Person>) Test2.Person.class;
        Constructor cons= cls.getDeclaredConstructor(String.class,Integer.class);

        Test2.Person person= (Test2.Person) cons.newInstance("呜呜呜",26);

        System.out.println(person.getAge());
        System.out.println(person.getName());
    }
}

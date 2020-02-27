import annotation.Init;
import annotation.Service;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class AnnotationProcessor {
    static Map<String, Object> serviceMap = new HashMap<>();

    public static void main(String[] args)  {

            loadService("SimpleService");
            loadService("LazyService");
            loadService("String");

        for (Map.Entry<String, Object> set: serviceMap.entrySet()) {
            System.out.println(set.getKey()+ " has been created");

        }
    }
    static void loadService(String className) {
        try {
            Class<?>  loadClass = Class.forName(className);
            if (loadClass.isAnnotationPresent(Service.class)){
                try {
                    Object serviceObj = loadClass.getDeclaredConstructor().newInstance();
                    serviceMap.put(className, serviceObj);
                } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
                    System.out.println("Class was found but couldn't create an instance");
                }

            }
        } catch (ClassNotFoundException e) {
            System.out.println("Sorry ClassNotFoundException");
        }


    }


    static void inspectService(Class<?> service ){
        int trigger = 0;
        if(service.isAnnotationPresent(Service.class)){
            Service ann = service.getAnnotation(Service.class);
            System.out.println("Service annotation  found in class "+ service.getSimpleName());
            Method[] methods = service.getMethods();
            for (Method m: methods) {
                if(m.isAnnotationPresent(Init.class)){
                    trigger = 1;
                }
            }
            if (trigger == 0) System.out.println("There are no annotation Init in class " + service.getSimpleName() );
            else System.out.println("Annotation Init  found in class " + service.getSimpleName() );
        }
        else System.out.println("There are no annotation Service in class " + service.getSimpleName());
    }

}

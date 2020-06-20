package Reflection;

import java.lang.annotation.Annotation;
import java.lang.reflect.*;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, NoSuchFieldException, InvocationTargetException, IllegalAccessException, InstantiationException {
        Class type = String.class;

        String string = "Value";
        Class<String> instanceType = (Class<String>)string.getClass();
        Class secondInstanceType = string.getClass();

        System.out.println("Constructors");
        Constructor[] constructors = type.getDeclaredConstructors();
        System.out.println("Number of constructors: " + constructors.length);
        for(Constructor constructor: constructors) {
            System.out.println(constructor+": "+constructor.getModifiers());
            Parameter[] parameters = constructor.getParameters();

            System.out.println("Number of parameters: " + parameters.length);
            for(Parameter parameter: parameters) {
                System.out.println(parameter+": "+parameter.getModifiers());
            }

            System.out.println("---------------------");
        }

        System.out.println("Methods");
        Method[] methods = type.getDeclaredMethods();
        System.out.println("Number of methods: " + constructors.length);
        for(Method method: methods) {
            System.out.println(method+": "+method.getModifiers());
            Parameter[] parameters = method.getParameters();

            System.out.println("Number of parameters: " + parameters.length);
            for(Parameter parameter: parameters) {
                System.out.println(parameter+": "+parameter.getModifiers());
            }

            System.out.println("Parameter annotations");
            Annotation[][] parametersAnnotations = method.getParameterAnnotations();
            for(Annotation[] annotationList: parametersAnnotations) {
                for(Annotation annotation: annotationList) {
                    System.out.println(annotation);
                }
                System.out.println("======================");
            }
            System.out.println("---------------------");
        }

        String first = "first";
        String second = "second";

        Method toStringMethod = type.getMethod("toString");
        System.out.println("Fields");
        Field[] fields = type.getFields();
        System.out.println("Number of fields: " + fields.length);
        for(Field field: fields) {
            System.out.println(field+": "+field.getModifiers());
            System.out.println("Field value: " + field.get(first));
            System.out.println("---------------------");
        }

        System.out.println("Annotations");
        Annotation[] annotations = Annotations.Main.class.getAnnotations();
        for(Annotation annotation: annotations) {
            System.out.println(annotation);
        }

        System.out.println("Extensions");
        System.out.println("Parent: " + type.getSuperclass());
        System.out.println("Interfaces");

        Class[] interfaces = type.getInterfaces();
        for(Class interfaceInstance: interfaces) {
            System.out.println("Interfaces: " + interfaceInstance);
        }

        Class<String> genericStringClass = String.class;
        String stringObject = genericStringClass.newInstance();

        Class secondGenericStringClass = String.class;
        String secondStringObject = (String)secondGenericStringClass.newInstance();
    }
}


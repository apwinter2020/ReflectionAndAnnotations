package Reflection.Implementations;

import java.lang.reflect.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) throws MalformedURLException, ClassNotFoundException, IllegalAccessException, InstantiationException, InvocationTargetException, NoSuchMethodException, NoSuchFieldException {

        System.out.println(String.class.getName());
        Class stringClass = Class.forName("java.lang.String");
        System.out.println(stringClass.getMethods()[3]);

        Object array1 = Array.newInstance(Class.forName("java.lang.String"),10);
        Object array2 = Array.newInstance(stringClass,5);

        System.out.println(array1.getClass().getName());

        Class stringArrayClass = Class.forName("[Ljava.lang.String;");
        Constructor[] constructors = stringArrayClass.getDeclaredConstructors();

        String[][] multiDimensionalArray1 = new String[3][3];
        System.out.println(multiDimensionalArray1.getClass());

        String[][] multiDimensionalArray2 = (String[][])Array.newInstance(String.class, new int[]{3,4});
        String[][] multiDimensionalArray3 = (String[][])Array.newInstance(String.class, 5,2);

        System.out.println(Integer.class.getName());
        Integer[] integerArray1 = new Integer[6];
        Integer[] integerArray2 = (Integer[]) Array.newInstance(Class.forName("java.lang.Integer"),6);
        Integer[] integerArray3 = (Integer[]) Array.newInstance(Integer.class,6);

        System.out.println(int.class.getName());
//        Class.forName("int");

        int[] intArray = new int[4];
        //Integer[] intArray2 = (Integer[]) Array.newInstance(Class.forName("int"),4);
        int[] intArray3 = (int[]) Array.newInstance(int.class,4);
        System.out.println(intArray.getClass().getName());

        double[] doubleArray = new double[4];
        System.out.println(doubleArray.getClass().getName());

        URL[] urls = {new URL("file://C:/Users/Hima/Desktop/project/IO-Streams/out/production/IO-Streams/")};
        URLClassLoader urlClassLoader = new URLClassLoader(urls);

        Class loadedClass = urlClassLoader.loadClass("ObjectsPackage.SampleChild");
        System.out.println(loadedClass.getName());
        Object instance = loadedClass.newInstance();
        System.out.println(instance.toString());

        Class secondLoadedClass = urlClassLoader.loadClass("ObjectsPackage.SampleChild");
        System.out.println(secondLoadedClass.getName());
        Constructor secondConstructor = secondLoadedClass.getConstructor(String.class);
        Object secondInstance = secondConstructor.newInstance("Reflected name");
        System.out.println(secondInstance.toString());

        Class thirdLoadedClass = urlClassLoader.loadClass("ObjectsPackage.SampleObject");
        System.out.println(thirdLoadedClass.getName());
        Constructor thirdConstructor = thirdLoadedClass.getConstructor(String.class);
        Object thirdInstance = thirdConstructor.newInstance("Reflected object");
        System.out.println(thirdInstance.toString());
        Method thirdMethod = thirdLoadedClass.getMethod("toString");
        System.out.println(thirdMethod.invoke(thirdInstance));
        Method secondThirdMethod = thirdLoadedClass.getDeclaredMethod("privateToString");
        secondThirdMethod.setAccessible(true);
        System.out.println(secondThirdMethod.invoke(thirdInstance));
        Field thirdField = thirdLoadedClass.getDeclaredField("name");
        thirdField.setAccessible(true);
        thirdField.set(thirdInstance, "Changed name");
        System.out.println(secondThirdMethod.invoke(thirdInstance));
    }
}

package ru.sbt.jschool.session1;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import java.util.Properties;


public class task4 {
    public static void main(String[] args) {
        String t = "JSCHOOL1_COUNT";
        String b = "JSCHOOL1_PROPERTIES_FILE";
        if (args.length > 0) {
            for (String arg : args) {
                try {
                    if (arg.startsWith(t)) {
                        helloWorld(Integer.parseInt(arg.substring(15, arg.length())));
                        System.out.println();
                        return;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Параметр введен некорректно");
                    System.out.println();
                }
            }
        }
        if (System.getProperty(t) != null) {
             if (!(System.getProperty(t).isEmpty())) {
                    helloWorld(Integer.parseInt(System.getProperty(t)));
                    return;
                }
            }
        else if (System.getenv(t) != null) {
             if (!(System.getenv(t).isEmpty())) {
                    helloWorld(Integer.parseInt(System.getenv(t)));
                    return;
                }
            }
        else if (System.getenv(b) != null) {
            String filePath = System.getenv(b);
            try {
                Properties p = new Properties();
                FileInputStream _p = new FileInputStream(filePath);
                p.load(_p);
                helloWorld(Integer.parseInt(p.getProperty(t)));
                return;
            } catch (IOException e){
                e.printStackTrace();
            }
        }
        else {
                System.out.println("Программа выводит 'Hello World!' количество раз, преданное: ");
                System.out.println("1.Если передан параметр вида JSCHOOl1_COUNT=XXX, где XXX число раз, то используется оно. \n" +
                        " 2. Если передана системная настройка вида JSCHOOl1_COUNT=XXX, где XXX число раз, то используется оно. \n" +
                        " 3. Если определена переменная окружения вида JSCHOOl1_COUNT=XXX, где XXX число раз, то используется оно. \n" +
                        " 4. Если определена переменная окружения вида JSCHOOL1_PROPERTIES_FILE=XXX, где XXX это путь к существующему файлу," +
                        " то загружает настройки оттуда и пытаемся получить настройку оттуда.");
            }
        }
    public static void helloWorld (int x){
        String h = "Hello world! ";
        for (int i = 0; i < x; i++) {
            System.out.println(h);
        }
    }
}
 /*List<String> prop = new ArrayList<>();
            try (Stream<String> stream = Files.lines(Paths.get(filePath))) {
                prop = stream.collect(Collectors.toList());
            } catch (IOException e) {
                e.printStackTrace();
            }
            String r = prop.toString();
            if (r.substring(1, 15).equals(t)) {
                helloWorld(Integer.parseInt(r.substring(16, r.length() - 1)));
            }*/
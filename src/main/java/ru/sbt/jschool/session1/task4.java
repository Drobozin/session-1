package ru.sbt.jschool.session1;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class task4 {
    public static void main (String [] args) {
        String t = "JSCHOOL1_COUNT";
        String h = "Hello world! ";
        String b = "JSCHOOL1_PROPERTIES_FILE";
        if (args.length > 0) {
            for (String arg : args) {
                if (arg.substring(0, 14).equals(t)) {
                    int x = Integer.parseInt(arg.substring(15, arg.length()));
                    for (int i = 0; i < x; i++) {
                        System.out.println(h);
                    }
                }
            }
        }
        else if (System.getProperty(t) != null){
             if(!(System.getProperty(t).isEmpty())) {
                int x = Integer.parseInt(System.getProperty(t));
                for (int i = 0; i < x; ++i) {
                    System.out.println(h);
                }
             }
        }
        else if(System.getenv(t) != null){
             if (!(System.getenv(t).isEmpty())) {
                int x = Integer.parseInt(System.getenv(t));
                for (int i = 0; i < x; ++i) {
                    System.out.println(h);
                }
             }
        }
        else if(System.getenv(b) != null){
             String filePath = System.getenv(b);
             List<String> prop = new ArrayList<>();

             try(Stream<String> stream = Files.lines(Paths.get(filePath))){
                 prop = stream.collect(Collectors.toList());
             } catch (IOException e){
                 e.printStackTrace();
             }
             String r = prop.toString();
             if (r.substring(1, 15).equals(t)) {
                 int x = Integer.parseInt(r.substring(16, r.length()-1));
                 for (int i = 0; i < x; i++) {
                    System.out.println(h);
                 }
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
}


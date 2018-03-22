package ru.sbt.jschool.session1;

import java.util.Map;
import java.util.Properties;

public class task3 {
    public static void main (String[] args){
        Map<String, String> env =  System.getenv();
        for (String envName : env.keySet()){
            System.out.format("%s=%s%n", envName, env.get(envName));
        }


    }
}

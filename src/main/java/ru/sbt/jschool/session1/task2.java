package ru.sbt.jschool.session1;

import java.util.Properties;

public class task2 {
    public static void main (String [] args){
        Properties vers = System.getProperties();
        vers.list(System.out);
    }
}

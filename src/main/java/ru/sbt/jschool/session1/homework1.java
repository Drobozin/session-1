package ru.sbt.jschool.session1;

import java.io.Console;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Если передан аргумент командной строки вида `name=XXX`, то возвращается он.
 * Если существует системная настройка вида `name=XXX`, то возвращается её значение.
 * Если определена переменная окружения вида `name=XXX`, то используется она.
 * Если property файл, находящийся по пути, переданном в конструкторе содержит настройку name, то используется она.
 * Если ничего не задано, возвращается null.
 *
 *
 * Реализация должна иметь конструктор, принимающий на вход:
 *  <ul>
 *      <li>String[] args, аргументы командной строки.</li>
 *      <li>String path, путь к property-файлу для использования.</li>
 *  </ul>
 */
public class homework1 implements PropertyHelper {
    String[] args;
    String path;

    public homework1(String[] args, String path){
        this.args = args;
        this.path = path;
    }

    @Override
    public String stringValue(String name) {
        if (args != null) {
            for (String arg : args) {
                if (arg.startsWith(name)) {
                    return arg.substring(arg.indexOf("=") + 1, arg.length());
                }
            }
        }
        if (System.getProperty(name) != null) {
             if (!(System.getProperty(name).isEmpty())) {
                return System.getProperty(name);
             }
        }
        if (System.getenv(name) != null) {
             if (!(System.getenv(name).isEmpty())) {
                return (System.getenv(name));
             }
        }
        if (path != null) {
            try {
                Properties p = new Properties();
                FileInputStream _p = new FileInputStream(path);
                p.load(_p);
                return p.getProperty(name);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else {
            return null;
        }
        return name;
    }

    @Override
    public Integer integerValue(String name) {
        return Integer.parseInt(stringValue(name));
    }

    @Override
    public Double doubleValue(String name) {
        return Double.parseDouble(stringValue(name));
    }

    public static void main (String [] args){
        homework1 test = new homework1(args, null);
        System.out.println(test.stringValue("zxc"));

    }

}

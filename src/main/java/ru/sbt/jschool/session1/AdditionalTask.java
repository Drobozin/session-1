package ru.sbt.jschool.session1;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * 1. На вход подаётся строка, содержащее число в бинарной системе счичсления.
 *    Нужно вернуть десятичное число(long) public long binaryToDec(String binary);
 * 2. На вход подаются 2 строки, содержащие двоичные числа - вернуть число, содержащую сумму этих чисел
 *    в двоичной системе счисления. public long sumOfBinary(String b1, String b2);
 * 3. На вход методу подаётся два массива long. Вернуть элементы, которые встречаются в обоих массивах
 *    public long[] intersection(long[] arr1, long[] arr2);
 */
public class AdditionalTask {
    public static void main (String[] args){
        String x = "1011";
        String z = "10110";
        long[] arr1 = {1, 2, 3, 6, 8, 123};
        long[] arr2 = {2, 3, 4, 8, 123, 76};
        long[] arr3 = intersection(arr1, arr2);

        System.out.println(binaryToDec(x));
        System.out.println(sumOfBinary(x, z));
        for (long i: arr3) {
            System.out.print(" " + i);
        }
    }

    public static long binaryToDec(String binary){
            long result = 0;
            String[] temp = binary.split("");
            for (int i = 0; i < binary.length(); ++i){
                try{
                    if (Long.parseLong(temp[i]) !=0 && Long.parseLong(temp[i]) !=1){
                        System.out.println("Введено число не в бинарной системе");
                        return 0;
                    }
                    else if(Long.parseLong(temp[i]) == 1){
                        result += Math.pow(2, Double.parseDouble(String.valueOf(i)));
                    }
                }catch (NumberFormatException e){
                    System.out.println("Некорректный ввод. Введите число в бинарной системе");
                    return 0;
                }

            }return result;
    }
    public static long sumOfBinary(String b1, String b2){
          long rb1 = 0;
          long rb2 = 0;
          String[] _b1 = b1.split("");
          String[] _b2 = b2.split("");
          try {
              for (int i = 0; i < _b1.length; ++i) {
                  if (Long.parseLong(_b1[i]) != 0 && Long.parseLong(_b1[i]) != 1) {
                      System.out.println("Число №1 введено не в бинарной системе");
                      return 0;
                  }
              }

              for (int i = 0; i < _b2.length; ++i) {
                  if (Long.parseLong(_b2[i]) != 0 && Long.parseLong(_b2[i]) != 1) {
                      System.out.println("Число №2 введено не в бинарной системе");
                      return 0;
                  }
              }
          }catch (NumberFormatException e){
              System.out.println("Некорректный ввод. Введите число в бинарной системе");
              return 0;
          }
          rb1 = Long.parseLong(b1, 2);
          rb2 = Long.parseLong(b2, 2);
          long result = Long.parseLong(Long.toBinaryString(rb1 + rb2));
          return result;
    }
    public static long[] intersection(long[] arr1, long[] arr2){
        ArrayList<Long> arrayList = new ArrayList<Long>();
        ArrayList<Long> rList = new ArrayList<Long>();
            for (long i : arr1) {
                arrayList.add(i);
            }
            for (long i:arr2) {
                if(arrayList.contains(i)){
                    rList.add(i);
                }
            }
        long[] result = new long[rList.size()];
        for (int i = 0; i < result.length; ++i){
            result[i] = rList.get(i).longValue();
        }
        return result;
    }

}

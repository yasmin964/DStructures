package DStructers_algorithms;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
//работа кода:
//1 - добавление контакта: Иванов 134
//2 - вывести всех
//3 - выход
public class phoneNum {
    // Str key - surname, int value - phone number
    // ArrayList<Integer> - [134, 122...]
    public static void addNumber(String sur, int num, Map<String, ArrayList<Integer>> map){
        if(map.containsKey(sur)){
            map.get(sur).add(num);//если имеется фамилия -> добавляем только номер этого человека
        }else{
            ArrayList<Integer> arr = new ArrayList<>();
            arr.add(num);
            map.put(sur, arr);//создаем новый arr, чтобы добавить нового чел
        }
    }
    // на вход только map
    public static void printBook(Map<String, ArrayList<Integer>> map) {
        for (var item : map.entrySet()) {//используется для перебора пар ключ-значение в карте с использованием цикла
            String phones = "";
            for (int el : item.getValue()) {
                phones = phones + el + ", ";
            }
            System.out.printf("%s: %s \n", item.getKey(), phones);
        }
    }
        public static void main(String[] args) {
            Map<String, ArrayList<Integer>> bookPhone = new HashMap<>();
            addNumber("Ivanov", 123, bookPhone);
            addNumber("Ivanov", 1234, bookPhone);
            addNumber("Petrov", 546585, bookPhone);
            addNumber("Sidorov", 8956477, bookPhone);
            addNumber("Ivanov", 12356233, bookPhone);
            addNumber("Petrov", 787897, bookPhone);
            printBook(bookPhone);
        }
    }


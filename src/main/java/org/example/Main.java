package org.example;


import org.example.entity.Employee;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        List<Employee> employees = new LinkedList<>();
        employees.add(new Employee(1,"Oğuz", "Samsa"));
        employees.add(new Employee(2,"Ali", "Veli"));
        employees.add(new Employee(3,"Ahmet","Mehmet"));
        employees.add(new Employee(1,"Oğuz","Samsa"));
        System.out.println(employees);;

        System.out.println("Duplicates: " + findDuplicates(employees));
        System.out.println("Uniques: " + findUniques(employees));
        System.out.println("Duplicates removed: " + removeDuplicates(employees));
    }

    public static List<Employee> findDuplicates(List<Employee> input){
        List<Employee> duplicates = new ArrayList<>();
        Set<Employee> uniqueItems = new HashSet<>();

        for (Employee item: input){
            if(item==null){
                continue;
            }
            if(!uniqueItems.add(item)){
                duplicates.add(item);
            }
        }

        return duplicates;
    }

    public static Map<Integer, Employee> findUniques(List<Employee> input){
        Map<Integer, Employee> result = new HashMap<>();
        for(Employee item: input){
            if(item==null){
                continue;
            }
            if(!result.containsKey(item.getId())){
                result.put(item.getId(), item);
            }
        }

        return result;
    }

    public static List<Employee> removeDuplicates(List<Employee> input){
        Set<Employee> uniqueSet = new HashSet<>();
        Set<Employee> duplicates = new HashSet<>();
        List<Employee> result = new ArrayList<>();

        for (Employee item : input) {

            if (item == null) {
                continue;
            }

            if(!uniqueSet.add(item)) {
                duplicates.add(item);
            }
        }

        for(Employee item: input) {

            if(item == null) {
                continue;
            }
            if(!duplicates.contains(item)){
                result.add(item);
            }
        }

        return result;

    }



}
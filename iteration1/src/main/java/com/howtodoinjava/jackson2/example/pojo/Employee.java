package com.howtodoinjava.jackson2.example.pojo;

public class Employee {
   // ObjectMapper mapper = new ObjectMapper();
   // mapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);

        private Integer id;
        private String name;
        private Integer age;
        private String location;

        public Employee(){
        System.out.println("Default constructor");
        }

        public Employee(Integer id, String name, Integer age, String location) {
            //super();
            System.out.println("constructor");
            this.id = id;
            this.name = name;
            this.age = age;
            this.location = location;
        }
}

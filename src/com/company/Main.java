package com.company;

import java.sql.*;
import java.util.Scanner;

public class Main extends ListService {

    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/","postgres","password");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        String insertSQL = "INSERT INTO table('id', 'email', 'description')";


        Statement statement = connection.prepareStatement(insertSQL, statement.RETURN_GENERATED_KEYS);

     /*   String query = "INSERT INTO ....";
        PreparedStatement preparedStatement = connection.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);

        preparedStatement.setXXX(1, VALUE);
        preparedStatement.setXXX(2, VALUE);
        preparedStatement.executeUpdate();

        ResultSet rs = preparedStatement.getGeneratedKeys();
        int key = rs.next() ? rs.getInt(1) : 0;*/



        System.out.println("Выберите вариант:" );
        System.out.println("1 Показать таблицу");
        System.out.println("2 Внести данные ");
        System.out.println("3 Удалить данные");

        int num = sc.nextInt();
        PeopleRepository peopleRepository = new PeopleRepository();

        if (num == 2) {

            System.out.println("Введите id: ");
            peopleRepository.setId(sc.nextInt());
            System.out.println("Введите почту: ");
            peopleRepository.setEmail(sc.next());
            System.out.println("Описание: ");
            peopleRepository.setDescription(sc.next());

            try {
                statement.setCursorName(Integer.toString(peopleRepository.getId()));
                statement.setCursorName(peopleRepository.getEmail());
                statement.setCursorName(peopleRepository.getDescription());
            } catch (SQLException e) {
                e.printStackTrace();
            }


            System.out.println(peopleRepository.getId());
            System.out.println(peopleRepository.getEmail());
            System.out.println(peopleRepository.getDescription());

        }








    }
}

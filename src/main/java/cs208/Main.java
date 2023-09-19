package cs208;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main
{
    public static Database database;

    public static void main(String[] args)
    {
        System.out.println("Starting the School Management System: Java API Server...");
        System.out.println("The server will listen on port 8080...");
        System.out.println("In a browser, open the URL:");
        System.out.println("    http://localhost:8080/classes");
        System.out.println("to see a list of classes in JSON format.");

        // TODO: create a SQLite data source in IntelliJ with this file name
        String sqliteFileName = "cs208_hw5.sqlite";

        database = new Database(sqliteFileName);

        try
        {
            database.getDatabaseConnection();
            database.testConnection();
        }
        catch (Exception exception)
        {
            // there is really no point in continuing if we cannot connect to the database
            System.err.println("Exiting the program...");
            return;

            // alternatively, we could have used
            // System.exit(1);
        }

        SpringApplication.run(Main.class, args);
    }

}

package sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class dataconnection {
    private Connection con;
    private Statement sc;
    private ResultSet res;

    public dataconnection(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/javacon?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","");
            sc = con.createStatement();
            System.out.println("Database Connection Succesfull");
        }
        catch (Exception e){
            System.out.println("Error : "+e);
        }
    }

    public void showdata(){
        try {
            String query = "select * from conect";
            res = sc.executeQuery(query);
            System.out.println("Record from database");

            while (res.next()){
                String id = res.getString("id");
                String name = res.getString("Name");
                String password = res.getString("Password");
                System.out.println("Id : "+id+"\nName : "+name+"\nPassword : "+password);
            }
        }
        catch (Exception e){
            System.out.println("Error : "+e);
        }
    }


    public static void main(String[] args) {
        dataconnection obj = new dataconnection();
        obj.showdata();
    }
}
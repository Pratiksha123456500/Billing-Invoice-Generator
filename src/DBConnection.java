
import java.sql.Connection;
import java.sql.DriverManager;

     
    public class DBConnection {

            public static Connection getConnection(){
                    Connection con=null;

                    
                try{

                    
                    Class.forName("com.mysql.cj.jdbc.Driver");


                return DriverManager.getConnection(
                        "jdbc:mysql://127.0.0.1:3306/billing_db?useSSL=false&serverTimezone=UTC", 
                        "root",
                        ""  
                    );

                
               
                } 
                catch(ClassNotFoundException e){
                    e.printStackTrace();
                
                }catch(Exception e){
                    e.printStackTrace();

                }
                return con;
            }

        }


    



package bookstore.data.connection;

public class PostgresqlDriver {

   public static void postgresqlDriver (){
       try {
           Class.forName("org.postgresql.Driver");
       } catch (ClassNotFoundException e) {
           throw new RuntimeException(e);
       }
   }

}

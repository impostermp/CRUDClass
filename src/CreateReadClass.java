import java.sql.*;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class CreateReadClass {
    private String url = "localhost";
    private int port = 5432;
    private String databaseName = "projectDB";
    private String username = "postgres";
    private String password = "hitman94";
    private Connection connection = null;
    private static CreateReadClass instance;


    private CreateReadClass(){
        initializePostgresqlDatabase();
    }

    public static CreateReadClass getInstance(){
        if (instance == null) {
            instance = new CreateReadClass();
        }
        return instance;
    }

    private void initializePostgresqlDatabase() {
        try {
            DriverManager.registerDriver(new org.postgresql.Driver());
            connection = DriverManager.getConnection("jdbc:postgresql://" + url
                    + ":"
                    + port
                    + "/" + databaseName, username, password);
        } catch (SQLException | IllegalArgumentException ex) {
            ex.printStackTrace(System.err);
        } finally {
            if (connection == null) System.exit(-1);
        }
    }

    public void createProduct(ProductHit product){
        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("INSERT into products (uuid,averageuserreview,price,clockspeed,weight,ean,size,category, name,description,publisheddate,expirationdate,inStock) values (?,?,?,?,?,?,?,?,?,?,?,?,?)");
                    preparedStatement.setObject(1,product.uuid);
                    preparedStatement.setDouble(2,product.averageUserReview);
                    preparedStatement.setDouble(3,product.price);
                    preparedStatement.setDouble(4,product.clockspeed);
                    preparedStatement.setDouble(5,product.weight);
                    preparedStatement.setString(6,product.ean);
                    preparedStatement.setString(7,product.size);
                    preparedStatement.setString(8,product.category);
                    preparedStatement.setString(9,product.name);
                    preparedStatement.setString(10,product.description);
                    preparedStatement.setTimestamp(11,Timestamp.from(product.publishedDate));
                    preparedStatement.setTimestamp(12,Timestamp.from(product.expirationDate));
                    preparedStatement.setArray(13, connection.createArrayOf("VARCHAR",
                            product.inStock.toArray()));
                    preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public List<ProductHit> getProducts(){
        List<ProductHit> productHitList = new ArrayList<>();
        try {
            PreparedStatement p = connection.prepareStatement("select * from products");
            ResultSet resultSet = p.executeQuery();
            while(resultSet.next()){
                productHitList.add(new ProductHit(UUID.fromString(resultSet.getString(2)),
                        resultSet.getDouble(3),
                        resultSet.getDouble(4),
                        resultSet.getDouble(5),
                        resultSet.getDouble(6),
                        resultSet.getString(7),
                        resultSet.getString(8),
                        resultSet.getString(9),
                        resultSet.getString(10),
                        resultSet.getString(11),
                        resultSet.getTimestamp(12).toInstant(),
                        resultSet.getTimestamp(13).toInstant(),
                        Arrays.asList(resultSet.getArray(14).toString())));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productHitList;
    }
}

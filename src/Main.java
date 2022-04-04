import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.UUID;

public class Main {

    public static void main(String[] args) {
    ProductHit productHit = new ProductHit(UUID.fromString("1cf3d1fd-7787-4b64-8ef9-0b6f131a9f4e"),
            4.446,0.00,0.0,1.00,"2054647099864","",
            "PC/Laptops","Lenovo ThinkPad T410 35.8 cm (14.1\")",
            "Lenovo ThinkPad T410, 35.8 cm (14.1\")," +
                    " 1280 x 800 pixels Lenovo ThinkPad T410. Display diagonal: 35.8 cm (14.1\")," +
                    " Display resolution: 1280 x 800 pixels",
            LocalDateTime.parse("2021-06-02T05:05:06.62213").atZone(ZoneId.systemDefault()).toInstant(),
            LocalDateTime.parse("2025-01-25T07:40:33.1695").atZone(ZoneId.systemDefault()).toInstant(),
            Arrays.asList("Charlottenlund","Herning"));

            CreateReadClass c = CreateReadClass.getInstance();
            //System.out.println(productHit.publishedDate);
            //c.createProduct(productHit);
        System.out.println(c.getProducts());


    }
}

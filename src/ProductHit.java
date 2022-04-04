import java.time.Instant;
import java.util.List;
import java.util.UUID;

public class ProductHit {
    UUID uuid;
    Double averageUserReview;
    Double price;
    Double clockspeed;
    Double weight;
    String ean;
    String size;
    String category;
    String name;
    String description;
    Instant publishedDate;
    Instant expirationDate;
    List<String> inStock;

    public ProductHit(UUID uuid, Double averageUserReview, Double price,
                      Double clockspeed, Double weight, String ean, String size,
                      String category, String name, String description, Instant publishedDate,
                      Instant expirationDate, List<String> inStock) {
        this.uuid = uuid;
        this.averageUserReview = averageUserReview;
        this.price = price;
        this.clockspeed = clockspeed;
        this.weight = weight;
        this.ean = ean;
        this.size = size;
        this.category = category;
        this.name = name;
        this.description = description;
        this.publishedDate = publishedDate;
        this.expirationDate = expirationDate;
        this.inStock = inStock;
    }

    @Override
    public String toString() {
        return "ProductHit{" +
                "uuid=" + uuid +
                ", averageUserReview=" + averageUserReview +
                ", price=" + price +
                ", clockspeed=" + clockspeed +
                ", weight=" + weight +
                ", ean='" + ean + '\'' +
                ", size='" + size + '\'' +
                ", category='" + category + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", publishedDate=" + publishedDate +
                ", expirationDate=" + expirationDate +
                ", inStock=" + inStock +
                '}';
    }

    public Instant getPublishedDate() {
        return publishedDate;
    }

    public Instant getExpirationDate() {
        return expirationDate;
    }
}

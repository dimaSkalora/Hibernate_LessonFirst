package lesson_15.models;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;


@Entity
@Table(name="product")
public class Product extends Model {
    private static final long serialVersionUID = -7845118151518L;

    @NotNull(message = "Field title is null")
    @Size(min=4, max=16, message = "awwcswrvwscv")
    @Column(name="title")
    private String title;
    @Pattern(regexp = "")
    @NotNull
    @Column(name="description")
    private String description;

    @NotEmpty
    @NotNull
    @Column(name="price")
    private BigDecimal price;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="product_category_id",referencedColumnName = "id")
    private ProductCategory productCategory;

    public Product() {
        super();
    }

    public Product(Long id) {
        super(id);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public ProductCategory getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(ProductCategory productCategory) {
        this.productCategory = productCategory;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id="+getId()+", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", productCategory=" + productCategory+
                '}';
    }
}

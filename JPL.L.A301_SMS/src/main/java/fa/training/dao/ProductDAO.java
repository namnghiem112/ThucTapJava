package fa.training.dao;

import fa.training.entities.Product;
import java.util.List;

public interface ProductDAO {
    List<Product> getAllProducts();
    boolean addProduct(Product product);
    boolean updateProduct(Product product);
    boolean deleteProduct(int productId);
}

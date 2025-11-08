package shop.management.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import shop.management.dao.ProductDAO;
import shop.management.entity.Product;
import shop.management.service.ProductService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class ProductRestController {

    public ProductService productService;
    public ObjectMapper objectMapper;

    @Autowired
    public ProductRestController(ProductService productService, ObjectMapper objectMapper){
        this.productService = productService;
        this.objectMapper = objectMapper;
    }

    @GetMapping("/list")
    public List<Product> getList(){
        List<Product> list = productService.findAll();
        return list;
    }
    @GetMapping("/list/{id}")
    public Product getById(@PathVariable int id){
        return productService.findById(id);
    }

    @PostMapping("/list")
    public Product addProduct(@RequestBody Product product){
        product.setId(0);
        return productService.save(product);
    }
    @DeleteMapping("/list/{id}")
    public String deleteProduct(@PathVariable int id){
        Product product = productService.findById(id);

        if(product == null){
            throw new RuntimeException("Product not found by id: "+id);
        }
        productService.deleteById(id);
        return "deleted product by id: "+id;
    }

    @PutMapping("/list")
    public Product updateProduct(@RequestBody Product product){
        return productService.save(product);
    }

    @PatchMapping("/list/{id}")
    public Product makePartialChanges(@PathVariable int id, @RequestBody Map<String, Object> patchPayload){
        Product product = productService.findById(id);
        if(product == null){
            throw new RuntimeException("Product by id: "+id+" not found");
        }
        if(patchPayload.containsKey("id")){
            throw new RuntimeException("Product contains id which is not allowed!!");
        }
        Product patchProduct = apply(product,patchPayload);
        Product dbProduct = productService.save(patchProduct);
        return dbProduct;
    }

    public Product apply(Product product, Map<String, Object> patchPayload){
        //convert Product object to a json object node
        ObjectNode productNode = objectMapper.convertValue(product, ObjectNode.class);
        // convert patch payload map to a json object node
        ObjectNode patchNode = objectMapper.convertValue(patchPayload, ObjectNode.class);
        // merge the patch updates into employee node
        productNode.setAll(patchNode);
        // convert it back and return
        return objectMapper.convertValue(productNode,Product.class);
    }
}

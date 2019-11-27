import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


public class Manager {
    public Map<String,Product> productMap = new HashMap<String,Product>();
    private Set<Product> productSet = new HashSet<Product>();

    private ObjectMapper mapper=new ObjectMapper();

    public Set<Product> getProductSet() {
        return productSet;
    }

    public void inputDB(){
        try {
            Product product=mapper.readValue(new File("E:\\IU\\1920sem1\\OOP\\exer\\lab5\\out\\production\\WarehouseManager\\product1"), Product.class);
            productMap.put(product.getName(),product);
            productSet.add(product);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void addObj(Product product){
        if (productSet.contains(product)){
            product.setAmount(product.getAmount()+1);
        }

        else{
            productSet.add(product);
        }
        productMap.put(product.getName(),product);
    }

    public void removeObj(Product product){
        product.setAmount(0);
        productSet.remove(product);
        productMap.remove(product.getName());
    }

    public void removebyAmount(Product product){
        productSet.add(product);
        productMap.replace(product.getName(),product);
    }

    public Product searchbyName(String name){
        return productMap.get(name);
    }

    @Override
    public String toString() {
        StringBuilder result= new StringBuilder("");
        for (var prod:productSet){
            result.append(prod.getProductId()).append("-").append(prod.getAmount()).append("-").append(prod.getDescription()).append(",\n");
        }
        return result.toString();
    }
}

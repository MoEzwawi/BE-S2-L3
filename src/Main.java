import entities.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
        private static Logger logger = LoggerFactory.getLogger(Main.class);
    public static void main(String[] args) {
        List<Product> productsList= new ArrayList<>();
        for(int i=0;i<50;i++){
            Random rndm = new Random();
            int n = i + 1;
            Product newBook = new Product("Book "+n,"Books", rndm.nextDouble(100,1000));
            productsList.add(newBook);
            logger.info(newBook.toString());
        }
    }
}
import entities.Customer;
import entities.Order;
import entities.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
        private static Logger logger = LoggerFactory.getLogger(Main.class);
    public static void main(String[] args) {
        // ******************** ESERCIZIO 1 **************************
        List<Product> booksList= new ArrayList<>();
        for(int i=0;i<50;i++){
            Random rndm = new Random();
            int n = i + 1;
            Product newBook = new Product("Book "+n,"Books", rndm.nextDouble(100,1000));
            booksList.add(newBook);
            // logger.info(newBook.toString());
        }
        // ******************** ESERCIZIO 2 **************************
        List<Product> infancyItemsList= new ArrayList<>();
        for(int i=0;i<50;i++){
            Random rndm = new Random();
            int n = i + 1;
            Product infancyItem = new Product("Diaper "+n,"Baby", rndm.nextDouble(4,300));
            infancyItemsList.add(infancyItem);
        }
        List<Order> ordersList = new ArrayList<>();
        for(int i=0;i<20;i++) {
            Random rndm = new Random();
            List<Product> l = infancyItemsList.stream().filter(p -> p.getPrice()< rndm.nextDouble(40)).toList();
            Customer c = new Customer("Customer n"+i,rndm.nextInt(1,6));
            Order o = new Order(l,c);
            ordersList.add(o);
        }
        //logger.info("List of baby products orders:");
        //ordersList.forEach(order -> logger.info(order.toString()));

        // ********************** ESERCIZIO 3 *********************************

        List<Product> boysItemsList= new ArrayList<>();
        for(int i=0;i<40;i++){
            Random rndm = new Random();
            int n = i + 1;
            Product boysItem = new Product("Clothing"+n,"Boys", rndm.nextDouble(4,300));
            boysItemsList.add(boysItem);
        }
        List<Product> salesBoysItemsList = boysItemsList.stream().map(i->{
            Product newItem = new Product(i.getName(),i.getCategory(), i.getPrice()*0.9);
            return newItem;
        }).toList();
        // boysItemsList.forEach(i->i.setPrice(i.getPrice()*0.9));

        // ********************** ESERCIZIO 4 *********************************
        List<Order> tier2Orders = ordersList.stream().filter(o->o.getCustomer().getTier()==2).toList();
        List<Product> tier2Products = new ArrayList<>();
        tier2Orders.forEach(order -> tier2Products.addAll(order.getProducts()));
        logger.info("Ecco la lista di prodotti ordinati da clienti di tier 2:");
        logger.info(tier2Products.toString());

        //Esempio di cast da cui si ottiene un effetto simile a Math.floor()

        /*double primoNumero = 5.937658;
        int secondoNumero = (int) primoNumero;

        System.err.println("primoNumero= "+primoNumero);
        System.err.println("secondoNumero= "+secondoNumero);
        System.out.println("buonanotte");*/
    }
}
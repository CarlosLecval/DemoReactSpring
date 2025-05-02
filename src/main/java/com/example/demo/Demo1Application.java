package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@RestController
public class Demo1Application {
    public static void main(String[] args) {
        SpringApplication.run(Demo1Application.class, args);
    }

    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
        return String.format("Hello %s!", name);
    }

    @GetMapping("/products")
    public List<Product> getProducts(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size) {

        List<Product> allProducts = List.of(
                new Product(
                        1,
                        "Wireless Mouse",
                        25.99,
                        "https://resource.logitech.com/w_776,h_437,ar_16:9,c_fill,q_auto,f_auto,dpr_1.0/d_transparent.gif/content/dam/logitech/en/products/mice/m100/m100-charcoal-feature-2.jpg"
                ),
                new Product(
                        2,
                        "Mechanical Keyboard",
                        89.50,
                        "https://m.media-amazon.com/images/I/71yGtauB-AL._AC_SL1500_.jpg"
                ),
                new Product(
                        3,
                        "27-inch Monitor",
                        229.00,
                        "https://www.lg.com/content/dam/channel/wcms/mx/images/monitores/24mr400-b_awmq_enms_mx_c/gallery/large03.jpg"
                ),
                new Product(
                        4,
                        "USB-C Hub",
                        34.95,
                        "https://m.media-amazon.com/images/I/5144iPgOWRL.jpg"
                ),
                new Product(
                        5,
                        "Laptop Stand",
                        45.00,
                        "https://m.media-amazon.com/images/I/715pvx8UWrL.jpg"
                ),
                new Product(
                        6,
                        "Bluetooth Headphones",
                        69.99,
                        "https://m.media-amazon.com/images/I/61RahTQtAqL._AC_UF1000,1000_QL80_.jpg"
                ),
                new Product(
                        7,
                        "Webcam 1080p",
                        59.49,
                        "https://m.media-amazon.com/images/I/71eGb1FcyiL.jpg"
                ),
                new Product(
                        8,
                        "Ergonomic Chair",
                        199.99,
                        "https://m.media-amazon.com/images/I/71NSpc4hQJL.jpg"
                ),
                new Product(
                        9,
                        "Portable SSD 1TB",
                        119.00,
                        "https://m.media-amazon.com/images/I/71bBCTIvIIL._AC_UF894,1000_QL80_.jpg"
                ),
                new Product(
                        10,
                        "Desk Lamp",
                        18.75,
                        "https://m.media-amazon.com/images/I/61rjeSH6+4L.jpg"
                )
        );

        int start = page * size;
        int end = Math.min(start + size, allProducts.size());

        if (start >= allProducts.size()) {
            return new ArrayList<>();
        }

        return allProducts.subList(start, end);
    }

    static class Product {
        private int id;
        private String name;
        private String imageUrl;
        private double price;

        public Product(int id, String name, double price, String imageUrl) {
            this.id = id;
            this.imageUrl = imageUrl;
            this.name = name;
            this.price = price;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public double getPrice() {
            return price;
        }

        public void setId(int id) {
            this.id = id;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public String getImageUrl() {
            return imageUrl;
        }

        public void setImageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
        }
    }
}

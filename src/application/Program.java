package application;

import java.util.Date;

import dao.Factory;
import dao.SellerDao;
import entities.Department;
import entities.Seller;

public class Program {
    public static void main(String[] args) {
        Department obj = new Department (1, "Books");

        Seller seller = new Seller(21, "bob","bob@gmail.com", new Date(), 3000.00, obj);
        SellerDao sellerDao = Factory.createSellerDao();
        System.out.println(seller);
        
    }
}

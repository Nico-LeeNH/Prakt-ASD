package Pertemuan15;

import java.util.ArrayList;
import java.util.Collections;

public class DemoArrayList {
    public static void main(String[] args) {
        ArrayList<Customer> customers = new ArrayList<>(2);

        Customer customer1 = new Customer(1, "Zakia");
        Customer customer2 = new Customer(5, "Budi");

        customers.add(customer1);
        customers.add(customer2);

        customers.add(new Customer(4, "Cica"));
        customers.add(2, new Customer(0, "Rosa"));

        Customer customer = customers.get(1);
        System.out.println(customer.name);
        customer.name = "Budi Utomo";

        System.out.println(customers.indexOf(customer2));

        for (Customer cust : customers) {
            System.out.println(cust.toString());
        }

        ArrayList<Customer> newCustomers = new ArrayList<>();
        newCustomers.add(new Customer(201, "Della"));
        newCustomers.add(new Customer(202, "Victor"));
        newCustomers.add(new Customer(203, "Sarah"));

        customers.addAll(newCustomers);

        for (Customer cust : customers) {
            System.out.println(cust.toString());
        }

        ArrayList<String> daftarSiswa = new ArrayList<>();
        daftarSiswa.add("Zainab");
        daftarSiswa.add("Andi");
        daftarSiswa.add("Rara");
        Collections.sort(daftarSiswa);

        System.out.println(daftarSiswa);

        customers.sort((c1, c2) -> c1.name.compareTo(c2.name));
        
        System.out.println(customers);

    }
}

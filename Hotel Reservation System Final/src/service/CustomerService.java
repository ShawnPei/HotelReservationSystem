package service;

import mode1.Customer;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class CustomerService {
    private static CustomerService customerService = null;

    public static CustomerService getInstance(){
        if (customerService == null) {
            customerService = new CustomerService();
        }
        return customerService;
    }
    public static Map<String,Customer> mapOfCustomer = new HashMap<>();
    public static void addCustomer(String firstname, String lastname, String email){
        Customer customer;
        customer = new Customer(firstname,lastname,email);
        mapOfCustomer.put(customer.getEmail(),customer);

    }
    public static Customer getCustomer(String customerEmail){
        return mapOfCustomer.get(customerEmail);

    }
    public static Collection<Customer> getAllCustomers() {
        for (String email : mapOfCustomer.keySet()) {
            System.out.println(mapOfCustomer.get(email));

        }
        return null;
    }

}

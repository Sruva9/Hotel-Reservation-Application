package hotel.service;

import hotel.model.Customer;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class CustomerService {

    private static final CustomerService instance = new CustomerService();

    private final Map<String, Customer> customers = new HashMap<>();

    private final Pattern emailPattern =
            Pattern.compile("^[A-Za-z0-9+_.-]+@(.+)\\.com$");

    private CustomerService() {}

    public static CustomerService getInstance() {
        return instance;
    }

    public void addCustomer(String email, String firstName, String lastName) {
        if (!emailPattern.matcher(email).matches()) {
            throw new IllegalArgumentException("Invalid email format");
        }

        customers.putIfAbsent(email, new Customer(firstName, lastName, email));
    }

    public Customer getCustomer(String email) {
        return customers.get(email);
    }

    public Map<String, Customer> getAllCustomers() {
        return customers;
    }
}
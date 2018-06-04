/*

package com.movie.MovieApp.Implement;

import com.movie.MovieApp.Model.Account;
import com.movie.MovieApp.Model.Customer;
import com.movie.MovieApp.Model.Employee;
import com.movie.MovieApp.Model.Store;
import com.movie.MovieApp.Repository.AccountRepository;
import com.movie.MovieApp.Repository.CustomerRepository;
import com.movie.MovieApp.Repository.EmployeeRepository;
import com.movie.MovieApp.Repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class implementclass {
    @Autowired
    private StoreRepository storeRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private CustomerRepository customerRepository;


    public void addEmployeeinStore(){
        storeRepository.deleteAllInBatch();
        employeeRepository.deleteAllInBatch();

        Store store = new Store("moviestore"," movielaan15 " ,15);

        Employee employee = new Employee("Jan");
        Employee employee1 = new Employee(" Janine");


        store.getEmployees().add(employee);
        store.getEmployees().add(employee1);

        employee.getStores().add(store);
        employee1.getStores().add(store);

        storeRepository.save(store);
    }


    public void addOneAccounttoCustomer(){
        accountRepository.deleteAllInBatch();
        customerRepository.deleteAllInBatch();

        Customer customer = new Customer("Leo Davidsen", "Tivolistraat 22");

        Account account = new Account(20.55, 2018);

        customer.setAccount(account);

        account.setCustomer(customer);

        customerRepository.save(customer);
    }
}
*/

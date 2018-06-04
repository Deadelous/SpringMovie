package com.movie.MovieApp;

import com.movie.MovieApp.Model.Account;
import com.movie.MovieApp.Model.Customer;
import com.movie.MovieApp.Model.Employee;
import com.movie.MovieApp.Model.Store;
import com.movie.MovieApp.Repository.AccountRepository;
import com.movie.MovieApp.Repository.CustomerRepository;
import com.movie.MovieApp.Repository.EmployeeRepository;
import com.movie.MovieApp.Repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;

@SpringBootApplication
public class MovieAppApplication  implements CommandLineRunner {

	@Autowired
	private StoreRepository storeRepository;

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private AccountRepository accountRepository;

	@Autowired
	private CustomerRepository customerRepository;


	public static void main(String[] args) {
		SpringApplication.run(MovieAppApplication.class, args);

	}

	@Override
	public void run(String[] args) throws Exception {

		addEmployeeinStore();
		addOneAccounttoCustomer();
	}



	public void addEmployeeinStore(){


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

		Customer customer = new Customer("Leo Davidsen", "Tivolistraat 22");

		Account account = new Account(20.55, 2018);

		customer.setAccount(account);

		account.setCustomer(customer);

		accountRepository.save(account);
	}

}

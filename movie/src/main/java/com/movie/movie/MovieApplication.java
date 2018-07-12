package com.movie.movie;

import com.movie.movie.Model.*;
import com.movie.movie.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;

import java.util.List;


@SpringBootApplication
public class MovieApplication  implements CommandLineRunner {

	private static final Logger log = LoggerFactory.getLogger(MovieApplication.class);

	@Autowired
	private StoreRepository storeRepository;

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private AccountRepository accountRepository;

	@Autowired

	private CustomerRepository customerRepository;

	@Autowired
	private MovieBaseRepository movieBaseRepository;

    private List<Movie> movies = null;

	public static void main(String[] args) {
		SpringApplication.run(MovieApplication.class, args);

	}



	@Override
	public void run(String[] args) throws Exception {
		addEmployeeinStore();
	//	addOneAccounttoCustomer();
	//	addMovies();
	}

	public void addEmployeeinStore() {
		Store store = new Store("moviestore", " movielaan15 ", 15);

		Employee employee = new Employee("Jan");
		Employee employee1 = new Employee(" Janine");

		Store store1 = new Store("store1", "storelaan2", 16);



		store.getEmployees().add(employee);
		store.getEmployees().add(employee1);
		store1.getEmployees().add(employee);

		employee.getStores().add(store);
		employee1.getStores().add(store);

		employee.getStores().add(store1);



		storeRepository.save(store);
		storeRepository.save(store1);
	}


	public void addOneAccounttoCustomer() {

		Customer customer = new Customer("Leo Davidsen", "Tivolistraat 22");

		Customer customer2 = new Customer("Jacqueline Jansen", "De roos 3");

		Account account = new Account(20, 20,"test", "test", true);

		Account account2 = new Account(10, 1992, "Vrouw", "password1", false);
		customer.setAccount(account);

		account.setCustomer(customer);

		customer2.setAccount(account2);

		account2.setCustomer(customer2);

		accountRepository.save(account);
		accountRepository.save(account2);
	}

	public void addMovies(){
		Movie movie = new Actionmovie("Leo", "LeoAuthor", 1992, "test test");

		Movie movie1 = new Actionmovie("rick", "rickauthor", 2022, "haha");

		Movie movie2= new Sciencemovie("david", "davidauthor", 2022, 22);

		Store store1 = new Store("store", "storeadress", 20);

        movie.setStore(store1);
        movie1.setStore(store1);
        movie2.setStore(store1);

        storeRepository.save(store1);

        movieBaseRepository.save(movie);
        movieBaseRepository.save(movie1);
        movieBaseRepository.save(movie2);


	}
}
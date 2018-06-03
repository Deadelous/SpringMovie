package com.movie.MovieApp;

import com.movie.MovieApp.Model.Employee;
import com.movie.MovieApp.Model.Store;
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

	public static void main(String[] args) {
		SpringApplication.run(MovieAppApplication.class, args);

	}

	@Override
	public void run(String[] args) throws Exception {

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

}

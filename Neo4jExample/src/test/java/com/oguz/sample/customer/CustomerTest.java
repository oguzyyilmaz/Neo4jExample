package com.oguz.sample.customer;

import com.oguz.sample.model.Customer;
import com.oguz.sample.repository.CustomerRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;

/**
 * Created by oguz on 18.06.2016.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerTest {

    @Autowired
    CustomerRepository customerRepository;

    @Test
    public void testCustomerRepository () {
        Customer customer = new Customer("oguzhan","yılmaz");

        customerRepository.save(customer);

       System.out.println("FindByFirstName = " + customerRepository.findByFirstName("oguzhan"));

    }

}

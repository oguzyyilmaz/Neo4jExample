package com.oguz.sample.repository;

import com.oguz.sample.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by oguz on 17.06.2016.
 */
public class CustomerRepositoryImpl implements CustomerRepositoryCustom {

    @Autowired
    CustomerRepository customerRepository;


    @Override
    public Customer customMethod(String firstName) {
        return customerRepository.findByFirstName(firstName);
    }
}

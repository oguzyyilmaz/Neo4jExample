package com.oguz.sample.repository;

import com.oguz.sample.model.Customer;
import com.oguz.sample.model.Person;
import com.oguz.sample.repositoryperson.PersonRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by oguz on 18.06.2016.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PersonRepositoryTest {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Test
    public void testPersonRepositoryInsert () {
        personRepository.deleteAll();
        String genders [] = {"M","F"};
        String Hoby [] = {"Music","Art","Play Game"};
        for(int i= 1; i<1000; i++) {
        Person person = new Person()
                .setGender(genders[i%2])
                .setHoby(Hoby[i%3])
                .setName("A"+i)
                .setPhoto("/home/oguz/IMG/img.jpeg")
                .setSurname("B"+i)
                .setTc("100000000"+i);
        person =personRepository.save(person);
       System.out.println(person.getName());
        }
    }
    @Test
    public void customMethodTest () {
        Person person = new Person();
        person= personRepository.customMethod("A1");
        System.out.println(person.getName());
    }
    @Test
    public void personLookUpMethodTest () {
        Person person = new Person();
        person = personRepository.lookup("A1");
        System.out.println(person.getName());

    }
    @Test
    public void personRepositoryAllTest () {
        Person person = new  Person()
                .setName("memo")
                .setSurname("kerse");
        personRepository.save(person);
        person = personRepository.findOne(person.getId());
        System.out.println(person.getName());
    }

}

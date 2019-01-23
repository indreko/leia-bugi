package ee.datanor.vali.it.leiabugi.controller;


import ee.datanor.vali.it.leiabugi.model.Person;
import ee.datanor.vali.it.leiabugi.service.PersonService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/v1/person")
public class PersonController {


  @Autowired PersonService personService;

  @RequestMapping(value = "/{socialSecurityId}", method = RequestMethod.GET)
  public Person getPerson(@PathVariable Long socialSecurityId){
    return personService.getPerson(socialSecurityId);

  }

  @RequestMapping(value = "/", method = RequestMethod.GET)
  public List<Person> getPersonList(){
    return personService.getPersons();

  }


  @RequestMapping(value = "/", method = RequestMethod.PUT)
  public void addPerson(@RequestBody Person item){
    personService.addPerson(item);
  }

}

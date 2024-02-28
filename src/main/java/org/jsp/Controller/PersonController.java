package org.jsp.Controller;

import java.util.List;

import org.jsp.Dao.PersonDao;
import org.jsp.Dto.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PersonController {

	@Autowired
	private PersonDao dao;

	@RequestMapping("/SavePersonform")
	public String createForm() {
		return "newform";
	}

	@RequestMapping(path = "/submit", method = RequestMethod.POST)
	public String returnData(@ModelAttribute Person person, Model model) {
		System.out.println(person.getId());
		System.out.println(person.getName());
		System.out.println(person.getPhone());
		System.out.println(person.getAge());
		System.out.println(person.getEmail());
		System.out.println(person.getPassword());
		int savePerson = this.dao.savePerson(person);
		model.addAttribute("person", person);
		return "personDetail";
	}

	@RequestMapping("/update")
	public String updateForm() {
		return "updateForm";
	}

	@RequestMapping(path = "/update", method = RequestMethod.POST)
	public String updatePerson(@ModelAttribute Person person, Model model) {
		System.out.println(person.getId());
		System.out.println(person.getName());
		System.out.println(person.getAge());
		System.out.println(person.getPhone());
		System.out.println(person.getEmail());
		System.out.println(person.getPassword());
		this.dao.updatePerson(person);
		model.addAttribute("updatePerson", person);
		return "updatePerson";
	}

	@RequestMapping("/delete")
	public String deletePerson() {
		return "deleteform";
	}

	@RequestMapping(path = "/delete", method = RequestMethod.POST)
	public String deletePersonById(@RequestParam("id") int id, Model model) {
		System.out.println(id);
		String msg = this.dao.deletePersonById(id);
		System.out.println(msg);
		model.addAttribute("msg", msg);
		return "deletePerson";

	}

	@RequestMapping("/find")
	public String getById() {
		return "findById";
	}

	@RequestMapping(path = "/find", method = RequestMethod.POST)
	public String GetById(@RequestParam("id") int id, Model model) {
		Person findPersonById = this.dao.findPersonById(id);
		System.out.println(findPersonById.getId());
		System.out.println(findPersonById.getName());
		System.out.println(findPersonById.getPhone());
		System.out.println(findPersonById.getAge());
		System.out.println(findPersonById.getEmail());
		System.out.println(findPersonById.getPassword());
		model.addAttribute("find", findPersonById);
		return "findDetail";
	}

	@RequestMapping("/findAll")
	public String getAll(Model model) {
		List<Person> findAll = this.dao.findAll();
		System.out.println(findAll.getClass().getName());
		model.addAttribute("allData", findAll);
		return "allData";
	}

	@RequestMapping("/findByIdAndPassword")
	public String findByIdAndPassword() {
		return "findByIdAndPassword";
	}

	@RequestMapping(path = "/dataByIdAndPass", method = RequestMethod.POST)
	public String dataByIdAndPass(@RequestParam("id") int id, @RequestParam("password") String password, Model model) {
		List<Person> findByIdAndPassword = this.dao.findByIdAndPassword(id, password);
		model.addAttribute("dataByIdAndPass", findByIdAndPassword);
		return "dataByIdAndPass";
	}
}

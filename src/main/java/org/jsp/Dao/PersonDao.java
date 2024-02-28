package org.jsp.Dao;

import java.io.Serializable;
import java.util.List;

import javax.transaction.Transactional;

import org.jsp.Dto.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class PersonDao {
	/**
	 * @return the template
	 */
	public HibernateTemplate getTemplate() {
		return hibernateTemplate;
	}

	/**
	 * @param template the template to set
	 */
	public void setTemplate(HibernateTemplate template) {
		this.hibernateTemplate = template;
	}

	@Autowired
	private HibernateTemplate hibernateTemplate;

	@Transactional
	public int savePerson(Person person) {
		int save = (int) this.hibernateTemplate.save(person);
		return save;
	}

	@Transactional
	public void updatePerson(Person person) {
		this.hibernateTemplate.saveOrUpdate(person);
	}

	@Transactional
	public String deletePersonById(int id) {
		Person person = this.hibernateTemplate.get(Person.class, id);
		if (person != null) {
			this.hibernateTemplate.delete(person);
			return " One Record Deleted Successfully By Person Id:";
		} else {
			return "Invalid Person Id:";
		}
	}

	public Person findPersonById(int id) {
		Person person = this.hibernateTemplate.get(Person.class, id);
		return person;
	}

	public List<Person> findAll() {
		List<Person> loadAll = this.hibernateTemplate.loadAll(Person.class);
		return loadAll;
	}

	public List<Person> findByIdAndPassword(int id, String password) {
		String qry = "select p from Person p where p.id=:id and p.password=:password";
		List<Person> getAll = (List<Person>) this.hibernateTemplate.findByNamedParam(qry,
				new String[] { "id", "password" }, new Object[] { id, password });
		return getAll;

	}
}

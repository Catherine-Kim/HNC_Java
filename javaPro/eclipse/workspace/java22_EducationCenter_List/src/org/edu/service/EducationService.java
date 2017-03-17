package org.edu.service;

import org.edu.vo.Employee;
import org.edu.vo.Person;
import org.edu.vo.Student;
import org.edu.vo.Teacher;

import java.util.ArrayList;
import java.util.DuplicateFormatFlagsException;

import org.edu.exception.*;

public class EducationService {
	// fields
	private ArrayList<Person> list;
	
	// constructor
	public EducationService(int size){
		list = new ArrayList<Person>();
	}
	
	// methods
	public void getPersons(){
		for(int i = 0; i < list.size(); i++){
			if(!(list.get(i).getName() == null)) 
				System.out.println(list.get(i));
		}
	}
	
	public void getPersons(ArrayList alist){
		for(int i = 0; i < alist.size(); i++){
			
				System.out.println(alist.get(i));
		}
	}
	
	public void addPerson(Person newPerson) throws DuplicateSSNException{
		boolean found = false;
		
		for(int i = 0; i < list.size(); i++){
			if(newPerson.getSsn().equals(list.get(i).getSsn())){
				found = true;
				throw new DuplicateSSNException(newPerson.getName());
			}
		}
		
		if(found == false){
			list.add(newPerson);
			System.out.println(newPerson.getName() + "���� ��ϵǾ����ϴ�.");
		}
	}
	
	public void deletePerson(String ssn) throws RecordNotFoundException{
		boolean found = false;
		
		for(int i = 0; i < list.size(); i++){
			if(ssn.equals(list.get(i).getName())){
				found = true;
				System.out.println(list.get(i).getName() + "���� Ż���Ͽ����ϴ�.");
				list.remove(i);
			}
		}
		
		if(found == false) throw new RecordNotFoundException();
	}
	
	public ArrayList findPerson(String address){
		ArrayList<Person> foundPeople = new ArrayList<Person>();
		
		int count = 0;
		for(Person p : list){
			if(p.getAddress().equals(address)){
				foundPeople.add(p);
				count++;
			}
		}
		System.out.println(address + "�� ��� ����� �� " + count + "���Դϴ�.");
		return foundPeople;
	}
	

	public void updatePerson(Person updatePerson) throws RecordNotFoundException{
		boolean found = false;
		for(int i = 0 ; i < list.size(); i++){
			if(list.get(i).getSsn().equals(updatePerson.getSsn())){
				found = true;
				list.get(i).setAddress(updatePerson.getAddress());
				list.get(i).setAge(updatePerson.getAge());
				list.get(i).setBirthday(updatePerson.getBirthday());
				list.get(i).setName(updatePerson.getName());
				
				if(list.get(i) instanceof Student)
					((Student)list.get(i)).setStuID(((Student) updatePerson).getSsn());
				
				if(list.get(i) instanceof Teacher)
					((Teacher)list.get(i)).setSubject(((Teacher) updatePerson).getSubject());
				
				if(list.get(i) instanceof Employee)
					((Employee)list.get(i)).setDept(((Employee) updatePerson).getDept());
			}
		}
		
		if(found == false){
			throw new RecordNotFoundException(updatePerson.getName());
		}
	}
}

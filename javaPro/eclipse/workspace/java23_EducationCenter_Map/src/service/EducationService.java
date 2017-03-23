package service;

import vo.Employee;
import vo.Person;
import vo.Student;
import vo.Teacher;

import java.util.ArrayList;
import java.util.DuplicateFormatFlagsException;
import java.util.HashMap;
import java.util.Iterator;

import exception.*;

public class EducationService {
	// fields
	private HashMap<String, Person> map;
	
	// constructor
	public EducationService(int size){
		map = new HashMap<String, Person>();
	}
	
	// methods
	public void getPersons(){
		Iterator<String> it = map.keySet().iterator();
		
		while(it.hasNext()){
			String temp = it.next();
			System.out.println("Key : " + temp + ", Value : " + map.get(temp));
		}
	}
	
	public void addPerson(String key_ssn, Person newPerson) throws DuplicateSSNException{
		if(map.containsKey(key_ssn))
			throw new DuplicateSSNException();
		else{
			map.put(key_ssn, newPerson);
			System.out.println(key_ssn + "님을 Map에 추가하였습니다.");
		}
	}
	
	public void deletePerson(String key_ssn) throws RecordNotFoundException{
		Person person = map.remove(key_ssn);
		
		if(person == null)
			throw new RecordNotFoundException();
		else
			System.out.println(key_ssn + "님을 Map에서 삭제하였습니다.");
	}	
	
	public ArrayList findPerson(String address){
		ArrayList<Person> list = new ArrayList<Person>();
		
		Iterator<String> it = map.keySet().iterator();
		
		while(it.hasNext()){
			String temp = it.next();
			if(map.get(temp).getAddress().equals(address))
				list.add(map.get(temp));
		}
		
		return list;
	}

	public void updatePerson(String key_ssn, Person updatePerson) throws RecordNotFoundException{
		if(map.containsKey(key_ssn)){
			map.put(key_ssn, updatePerson);
			System.out.println(updatePerson.getName() + "님으로 교체했습니다.");
		}else{
			throw new RecordNotFoundException();
		}
	}
}

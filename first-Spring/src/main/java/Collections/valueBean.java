package Collections;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class valueBean {

	private String name;
	private int age;
	private List<String> interest;
	private Set<String> city;
	private Map<String,Double> map;
	private Properties db;
	public Properties getDb() {
		return db;
	}
	public void setDb(Properties db) {
		this.db = db;
	}
	public Map<String, Double> getMap() {
		return map;
	}
	public void setMap(Map<String, Double> map) {
		this.map = map;
	}
	public Set<String> getCity() {
		return city;
	}
	public void setCity(Set<String> city) {
		this.city = city;
	}
	public valueBean(){
		System.out.println("valueBean()");
	}
	public List<String> getInterest() {
		return interest;
	}
	public void setInterest(List<String> interest) {
		this.interest = interest;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "valueBean [name=" + name + ", age=" + age + ", interest=" + interest + ", city=" + city + ", map=" + map
				+ ", db=" + db + "]";
	}
	
}

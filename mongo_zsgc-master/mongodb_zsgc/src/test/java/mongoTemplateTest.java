import java.util.ArrayList;
import java.util.List;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import net.fuzui.pojo.User;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:config/spring/applicationContext.xml"})
public class mongoTemplateTest {
	@Autowired
	MongoTemplate mongoTemplate;

	/**
	 * 一、save方法
	 * 遍历插入
	 * 若新增数据的主键已经存在，则会对当前已经存在的数据进行修改操作
	 * */
	@Test
	public void saveTest() {
		User user = new User();
		user.setName("wwze01");
		user.setUsername("wwze01");
		user.setPassword("123456");
		System.out.println(mongoTemplate);
		
		mongoTemplate.save(user);	
	}

	/**
	 * 二、insert方法
	 * 一次性插入一整个列表，而不用进行遍历操作，效率相对较高
	 * 若新增数据的主键已经存在，则会抛 org.springframework.dao.DuplicateKeyException 异常提示主键重复，不保存当前数据。
	 * */
	@Test
	public void insertTest() {
		User user = new User();
		user.setName("wwze02");
		user.setUsername("wwze02");
		user.setPassword("123");
		System.out.println(mongoTemplate);

		mongoTemplate.insert(user);	
	}
	
	/**
	 * 三、批量插入
	 * 
	 * */
	@Test
	public void insertAllTest() {
		ArrayList<User> manyUser = new ArrayList<>();
		User user1 = new User();
		user1.setName("wwze03");
		user1.setUsername("wwze03");
		user1.setPassword("1234");
		manyUser.add(user1);
		User user2 = new User();
		user2.setName("wwze04");
		user2.setUsername("wwze04");
		user2.setPassword("12345");
		manyUser.add(user2);
		mongoTemplate.insertAll(manyUser);
	}
	
	/**
	 * 四、插入嵌套文档
	 * 这种复杂的数据结构如果直接使用javabean是比较麻烦的，这种比较复杂的数据结构，
	 * 只需要拿到json字符串，并将其转换成json对象，即可直接插入到mongodb中
	 * */
	@Test
	public void insertNestTest(){ 
		String classStr = "{'classId':'1','Students':[{'studentId':'1','name':'zhangsan'}]}";
		JSONObject parseObject = JSON.parseObject(classStr);
    	mongoTemplate.insert(parseObject,"class");//class为collection
	}
	
	/**
	 * 五、更新数据
	 * upsert和updateFirst、updateMulti
	 * */
	@Test
	public void update() {
		Query query = new Query();
		
		//Criteria.where(属性名).后可跟lt lte gt gte等
		query.addCriteria(Criteria.where("classId").is("1"));
		Update update = new Update();
		update = Update.update("teacher","WANGZE");
		mongoTemplate.upsert(query, update, "fuzui");
		
		/*
		 * upsert方法时如果query条件没有筛选出对应的数据，那么upsert会插入一条新的数据，而update什么都不会做
		 * 等同于关系型数据库中的merge和update。
		mongoTemplate.updateFirst(query, update, "class");
		mongoTemplate.updateMulti(query, update, "class");
		*/	
	}
	
	/**
	 * 六、添加嵌套文档中的数据
	 * addToSet方法：如果要插入的数据已经存在，则不进行任何操作；
	 * push方法：即使要插入的数据已存在，但仍要插入一条一样的数据。
	 * */
	@Test
	public void addNestTest() {
		Query query = Query.query(Criteria.where("classId").is("1"));
		User user = new User("1","wwze05","wwze05","123","student","12345678901",1,"M");
		Update update = new Update();
		
		update.push("Students",user);
		//update.addToSet("Students", user);
		mongoTemplate.upsert(query, update, "fuzui");
	}
	
	/**
	 * 七、修改内嵌文档中的数据
	 * 使用.$.连接
	 * 只更新第一条
	 * */
	@Test
	public void updateNestTest() {
		Query query = Query.query(Criteria.where("classId").is("1").and("Students.name").is("wwze05"));
		Update update = Update.update("Students.$.password", "456");
		
		//User user = new User("1","wwze05","wwze05","123");
		//update.pull("students", user);
		
		mongoTemplate.upsert(query, update, "fuzui");
	}
	
	/**
	 * 八、删除内嵌文档中的数据
	 * 只删除第一条
	 * 不能彻底删除，会把符合条件的数据修改为空；
	 * 如需彻底删除，需使用pull方法，pull方法中的实体对象数据应与被删除的完全一样。
	 * */
	@Test
	public void deleteNestTest() {
		Query query = Query.query(Criteria.where("classId").is("1").and("Students.name").is("wwze05"));
		Update update = new Update();
		update.unset("Students.$");
		mongoTemplate.upsert(query, update, "fuzui");
	}
	
	/**
	 * 九、删除
	 * remove方法
	 * */
	@Test
	public void deleteTest() {
		Query query = Query.query(Criteria.where("classId").is("1"));
		mongoTemplate.remove(query,"fuzui");
	}

	/**
	 * 十、查询全部
	 * */
	@Test
	public void queryAll(){
		List<User> userList = mongoTemplate.find(new Query(),User.class);
		System.out.println(mongoTemplate.find(new Query(),User.class));
	}
}

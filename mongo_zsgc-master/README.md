# mongo_zsgc
基于springMVC +MongoDB实现登录注册以及增删改查
用到idea，MongoDB4.0.5版本，java8，tomcat9，spring4.0.0jar，spring-data-mongodb1.5.5jar（最开始用spring5.0jar和spring-data-mongodb2.0的jar，怎么都无法注入MongoTemplate）。界面为了没那么丑，简单用到了前端框架bootstrap。
程序中还有很多bug，例如没有用到id（唯一性定位删除更改），导致更新操作修改name时可能会出现问题。源码中有一个测试类，写了MongoTemplate的基本方法（增删改查）

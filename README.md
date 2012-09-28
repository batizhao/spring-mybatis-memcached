Spring MyBatis Memcached Bootstrap
===========================

# 说明
* *ssm3-mybatis2-memcached* 使用了 simple-spring-memcached 。因为 mybatis-memcached 不支持 MyBatis2（iBatis），只能用在 MyBatis3 里。但是因为有的项目还跑在 MyBatis2 版本上，所以也做一个例子。
* *mm-mybatis3-memcached* 使用了 mybatis-memcached 。因为 simple-spring-memcached 暂时和 MyBatis3 没办法直接整合(MyBatis3 不再需要 DAO 实现类)，simple-spring-memcached
annotation 在 interface 方法里不起作用。见我提交的 [Bug](http://code.google.com/p/simple-spring-memcached/issues/detail?id=7)。
* *ssm3-springcache-mybatis3-memcached* 通过 Spring Cache（Spring 3.1+） 实现 simple-spring-memcached 和 MyBatis3 整合。
* simple-spring-memcached 使用了 JSON 序列化。

# 比较

* mybatis-memcached 对缓存的控制粒度最粗（比如更新某块缓存中的某个 key 值），基本不能做任何精细控制。但是最简单，不用写任何代码。简单项目可以使用。
* 如果希望做细粒度控制，可以使用 SSM，如果使用了 Spring Cache ，还可以用到 SpEL 对 key 进行灵活定义.

# mm-mybatis3-memcached
使用这种方式，调用 getUsersByRoleId 这种两张表关联数据的方法时，会出现脏数据的问题。
Cache 的 namespace 根据是这样生成的：

    Object key 'me.batizhao.dao.UserDao' converted in '_mybatis_18d173c3'       
	Object key 'me.batizhao.dao.RoleDao' converted in '_mybatis_73a81b38'
		
namespace 下边的查询缓存是这样被保存在 memcached 的	

	Insert/Updating object (_mybatis_18d173c3, [_mybatis_44b07f4c, _mybatis_46ba070c])	
	Insert/Updating object (_mybatis_73a81b38, [_mybatis_1f462b4d, _mybatis_33742b43])    

先调用 getUsersByRoleId 生成缓存，再调用 updateRole 方法，最后再一次调用 getUsersByRoleId，User 中相关的 Role 查询结果还是走缓存，不会被更新。

    Object key '1152417612:1218320355:me.batizhao.dao.UserDao.getUsersByRoleId:0:2147483647:SELECT u.id, u.name, r.id as "role.id", r.name as "role.name" FROM user u, user_role ur, role r WHERE u.id = ur.userid and r.id = ur.roleid and ur.roleid = ?:1' converted in '_mybatis_44b07f4c' 
    
# ssm3-mybatis2-memcached
使用这种方式，可以细粒度的控制 Memcached. 详见：

* [使用 Simple-Spring-Memcached Annotation](http://batizhao.github.com/java/2012/09/27/simple-spring-memcached-annotation/)
* [使用 Simple-Spring-Memcached: SingleCache](http://batizhao.github.com/java/2012/09/27/using-simple-spring-memcached-one/)
* [使用 Simple-Spring-Memcached: MultiCache](http://batizhao.github.com/java/2012/09/27/using-simple-spring-memcached-two/)
* [http://batizhao.github.com/java/2012/09/28/using-simple-spring-memcached-three/](http://batizhao.github.com/java/2012/09/28/using-simple-spring-memcached-three/)         
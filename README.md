Spring MyBatis Memcached Bootstrap
===========================

# 说明
* *ssm3-mybatis2-memcached* 使用了 simple-spring-memcached 。因为 mybatis-memcached 不支持 MyBatis2（iBatis），只能用在 MyBatis3 里。但是因为有的项目还跑在 MyBatis2 版本上，所以也做一个例子。
* *mm-mybatis3-memcached* 使用了 mybatis-memcached 。因为 simple-spring-memcached 暂时和 MyBatis3 没办法直接整合，因为 MyBatis3 不再需要 DAO 实现类，simple-spring-memcached
annotation 在 interface 方法里不起作用。见我提交的 [Bug](http://code.google.com/p/simple-spring-memcached/issues/detail?id=7)。
* *ssm3-springcache-mybatis3-memcached* 通过 Spring Cache（Spring 3.1+） 实现 simple-spring-memcached 和 MyBatis3 整合。
* simple-spring-memcached 使用了 JSON 序列化。

# 比较

* mybatis-memcached 对缓存的控制粒度最粗（比如更新某块缓存中的某个 key 值），基本不能做任何精细控制。但是最简单，不用写任何代码。简单项目可以使用。
* 如果希望做细粒度控制，可以使用 SSM，如果使用了 Spring Cache ，还可以用到 SpEL 对 key 进行灵活定义.
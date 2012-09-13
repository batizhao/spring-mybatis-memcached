spring-mybatis-memcached-bootstrap
===========================

# 说明
* mybatis-memcached 不支持 MyBatis2，只能用在 MyBatis3 里。但是因为有的项目还跑在 MyBatis2 版本上，所以也做一个例子。
* simple-spring-memcached 暂时和 MyBatis3 没办法整合，因为 MyBatis3 不再需要 DAO 实现类，simple-spring-memcached
annotation 在 interface 方法里不起作用。见我提交的 [Bug](http://code.google.com/p/simple-spring-memcached/issues/detail?id=7)。

mm-mybatis3-memcached(mybatis-memcached + MyBatis3)
ssm3-mybatis2-memcached(simple-spring-memcached + MyBatis2)
ssm3-springcache-mybatis3-memcached(simple-spring-memcached + Spring Cache + MyBatis2)
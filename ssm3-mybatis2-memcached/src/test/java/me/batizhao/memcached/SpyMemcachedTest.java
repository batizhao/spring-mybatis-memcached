package me.batizhao.memcached;

import net.spy.memcached.*;

import java.io.IOException;
import java.util.Arrays;

public class SpyMemcachedTest {

    public static void main(String[] args) throws IOException {
        //MemcachedClient c = new MemcachedClient(AddrUtil.getAddresses("127.0.0.1:11211 127.0.0.1:11222"));

        ConnectionFactoryBuilder builder = new ConnectionFactoryBuilder();
        builder.setHashAlg(DefaultHashAlgorithm.KETAMA_HASH);
        builder.setLocatorType(ConnectionFactoryBuilder.Locator.CONSISTENT);
        ConnectionFactory connectionFactory = builder.build();

        MemcachedClient c = new MemcachedClient(connectionFactory, AddrUtil.getAddresses("127.0.0.1:11211 127.0.0.1:11222"));

        String s = "Hello, key1 Cache.";
        c.set("key1", 60, s);
        Object myObject1 = c.get("key1");

        System.out.println(myObject1);

        /*String s2 = "Hello, key2 Cache.";
        c.set("key2", 60, s2);
        Object myObject2 = c.get("key2");

        System.out.println(myObject2);*/

        byte[] bKey = DefaultHashAlgorithm.computeMd5("key1");
        long rv = rv = ((long) (bKey[3] & 0xFF) << 24)
                | ((long) (bKey[2] & 0xFF) << 16)
                | ((long) (bKey[1] & 0xFF) << 8)
                | (bKey[0] & 0xFF);
        System.out.println("Cache Key Hash Value:" + rv);

        c.shutdown();
    }


}

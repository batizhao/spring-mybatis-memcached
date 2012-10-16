package me.batizhao;

import net.rubyeye.xmemcached.*;
import net.rubyeye.xmemcached.impl.KetamaMemcachedSessionLocator;
import net.rubyeye.xmemcached.utils.AddrUtil;

public class XMemcachedTest {

    public static void main(String[] args) throws Exception {
        MemcachedClientBuilder builder = new XMemcachedClientBuilder(AddrUtil.getAddresses("127.0.0.1:11211 127.0.0.1:11222"));
        KetamaMemcachedSessionLocator ketamaNodeLocator = new KetamaMemcachedSessionLocator();
        builder.setSessionLocator(ketamaNodeLocator);
        MemcachedClient c = builder.build();

        String s = "Hello, key1 Cache.";
        c.set("key1", 60, s);
        Object myObject1 = c.get("key1");

        System.out.println(myObject1);

        /*String s2 = "Hello, key2 Cache.";
        c.set("key2", 60, s2);
        Object myObject2 = c.get("key2");

        System.out.println(myObject2);*/

        byte[] bKey = HashAlgorithm.computeMd5("key1");
        long rv = (long) (bKey[3] & 0xFF) << 24 | (long) (bKey[2] & 0xFF) << 16
                | (long) (bKey[1] & 0xFF) << 8 | bKey[0] & 0xFF;
        System.out.println("Cache Key Hash Value:" + rv);
        System.out.println("Server Node: " + ketamaNodeLocator.getSessionByKey("key1"));

        c.shutdown();

    }
}

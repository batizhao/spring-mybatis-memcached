package me.batizhao.cache;

import com.google.code.ssm.api.ParameterDataUpdateContent;
import com.google.code.ssm.api.ParameterValueKeyProvider;
import com.google.code.ssm.api.counter.DecrementCounterInCache;
import com.google.code.ssm.api.counter.IncrementCounterInCache;
import com.google.code.ssm.api.counter.ReadCounterFromCache;
import com.google.code.ssm.api.counter.UpdateCounterInCache;
import org.springframework.stereotype.Component;

@Component
public class Counter {

    @DecrementCounterInCache(namespace = "follower")
    public void decrement(@ParameterValueKeyProvider String key) {

    }

    @IncrementCounterInCache(namespace = "follower")
    public void increment(@ParameterValueKeyProvider String key) {

    }

    @ReadCounterFromCache(namespace = "follower")
    public long getCounter(@ParameterValueKeyProvider String key) {
        return 100;
    }

    @UpdateCounterInCache(namespace = "follower", expiration = 100)
    public void update(@ParameterValueKeyProvider String key, @ParameterDataUpdateContent Long value) {

    }
}

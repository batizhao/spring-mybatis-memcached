package me.batizhao.cache;

import com.google.code.ssm.api.InvalidateAssignCache;
import com.google.code.ssm.api.InvalidateSingleCache;
import com.google.code.ssm.api.ParameterValueKeyProvider;
import org.springframework.stereotype.Component;

@Component
public class UserCache {

    @InvalidateSingleCache(namespace = "user/list")
    public void invalidateGetUsersByRoleId(@ParameterValueKeyProvider Long id){
    }

    @InvalidateAssignCache(assignedKey = "user/getUsersByRoleIds", namespace = "user")
    public void invalidategetUsersByRoleIds(){
    }
}

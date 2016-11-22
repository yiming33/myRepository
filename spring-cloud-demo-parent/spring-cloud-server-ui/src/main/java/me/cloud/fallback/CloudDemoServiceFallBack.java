package me.cloud.fallback;

import me.cloud.service.CloudDemoService;
import org.springframework.stereotype.Component;

/**
 * Created by YiMiNG on 2016/11/21.
 */
@Component
public class CloudDemoServiceFallBack implements CloudDemoService{
    @Override
    public String getMessage() {
        return "this is  feign fallback";
    }
}

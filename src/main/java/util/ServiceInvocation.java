package util;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.ui.ModelMap;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by Flyme on 2017/1/24.
 */
public class ServiceInvocation implements InvocationHandler {
    // 目标对象
    private Object target;

    public ServiceInvocation(Object target) {
        super();
        this.target = target;
    }


    //调用代理对象的方法时 会调用此方法
    @Transactional
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        try{
            // 执行目标对象的方法
            Object result = method.invoke(target, args);
            return result;
        }catch (Exception e){
            e.printStackTrace();
            for (Object obj:args) {
                if(obj instanceof ModelMap){
                    ((ModelMap) obj).addAttribute(Names.ERR_TAG, "未知错误");
                    return false;
                }
            }
            return false;
        }
    }

    public Object getProxy() {
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(), this);
    }

}

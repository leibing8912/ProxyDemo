package cn.jianke.proxydemo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @className: ProxyHandler
 * @classDescription: 代理接口调用处理器
 * @author: leibing
 * @createTime: 2017/2/18
 */
public class ProxyHandler implements InvocationHandler {
    // 需要被代理的委托类实例
    private Object proxied;

    /**
     * Constructor
     * @author leibing
     * @createTime 2017/2/18
     * @lastModify 2017/2/18
     * @param proxied 需要被代理的委托类实例
     * @return
     */
    public ProxyHandler(Object proxied){
        this.proxied = proxied;
    }

    @Override
    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
        return method.invoke(proxied, objects);
    }
}

package cn.jianke.proxydemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.lang.reflect.Proxy;

/**
 * @className: ProxyActivity
 * @classDescription: 代理页面
 * @author: leibing
 * @createTime: 2017/2/18
 */
public class ProxyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // new获取委托类实例
//        RealSubject mRealSubject = new RealSubject();
        try {
            // 反射获取委托类实例
            Class RealSubjectClass = Class.forName("cn.jianke.proxydemo.RealSubject");
            RealSubject mRealSubject = (RealSubject) RealSubjectClass.newInstance();
            // 代理
            Subject proxySubject = (Subject) Proxy.newProxyInstance(Subject.class.getClassLoader(),
                    new Class[]{Subject.class},
                    new ProxyHandler(mRealSubject));
            // 开始代理
            proxySubject.doSomeThing();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("ddddddddddddd 111 e = " + e.getMessage());
        } catch (InstantiationException e) {
            e.printStackTrace();
            System.out.println("ddddddddddddd 222 e = " + e.getMessage());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            System.out.println("ddddddddddddd 333 e = " + e.getMessage());
        }
    }
}

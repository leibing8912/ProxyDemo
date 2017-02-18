package cn.jianke.proxydemo;

/**
 * @className: RealSubject
 * @classDescription: 委托类
 * @author: leibing
 * @createTime: 2017/2/18
 */
public class RealSubject implements Subject{
    @Override
    public void doSomeThing() {
        System.out.println("dddddddddddd  我是委托类，我要开始工作了~~~~");
    }
}

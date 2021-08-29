package org.example.offer.mooc.other.pattern.callback;

public class CallbackDemo {
    public static void main(String[] args) {
        //回调函数:往组件注册自定义的方法以便组件在特定的场景下调用
        //这里thread就是组件,run就是回调函数.并不是希望直接调用run,而是希望组件thread在将来的某个时刻调用
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("我要休息了");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("我被回调了");
            }
        });
        thread.start();
    }
}

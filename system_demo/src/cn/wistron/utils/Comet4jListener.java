package cn.wistron.utils;


import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.comet4j.core.CometContext;
import org.comet4j.core.CometEngine;

import cn.wistron.bean.AlarmBean;
import cn.wistron.dao.AlarmDao;

public class Comet4jListener  implements ServletContextListener {
	    //频道1
        private static final String CHANNEL1 = "alarm";
        //频道2
        private static final String CHANNEL2="rootsrc";
        /*
         * (non-Javadoc)
         * @see javax.servlet.ServletContextListener#contextInitialized(javax.servlet.ServletContextEvent)
         *初始化山下文
         */
        public void contextInitialized(ServletContextEvent arg0) {
        	/*
        	 * CometContext:Comet4J上下文，负责初始化配置、引擎对象、连接器对象、消息缓存等。
        	 */
                CometContext cc = CometContext.getInstance();
                //注册频道，即标识哪些字段可用当成频道，用来作为向前台传送数据的“通道”
                cc.registChannel(CHANNEL1);
                cc.registChannel(CHANNEL2);
                Thread helloAppModule = new Thread(new HelloAppModule(), "Sender App Module");
                //下面的内部类的方法是个死循环，设置helloAppModule线程为“守护线程”，则当jvm只剩“守护线程”时(主线程结束)，该线程也会结束。
                helloAppModule.setDaemon(true);
                helloAppModule.start();

        }
			/*
			 * 内部线程类
			 */
        class HelloAppModule implements Runnable {
                public void run() {
                        while (true) {
                                try {
                                        Thread.sleep(10000);
                                } catch (Exception ex) {
                                        ex.printStackTrace();
                                }
                                // CometEngine ： 引擎，负责管理和维持连接，并能够完成必要的发送服务
                                CometEngine engine = CometContext.getInstance().getEngine();
                                /*
                                 * 参数的意思：通过什么频道（CHANNEL1）发送什么数据（wav/01.wav），
                                 * 前台可用可用频道的值（alarm）来获取某频道发送的数据
                                 */
                             /*   AlarmBean first = new AlarmDao().getFirst();*/
                              //  System.out.println(first.getAlarm_Time());
                                
                                engine.sendToAll(CHANNEL1,"");
                                engine.sendToAll(CHANNEL2, "wav/01.wav");
                        }
                }
        }

        public void contextDestroyed(ServletContextEvent arg0) {

        }
}
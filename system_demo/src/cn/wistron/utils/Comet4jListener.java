package cn.wistron.utils;


import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.comet4j.core.CometContext;
import org.comet4j.core.CometEngine;

import cn.wistron.bean.AlarmBean;
import cn.wistron.dao.AlarmDao;

public class Comet4jListener  implements ServletContextListener {
	    //Ƶ��1
        private static final String CHANNEL1 = "alarm";
        //Ƶ��2
        private static final String CHANNEL2="rootsrc";
        /*
         * (non-Javadoc)
         * @see javax.servlet.ServletContextListener#contextInitialized(javax.servlet.ServletContextEvent)
         *��ʼ��ɽ����
         */
        public void contextInitialized(ServletContextEvent arg0) {
        	/*
        	 * CometContext:Comet4J�����ģ������ʼ�����á��������������������Ϣ����ȡ�
        	 */
                CometContext cc = CometContext.getInstance();
                //ע��Ƶ��������ʶ��Щ�ֶο��õ���Ƶ����������Ϊ��ǰ̨�������ݵġ�ͨ����
                cc.registChannel(CHANNEL1);
                cc.registChannel(CHANNEL2);
                Thread helloAppModule = new Thread(new HelloAppModule(), "Sender App Module");
                //������ڲ���ķ����Ǹ���ѭ��������helloAppModule�߳�Ϊ���ػ��̡߳�����jvmֻʣ���ػ��̡߳�ʱ(���߳̽���)�����߳�Ҳ�������
                helloAppModule.setDaemon(true);
                helloAppModule.start();

        }
			/*
			 * �ڲ��߳���
			 */
        class HelloAppModule implements Runnable {
                public void run() {
                        while (true) {
                                try {
                                        Thread.sleep(10000);
                                } catch (Exception ex) {
                                        ex.printStackTrace();
                                }
                                // CometEngine �� ���棬��������ά�����ӣ����ܹ���ɱ�Ҫ�ķ��ͷ���
                                CometEngine engine = CometContext.getInstance().getEngine();
                                /*
                                 * ��������˼��ͨ��ʲôƵ����CHANNEL1������ʲô���ݣ�wav/01.wav����
                                 * ǰ̨���ÿ���Ƶ����ֵ��alarm������ȡĳƵ�����͵�����
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
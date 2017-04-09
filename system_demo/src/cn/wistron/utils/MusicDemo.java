package cn.wistron.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import sun.audio.*;

/**
 * ������������
 * 
 * @author С��
 *
 */
public class MusicDemo {
	private static MusicDemo ms;
	public static MusicDemo getInstance(){
		if(ms!=null){
			ms=new MusicDemo();
		}
		
		return ms; 
	}
    
    public static void SoundUtils(String path) throws InterruptedException, IOException{
        // ���������ļ�����������
        InputStream in = null;
		try {
			in = new FileInputStream(path);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        // ������Ƶ������
        final AudioStream audioStream = new AudioStream(in);
        new Thread(new Runnable() {         
           
            public void run() {
                // ʹ����Ƶ��������������
                AudioPlayer.player.start(audioStream);              
            }
        }).start();

        Thread.sleep(12000);
        // ֹͣ��������
        AudioPlayer.player.stop(audioStream);
    }
}
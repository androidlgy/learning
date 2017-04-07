package cn.wistron.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import sun.audio.*;

/**
 * 测试声音播放
 * 
 * @author 小明
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
        // 创建音乐文件输入流对象
        InputStream in = null;
		try {
			in = new FileInputStream(path);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        // 创建音频流对象
        final AudioStream audioStream = new AudioStream(in);
        new Thread(new Runnable() {         
           
            public void run() {
                // 使用音频播放器播放声音
                AudioPlayer.player.start(audioStream);              
            }
        }).start();

        Thread.sleep(12000);
        // 停止声音播放
        AudioPlayer.player.stop(audioStream);
    }
}
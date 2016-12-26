
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import sun.audio.*;

/**
 * ������������
 * 
 * @author andy
 *
 */
public class MusicDemo {

    public static void main(String[] args) throws Exception {
        // ���������ļ�����������
        InputStream in = new FileInputStream("E://01.wav");
        // ������Ƶ������
        final AudioStream audioStream = new AudioStream(in);
        new Thread(new Runnable() {         
            @Override
            public void run() {
                // ʹ����Ƶ��������������
                AudioPlayer.player.start(audioStream);              
            }
        }).start();

        Thread.sleep(8000);
        // ֹͣ��������
        AudioPlayer.player.stop(audioStream);
    }
}
package cn.fiberhome.Thread1;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

//传统定时器
public class TraditionalTimerTest {
	private static int count=0;
	public static void main(String[] args) {
	/*	new Timer().schedule(new TimerTask() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("bombing!");
			}
		}, 10000,30000);//定时器调度
*/	
    
	class MyTimeTask extends TimerTask{
		
		@Override
		public void run() {
			count=(count+1)%2;
			// TODO Auto-generated method stub
			System.out.println("bombing!");
			new Timer().schedule(/*new TimerTask() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					System.out.println("bombing!");
				}
			}*/new MyTimeTask(), 2000+2000*count);
		}
	}

	
     new Timer().schedule(new MyTimeTask(),2000+2000*count);
		while(true){
			System.out.println(new Date().getSeconds());
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			
		}
	}

}


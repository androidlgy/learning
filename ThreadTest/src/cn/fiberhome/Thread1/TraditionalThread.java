package cn.fiberhome.Thread1;

public class TraditionalThread {
	public static void main(String[] args) {
		//方式1
		Thread thread = new Thread(){
			@Override
			public void run() {
				// TODO Auto-generated method stub
				while(true){
					try {
						Thread.sleep(500);
					} catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
					}
					System.out.println("1:"+Thread.currentThread().getName());//获取当前执行线程的名称
					//System.out.println("2:"+this.getName());
				}
			}
		};		
		thread.start();
		//方式2
		
		Thread thread2 = new Thread(new Runnable() {
			@Override
			public void run()  {
				// TODO Auto-generated method stub
				while(true){
					try {
						Thread.sleep(500);
					} catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
					}
					System.out.println("2:"+Thread.currentThread().getName());//获取当前执行线程的名称
				}
			}
		});
		thread2.start();
		
		//方式3
		new Thread(
				new Runnable() {
					
					@Override
					public void run()  {
						// TODO Auto-generated method stub
						while(true){
							try {
								Thread.sleep(500);
							} catch (Exception e) {
								// TODO: handle exception
								e.printStackTrace();
							}
							System.out.println("4:"+Thread.currentThread().getName());//获取当前执行线程的名称
						}
					}
				}
				){
			
			@Override
			public void run()  {
				// TODO Auto-generated method stub
				while(true){
					try {
						Thread.sleep(500);
					} catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
					}
					System.out.println("3:"+Thread.currentThread().getName());//获取当前执行线程的名称
				}
			}
		}.start();
	}

}

package cn.fiberhome.Thread1;

public class TraditionalThread {
	public static void main(String[] args) {
		//��ʽ1
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
					System.out.println("1:"+Thread.currentThread().getName());//��ȡ��ǰִ���̵߳�����
					//System.out.println("2:"+this.getName());
				}
			}
		};		
		thread.start();
		//��ʽ2
		
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
					System.out.println("2:"+Thread.currentThread().getName());//��ȡ��ǰִ���̵߳�����
				}
			}
		});
		thread2.start();
		
		//��ʽ3
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
							System.out.println("4:"+Thread.currentThread().getName());//��ȡ��ǰִ���̵߳�����
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
					System.out.println("3:"+Thread.currentThread().getName());//��ȡ��ǰִ���̵߳�����
				}
			}
		}.start();
	}

}

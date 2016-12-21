package cn.fiberhome.Thread1;

public class TraditionalSynchronized {
	public static void main(String[] args) {
		new TraditionalSynchronized().init();
		
	}
	private void init(){
		final Outputer outputer = new Outputer();
	    new Thread(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					while(true){
						try {
							Thread.sleep(10);
						} catch (Exception e) {
							// TODO: handle exception
							e.printStackTrace();
						}
						outputer.output("linguangyuan**************");
					}
					
				}
			}).start();
	    
	    new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				while(true){
					try {
						Thread.sleep(10);
					} catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
					}
					outputer.output("fangdan-------------------");
				}
				
			}
		}).start();
	}
   class Outputer{
	   public void output(String name){
		   int length = name.length();
		   synchronized (this) {
			   for(int i=0;i<length;i++){
				   System.out.print(name.charAt(i));
			   }			
		}
		   
		   System.out.println();
	   }
   }
}

package cn.fiberhome.Thread1;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class ThreadScopeShareData {
	//private static int date=0;
	//private static Map<Thread,Integer> threadData=new HashMap<Thread,Integer>();
	private static ThreadLocal<Integer> x=new ThreadLocal<Integer>();
	private static ThreadLocal<MyThreadScopeData> myThreadScopeData=new ThreadLocal<MyThreadScopeData>();
	public static void main(String[] args) {
		for(int i=0;i<2;i++){
		new Thread(new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				int date = new Random().nextInt();
				System.out.println(Thread.currentThread().getName()+" has put date "+date);
				//threadData.put(Thread.currentThread(), date);
				x.set(date);
				MyThreadScopeData.getInstance().setName("name "+date);
				MyThreadScopeData.getInstance().setAge(date);
				//mydata.setName("name "+date);
				//mydata.setAge(date);
				//myThreadScopeData.set(mydata);
				new A().get();
				new B().get();
				
			}
		}).start();
		
	}
}
   static class A{
	   public void get(){
		   //date=threadData.get(Thread.currentThread());
		  int date=x.get();
		   System.out.println("A from"+Thread.currentThread().getName()+" get date "+date);
		  // MyThreadScopeData mydate = myThreadScopeData.get();
		   MyThreadScopeData mydate = MyThreadScopeData.getInstance();
		   
		   System.out.println("A from"+Thread.currentThread().getName()+" getmydate "+mydate.getName()+","+mydate.getAge());
	   }
   }
   static class B{
	   public void get(){
		   //date=threadData.get(Thread.currentThread());
		  int date=x.get();
		   System.out.println("B from"+Thread.currentThread().getName()+" get date "+date);
	   }
   }
}
  class MyThreadScopeData{
	  private MyThreadScopeData(){
		  
	  }
	  public static MyThreadScopeData getInstance(){
		  MyThreadScopeData instance=map.get();
		  if(instance==null){
			  instance=new MyThreadScopeData();
			  map.set(instance);
		  }
		  return instance;
	  }
	  //private static MyThreadScopeData instance=new MyThreadScopeData();//±¥ººÊ½
	 // private static MyThreadScopeData instance=null;//¶öººÊ½
	  private static ThreadLocal<MyThreadScopeData> map=new ThreadLocal<MyThreadScopeData>();
	 
	  
	  private String name;
	  private int age;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	  
  }

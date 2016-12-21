package cn.wistron.utils;

public class TestMail {
	public static void main(String[] args){   
        //这个类主要是设置邮件   
     MailSenderInfo mailInfo = new MailSenderInfo();    
     mailInfo.setMailServerHost("smtp.163.com");    
     mailInfo.setMailServerPort("25");    
     mailInfo.setValidate(true);    
     mailInfo.setUserName("lgy1152835411@163.com");    
     mailInfo.setPassword("fd52013147515");//您的邮箱密码    
     mailInfo.setFromAddress("lgy1152835411@163.com");    
     mailInfo.setToAddress("602278868@qq.com");    
     mailInfo.setSubject("林德华");    
     mailInfo.setContent("这是我用javamail发的一封邮件");    
        //这个类主要来发送邮件   
     SimpleMailSender sms = new SimpleMailSender();   
         sms.sendTextMail(mailInfo);//发送文体格式    
        /* sms.sendHtmlMail(mailInfo);//发送html格式   
*/   }  

}

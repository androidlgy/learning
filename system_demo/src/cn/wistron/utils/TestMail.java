package cn.wistron.utils;

public class TestMail {
	public static void main(String[] args){   
        //�������Ҫ�������ʼ�   
     MailSenderInfo mailInfo = new MailSenderInfo();    
     mailInfo.setMailServerHost("smtp.163.com");    
     mailInfo.setMailServerPort("25");    
     mailInfo.setValidate(true);    
     mailInfo.setUserName("lgy1152835411@163.com");    
     mailInfo.setPassword("fd52013147515");//������������    
     mailInfo.setFromAddress("lgy1152835411@163.com");    
     mailInfo.setToAddress("602278868@qq.com");    
     mailInfo.setSubject("�ֵ»�");    
     mailInfo.setContent("��������javamail����һ���ʼ�");    
        //�������Ҫ�������ʼ�   
     SimpleMailSender sms = new SimpleMailSender();   
         sms.sendTextMail(mailInfo);//���������ʽ    
        /* sms.sendHtmlMail(mailInfo);//����html��ʽ   
*/   }  

}

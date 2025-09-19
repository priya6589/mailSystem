import com.app.mail.GmailSender;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        GmailSender sender = new GmailSender();
        String from = "riyaded539@dotxan.com";
        String to = "fofen33945@camjoint.com";
        String subject = "Testing Purpose";
        String body = "This is only for testing purpose...!!!";
        File file = new File("C:\\Users\\priya\\Downloads\\java_interview_qa.pdf");
        boolean b =  sender.sendEmail(from,to,subject,body,file);

        if(b){
            System.out.println("Congrats...Your email sent successfully...!!!");
        }else{
            System.out.println("Oops...There is something a problem with sending your email.");
        }
    }
}

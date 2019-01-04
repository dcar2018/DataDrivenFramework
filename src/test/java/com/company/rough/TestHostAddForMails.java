package com.company.rough;

import com.company.utilities.MonitoringMail;
import com.company.utilities.TestConfig;

import javax.mail.MessagingException;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class TestHostAddForMails {
    public static void main(String[] args) throws UnknownHostException, MessagingException {

        System.out.println("Get local host  = " + InetAddress.getLocalHost().getHostAddress());

        MonitoringMail mail = new MonitoringMail();

        String messageBody = "http://" + InetAddress.getLocalHost().getHostAddress() + ":8080/job/DataDrivenFramework/Extent_20HTML_20Test_20Results_20Report/";
        System.out.println("messageBody = " + messageBody);

        //below will send the mail to the given address
        mail.sendMail(TestConfig.server, TestConfig.from, TestConfig.to, TestConfig.subject, messageBody);


    }

}

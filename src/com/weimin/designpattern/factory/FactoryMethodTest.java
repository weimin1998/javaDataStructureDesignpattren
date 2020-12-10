package com.weimin.designpattern.factory;

/**
 * @Author weimin
 * @Date 2020/10/5 0005 15:10
 */
public class FactoryMethodTest {
    public static void main(String[] args) {
        Message email = MessageFactory.getEmail();
        Message qq = MessageFactory.getQq();
        Message sms = MessageFactory.getSms();
        Message weChat = MessageFactory.getWeChat();
        System.out.println(email);
        System.out.println(qq);
        System.out.println(sms);
        System.out.println(weChat);
    }
}

interface Message {}

class Sms implements Message {}
class WeChat implements Message {}
class Qq implements Message {}
class Email implements Message {}

class MessageFactory {
    public static Sms getSms() {
        return new Sms();
    }

    public static WeChat getWeChat() {
        return new WeChat();
    }

    public static Qq getQq() {
        return new Qq();
    }

    public static Email getEmail() {
        return new Email();
    }
}

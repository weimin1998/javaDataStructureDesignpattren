package com.weimin.designpattern.principle.dependencyInversion;

/**
 * @Author weimin
 * @Date 2020/10/4 0004 14:18
 */
public class Main {
    public static void main(String[] args) {
        Person person = new Person();
        person.receive(new Email());
        person.receive(new QQ());
        person.receive(new WeChat());
        person.receive(new Sms());
    }
}

class Person{
    public void receive(Message message){
        System.out.println(message.getInfo());
    }
}

interface Message{
    String getInfo();
}

class Email implements Message{
    @Override
    public String getInfo() {
        return "邮件信息";
    }
}
class Sms implements Message{
    @Override
    public String getInfo() {
        return "短信信息";
    }
}

class WeChat implements Message{
    @Override
    public String getInfo() {
        return "微信信息";
    }
}

class QQ implements Message{
    @Override
    public String getInfo() {
        return "qq信息";
    }
}

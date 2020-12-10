package com.weimin.designpattern.adapter.classadapter;

/**
 * @Author weimin
 * @Date 2020/10/6 0006 12:39
 */
public class ClassadapterTest {
    public static void main(String[] args) {
        Phone phone = new Phone();
        phone.setPower5(new PowerAdapter());

        phone.charging();
    }
}

class Power220 {
    // 220v的电压
    int v = 220;
    public int power220V(){
        return v;
    }
}

interface Power5 {
    // 5v的电压
    int power5v();
}

class PowerAdapter extends Power220 implements Power5 {

    @Override
    public int power5v() {
        // 相当于降压器,220v的电压降为5v
        return v / 44;
    }
}

class Phone{
    private Power5 power5;

    public void setPower5(Power5 power5) {
        this.power5 = power5;
    }

    public void charging(){
        int i = power5.power5v();
        System.out.println("手机使用"+i+"v的电压充电");
    }
}

package com.weimin.designpattern.adapter.objectadapter;

/**
 * @Author weimin
 * @Date 2020/10/6 0006 12:49
 */
public class ObjectAdapterTest {
    public static void main(String[] args) {
        Phone phone = new Phone();
        PowerAdapter powerAdapter = new PowerAdapter();
        Power220 power220 = new Power220();
        powerAdapter.setPower220(power220);
        phone.setPower5(powerAdapter);

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

class PowerAdapter implements Power5{

    // 不继承，改为聚合
    private Power220 power220;


    public void setPower220(Power220 power220) {
        this.power220 = power220;
    }

    @Override
    public int power5v() {
        // 相当于降压器,220v的电压降为5v
        return power220.power220V() / 44;
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

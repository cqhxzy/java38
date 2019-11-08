package usb;

public class UsbFan extends Fan implements UsbInterface {
    @Override
    public void service() {
        System.out.println("风扇连接USB接口后开始旋转");
    }

    @Override
    public void speed() {

    }

    @Override
    public void test() {

    }

    @Override
    public void m1() {

    }
}

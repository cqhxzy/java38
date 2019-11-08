package usb;

public class Udisk implements UsbInterface {
    @Override
    public void service() {
        System.out.println("usb连接U盘后，开始传输数据");
    }
}

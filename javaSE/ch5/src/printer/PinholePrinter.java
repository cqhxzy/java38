package printer;

import printer.inkbox.InkBox;
import printer.paper.Paper;

/**
 * 针孔打印机
 */
public class PinholePrinter extends AbstractPrinter{
    public PinholePrinter(InkBox inkBox, Paper paper) {
        super("惠普",inkBox,paper);
    }

    @Override
    public void print(String str) {
        System.out.println(super.getBrand() + "打印机在" + super.getPaper().getSize() + "纸上面打印了"
                + super.getInkBox().getColor() + "的内容：" + str
        );
    }

    @Override
    public void scan() {
        System.out.println(super.getBrand() + "开始扫描数据...");
    }
}

package printer;

import printer.inkbox.InkBox;
import printer.paper.Paper;

/**
 * 复印机
 */
public class Duplicator extends AbstractPrinter{
    public Duplicator(InkBox inkBox, Paper paper) {
        super("联想",inkBox,paper);
    }

    @Override
    public void print(String str) {
        System.out.println(super.getBrand() + "复印机在" + super.getPaper().getSize() + "纸上面打印了"
            + super.getInkBox().getColor() + "的内容：" + str
        );

    }

    @Override
    public void scan() {
        System.out.println(super.getBrand() + "复印机开始扫描数据...");
    }
}

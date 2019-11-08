package printer;

import printer.inkbox.BlackInkBox;
import printer.inkbox.ColorInkBox;
import printer.inkbox.InkBox;
import printer.paper.A3Paper;
import printer.paper.A4Paper;
import printer.paper.Paper;

public class Client {
    public static void main(String[] args) {

        InkBox black = new BlackInkBox();//黑色墨盒
        InkBox color = new ColorInkBox();//彩色墨盒

        Paper a4 = new A4Paper(); //A4纸
        Paper a3 = new A3Paper(); //A3纸

        //实例化打印机，并安装墨盒和纸张
        //AbstractPrinter printer = new Duplicator(color,a3);

        AbstractPrinter printer = new PinholePrinter(black, a4);
        printer.print("hello world");

    }
}

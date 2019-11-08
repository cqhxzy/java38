package printer;

import printer.inkbox.InkBox;
import printer.paper.Paper;

/**
 * 抽象打印机
 */
public abstract class AbstractPrinter implements Printer{
    /***
     * 使用打印机之前必须安装墨盒和纸张
     * @param brand
     */
    public AbstractPrinter(String brand,InkBox inkBox,Paper paper) {
        this.brand = brand;
        this.inkBox = inkBox;
        this.paper = paper;
    }
    //品牌
    private String brand;
    private InkBox inkBox; //组合一个墨盒
    private Paper paper;

    public String getBrand() {
        return brand;
    }

    public InkBox getInkBox() {
        return inkBox;
    }

    public Paper getPaper() {
        return paper;
    }
}

package proxy;

/**
 * 明星
 */
public class SuperStar implements Work {
    private String name;

    public SuperStar(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void ad() {
        System.out.println(this.name + "拍广告");
    }

    @Override
    public void tv() {
        System.out.println(this.name + "拍电视剧");
    }
}

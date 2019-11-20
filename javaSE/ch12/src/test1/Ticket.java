package test1;

/**
 * 火车票
 * 共享资源类
 */
public class Ticket {
    //总共20张票
    private int ticket = 20;

    //为了实现单例模式
    private Ticket(){}

    public static Ticket getInstance() {
        //为了实现延迟获取Ticket类的对象
        return TicketInner.ticket;
    }

    /**
     * 静态内部类
     */
    private static class TicketInner{
        private static Ticket ticket = new Ticket();
    }

    /**
     * 同步方法
     */
    public synchronized void sell(){
        if (this.getTicket() > 0) {
            String name = Thread.currentThread().getName();
            System.out.println(name + "卖出了票号为" + ticket + "的票");
            ticket--;
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public int getTicket() {
        return ticket;
    }
}

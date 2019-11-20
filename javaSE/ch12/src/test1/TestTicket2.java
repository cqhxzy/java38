package test1;

public class TestTicket2 {


    //线程
    private static class TicketThread implements Runnable {

        //引入共享资源
        private Ticket ticket;
        public TicketThread(Ticket ticket){
            this.ticket = ticket;
        }

        @Override
        public void run() {
            //只要还有余票，就继续卖
            while (this.ticket.getTicket() > 0) {

                ////////////

                ticket.sell();
            }
        }
    }

    public static void main(String[] args) {
        Ticket ticket = Ticket.getInstance();//单例模式

        TicketThread ticketThread1 = new TicketThread(ticket);
        //第一个线程
        Thread t1 = new Thread(ticketThread1, "重庆北站");

        //第二个线程
        TicketThread ticketThread2 = new TicketThread(ticket);
        Thread t2 = new Thread(ticketThread2, "重庆西站");

        TicketThread ticketThread3 = new TicketThread(ticket);
        Thread t3 = new Thread(ticketThread3, "重庆南站");

        TicketThread ticketThread4 = new TicketThread(ticket);
        Thread t4 = new Thread(ticketThread4, "菜园坝站");

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}


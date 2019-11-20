package test2;

/**
 * 消费者
 */
public class Consumer implements Runnable{

    //引入共享资源
    private Repo repo;

    public Consumer(Repo repo) {
        this.repo = repo;
    }

    @Override
    public void run() {
        while (true) {
            repo.sell();
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

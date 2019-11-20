package test2;

/**
 * 生产者
 */
public class Productor implements Runnable{
    private Repo repo;

    public Productor(Repo repo) {
        this.repo = repo;
    }

    @Override
    public void run() {

        while (true) {
            this.repo.produce();
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}

package by.bsu.lab11;

public class MyThread extends Thread{
    private MyResource resource;

    public MyThread(MyResource resource) throws MyThreadException {
        this.resource = resource;
        int cur = resource.getCurrent();
        cur++;
        resource.setCurrent(cur);
        if(resource.getCurrent()>resource.getBound()) {
            throw new MyThreadException("Only "+resource.getBound()+" buses have access to "+resource.getBusStation()+"!");
        }
    }

    @Override
    public void run(){
        System.out.println(Thread.currentThread().getName());
    }
}

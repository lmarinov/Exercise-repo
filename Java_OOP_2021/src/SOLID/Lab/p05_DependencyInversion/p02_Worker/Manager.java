package SOLID.Lab.p05_DependencyInversion.p02_Worker;

public class Manager implements ManagerInterface{
    private Worker worker;

    public Manager(Worker worker) {
        this.worker = worker;
    }

    @Override
    public void manage(){
        this.worker.work();
    }
}

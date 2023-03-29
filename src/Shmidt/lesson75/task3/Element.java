package Shmidt.lesson75.task3;

public class Element {

    private int number;

    public Element(int number) {
        this.number = number;
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("Finalize. " + number);
        super.finalize();
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}

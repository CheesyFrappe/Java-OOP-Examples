public class Dog implements Interface1 {

    @Override
    public void speak() {
        System.out.println("hav-hav");
    }

    @Override
    public void walk() {
        System.out.println("Dog walks");
    }

    @Override
    public void swim() {
        System.out.println("can swim");
    }

}

public class Cat implements Interface1 {

    @Override
    public void speak() {
        System.out.println("meow-meow");
    }

    @Override
    public void walk() {
        System.out.println("Cat walks");
    }

    @Override
    public void swim() {
        System.out.println("can't swim");
    }
}

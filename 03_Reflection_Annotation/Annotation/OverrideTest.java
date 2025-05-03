class Animal{
	public void makeSound() {
		System.out.println("this animal makes sound");
	}
}
class Dog extends Animal{
	@Override
	public void makeSound() {
		
		System.out.println("Dog barks");
	}
}
public class OverrideTest {
	public static void main(String[] args) {
		Dog a=new Dog();
		a.makeSound();
	}

}

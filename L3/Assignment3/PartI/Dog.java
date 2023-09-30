
public class Dog {

    private int age;
    private String owner;
    private String breed;

    public Dog() {};

    public Dog(int age, String owner, String breed) {
        this.age = age;
        this.owner = owner;
        this.breed = breed;
    }

    public static boolean hasSameOwner(Dog dog1, Dog dog2) {
        return dog1.owner.equals(dog2.owner);
    }

    public static double avgAge(Dog[] dogs) {
        double age = 0;
        for(Dog d: dogs) {
        	if(d != null) age += d.age;
        }
        return age / dogs.length;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String toString() {
        return this.getBreed() + ": Owner: " + this.getOwner() + ", Age: " + this.getAge();
    }

    public static void main(String[] args) {
        Dog[] dogs = new Dog[5];
        dogs[0] = new Dog(4, "Stephen Colbert", "Boxer");
        dogs[1] = new Dog(8, "Dexter Morgan", "Corgi");
        dogs[2] = new Dog(8, "Dexter Morgan", "Corgi2");
        System.out.println(dogs[0].toString());
        System.out.println("Avg age: " + Dog.avgAge(dogs));
        System.out.println("Dog 0 and Dog 1 have same owner: " + Dog.hasSameOwner(dogs[0], dogs[1]));
        System.out.println("Dog 1 and Dog 2 have same owner: " + Dog.hasSameOwner(dogs[1], dogs[2]));
    }
}
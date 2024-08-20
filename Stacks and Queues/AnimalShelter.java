import java.util.LinkedList;

public class AnimalShelter {
    public static void main(String[] args) {
        AnimalShelter shelter = new AnimalShelter();
        AnimalQueue queue = shelter.new AnimalQueue();

        queue.enqueue(shelter.new Dog("Buddy"));
        queue.enqueue(shelter.new Cat("Whiskers"));
        queue.enqueue(shelter.new Dog("Rex"));
        queue.enqueue(shelter.new Cat("Mittens"));

        System.out.println("Dequeued: " + queue.dequeueAny().name); // Buddy
        System.out.println("Dequeued Dog: " + queue.dequeueDogs().name); // Rex
        System.out.println("Dequeued Cat: " + queue.dequeueCats().name); // Whiskers
    }

    abstract class Animal {
        private int order;
        protected String name;

        public Animal(String name) {
            this.name = name;
        }

        public void setOrder(int ord) {
            this.order = ord;
        }

        public int getOrder() {
            return order;
        }

        // Compare order of animal to return the older item
        public boolean isOlderThan(Animal a) {
            return this.order < a.getOrder();
        }
    }

    class AnimalQueue {
        LinkedList<Dog> dogs = new LinkedList<Dog>();
        LinkedList<Cat> cats = new LinkedList<Cat>();

        private int order = 0; // acts as timestamp

        public void enqueue(Animal a) {
            // order is used as a sort of timestamp
            // so that we can compare the insertion order of dog to a Cat
            a.setOrder(order);
            order++;

            if (a instanceof Dog)
                dogs.addLast((Dog) a);
            else if (a instanceof Cat)
                cats.addLast((Cat) a);
        }

        public Animal dequeueAny() {
            // Look at tops of dog and cat queues, and pop the queue with the oldest value
            if (dogs.size() == 0) {
                return dequeueCats();
            } else if (cats.size() == 0) {
                return dequeueDogs();
            }

            Dog dog = dogs.peek();
            Cat cat = cats.peek();

            if (dog.isOlderThan(cat)) {
                return dequeueDogs();
            } else {
                return dequeueCats();
            }
        }

        public Dog dequeueDogs() {
            return dogs.poll();
        }

        public Cat dequeueCats() {
            return cats.poll();
        }
    }

    class Dog extends Animal {
        public Dog(String n) {
            super(n);
        }
    }

    class Cat extends Animal {
        public Cat(String n) {
            super(n);
        }
    }
}

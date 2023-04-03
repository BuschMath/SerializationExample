
/*In this example, we create a Person object and write it to a file called 
    person.ser using an ObjectOutputStream. We then read the object from 
    the file using an ObjectInputStream and store it in a new Person object 
    called deserializedPerson. We then print out both the original Person 
    object and the deserialized Person object to verify that the 
    deserialization process worked correctly. */

import java.io.*;

public class SerializationExample {

    public static void main(String[] args) {
        // create an object to serialize
        Person person = new Person("Alice", 30);

        try {
            // create a file output stream to write the serialized object to a file
            FileOutputStream fileOut = new FileOutputStream("person.ser");

            // create an object output stream to serialize the object and write it to the file output stream
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(person);

            // close the output streams
            out.close();
            fileOut.close();

            // deserialize the object by reading it from the file
            FileInputStream fileIn = new FileInputStream("person.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            Person deserializedPerson = (Person) in.readObject();

            // close the input streams
            in.close();
            fileIn.close();

            // print out the original and deserialized objects
            System.out.println("Original Person: " + person);
            System.out.println("Deserialized Person: " + deserializedPerson);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

// a sample serializable class
class Person implements Serializable {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String toString() {
        return "Person[name=" + name + ", age=" + age + "]";
    }
}

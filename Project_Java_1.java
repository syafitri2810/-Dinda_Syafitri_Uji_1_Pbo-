// Abstract class Vehicle 
public abstract class Vehicle {
    // Method abstract: harus diimplementasikan oleh subclass
    public abstract void startEngine();
}

// Interface untuk kendaraan listrik
interface Electric {
    void chargeBattery();
}

// Class Car mewarisi Vehicle dan mengimplementasikan Electric
class Car extends Vehicle implements Electric {
    @Override
    public void startEngine() 
    {
        System.out.println("Mobil menyala dengan tombol start dan tenaga listrik.");
    }

    @Override
    public void chargeBattery() 
    {
        System.out.println("Mobil sedang mengisi ulang daya baterai.");
    }
}

// Class Motorcycle hanya mewarisi Vehicle
class Motorcycle extends Vehicle {
    @Override
    public void startEngine() 
    {
        System.out.println("Motor menyala dengan kick starter atau tombol.");
    }
}

// Class utama untuk menjalankan program
class MainApp {
    public static void main(String[] args) 
    {
        // Polymorphism: Objek Vehicle bisa berupa Car atau Motorcycle
        Vehicle kendaraan1 = new Car();
        Vehicle kendaraan2 = new Motorcycle();

        // Memanggil method yang di-override
        kendaraan1.startEngine(); // Output: Mobil menyala...
        kendaraan2.startEngine(); // Output: Motor menyala...

        // Type casting untuk mengakses method khusus milik Car
        if (kendaraan1 instanceof Electric) 
        {
            Electric listrik = (Electric) kendaraan1;
            listrik.chargeBattery(); // Output: Mobil sedang mengisi daya baterai.
        }
    }
}
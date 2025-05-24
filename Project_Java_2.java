// Interface untuk produk yang kena pajak
interface Taxable {
    double getTax(); // Method yang wajib dibuat oleh class yang kena pajak
}

// Abstract class Product 
abstract class Product {
    protected String name;   // Nama produk
    protected double price;  // Harga produk

    // Konstruktor: digunakan untuk memberi nilai awal nama dan harga
    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    // Method abstract: harus diimplementasikan oleh setiap subclass
    public abstract double getTotalPrice();

    // Mengambil nama produk (digunakan saat menampilkan belanjaan)
    public String getName() {
        return name;
    }
}

// Subclass Food untuk produk makanan (tidak kena pajak)
class Food extends Product {
    // Konstruktor memanggil konstruktor Product
    public Food(String name, double price) 
    {
        super(name, price);
    }

    // Mengembalikan harga asli (tanpa pajak)
    @Override
    public double getTotalPrice() 
    {
        return price;
    }
}

// Subclass Beverage untuk produk minuman (kena pajak)
class Beverage extends Product implements Taxable {
    public Beverage(String name, double price) 
    {
        super(name, price);
    }

    // Menghitung pajak 10% dari harga
    @Override
    public double getTax() 
    {
        return price * 0.1;
    }

    // Harga total minuman = harga asli + pajak
    @Override
    public double getTotalPrice() 
    {
        return price + getTax();
    }
}

// Class utama yang menjalankan program kasir
class MainKasir {
    public static void main(String[] args) 
    {
        // Array belanjaan berisi campuran produk (makanan dan minuman)
        Product[] belanja = new Product[] 
        {
            new Food("Nasi Goreng", 15000),     // Tidak kena pajak
            new Beverage("Teh Manis", 5000),    // Kena pajak
            new Beverage("Kopi", 7000),         // Kena pajak
            new Food("Roti", 10000)             // Tidak kena pajak
        };

        double total = 0; // Untuk menyimpan total harga semua belanjaan

        System.out.println("Daftar Belanja:");
        // Loop melalui setiap item di array belanja
        for (Product p : belanja) 
        {
            // Menampilkan nama produk dan harga total (sudah dihitung otomatis apakah pakai pajak atau tidak)
            System.out.println("- " + p.getName() + ": Rp" + p.getTotalPrice());
            // Menambahkan harga total ke total keseluruhan
            total += p.getTotalPrice();
        }

        // Menampilkan total akhir yang harus dibayar
        System.out.println("Total Bayar: Rp" + total);
    }
}
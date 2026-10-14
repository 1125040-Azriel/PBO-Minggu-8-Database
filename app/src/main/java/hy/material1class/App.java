package hy.material1class;

import java.lang.reflect.Method;

class Mahasiswa {

    public static String universitas = "ITHB";

    // attributes
    public String nim;
    public String nama;

    // constructor
    public Mahasiswa(String nim, String nama) {
        this.nim = nim;
        this.nama = nama;
    }

    // method
    public void print() {
        System.out.println(
            "NIM: " +
                this.nim +
                "\nNama: " +
                this.nama +
                "\nKampus: " +
                Mahasiswa.universitas
        );
    }

    // public static void printNim(){
    //     System.out.println(nim);
    // }
}

public class App {

    public static void main(String[] args) throws NoSuchMethodException {
        // object
        Mahasiswa mahasiswa1 = new Mahasiswa("1112048", "Hans Yulian");
        Mahasiswa mahasiswa2 = new Mahasiswa("1117001", "Natasha Yulian");

        // calling object method
        mahasiswa1.print();
        mahasiswa2.print();
        System.out.println("------------------");

        // static property
        // mahasiswa1.universitas = "Institut Teknologi Harapan Bangsa";
        Mahasiswa.universitas = "Institut Teknologi Harapan Bangsa";
        mahasiswa1.print();
        mahasiswa2.print();
        System.out.println("------------------");

        // same method
        Method m1 = mahasiswa1.getClass().getMethod("print");
        Method m2 = mahasiswa2.getClass().getMethod("print");
        System.out.println("Same method object? " + m1.equals(m2));
    }
}

package hy.material1class;

enum JenisKelamin {
    WANITA,
    PRIA,
}

public class Enumeration {

    public Enumeration() {
        JenisKelamin jenis = JenisKelamin.WANITA;

        if (jenis == JenisKelamin.WANITA) {
            System.out.println("Jenis kelamin wanita");
        } else {
            System.out.println("Jenis kelamin bukan wanita");
        }

        switch (jenis) {
            case WANITA:
                System.out.println("Ini adalah wanita");
                break;
            case PRIA:
                System.out.println("Ini adalah pria");
                break;
        }
    }
}

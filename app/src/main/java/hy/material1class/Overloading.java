package hy.material1class;

class SegiEmpat {

    private int panjang;
    private int lebar;

    public SegiEmpat(int panjang, int lebar) {
        this.panjang = panjang;
        this.lebar = lebar;
    }

    public SegiEmpat(int sisi) {
        this.panjang = sisi;
        this.lebar = sisi;
    }

    public void gambar() {
        gambar("*");
    }

    public void gambar(String karakter) {
        for (int i = 0; i < panjang; i++) {
            for (int j = 0; j < lebar; j++) {
                System.out.print(karakter);
            }
            System.out.println();
        }
    }
}

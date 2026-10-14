
package hy.material8database.models;

public class Matakuliah {
    public String kodeMatakuliah;
    public String nama;
    public int sks;
    public String kodeJurusan;

    public Matakuliah(
            String kodeMatakuliah,
            String nama,
            int sks,
            String kodeJurusan) {
        this.kodeMatakuliah = kodeMatakuliah;
        this.nama = nama;
        this.sks = sks;
        this.kodeJurusan = kodeJurusan;
    }
}

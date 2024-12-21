/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author putri
 */
public class PenjadwalanBelajar extends Penjadwalan {
    private String mataKuliah;
    private String hari;
    private String waktu;

    public PenjadwalanBelajar(String kategori, String mataKuliah, String hari, String waktu) {
        super(kategori);
        this.mataKuliah = mataKuliah;
        this.hari = hari;
        this.waktu = waktu;
    }

    public String lihatJadwalBelajar() {
        return "Jadwal Belajar: " + mataKuliah + " pada hari " + hari + " jam " + waktu;
    }
}
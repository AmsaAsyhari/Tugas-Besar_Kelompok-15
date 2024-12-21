/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author putri
 */
public class PenjadwalanMain extends Penjadwalan {
    private String kegiatan;
    private String hari;
    private String waktu;

    public PenjadwalanMain(String kategori, String kegiatan, String hari, String waktu) {
        super(kategori);
        this.kegiatan = kegiatan;
        this.hari = hari;
        this.waktu = waktu;
    }

    public String lihatJadwalMain() {
        return "Jadwal Main: " + kegiatan + " pada hari " + hari + " jam " + waktu;
    }
}
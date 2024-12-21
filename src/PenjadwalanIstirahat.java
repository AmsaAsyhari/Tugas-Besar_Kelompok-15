/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author putri
 */
public class PenjadwalanIstirahat extends Penjadwalan {
    private String kategoriIstirahat;
    private String hari;
    private String waktu;

    public PenjadwalanIstirahat(String kategori, String kategoriIstirahat, String hari, String waktu) {
        super(kategori);
        this.kategoriIstirahat = kategoriIstirahat;
        this.hari = hari;
        this.waktu = waktu;
    }

    public String lihatJadwalIstirahat() {
        return "Jadwal Istirahat: " + kategoriIstirahat + " pada hari " + hari + " jam " + waktu;
    }
}
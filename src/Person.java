/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author putri
 */
public class Person {
    private String nama;
    private String ttl;
    private int umur;
    private String noHP;
    private String email;

    public Person(String nama, String ttl, int umur, String noHP, String email) throws Exception {
        if (!nama.matches("[a-zA-Z\\s]+")) {
            throw new Exception("Nama hanya boleh mengandung huruf!");
        }
        if (String.valueOf(umur).matches("\\d+")) {
            this.umur = umur;
        } else {
            throw new Exception("Umur harus angka!");
        }
        if (noHP.matches("\\d{1,12}")) {
            this.noHP = noHP;
        } else {
            throw new Exception("No HP harus angka dan maksimal 12 digit!");
        }
        this.nama = nama;
        this.ttl = ttl;
        this.email = email;
    }

    public boolean login(String inputNama, String inputNoHP) {
        return this.nama.equalsIgnoreCase(inputNama) && this.noHP.equals(inputNoHP);
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugaspraktikum7;

/**
 *
 * @author Lenovo
 */
public class Main {
    public static void main(String[] args) {
        Toko licioTekno = new Toko("Licio Tekno");
        // meminta menampilkan seluruh hp
        licioTekno.showListHandphone();
        
        // cek spesifikasi hp no 1 dan 5
        licioTekno.spesifikasi(1);
        licioTekno.spesifikasi(5);
        
        // objek handphone baru
        Smartphone geniusX101 = new Smartphone("Genius", "X101", "Android", "SMARTPHONE", "24MP", 'X');
        String messages = "Tahukah kamu bahwa bumi itu berbentuk donat?";
        geniusX101.sendMessage(123324L, messages);
        
        Symbian nuke404 = new Symbian("Nuke", "404", "Symbian", "SYMBIAN", "Keyboard Lite", 10);
        messages = "Hey there! \n i sent nuke for you.. here it is \nBOOM";
        nuke404.sendMessage(60492148L, messages);
        
        System.out.Println("Commit baru")
    }
}

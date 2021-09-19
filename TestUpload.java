/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugaspraktikum7;

class Toko {
    private String namaToko;
    private Smartphone merdekaSN205G = new Smartphone("Merdeka", "MN205G", "Android", "SMARTPHONE", "20MP", 'C');
    private Smartphone merdekaM45 = new Smartphone("Merdeka", "M45", "Android", "SMARTPHONE", "14MP", 'B');
    private Smartphone oiceSlim3 = new Smartphone("Oice", "Slim 3F", "Android", "SMARTPHONE", "18MP", 'C');
    private Smartphone oiceGamingX = new Smartphone("Oice", "Gaming X", "Android", "SMARTPHONE", "20MP", 'C');
    private Symbian nokiaN5X = new Symbian("Nokia", "N5x", "Symbian", "SYMBIAN","Built-in numeric", 20);
    private Symbian nokiaN95 = new Symbian("Nokia", "N95", "Symbian", "SYMBIAN","Slide-out numeric", 12);
    private Symbian nokiaThunder = new Symbian("Nokia", "Thunder", "SYMBIAN", "Symbian","Built-in numeric", 18);
   
    protected ArrayList<Handphone> listHandphone = new ArrayList<Handphone>();
    protected ArrayList<Smartphone> listSmartphone = new ArrayList<Smartphone>();
    protected ArrayList<Symbian> listSymbian = new ArrayList<Symbian>();
    
    
    Scanner sc = new Scanner(System.in);

    public Toko(String namaToko) {
        this.namaToko = namaToko;
        setListHandphone();
        setListSmartphone();
        setListSymbian();
        System.out.println("Hai kak.. Selamat Datang di " + this.namaToko);
        //menu();
    }

    // getter setter
    public String getNamaToko() {
        return namaToko;
    }
    public void setNamaToko(String namaToko) {
        this.namaToko = namaToko;
    }
    public ArrayList<Handphone> getListHandphone() {
        return listHandphone;
    }
    public void setListHandphone(ArrayList<Handphone> listHandphone) {
        this.listHandphone = listHandphone;
    }
    public ArrayList<Smartphone> getListSmartphone() {
        return listSmartphone;
    }
    public void setListSmartphone(ArrayList<Smartphone> listSmartphone) {
        this.listSmartphone = listSmartphone;
    }
    public ArrayList<Symbian> getListSymbian() {
        return listSymbian;
    }
    public void setListSymbian(ArrayList<Symbian> listSymbian) {
        this.listSymbian = listSymbian;
    }

    public void spesifikasi(int choiceNumber){
        int listNumber = choiceNumber -1;
        String phoneBrand =listHandphone.get(listNumber).getBrand();
        String phoneModel = listHandphone.get(listNumber).getModel();
        String phoneType = listHandphone.get(listNumber).getPhoneType();
        System.out.println("\nMenampilkan spesifikasi " + phoneBrand + " " + phoneModel);
        // checking type of handphone
        if(phoneType == "SMARTPHONE"){
            for(Smartphone phone: listSmartphone){
                if(phoneModel == phone.getModel()){
                    System.out.println("Nama Brand \t: " + phone.getBrand());
                    System.out.println("Model HP \t: " + phone.getModel());
                    System.out.println("Sistem Operasi \t: " + phone.getOs());
                    System.out.println("Kamera Depan \t: " + phone.getFrontCameraSpecs());
                    System.out.println("USB TYPE \t: " + phone.getUsbType());
                }
            }
        } else if(phoneType == "SYMBIAN"){
            for(Symbian phone: listSymbian){
                if(phoneModel == phone.getModel()){
                    System.out.println("Nama Brand \t: " + phone.getBrand());
                    System.out.println("Model HP \t: " + phone.getModel());
                    System.out.println("Sistem Operasi \t: " + phone.getOs());
                    System.out.println("Jenis Keyboard \t: " + phone.getKeyboardType());
                    System.out.println("Jumlah Key  \t: " + phone.getNumOfKeyboardKeys());
                }
            }
        }
        System.out.println();
        
    }

}

/*
   Main Class
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

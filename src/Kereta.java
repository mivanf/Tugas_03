public class Kereta {
    private String namaKereta; // Variabel untuk nama kereta
    private int sisaTiket; // Variabel untuk sisa tiket
    private Ticket ticket; // variabel untuk jumlah tiket

    public Kereta() { // Default constructor kereta Komuter
        ticket = new Ticket(); // Membuat objek Ticket
        sisaTiket = 1000; // Batas tiket yang terjual untuk kereta komuter
        namaKereta = "Komuter"; // Untuk menginisiasi nama kerrta
        
    }

    public Kereta(String namaKereta, int jumlahTiket) { // Overload constructor untuk KAJJ
        ticket = new Ticket(); // Membuat objek Ticket
        sisaTiket = jumlahTiket; // Nilai sisaTiket menjadi jumlahTiket
        this.namaKereta = namaKereta; // Membedakan dari perimeter lokal
    }

    public void tambahTiket(String namaPenumpang) {
        if (sisaTiket > 0) { // Jika tiket lebih dari 0, maka if ini akan berjalan
            String[] newPenumpang = ticket.getNamaPenumpang(); // Mengambil array penumpang dari objek ticket
            if (newPenumpang == null) { // Ini akan berjalan jika array nya kosong
                newPenumpang = new String[0]; // Menginisiasikan sebagai array kosong
            }
            newPenumpang = addElement(newPenumpang, namaPenumpang); // Memanggil method addElement() dan memasukkan penumpang ke newPenumpang
            ticket.setNamaPenumpang(newPenumpang); // Menyimpan array ke objek ticket
            System.out.println("========================================================"); // Output pembatas
            System.out.println("Tiket berhasil disimpan"); // Output ketika tiket berhasil disimpan
            sisaTiket--; // Mengurangi nilai pada sisaTiket
        }
    }

    public void tambahTiket(String namaPenumpang, String asal, String tujuan) {
        System.out.println("========================================================"); // Output pembatas
        String[] newPenumpang = ticket.getNamaPenumpang(); // Untuk menyimpan nama-nama penumpang
        if (newPenumpang == null) { // Ini akan berjalan jika array nya kosong
            newPenumpang = new String[0]; // Menginisiasikan sebagai array kosong
        }
        if ((sisaTiket) > 0) { // Jika tiket lebih dari 0, maka if ini akan berjalan
            newPenumpang = addElement(newPenumpang, namaPenumpang); // Memanggil method addElement() dan memasukkan penumpang ke newPenumpang
            ticket.setNamaPenumpang(newPenumpang); // Menyimpan array ke objek ticket
    
            String[] newAsal = ticket.getAsal(); // Menginisiasi asal
            if (newAsal == null) { // Ini akan berjalan jika array nya kosong
                newAsal = new String[0]; // Menginisiasikan sebagai array kosong
            }
            newAsal = addElement(newAsal, asal); // Memanggil method addElement() dan memasukkan asal ke newAsal
            ticket.setAsal(newAsal); // Menyimpan array ke objek ticket
    
            String[] newTujuan = ticket.getTujuan(); // Menginisiasi tujuan
            if (newTujuan == null) { // Ini akan berjalan jika array nya kosong
                newTujuan = new String[0]; // Menginisiasikan sebagai array kosong
            }
            newTujuan = addElement(newTujuan, tujuan); // Memanggil method addElement() dan memasukkan tujuan ke newTujuan
            ticket.setTujuan(newTujuan); // Menyimpan array ke objek ticket
    
            sisaTiket--; // Mengurangi nilai pada sisaTiket
            if (sisaTiket < 30){ // Jika tiket kurang dari 30, maka if ini akan berjalan
                System.out.println("Tiket berhasil dipesan Sisa tiket tersedia: " + sisaTiket); // Output ketika tiket berhasil dipesa dan menampilkan sisa tiket
            } 
            else{
                System.out.println("Tiket berhasil dipesan"); // Output ketika tiket berhasil disimpan
            }
        } else {
            System.out.println("Kereta telah habis dipesan, silahkan cari jadwal keberangkatan lainnya"); // Output ketika tiket kereta telah habis
        }
    }

    public void tampilkanTiket() {
        System.out.println("========================================================"); // Output pembatas
        System.out.println("Daftar penumpang kereta api " + namaKereta + ":"); // Output untuk daftar pada nama kereta
        System.out.println("----------------------------"); // Output pembatas
        String[] penumpang = ticket.getNamaPenumpang(); // Mendapatkan array yang berisi nama-nama penumpang dari ticket
        String[] asal = ticket.getAsal(); // Mendapatkan array yang berisi asal penumpang dari ticket
        String[] tujuan = ticket.getTujuan(); // Mendapatkan array yang berisi tujuan penumpang dari ticket
        for (int i = 0; i < penumpang.length; i++) { // Looping ini akan berjalan sesuai dengan jumlah penumpang
            System.out.println("Nama: " + penumpang[i]); // Output nama penumpang
            if (asal != null && asal.length > i) { // If ini akan berjalan jika asal tidak null dan panjangnya lebih besar dari i
                System.out.println("Asal: " + asal[i]); // Output asal penumpang
            }
            if (tujuan != null && tujuan.length > i) { // If ini akan berjalan jika tujuan tidak null dan panjangnya lebih besar dari i
                System.out.println("Tujuan: " + tujuan[i]); // Output tujuan penumpang
                System.out.println("----------------------------"); // Output pembatas
            }
        }
    }

    private String[] addElement(String[] array, String element) { // Method addElement()
        String[] newArray = new String[array.length + 1]; // Membuat array baru yang lebih panjang 1 nilai dari array
        for (int i = 0; i < newArray.length; i++) { // Looping ini akan berjalan sesuai dengan panjang newArray
            newArray[i] = array[i]; // Menyalin dari array ke newArray
        }
        newArray[array.length] = element; // Menambah element kedalam newArray
        return newArray; // Mengembalikan newArray
    }
}
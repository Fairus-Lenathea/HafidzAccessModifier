// File: House.java
class House {
    private String safeBox = "Dokumen Rahasia"; // Private: Hanya pemilik rumah
    protected String familyPhoto = "Foto Keluarga"; // Protected: Untuk keluarga
    public String garden = "Taman Rumah"; // Public: Untuk umum
    String livingRoom = "Ruang Tamu"; // Default: Untuk penghuni rumah

    // Private method to access the safe box
    private void accessSafeBox() {
        System.out.println("Akses ke brankas pribadi: " + safeBox);
    }

    // Protected method to access family photo
    protected void viewFamilyPhoto() {
        System.out.println("Melihat foto keluarga: " + familyPhoto);
    }

    // Public method to access the garden
    public void visitGarden() {
        System.out.println("Mengunjungi taman: " + garden);
    }    // Default method to access the living room
    void relaxInLivingRoom() {
        System.out.println("Bersantai di ruang tamu: " + livingRoom);
    }
}
// Subclass yang berada di paket yang sama
class FamilyMember extends House {
    public void familyAccess() {
        // Bisa mengakses protected dan default dari House
        viewFamilyPhoto(); // Protected
        relaxInLivingRoom(); // Default
    }
}

// Kelas lain di luar keluarga (di luar paket)
public class AccessModifiersExample {
    public static void main(String[] args) {
        House myHouse = new House();
        FamilyMember member = new FamilyMember();

        // Akses public
        myHouse.visitGarden();

        // Tidak bisa akses private
        // myHouse.accessSafeBox(); // Error: accessSafeBox() has private access

        // Tidak bisa akses protected (kecuali melalui subclass)
        // myHouse.viewFamilyPhoto(); // Error: viewFamilyPhoto() has protected access

        // Tidak bisa akses default dari luar paket
        // myHouse.relaxInLivingRoom(); // Error: relaxInLivingRoom() is not public

        // Subclass bisa mengakses protected dan default
        member.familyAccess();
    }
}

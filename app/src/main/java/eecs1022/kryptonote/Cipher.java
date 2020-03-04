package eecs1022.kryptonote;

public class Cipher {
    private String key;
    public static final String ALPHABET="ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public Cipher(String k){

    }

    public String Encrypt(String note){
        return "";
    }

    public String Decrypt(String note){
        return "";
    }

    private String makePad(String note){
        String pad=this.key;
        for (;pad.length()<=note.length();)
            pad+=this.key;
        return pad;
    }
}

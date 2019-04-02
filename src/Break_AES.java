public class Break_AES extends Function_AES{

    byte [] Cipher;
    byte [] Message;


    public Break_AES(String messPath, String cipherPath, String outputPath) {
        OutputPath=outputPath;
        Cipher = getBytesFromFile(cipherPath);
        Message=getBytesFromFile(messPath);
    }

    public void BreakKey(){

        Key1 =new byte[16];
        Key2 = new byte[16];
        Key3=new byte[16];

        for (int i = 0; i <16 ; i++) {
            Key2[i]=127;
        }
        byte [] FirstMess=new byte[16];
        byte [] FirstCipher=new byte[16];
        for (int i = 0; i <16 ; i++) {
            FirstMess[i]=Message[i];
            FirstCipher[i]=Cipher[i];
        }
        byte [][] messarr=new byte[1][];
        messarr[0]=FirstMess;
        Encrypt_AES encrypt_aes=new Encrypt_AES(Key1,Key2,Key3,messarr,null);
        byte [] EnctyptMess=new byte[16];
        EnctyptMess=encrypt_aes.Encrypt();

        Key3=AfterXor(EnctyptMess,FirstCipher);

        byte [] MainKey=new byte[48];
        for (int i = 0; i <16 ; i++) {
            MainKey[i]=Key1[i];
            MainKey[i+16]=Key2[i];
            MainKey[i+32]=Key3[i];
        }

        WriteResToFile(OutputPath,MainKey);

    }


}

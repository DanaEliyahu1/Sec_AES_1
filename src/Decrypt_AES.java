import javax.crypto.Cipher;

public class Decrypt_AES extends Function_AES {

    byte []MainCipher;
    byte [][] Ciphers;

    public Decrypt_AES(String KeyPath, String MessPath, String OutputPath) {
        MainKey=getBytesFromFile(KeyPath);
        MainCipher=getBytesFromFile(MessPath);
        this.OutputPath = OutputPath;
        Key1 = new byte[16];
        Key2 = new byte[16];
        Key3 = new byte[16];
        for (int i = 0; i < 16; i++) {
            Key1[i] = MainKey[i];
            Key2[i] = MainKey[16 + i];
            Key3[i] = MainKey[32 + i];

        }
        Ciphers = new byte[MainCipher.length / 16][];

        for (int i = 0; i < Ciphers.length; i++) {
            Ciphers[i]=new byte[16];
            for (int j = 0; j < 16; j++) {
                Ciphers[i][j] = MainCipher[i * 16 + j];


            }

        }
    }

    public void Decrypt() {
        byte[] UnDoShiftRow = null;
        byte[] Afterxor = null;
        byte[] result = new byte[MainCipher.length];
        for (int i = 0; i < Ciphers.length; i++) {

            Afterxor = AfterXor(Ciphers[i], Key3);
            UnDoShiftRow = UnShiftRow(Afterxor);
            Afterxor = AfterXor(UnDoShiftRow, Key2);
            UnDoShiftRow = UnShiftRow(Afterxor);
            Afterxor = AfterXor(UnDoShiftRow, Key1);
            UnDoShiftRow = UnShiftRow(Afterxor);
            for (int j = 0; j < 16; j++) {
                result[16 * i + j] = UnDoShiftRow[j];
            }
        }
        WriteResToFile(OutputPath, result);

    }

}







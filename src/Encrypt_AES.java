import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Encrypt_AES extends Function_AES {


    byte[] MainMessage;
    byte[][] Messages;

    public Encrypt_AES(byte[] key1, byte[] key2, byte[] key3, byte[][] messages, String outputPath) {
        Key1 = key1;
        Key2 = key2;
        Key3 = key3;
        Messages = messages;
        OutputPath = outputPath;
        MainMessage = new byte[Messages.length * 16];
    }

    public Encrypt_AES(String KeyPath, String MessPath, String OutputPath) {
        MainKey = getBytesFromFile(KeyPath);
        MainMessage = getBytesFromFile(MessPath);
        this.OutputPath = OutputPath;
        Key1 = new byte[16];
        Key2 = new byte[16];
        Key3 = new byte[16];
        for (int i = 0; i < 16; i++) {
            Key1[i] = MainKey[i];
            Key2[i] = MainKey[16 + i];
            Key3[i] = MainKey[32 + i];

        }
        Messages = new byte[MainMessage.length / 16][];

        for (int i = 0; i < Messages.length; i++) {
            Messages[i] = new byte[16];
            for (int j = 0; j < 16; j++) {
                Messages[i][j] = MainMessage[i * 16 + j];


            }

        }
    }


    public void Encrypt() {
        byte[] AfterShiftRow = null;
        byte[] Afterxor = null;
        byte[] result = new byte[MainMessage.length];
        for (int i = 0; i < Messages.length; i++) {
            AfterShiftRow = ShiftRow(Messages[i]);
            Afterxor = AfterXor(AfterShiftRow, Key1);

            AfterShiftRow = ShiftRow(Afterxor);
            Afterxor = AfterXor(AfterShiftRow, Key2);

            AfterShiftRow = ShiftRow(Afterxor);
            Afterxor = AfterXor(AfterShiftRow, Key3);
            for (int j = 0; j < 16; j++) {
                result[16 * i + j] = Afterxor[j];
            }
        }
        WriteResToFile(OutputPath, result);


    }




}

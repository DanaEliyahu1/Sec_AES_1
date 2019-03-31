import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Encrypt_AES {

    byte[] MainKey;
    byte[] Key1;
    byte[] Key2;
    byte[] Key3;
    byte[] MainMessage;
    byte [][] Messages;
    String OutputPath;

    public Encrypt_AES(String KeyPath, String MessPath, String OutputPath) {
        try {
            MainKey = Files.readAllBytes(Paths.get(KeyPath));
            MainMessage = Files.readAllBytes(Paths.get(MessPath));;
        } catch (IOException e) {
            e.printStackTrace();
        }
        OutputPath = OutputPath;

        for (int i = 0; i <16 ; i++) {
            Key1[i]=MainKey[i];
            Key2[i]=MainKey[16+i];
            Key3[i]=MainKey[32+i];

        }
        Messages =new byte[MainMessage.length/16][];

        for (int i = 0; i < Messages.length; i++) {
            for (int j = 0; j <16 ; j++) {
                Messages[i][j]=MainMessage[i*16+j];


            }

        }
    }
    public void Encrypt(){
        for (int i = 0; i <Messages.length ; i++) {
            byte [] AfterShiftRow=ShiftRow(Messages[i]);

        }




    }

    private byte[] ShiftRow(byte[] message) {
        byte [] ShiftRow=new byte[16];

        return null;
    }


}

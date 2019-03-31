import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Function_AES {


    byte[] MainKey;
    byte[] Key1;
    byte[] Key2;
    byte[] Key3;
    String OutputPath;

    public byte[] getBytesFromFile(String Path) {
        try {
            return Files.readAllBytes(Paths.get(Path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;

        /* int in;
        char c;
        InputStream Input=null;
        String s="";
        try {
            Input=new FileInputStream(Path);
            while ((in=Input.read())!=-1){
                c=(char)in;
                s+=c;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if(Input!=null){
                try {
                    Input.close();
                }
                catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
        return s.getBytes();*/
    }

    public byte[] AfterXor(byte[] afterShiftRow, byte[] key1) {
        byte[] Xor = new byte[16];
        for (int i = 0; i < 16; i++) {
            Xor[i] = (byte) (afterShiftRow[i] ^ key1[i]);
        }
        return Xor;
    }


    public byte[] ShiftRow(byte[] message) {

        byte[] ShiftRow = new byte[16];
        ShiftRow[0] = message[0];
        ShiftRow[4] = message[4];
        ShiftRow[8] = message[8];
        ShiftRow[12] = message[12];
        ShiftRow[1] = message[5];
        ShiftRow[5] = message[9];
        ShiftRow[9] = message[13];
        ShiftRow[13] = message[1];
        ShiftRow[2] = message[10];
        ShiftRow[6] = message[14];
        ShiftRow[10] = message[2];
        ShiftRow[14] = message[6];
        ShiftRow[3] = message[15];
        ShiftRow[7] = message[3];
        ShiftRow[11] = message[7];
        ShiftRow[15] = message[11];

        return ShiftRow;
    }

    public byte[] UnShiftRow(byte[] message) {
        byte[] UnShiftRow = new byte[16];

        UnShiftRow[0] = message[0];
        UnShiftRow[4] = message[4];
        UnShiftRow[8] = message[8];
        UnShiftRow[12] = message[12];
        UnShiftRow[5] = message[1];
        UnShiftRow[9] = message[5];
        UnShiftRow[13] = message[9];
        UnShiftRow[1] = message[13];
        UnShiftRow[10] = message[2];
        UnShiftRow[14] = message[6];
        UnShiftRow[2] = message[10];
        UnShiftRow[6] = message[14];
        UnShiftRow[15] = message[3];
        UnShiftRow[3] = message[7];
        UnShiftRow[7] = message[11];
        UnShiftRow[11] = message[15];

        return UnShiftRow;
    }
    public void WriteResToFile(String outputPath, byte[] result) {
        try {
            OutputStream output = null;
            try {
                output = new BufferedOutputStream(new FileOutputStream(OutputPath));
                output.write(result);
            } finally {
                output.close();
            }
        } catch (FileNotFoundException ex) {
            System.out.println("file not found");
        } catch (IOException ex) {
            System.out.println("IO Exception");
        }
    }





}

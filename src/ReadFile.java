import java.nio.file.Paths;
import java.util.InputMismatchException;

public class ReadFile {


    public static void Parse(String command){

        String [] arr= command.split(" ");

        if(arr[0].equals("-b")){
            String MessPath="";
            String CipherPath="";
            String OutputPath="";

            for (int i = 0; i <arr.length ; i++) {

               if(arr[i].equals("-m") && i+1<arr.length){
                    MessPath=arr[i+1];
                }
                else if(arr[i].equals("-c") && i+1<arr.length){
                    CipherPath=arr[i+1];
                }
                else if(arr[i].equals("-o") && i+1<arr.length){
                    OutputPath=arr[i+1];
                }
            }
            if (MessPath.equals("") || CipherPath.equals("") || OutputPath.equals("")){
                throw new InputMismatchException("could not find path");
            }
            Break_AES break_aes=new Break_AES(MessPath,CipherPath,OutputPath);

            break_aes.BreakKey();
        }
        else{
            boolean IsEncrypt= false;
            String KeyPath= "";
            String InputPath="";
            String OutputPath="";

            for (int i = 0; i <arr.length ; i++) {
                if(arr[i].equals("-e"))
                {
                    IsEncrypt=true;
                }
                else if(arr[i].equals("-d")) {
                    IsEncrypt=false;
                }

                else if(arr[i].equals("-k") && i+1<arr.length){
                    KeyPath=arr[i+1];
                }
                else if(arr[i].equals("-i") && i+1<arr.length){
                    InputPath=arr[i+1];
                }
                else if(arr[i].equals("-o") && i+1<arr.length){
                    OutputPath=arr[i+1];
                }
            }
            if (KeyPath.equals("") || InputPath.equals("") || OutputPath.equals("")){
                throw new InputMismatchException("could not find path");
            }

            if (IsEncrypt){
                Encrypt_AES En_AES = new Encrypt_AES(KeyPath,InputPath,OutputPath);
                En_AES.Encrypt();
            }
            else {
                Decrypt_AES En_AES = new Decrypt_AES(KeyPath,InputPath,OutputPath);
                En_AES.Decrypt();
            }
        }



    }

    public static void main(String[] args) {
      //  Parse("-e -k tryK.txt -i message_long -o test.txt ");
         // Parse("-b -m message_long -c cipher_long -o tryK.txt ");
          Parse("-d -k tryK.txt -i cipher_long -o test.txt ");


//        byte[] keys=new byte[16];
//        byte[][] m=new byte[1][];
//        m[0]=new byte[16];
//        m[0][7]=1;
//        String output="try.txt";
//        Encrypt_AES En_AES = new Encrypt_AES(keys,keys,keys,m,output);
//        En_AES.Encrypt();
    }




}

import java.util.InputMismatchException;

public class ReadFile {


    public void Parse(String command){

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
        }



    }





}

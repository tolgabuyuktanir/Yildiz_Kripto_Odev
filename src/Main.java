import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {
        chipper();
        try {
            runApplication();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static String getHDDSerialNumber() {
        StringBuffer output = new StringBuffer();
        Process p;
        String[] cmd={"/bin/sh", "-c","udevadm info --query=all --name=/dev/sda | grep ID_SERIAL="};
        try {
            p = Runtime.getRuntime().exec(cmd);
            p.waitFor();
            BufferedReader reader =
                    new BufferedReader(new InputStreamReader(p.getInputStream()));

            String line = "";
            while ((line = reader.readLine())!= null) {
                output.append(line + "\n");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return output.toString().substring(13,output.length());
    }
    public static String getUSBDeviceId()
    {
        StringBuffer output = new StringBuffer();
        Process p;
        String[] cmd={"/bin/sh", "-c","cat /proc/scsi/usb-storage/* | grep \"Serial Number\""};
        try {
            p = Runtime.getRuntime().exec(cmd);
            p.waitFor();
            BufferedReader reader =
                    new BufferedReader(new InputStreamReader(p.getInputStream()));
            output.append(reader.readLine());

        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(output);
        return output.toString().substring(15,output.length());
    }

    public static void chipper() {
        String key=null;
        try
        {
            key = getHDDSerialNumber().substring(getHDDSerialNumber().length()-12,getHDDSerialNumber().length())+getUSBDeviceId();
            System.out.println(key);
            File inputFile = new File("Java-Snake-Game.jar");
            File encryptedFile = new File("Java-Snake-Game.Encrypted");
            File decryptedFile = new File("Java-Snake-Game.jar");
            System.out.println(decryptedFile.hashCode());
            try {
                if(inputFile.exists())
                {
                    CryptoUtils.encrypt(key, inputFile, encryptedFile);
                    inputFile.delete();
                }
                if(encryptedFile.exists())
                {
                    CryptoUtils.decrypt(key, encryptedFile, decryptedFile);
                }
            } catch (CryptoException ex) {
                System.out.println(ex.getMessage());
                ex.printStackTrace();
            }
        }
        catch (Exception e)
        {
            System.err.println("Yazılım tedarikçiniz ile iletişime geçiniz!");
        }
    }
    public static void runApplication() throws InterruptedException {
        StringBuffer output = new StringBuffer();
        File decryptedFile = new File("Java-Snake-Game.jar");
        Process p;
        try {
            long start=System.nanoTime();
            p=Runtime.getRuntime().exec("/usr/lib/jvm/java-8-oracle/bin/java -jar Java-Snake-Game.jar");
            long end=System.nanoTime();
            System.out.println((end-start)/1000000000);
            p.waitFor();
            BufferedReader reader =
                    new BufferedReader(new InputStreamReader(p.getInputStream()));
            System.out.println(reader.readLine());
            if(decryptedFile.exists())
                decryptedFile.deleteOnExit();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

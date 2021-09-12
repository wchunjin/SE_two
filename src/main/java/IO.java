import java.io.*;

public class IO {
    public static String In(String fileName) {
        String str = "";
        String line;
        File file = new File(fileName);
        FileInputStream fis = null;
        InputStreamReader isr = null;
        BufferedReader br = null;
        try {
            fis = new FileInputStream(file);
            isr = new InputStreamReader(fis, "UTF-8");
            br = new BufferedReader(isr);
            while ((line = br.readLine()) != null) {
                str += line;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try{
                isr.close();
                br.close();
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return str;
    }

    public static void Out(double content, String fileName){
        String str = Double.toString(content);
        File file = new File(fileName);
        FileWriter fw = null;
        try {
            fw = new FileWriter(file, true);
//            fw.write(str, 0, (str.length() > 3 ? 4 : str.length()));
            fw.write("\r\n");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try{
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

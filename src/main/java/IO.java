import java.io.*;
import java.nio.charset.StandardCharsets;

public class IO {
    /**
     * 读取文件
     * @param fileName:文件路径
     * @return 文件内容——字符串类型
     */
    public static String In(String fileName) {
        StringBuilder article = new StringBuilder(); // 保存读取的文件内容
        String line; // 每次读取一行文文件

        // 采用字符缓冲流读取文件
        File file = new File(fileName);
        FileInputStream fis = null;
        InputStreamReader isr = null;
        BufferedReader br = null;
        try {
            fis = new FileInputStream(file);
            isr = new InputStreamReader(fis, StandardCharsets.UTF_8);
            br = new BufferedReader(isr);
            while ((line = br.readLine()) != null) {
                // 追加当前读取的字符串
                line = line.replaceAll("\\s+","");
                article.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try{
                // 释放资源
                assert isr != null;
                isr.close();
                assert br != null;
                br.close();
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return article.toString();
    }

    /**
     * 写入文件
     * @param content:写入的内容
     * @param fileName:写入文件路径
     */
    public static void Out(String content, String fileName){
        File file = new File(fileName);
        FileWriter fw = null;
        try {
            fw = new FileWriter(file, true);
            fw.write(content);
            fw.write("\r\n");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try{
                assert fw != null;
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

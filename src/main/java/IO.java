import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class IO {
    /**
     * 读取文件
     * @param fileName:文件路径
     * @return 文件内容——字符串类型
     */
    public static String In(String fileName) {
        if (fileName==null||fileName.trim().equals("")) {
            throw new NullPointerException("错误：文件路径为空，找不到相关文件");
        }
        StringBuilder article; // 保存读取的文件内容
        // 采用字符缓冲流读取文件
        try {
            article = new StringBuilder();
            File file = new File(fileName);
            FileInputStream fis = new FileInputStream(file);
            InputStreamReader isr = new InputStreamReader(fis, StandardCharsets.UTF_8);
            BufferedReader br = new BufferedReader(isr);
            String line; // 每次读取一行文文件
            while ((line = br.readLine()) != null) {
                // 追加当前读取的字符串
                line = line.replaceAll("\\s+","");
                article.append(line);
            }
            // 释放资源
            fis.close();
            isr.close();
            br.close();
        } catch (IOException e) {
            throw new NullPointerException("错误：文件路径错误，找不到相关文件");
        }

        return article.toString();
    }

    /**
     * 读取停用词文件
     * @return 停用字符集
     */
    public static List<String> stopWords() {
        List<String> result = new ArrayList<>();
        try {
            // 读取停用词文件
            // 通过类加载器读取resource目录下的文件
            InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("hit_stopwords.txt");
            assert null != is:"错误：找不到停用词文件";
            InputStreamReader sr = new InputStreamReader(is, StandardCharsets.UTF_8);
            BufferedReader br = new BufferedReader(sr);
            String line;
            while ((line = br.readLine()) != null) {
                result.add(line);
            }
            is.close();
            sr.close();
            br.close();
        } catch (IOException e) {
            throw new AssertionError();
        }
        return result;
    }

    /**
     * 写入文件
     * @param content:写入的内容
     * @param fileName:写入文件路径
     */
    public static void Out(String content, String fileName){
        if (content==null||content.trim().equals("")) {
            throw new NullPointerException("错误：无写入内容");
        }
        if (fileName==null||fileName.trim().equals("")) {
            throw new NullPointerException("错误：文件路径为空，无法写入文件");
        }
        try {
            File file = new File(fileName);
            FileWriter fw = new FileWriter(file, true);
            fw.write(content);
            fw.write("\r\n");
            fw.close();
        } catch (IOException e) {
            throw new NullPointerException("错误：文件路径为错误，无法写入文件");
        }
    }
}

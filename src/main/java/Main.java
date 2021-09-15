import java.util.List;

public class Main {
    public static void main(String[] args) {
        // 读取文件，内容保存至字符串变量中
        String str0 = IO.In(args[0]);
        String str1 = IO.In(args[1]);
        // 停用字符集
        List<String> stopWords = IO.stopWords();

        // 分词
        List<String> list0 =  Participle.participle(str0, stopWords);
        List<String> list1 =  Participle.participle(str1, stopWords);
        // 分词并集
        List<String> union = Participle.unionSet(list0, list1);
        // 计算词频
        int[] arr0 = Participle.computingWordFrequency(list0, union);
        int[] arr1 = Participle.computingWordFrequency(list1, union);

        // 利用余弦相似算法计算文本相似度
        String result = Cosine.calculate(arr0, arr1);
        IO.Out("原文路径："+args[0], args[2]);
        IO.Out("对比文章路径："+args[1], args[2]);
        IO.Out("相似度："+result, args[2]);
    }
}

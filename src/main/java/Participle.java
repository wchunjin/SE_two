import com.hankcs.hanlp.HanLP;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Participle {
    /**
     * 提取分词的文本组成新集合
     * @param str:要分词的文章
     * @param stopWords:停用词集合
     * @return 分词集合
     */
    static List<String> participle(String str, List<String> stopWords) {
        // 关闭词性显示
        HanLP.Config.ShowTermNature = false;
        // 标准分词，取出 word属性组成新字符串集合
        List<String> result = HanLP.segment(str).stream().map(item->item.word).collect(Collectors.toList());
        // 去除停用词
        result.removeAll(stopWords);
        return result;
    }

    /**
     * 两个list集合取并集
     * @param list0:分词集合0
     * @param list1:分词集合1
     * @return 两个分词集合的并集
     */
    static List<String> unionSet(List<String> list0, List<String> list1) {
        // 创建一个list集合存放两个list集合的内容
        List<String> union = new ArrayList<>();
        union.addAll(list0);
        union.addAll(list1);
        // 将list集合中重复的元素去重返回
        return union.stream().distinct().collect(Collectors.toList());
    }

    /**
     * 计算词频
     * @param list:分词集合
     * @param union:分词并集
     * @return 分词集合各元素在分词并集中出现的频率
     */
    static int[] computingWordFrequency(List<String> list, List<String> union) {
        int[] arr = new int[union.size()];
        for (int i = 0; i < union.size(); i++) {
            // 调用接口，查询某元素再list集合中出现几次
            arr[i] = Collections.frequency(list, union.get(i));
        }
        return arr;
    }
}

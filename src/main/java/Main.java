import com.hankcs.hanlp.HanLP;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        String str0 = IO.In("C:\\Users\\18350\\Desktop\\test\\orig.txt");
        String str1 = IO.In("C:\\Users\\18350\\Desktop\\test\\orig_0.8_add.txt");

//        String str0 = "我喜欢吃苹果，不喜欢吃榴莲。";
//        String str1 = "我不喜欢吃苹果，也不喜欢吃榴莲。";

        List<String> list0 =  HanLP.segment(str0).stream().map(a -> a.word).filter(s -> !"`~!@#$^&*()=|{}':;',\\[\\].<>/?~！@#￥……&*（）——|{}【】‘；：”“'。，、？ ".contains(s)).collect(Collectors.toList());
//        System.out.println(list0);
        List<String> list1 =  HanLP.segment(str1).stream().map(a -> a.word).filter(s -> !"`~!@#$^&*()=|{}':;',\\[\\].<>/?~！@#￥……&*（）——|{}【】‘；：”“'。，、？ ".contains(s)).collect(Collectors.toList());
//        System.out.println(list1);

        List<String> result = new ArrayList<>();
        result.addAll(list0);
        result.addAll(list1);
//        System.out.println(result.stream().distinct().collect(Collectors.toList()));
        List<String> allWords = result.stream().distinct().collect(Collectors.toList());
//        System.out.println(allWords);

        int[] arr0 = new int[allWords.size()];
        for (int i = 0; i < allWords.size(); i++) {
            arr0[i] = Collections.frequency(list0, allWords.get(i));
        }

//        System.out.println(Arrays.toString(arr0));

        int[] arr1 = new int[allWords.size()];
        for (int i = 0; i < allWords.size(); i++) {
            arr1[i] = Collections.frequency(list1, allWords.get(i));
        }

//        System.out.print(Arrays.toString(arr1));

        double dividend = 0;
        double divisor1 = 0;
        double divisor2 = 0;
        for (int i = 0; i < arr0.length; i++) {
            dividend += arr0[i] * arr1[i];
            divisor1 += Math.pow(arr0[i], 2);
            divisor2 += Math.pow(arr1[i], 2);
        }

        System.out.println(dividend / (Math.sqrt(divisor1) * Math.sqrt(divisor2)));

    }
}

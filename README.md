#### [个人项目github链接](https://github.com/wchunjin/SE_two)

#### 作业简述

| 这个作业属于哪个课程 | [作业课程](https://edu.cnblogs.com/campus/gdgy/networkengineering1934-Softwareengineering) |
| -------------------- | ------------------------------------------------------------ |
| 这个作业要求在哪里   | [作业要求](https://edu.cnblogs.com/campus/gdgy/networkengineering1934-Softwareengineering/homework/12137) |
| 这个作业的目标       | 设计一个论文查重算法，给出一个原文文件和一个在这份原文上经过了增删改的抄袭版论文的文件，在答案文件中输出其重复率。 |

#### PSP表格

| ***\*PSP2.1\****                        | ***\*Personal Software Process Stages\**** | ***\*预估耗时（分钟）\**** | ***\*实际耗时（分钟）\**** |
| --------------------------------------- | ------------------------------------------ | -------------------------- | -------------------------- |
| Planning                                | 计划                                       |                            |                            |
| · Estimate                              | · 估计这个任务需要多少时间                 | 600                        | 1240                       |
| Development                             | 开发                                       |                            |                            |
| · Analysis                              | · 需求分析 (包括学习新技术)                | 120                        | 360                        |
| · Design Spec                           | · 生成设计文档                             | 20                         | 40                         |
| · Design Review                         | · 设计复审                                 | 20                         | 20                         |
| · Coding Standard                       | · 代码规范 (为目前的开发制定合适的规范)    | 20                         | 20                         |
| · Design                                | · 具体设计                                 | 40                         | 60                         |
| · Coding                                | · 具体编码                                 | 220                        | 240                        |
| · Code Review                           | · 代码复审                                 | 20                         | 40                         |
| · Test                                  | · 测试（自我测试，修改代码，提交修改）     | 60                         | 240                        |
| Reporting                               | 报告                                       |                            |                            |
| · Test Repor                            | · 测试报告                                 | 40                         | 180                        |
| · Size Measurement                      | · 计算工作量                               | 20                         | 20                         |
| · Postmortem & Process Improvement Plan | · 事后总结, 并提出过程改进计划             | 20                         | 20                         |
|                                         | · 合计                                     | 600                        | 1240                       |

#### 计算模块接口的设计与实现过程

##### 项目结构

![image-20210916203413045](C:\Users\18350\AppData\Roaming\Typora\typora-user-images\image-20210916203413045.png)

1.路径：SE_two\src\main\java\

​	Cosine类：计算余弦相似度

​	IO类：文件读取与写入

​	Main类：主类

​	Participle类：分词

2.路径：SE_two\src\main\resources\

​	hit_stopwords.txt：停用词词典，选用的是哈工大版停用词

3.路径：SE_two\src\test\

​	java文件夹下存放的是测试类，测试各对应类中的各个方法

​	例：testCosine类测试Cosine类中的各个方法

​	resources文件夹下存放的是测试过程中需要读入和写出的文本

##### 流程图

![image-20210916211135918](C:\Users\18350\AppData\Roaming\Typora\typora-user-images\image-20210916211135918.png)

##### 关键函数的分析与实现

该项目主要使用：hanlp分词器+余弦相似度算法

假设有两个句子：

​	句子A：这只皮靴号码大了，那只号码合适。

​	句子B：这只皮靴号码不小，那只更合适。

**第一步：分词**

先是标准分词结果：

​	句子A：[这, 只, 皮靴, 号码, 大, 了, ，, 那只, 号码, 合适, 。]

​	句子B：[这, 只, 皮靴, 号码, 不, 小, ，, 那只更, 合适, 。]

读取停用词：

​	[———, 》），, ）÷（１－, ”，, ）、, ＝（, :, →, ℃ , ...]

对标准分词结果进行停用词过滤：

​	句子A：[只, 皮靴, 号码, 大, 那只, 号码, 合适]

​	句子B：[只, 皮靴, 号码, 不, 小, 那只更, 合适]

**实现：Participle.participle() 借助 hanlp分词器**

![image-20210916215104134](C:\Users\18350\AppData\Roaming\Typora\typora-user-images\image-20210916215104134.png)

**第二步：合并分词**

将第一步得到的两个分词结果进行合并:

​	[只, 皮靴, 号码, 大, 那只, 合适, 不, 小, 那只更]

**实现：Participle.unionSet()**

![image-20210916215044542](C:\Users\18350\AppData\Roaming\Typora\typora-user-images\image-20210916215044542.png)

**第三步：计算词频**

计算各句子分词在合并分词中出现的次数

​	句子A：[只, 皮靴, 号码, 大, 那只, 号码, 合适]

​	合并分词：[只 1, 皮靴 1, 号码 2, 大 1, 那只 1, 合适 1, 不 0, 小 0, 那只更 0]

​	句子A词频：[1, 1, 2, 1, 1, 1, 0, 0, 0]

​	句子B：[只, 皮靴, 号码, 不, 小, 那只更, 合适]

​	合并分词：[只 1, 皮靴 1, 号码 1, 大 0, 那只 0, 合适 1, 不 1, 小 1, 那只更 1]

​	句子B词频：[1, 1, 1, 0, 0, 1, 1, 1, 1]

**实现：Participle.computingWordFrequency()**

![image-20210916215148247](C:\Users\18350\AppData\Roaming\Typora\typora-user-images\image-20210916215148247.png)

**第四步：计算余弦相似度**

计算结果作为相似度对比结果

![img](https://private.codecogs.com/gif.latex?%5Ccos%5CTheta%20%3D%5Cfrac%7BA%5Ccdot%20B%7D%7B%7CA%7C%5Ccdot%20%7CB%7C%7D%3D%5Ctfrac%7B%5Csum_%7Bn%7D%5E%7Bi%3D1%7D%28A_%7Bi%7D%5Ctimes%20B_%7Bi%7D%29%7D%7B%5Csqrt%7B%5Csum_%7Bn%7D%5E%7Bi%3D1%7D%28A_%7Bi%7D%29%5E%7B2%7D%7D%5Ctimes%20%5Csqrt%7B%5Csum_%7Bn%7D%5E%7Bi%3D1%7D%28B_%7Bi%7D%29%5E%7B2%7D%7D%7D)

​	A·B=(1, 1, 2, 1, 1, 1, 0, 0, 0)·(1, 1, 1, 0, 0, 1, 1, 1, 1)=5

​	|A|=|(1, 1, 2, 1, 1, 1, 0, 0, 0)|=3

​	|B|=|(1, 1, 1, 0, 0, 1, 1, 1, 1)|=根号7

​	cos=5/(3*根号7)=0.6299

**实现：Cosine.calculate()**

![image-20210916220054858](C:\Users\18350\AppData\Roaming\Typora\typora-user-images\image-20210916220054858.png)

**参考博客：**[余弦计算相似度度量](https://blog.csdn.net/u012160689/article/details/15341303)

#### **计算模块接口部分的性能改进**

##### 内存部分

![image-20210916223646368](C:\Users\18350\AppData\Roaming\Typora\typora-user-images\image-20210916223646368.png)

程序中消耗较大的有：

int[] 相关的主要有，词频计算与余弦相似度计算

hanlp 分词器分词与停用词过滤

##### 运行时间

不知道为什么，在 IDEA中直接运行测试方法只用 900ms左右

![image-20210916224249150](C:\Users\18350\AppData\Roaming\Typora\typora-user-images\image-20210916224249150.png)

而在 IDEA中通过 Profile测试工具运行测试文本却要用 4s左右

![image-20210916224511083](C:\Users\18350\AppData\Roaming\Typora\typora-user-images\image-20210916224511083.png)

即使是实际使用，也只是用 1s左右

![image-20210916224805085](C:\Users\18350\AppData\Roaming\Typora\typora-user-images\image-20210916224805085.png)

#### 计算模块部分单元测试展示

测试结果与异常提醒均以注释形式写入代码中

##### Cosine类测试

![image-20210916225637301](C:\Users\18350\AppData\Roaming\Typora\typora-user-images\image-20210916225637301.png)

##### IO类测试

![image-20210916231627808](C:\Users\18350\AppData\Roaming\Typora\typora-user-images\image-20210916231627808.png)

![image-20210916231704979](C:\Users\18350\AppData\Roaming\Typora\typora-user-images\image-20210916231704979.png)

![image-20210916231803802](C:\Users\18350\AppData\Roaming\Typora\typora-user-images\image-20210916231803802.png)

![image-20210916231923070](C:\Users\18350\AppData\Roaming\Typora\typora-user-images\image-20210916231923070.png)

##### Participle类测试

![image-20210916232742290](C:\Users\18350\AppData\Roaming\Typora\typora-user-images\image-20210916232742290.png)

![image-20210916232854082](C:\Users\18350\AppData\Roaming\Typora\typora-user-images\image-20210916232854082.png)

![image-20210916232909692](C:\Users\18350\AppData\Roaming\Typora\typora-user-images\image-20210916232909692.png)

##### Main类

![image-20210916233937377](C:\Users\18350\AppData\Roaming\Typora\typora-user-images\image-20210916233937377.png)

![image-20210916233956304](C:\Users\18350\AppData\Roaming\Typora\typora-user-images\image-20210916233956304.png)

![image-20210916234012540](C:\Users\18350\AppData\Roaming\Typora\typora-user-images\image-20210916234012540.png)

##### 代码覆盖率

![image-20210916234152711](C:\Users\18350\AppData\Roaming\Typora\typora-user-images\image-20210916234152711.png)

lines covered低的原因是：写了很多异常情况信息提示，却很少用到

#### 计算模块部分异常处理说明

​	异常处理写了很多，这里展示不完，主要说一下写在哪里，写了什么。

​	基本各个方法都写关于传入参数的异常处理，例：

![image-20210916235138683](C:\Users\18350\AppData\Roaming\Typora\typora-user-images\image-20210916235138683.png)

![image-20210916235217656](C:\Users\18350\AppData\Roaming\Typora\typora-user-images\image-20210916235217656.png)

​	关于计算的方法，一些计算过程也写了异常处理，例：

![image-20210916235329160](C:\Users\18350\AppData\Roaming\Typora\typora-user-images\image-20210916235329160.png)

​	关于异常情况，大致上都在测试类中，把各个方法会碰到的异常情况都测试了一次，并且异常处理结果以注释形式写在各个测试方法中，有兴趣的可以在单元测试那里看。

#### 项目程序功能测试

![image-20210916235842207](C:\Users\18350\AppData\Roaming\Typora\typora-user-images\image-20210916235842207.png)

![image-20210916235908253](C:\Users\18350\AppData\Roaming\Typora\typora-user-images\image-20210916235908253.png)

#### 项目中碰到的问题

mevan项目以及打包后的jar包，读取resources文件夹下的txt文件失败问题：

**参考博客**

[【解惑】深入jar包：从jar包中读取资源文件](https://www.iteye.com/blog/hxraid-483115)

[Maven jar 如何读取resource目录下的文件（read file in resource folder）](https://blog.csdn.net/xinyuanqianxun1987/article/details/88958963)

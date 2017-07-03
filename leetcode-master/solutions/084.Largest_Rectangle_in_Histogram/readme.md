## 084. Largest Rectangle in Histogram (Hard)  
  
### **链接**：  
题目：https://leetcode.com/problems/largest-rectangle-in-histogram/  
代码(github)：https://github.com/illuz/leetcode  
  
### **题意**：  
求一些宽为 1 的矩形条的最大矩形。  
  
### **分析**：  
  
跟 [Container With Most Water](./solutions/011.Container_With_Most_Water) 很像。  
  
暴力：以每个矩形条为最高，维护最低向前找内含的矩形，O(n*m)，肯定会超时的啦。（听说优化下，只处理峰顶就能过，不过复杂度还是没变的）  
  
有好多种做法，O(nlogn) 到 O(n) 的都有，具体可以看[这篇文章](http://blog.csdn.net/arbuckle/article/details/710988)。  
这里我简单翻译总结下：  
  
1. 分治 + 线段树。线段树存每个区间的最小值，每次处理一个区间时，找到区间最小值，然后分治两边的区间，答案肯定是 `(最小值 * 区间长度)` 和分治得到的结果中的。复杂度 O(nlogn)  
2. 线性处理 + 线段树。对每个矩形条，向左向右找最近的比它小的位置，以它为最低的矩形就可以求出来了，处理每个矩形条就行了，复杂度 O(nlogn)。（这里它说找位置是 O(logn) 复杂度，我没想出来，我只想到二分来找位置，复杂度 O(lognlogn)，总的复杂度就是 O(nlognlogn) 了）  
3. 排序 + 扫描线。先排序，再从上向下扫，维护一个区间链，扫到的矩形条的**原位置**加入区间链，该合并时就合并，每次区间最大长度就是当前高度的最宽区间了。因为排序，所以这个算法复杂度是 O(nlogn)。  
4. 用单调栈来做，很巧妙，只要扫一遍就行了，在把数从栈中挤出去的时候，计算两个矩形条间的矩形面积。复杂度 O(n)。  
5. 将单调栈做法改写成递归，其实就是把函数栈当成单调栈来用。  
6. 三个矩形条为一个窗口，有几个操作：更新最大值，合并其中两个矩形条为一个新的矩形条（高度为较小的那个，宽度为两宽度的和），窗口左移和右移。（具体见原文）  

这里用 C++ 实现了暴力 + 优化过的，用 Java 实现算法 4 的单调栈做法。
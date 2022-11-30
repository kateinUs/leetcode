## 二分法 Binary Search
### 使用条件
1. 排序数组
2. 要求找一个比O(n)更小的时间复杂度的算法
3. 找到数组中的一个分割位置，使得左半部分满足某个条件，右半部分不满足
4. 找打一个最大/最小的值使得某个条件被满足

### 复杂度
* 时间复杂度：O(log n)
* 空间复杂度: O(1)

### 模板
```
int binarySearch(int[] nums, int target){
    // 处理corner case
    if(nums == null || nums.length == 0)
        return -1;
    
    int start = 0, end = nums.length - 1;
    while(start + 1 < end){
        int mid = start + (start - end) / 2;
        if(nums[mid] == target){
            return mid;
        } else if(nums[mid] < target){
            start = mid;
        } else{
            end = mid;
        }
    }
    // 结束循环后进行判断，范围内只有两个数
    if(nums[start] == target)
        return start;
    if(nums[end] == target)
        return end;
    return -1;
}

```

## 双指针 Two Pointers
### 使用条件
1. 滑动窗口 (90%)
2. 时间复杂度要求O(n) (80%)
3. 要求in-place操作，只可以交换，不能使用额外空间(80%)
4. 有子数组subarray/子字符串的关键词(50%)
5. 有回文 palindrome 关键词(50%)

### 复杂度
* 时间复杂度O(n)
  - 时间复杂度与最内层循环主体的执行次数有关
  - 与有多少重while/for循环无关
* 空间复杂度: O(1)

### 代码模板
* 相向双指针 (partition in quicksort)
```
public void partition(int[] A, int start, int end){
    if(start >= end){
        return;
    }
    int left = start, right = end;
    while(left <= right){
        // 找到从左往右第一个大于等于pivot的值，以备交换
        while(left <= right && A[left] < pivot){
            left++;
        }
        // 找到从右往左一个个小于等于pivot的值，以备交换
        while(left <= right && A[right] > pivot){
            right--;
        }
        if(left <= right){
            int tmep = A[left];
            A[left] = A[right];
            A[right] = temp;
            left++; 
            right--;
        }
    }
}

```

* 同向双指针
  - Moving zeros
```
int j=0;
for(int i=0; i < n; i++){
    //不满足则循环到满足搭配为止
    while(j < n && i到j之间不满足条件){
        j++;
    }
    if(i到j之间满足条件){
        处理i，j这次搭配
    }
}
```

* 背向双指针
```
// 这里position可以是截断点
left = position;
right = position + 1;

while(left >= 0 && right < len){
    if(可以停下来了){
        break;
    }
    left--;
    right++;
}
```

* 合并双指针 merge 2 lists
```
AraryList<Integer> merger(ArrayList<Integer> list1, ArrayList<Integer> list 2){
    // 需要一个新的list，而不是inplace的修改
    ArrayList<Integer> newList = new ArrayList<Integer>();
    int i=0, j=0;
    while(i < list1.size() && j<list2.size()){
        if(list1.get(i) < list2.get(j)){
            newList.add(list1.get(i));
            i++;
        }
        else{
            newList.add(list2.get(j));
            j++;
        }
    }
    // 合并上下的数列到newList里
    // 无需用if(i<list1.size())，直接while即可
    while(i < list1.size()){
        newList.add(list1.get(i));
        i++;
    }
    while(j < list2.size()){
        newList.add(list2.get(j));
        j++;
    }
    return newList;
}
```

## 双指针 Two Pointers
### 使用条件

### 复杂度
* 时间复杂度
  - 快速排序（期望复杂度）: O(nlogn)
  - 归并排序（最坏复杂度）：O(nlogn)
* 空间复杂度: O(1)
  - 快速排序: O(1)
  - 归并排序：O(n)
### 代码模板
* 快速排序
```
// Quick Sort
public class Solution{
    public void sortIntegers(int[] A){
        quickSort(A, 0, A.length-1);
    }

    private void quickSort(int[] A, int start, int end){
        if(start >= end) return;

        int left = start, right = end;
        // Key point 1: pivot is the value, not the index
        int pivot = A[(start+end)/2];

        // Key point 2: every time you compare left & right, it should be left <= right not left < right
        while(left <= right){
            while(left <= right && A[left] < pivot)
                left++;
            
            while(left <= right && A[right] > pivot)
                right--;
            
            if(left <= right){
                int temp = A[left];
                A[left] = A[right];
                A[right] = A[left];
                left++;
                right--;
            }
        }
        quickSort(A, start, right);
        quickSort(A, left, end);
    }
}

```

* 归并排序
```
// Merge Sort
public class Solution{
    public void sortInteger(int[] A){
        if(A == null || A.length == 0) return;

        int[] temp = new int[A.length];
        mergeSort(A, 0, A.length-1, temp);
    }

    private void mergeSort(int[] A, int start, int end, int[] temp){
        if(start >= end) return;

        // sort left part
        mergeSort(A, start, (start+end)/2, temp);
        // sort right part
        mergeSort(A, (start+end)/2 + 1, end, temp);
        // merge sorted left part and right part
        merge(A, start, end, temp);
    }

    // e.g. merge(A, 4, 7, temp) 现在就是要排右半边
    //     0 1 2 3    4 5 6 7
    // A = [][][][] | [][][][]
    //   mid = (4+7)/2 = 5
    //   left = 4, right=6
    // 这里的左半部分是left->mid,右半部分是right->end (end inclusive)
    private void merge(int[] A, int start, int end, int[] temp){
        int mid = (start + end)/2;
        int left = start;
        int right = middle + 1;
        int i = start; // i is the index on temp
        while(left <= mid && right <= end){
            if(A[left] < A[right]){
                temp[i++] = A[left++];
            }else{
                temp[i++] = A[right++];
            }
        }

        while(left <= mid)
            temp[i++] = A[left++];
        while(right <= end)
            temp[i++] = A[right++];
    
        // 再把temp赋回给A
        for(i = start; i<=end; i++){
            A[i] = temp[i];
        }
    }
}
```

## 二叉树分治 Binary Tree Divide & Conquer
### 使用条件
* 二叉树相关问题(99%)
* 可以一分为二分别处理之后再合并结果(100%)
* 数组相关的问题(10%)

### 复杂度
* 时间复杂度: O(n)
* 空间复杂度: O(n) (含递归调用的栈空间的最大耗费)
### 代码模板
```
// 返回类型自定义
public int divideConquer(TreeNode node){
    // 递归出口
    // 一般处理node==null就够了，不需要处理node==leaf
    if(node == null){
        return ...;
    }

    //处理左子树
    int leftResult = divideConquer(node.left);
    int rightResult = divideConquer(node.right);

    //合并答案
    int result = leftResult + rightResult;
    return result;
}

```

## 二叉树搜索树非递归 BST Iterator
### 使用条件
* 用非递归方式(Non-recursion/Iteration)实现二叉树的中序遍历
* 常用于BST 但不仅仅可以用于BST

### 复杂度
* 时间复杂度: O(n)
* 空间复杂度: O(n) 
### 代码模板
```
public List<TreeNode> inorderTraversal(TreeNode root){
    List<TreeNode> inorder = new ArrayList<>();
    if(root == null) return inorder;

    // 创建dummy node，右指针指向root
    // 放到stack里，此时栈顶dummy就是iterator的当前位置
    TreeNode dummy = new TreeNode(0);
    dummy.right = root;
    Stack<TreeNode> stack = new Stack<>();
    stack.push(dummy);

    // 每次iterator挪到下一个点
    // 就是调整stack使得栈顶是下一个点
    while(!stack.isEmpty()){
        TreeNode node = stack.pop();
        if(node.right != null){
            node = node.right;
            while(node != null){
                stack.push(node);
                node = node.left;
            }
        }

        if(!stack.isEmtpy()){
            inorder.add(stack.peek());
        }
    }
    return inrder;
}
```

## 宽度优先搜索 BFS
### 使用条件
* 拓扑排序 (100%)
* 出现连通块的关键词(100%)
* 分层遍历(100%)
* 简单图最短路径(SSSP)
* 给定一个变换规则，从初始状态变到终止状态最少几步(100%)

### 复杂度
* 时间复杂度: O(V+E)
* 空间复杂度: O(V) 
### 代码模板

* BFS的基础模板，用map存距离
``` 
returnType bfs(Node startNode){
    Queue<Node> q = ArrayDeque<>();

    Map<Node, Integer> distance = new HashMap<>();

    q.offer(startNode);
    distance.put(startNode, 0);

    while(!q.isEmpty()){
        Node cur = q.poll();
        if(node 是终点){
            break; 或者 return somthing;
        }

        for(Node neighbor: node.getNeighbors()){
            if(distance.containsKey(neighbor)){
                continue;
            }
            q.offer(neighbor);
            distance.put(neighbor, distance.get(cur)+1);
        }

    }
    // 如果要返回所有点离起点的距离，就返回hashmap
    return distance;
    // 如果要返回所有连通的节点，就返回hashmap里所有的点
    return distance.keySet();
    // 如果要返回离终点的最短距离
    return distance.get(endNode);
}

```

* BFS 层序遍历模板
```
int bfs(Node startNode){
    Queue<Node> q = ArrayDeque<>();

    Set<Node> visited = new HashSet<>();

    q.offer(startNode);
    visited.add(startNode);
    int level = 0;
    while(!q.isEmpty()){
        int size = q.size();
        for(int i=0; i<size; i++){
            Node cur = q.poll();
            if(cur 满足条件的时候){ // 可以返回当前的层数
                return level;
            }
            for(Node neighbor: node.getNeighbors()){
                if(distance.contains(neighbor)){
                    continue;
                }
                q.offer(neighbor);
                visited.add(neighbor);
            }
        }
        level ++;
    }
}

```

* BFS 拓扑排序模板
```


```


## 深度优先搜索 DFS
### 使用条件
* 找满足某个条件的所有方案 (99%)
* 二叉树Binary Tree的问题(90%)
* 组合问题 (95%)
  - 问题模型: 求出所有满足条件的"组合"
  - 判断条件: 组合中的元素是顺序无关的 
* 排列问题 (95%)
  - 问题模型: 求出所有满足条件的"排列"
  - 判断调节: 组合中的元素是春旭相关的 （外星人字典）
  
### 不要用DFS的场景
* 连通块问题 (一定要用BFS，否则StackOverFlow)
* 拓扑排序 (一定要用BFS，否则StackOverFlow)
* 一切BFS可以解决的问题
  
### 复杂度
* 时间复杂度: O(方案个数 * 构造每个方案的时间)
  - 树的遍历: O(n)
  - 排列问题: O(n! * n)
  - 组合问题: O(2^n * n)
* 空间复杂度
### 代码模板

```
public ReturnType dfs(参数列表){
    if(递归出口){
        记录答案
        return;
    }

    for(所有的拆解可能性){
        修改所有的参数
        dfs(参数列表);
        还原所有被修改过的参数
    }

    return somthing 如果需要的话，很多时候不需要return的值 除了分治的写法
}
```

## 堆 Heap
### 使用条件
* 找最大值或最小值 (60%)
* 找第k大（pop k次，复杂度是O(nlogk)）(50%)
* 要求logn时间对数据进行操作(40%)
  
### 堆不能解决的问题
* 查询比某个数大是最小值/最接近的值(平衡排序二叉树Balanced BST/ 红黑树 TreeMap 才能解决)
* 找某段区间的最大值最小值(线段树Segment Tree可以解决)
* O(n)找第k大(使用快排中的partition操作)
  
### 代码模板
Java 带删除特定元素功能的堆
额外维护一个set，使得heap的delete操作在O(logn)时间内实现

```
class ValueIndexPair{
    int val, index;
    public ValueIndexPair(int val, int index){
        this.val = val;
        this.index = index;
    }
}

class Heap{
    private Queue<ValueIndexPair> minHeap;
    private Set<Integer> deleteSet;

    public Heap(){
        minHeap = new PriorityQueue<>((p1, p2)-> (p1.val - p2.val));
        deleteSet = new HashSet<>();
    }

    public void push(){
        minHeap.add(new ValueIndexPair(val, index));
    }

    private void lazyDeletion(){
        while(minHeap.size() != 0 && deleteSet.contains(minHeap.peel().index)){
            ValueIndexPair pair = minHeap.poll();
            deleteSet.remove(pair.index);
        }
    }

    public ValueIndexPair top(){
        lazyDeletion();
        return minHeap.peek();
    }

    public void pop(){
        lazyDeletion();
        minHeap.poll();
    }

    public void delete(int index){
        deleteSet.add(index);
    }

    public boolean isEmpty(){
        return minHeap,size() == 0;
    }
}

```


## 并查集
### 使用条件
* 需要查询图的联通状况的问题
* 需要支持快速合并两个集合的问题
  
### 复杂度
* 时间复杂度 
  - union O(1)
  - find O(1)
* 空间复杂度 O(n)
  
### 代码模板
```
// 用map实现并查集
class UnionFind {
    HashMap<Integer, Integer> fatherMap;
    HashMap<Integer, Integer> sizeMap;
    public UnionFind() {
        fatherMap = new HashMap<>();
        sizeMap = new HashMap<>();
    }

    public void add(int x) {
        if (fatherMap.containsKey(x))  return;
        fatherMap.put(x, x); // make x point to itself
        sizeMap.put(x, 1);
    }

    private Integer find(Integer node) {
        Integer captain = fatherMap.get(node);
        // 如果自己的船长不是自己 bubble up
        if (captain != node) {
            fatherMap.put(node, find(captain));
        }
        return fatherMap.get(node);
    }

    public boolean isConnected(Integer aNode, Integer bNode) {
        return find(aNode) == find(bNode);
    }

    public void union(Integer aNode, Integer bNode) {
        if (aNode == null || bNode == null) return;
        Integer aHead = find(aNode);
        Integer bHead = find(bNode);
        if (aHead != bHead) {
            int aSize = sizeMap.get(aHead);
            int bSize = sizeMap.get(bHead);
            if (aSize < bSize) {
                fatherMap.put(aHead, bHead);
                sizeMap.put(bHead, aSize + bSize);
            } else {
                fatherMap.put(bHead, aHead);
                sizeMap.put(aHead, aSize + bSize);
            }
        }
    }
}
```


## 字典树
### 使用条件
* 需要查询包含某个单词前缀的单词/字符串是否存在
* 字符矩阵中找单词的问题 (word search)
  
### 复杂度
* 时间复杂度 O(L) 增删查改
* 空间复杂度 O(N*L) N是单词数，L是单词长度
  
### 代码模板

```
class TrieNode{
    //儿子节点
    public Map<Character, TrieNode> children;
    // 根节点到该节点是否是一个单词
    public boolean isWord;
    //根节点到该节点的单词是什么
    public String word;

    public TrieWord(){
        sons = new HashMap<Character, TrieNode>();
        isWord = false;
        word = null;
    }
}

public class Trie{
    private TrieNode root;
    public Trie(){
        root = new TrieNode();
    }

    public TrieNode getRoot(){
        return root;
    }

    // 插入单词
    public void insert(String word){
        TrieNode = root;

    }
}
```


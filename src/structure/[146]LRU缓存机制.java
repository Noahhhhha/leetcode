//运用你所掌握的数据结构，设计和实现一个 LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。 
//
// 获取数据 get(key) - 如果密钥 (key) 存在于缓存中，则获取密钥的值（总是正数），否则返回 -1。 
//写入数据 put(key, value) - 如果密钥不存在，则写入其数据值。当缓存容量达到上限时，它应该在写入新数据之前删除最近最少使用的数据值，从而为新的数据值留出空间。 
//
// 进阶: 
//
// 你是否可以在 O(1) 时间复杂度内完成这两种操作？ 
//
// 示例: 
//
// LRUCache cache = new LRUCache( 2 /* 缓存容量 */ );
//
//cache.put(1, 1);
//cache.put(2, 2);
//cache.get(1);       // 返回  1
//cache.put(3, 3);    // 该操作会使得密钥 2 作废
//cache.get(2);       // 返回 -1 (未找到)
//cache.put(4, 4);    // 该操作会使得密钥 1 作废
//cache.get(1);       // 返回 -1 (未找到)
//cache.get(3);       // 返回  3
//cache.get(4);       // 返回  4
// 
// Related Topics 设计



//leetcode submit region begin(Prohibit modification and deletion)

/**
 * 最近最少使用缓存机制
 * 需要用到一个HashMap和LinkedList双向链表(这次我自制了一个)，类似于LinkHashMap的底层实现
 * HashMap中存着LikedListNode，也就是存有链表的每个节点，然后每个节点再前后互相指着
 * 新put进去的和get得到的 都需要删除掉，再重新绑定到LinkedList的头指针后面
 * 所以排在双向链表最后面的就是最不常用的，当size超标了以后，直接删除最后面的指针就可以了
 *
 * 真正用来存储的是HashMap，链表的作用是它的尾指针就是最少使用的，头指针是最近使用的
 * HashMap和双向链表的增、删都要同步做
 * Map<Integer,MyDoubleLinkedListNode> 注意map中装的是节点
 */
class LRUCache {
    Map<Integer,MyDoubleLinkedListNode> myMap; // 用来存储的HashMap
    MyDoubleLinkedListNode head; // 链表的头指针
    MyDoubleLinkedListNode tail; // 链表的尾指针
    int size; // 用来记录尺寸的
    public LRUCache(int capacity) {
        size = capacity;
        myMap = new HashMap<>();
        head = new MyDoubleLinkedListNode(-1, -1); // 一头一尾两个虚节点
        tail = new MyDoubleLinkedListNode(-1, -1);
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        if(size==0){
            return -1;
        }
        if(myMap.containsKey(key)){
            MyDoubleLinkedListNode node = myMap.get(key);
            delete(node);
            add(node);
            return myMap.get(key).value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (size == 0) return;
        MyDoubleLinkedListNode newNode = new MyDoubleLinkedListNode(key,value);
        if (!myMap.containsKey(key)){ // 当map中不包括这个key的时候，要考虑两种情况
            // 第一种情况是当前size是不是满了，如果满了就要砍掉最后一个节点
            if (myMap.size() >= size){
                // map.size返回的是键值对的数量
                MyDoubleLinkedListNode OldTail = tail.pre;
                delete(OldTail);
                myMap.remove(OldTail.key);
            }
            // 当size还没有满的时候
            add(newNode);
            myMap.put(key,newNode);
        }else {
            // 当已经有了这个节点的时候，就要覆盖这个节点的值
            // 为了确定LRU的顺序，应把其删除delete，再添加
            delete(myMap.get(key));
            myMap.remove(key);
            add(newNode);
            myMap.put(key,newNode);
        }
    }

    private void delete(MyDoubleLinkedListNode node){
        MyDoubleLinkedListNode pre = node.pre;
        MyDoubleLinkedListNode next = node.next;
        pre.next = next;
        next.pre = pre;
    }

    private void add(MyDoubleLinkedListNode node){
        // 从头指针后面加入
        MyDoubleLinkedListNode oldFirst = head.next; // 记录一下原先的第一个
        head.next = node;
        node.pre = head;
        node.next = oldFirst;
        oldFirst.pre = node;
    }
}
class MyDoubleLinkedListNode{
    MyDoubleLinkedListNode pre; // 指向前面
    MyDoubleLinkedListNode next; // 指向后面
    int key;
    int value;

    public MyDoubleLinkedListNode(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
//leetcode submit region end(Prohibit modification and deletion)

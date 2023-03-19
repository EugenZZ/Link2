public class LinkNode {
    //头节点
    public Node headNode;
    //尾节点
    public Node tailNode;
    //链表长度
    public int size;

    public Node getHeadNode() {
        return headNode;
    }

    public Node getTailNode() {
        return tailNode;
    }

    public int getSize() {
        return size;
    }

    public LinkNode() {
        this.headNode =new Node();
        this.tailNode =headNode;;

    }
    //对调头尾节点，方便链表反转
    public void turn(){
        Node temp=this.headNode;
        this.headNode =this.tailNode;

        this.tailNode = temp;
    }

    //打印链表
    public void display(){
        Node cur=this.headNode.next;
        while(cur != null){
            System.out.print(cur.data+" ");
            cur=cur.next;
        }
    }
    //尾插法
    public void headInsert(String data){
        Node newNode = new Node(data);
//        if(this.headNode == null){
//            this.headNode = newNode;
//            this.tailNode = newNode;
//        }else{
            this.tailNode.next = newNode;
            newNode.pre = this.tailNode;
            this.tailNode = newNode;
        //}
        this.size++;
    }
    //头插法
    public void tailInsert(String data){
        Node newNode = new Node(data);
        if(this.headNode == null){
            this.headNode = newNode;
            this.tailNode = newNode;
        }else{
            newNode.next = this.headNode;
            this.headNode.pre = newNode;
            this.headNode = newNode;
        }
        this.size++;
    }
    //删除
    public void delete(String data){
        Node cur=this.headNode.next;
        while(cur!=null){
            if(cur.data.equals(data)){
                if(cur==this.headNode.next){
                    this.headNode.next = cur.next;
                    if(this.headNode.next != null){
                        this.headNode.next.pre = null;
                    }
                    else{
                        this.tailNode = null;
                    }
                }else{
                    System.out.println(cur.data);
                    System.out.println();
                    cur.pre.next = cur.next;
                    if(cur.next!=null){
                        cur.next.pre = cur.pre;
                    }
                    else{
                        this.tailNode = this.tailNode.pre;
                    }
                }
                this.size--;
                return;
            }
            cur=cur.next;
        }
    }
    //查询
    public boolean find(String key){
     Node cur=new Node(key);
     while(cur!=null){
         if(cur.data==key){
             return true;
         }
         cur=cur.next;
     }
     return false;
    }
    //查询中点
    public Node findMidPoint(){
        Node cur1=this.headNode.next;
        //快指针
        Node cur2=this.headNode.next;
        //慢指针
        while(cur1.next!=null){
            if(cur1.next.next!=null) {
                cur2 = cur2.next;
                cur1 = cur1.next.next;
            }
            else{
                cur2 = cur2.next;
                return cur2;
            }
        }
        return cur2;
    }
    public boolean isRound(){
        Node cur1=this.headNode;
        //慢指针
        Node cur2=this.headNode.next;
        //快指针
        while(cur1!=cur2){
            if(cur1==null||cur2==null){
                return false;
            }
            cur1=cur1.next;
            cur2=cur2.next.next;

        }
        return true;
    }
    //反转函数
    public void reverse1(){
        this.tailNode=this.headNode.next;
        Node cur=this.headNode.next;
        Node pre=null;
        while(cur!=null) {
            //存储第二个节点地址
            Node temp = cur.next;
            //第二个节点指向前一个节点
            cur.next = pre;
            //两个结点向前移一位
            pre = cur;
            this.headNode.next = pre;
            cur = temp;
        }
        this.display();

    }
    //奇偶对调
    public void change(){
        Node cur1=this.headNode.next;
        Node cur2=this.headNode.next.next;
        if(cur1==null){
            return;
        }
        //走到null或走到最后一个为奇数时跳出
        while(cur1!=null&&cur2!=null){
            //相邻奇偶位对换
            String temp = cur1.data;
            cur1.data = cur2.data;
            cur2.data = temp;
            //下一组
            cur1=cur2.next;
            if(cur1!=null){
                cur2=cur2.next.next;
            }
            else{
                break;
            }

        }
        this.display();

    }


}

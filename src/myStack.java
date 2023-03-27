public class myStack {
        private Node header = new Node();   // 创建头节点
        private int size=0;

        myStack(){}

    public String get(int index) {
            int num=0;
            Node    node=header.next;
            while(index>num){
                node=node.next;
                num++;
            }
            return node.value;
    }

    class Node {
            String value;
            Node next;
        }
       //放入栈顶
        public boolean push(String value) {
            Node n = new Node();
            size++;
            n.value = value;
            if (header.next == null) {
                header.next = n;
                return true;
            }
            n.next = header.next;
            header.next = n;
            return true;
        }
      //删除栈顶
        public String pop() {
            if (header.next == null) {
                return "0";
            }
            String value = header.next.value;
            header.next = header.next.next;
            size--;
            return value;
        }
      //得到栈顶
        public String getTop() {
            if (header.next != null) {
                return header.next.value;
            }
            return null;
        }
      //判断栈顶是否为空
        public boolean isEmpty() {
            return header.next == null;
        }
        public int size() {
            return this.size;
        }
    public void clear(){
        header.next=null;
        size=0;
    }


}

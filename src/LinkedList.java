public class LinkedList<T> {
    private ListNode<T> firstNode = null;

    public LinkedList(){ }

    public void add(T data){
        ListNode<T> newNode = new ListNode<>(data);
        if (firstNode == null){
            firstNode = newNode;
            return;
        }

        ListNode<T> curr = firstNode;
        while (curr.getNext() != null) curr = curr.getNext();
        curr.setNext(newNode);
    }

    public void remove(){
        firstNode = firstNode.getNext();
    }

    public void clear(){
        firstNode = null;
        //GC will clear it
    }

    //N3
    public void reverse(){
        ListNode prev = null, curr = firstNode, next = firstNode.getNext();

        while (next != null){
            next = curr.getNext();
            curr.setNext(prev);
            prev = curr;
            curr = next;
        }
        firstNode = prev;
    }

    public LinkedList reverseList(){
        LinkedList<T> result = new LinkedList<>();

        reverse();
        ListNode<T> curr = this.firstNode;
        while (curr != null){
            result.add(curr.data);
            curr = curr.getNext();
        }
        reverse();

        return result;
    }

    public String toString(){
        if (firstNode == null){
            return "List is Empty";
        }

        StringBuilder sb = new StringBuilder();
        ListNode<T> currentNode = firstNode;

        sb.append(currentNode.data);
        currentNode = currentNode.getNext();
        while(currentNode != null){
            sb.append("->");
            sb.append(currentNode.data);
            currentNode = currentNode.getNext();
        }

        return sb.toString();
    }

    public class ListNode<K>{
        private ListNode<K> next = null;
        public K data;

        public ListNode(K data){
            this.data = data;
        }

        public void setNext(ListNode<K> next) {
            this.next = next;
        }

        public ListNode<K> getNext() {
            return next;
        }
    }
}

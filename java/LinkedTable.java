public class LinkedTable {
    Node next = null;

    void addNode(int a){
        Node node = new Node(a);
        //empty
        if (next == null) {
            next = node;
            return;
        }

        Node temp = next;
        while (temp.next != null){
            //find final node
            temp = temp.next;
        }
        temp.next = node;
    }

    @Override
    public String  toString() {
        StringBuilder stringBuilder = new StringBuilder();

        if (next == null) {
             return "empty";
        }

        Node temp = next;
        while (temp != null){
            //find final node
            stringBuilder.append(temp.data).append("__");
            temp = temp.next;
        }
        return stringBuilder.toString();
    }
}

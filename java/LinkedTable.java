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
    public String toString() {
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
    int getLength(){
        int length = 0;
        Node temp = this.next;
        while (temp != null){
            length ++;
            temp = temp.next;
        }
        return  length;
    }
    boolean remove(int index){

        if(getLength() == 0 || index < 1 || index > getLength()){
            return false;
        }
        //remove 1   index < length() this.next = this.next.next;
        // remove 1   index == length() this.next = null;

        // next->node1->node2  lenght 2
        // index 1
        //temp node1
        //i 1
        Node temp = this.next;
        int i = 1;
        while (temp != null){
            if(i == index){
                if (index == getLength()){
                    temp = null;
                }else{
                    temp = temp.next;
                }
                return true;
            }
            temp = temp.next;
            i++;
        }
        return true;
    }



}

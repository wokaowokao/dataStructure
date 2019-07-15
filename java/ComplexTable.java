public class ComplexTable {
    //判断链表是否有 环 环位置
    //两个链表是否相交  相交位置
    Node next = null;

    void addNode(Node node) {
        Node node1 = next;
        if (node1 == null) {
            next = node;
            return;
        }
        while (node1.next != null) {
            node1 = node1.next;
        }

        node1.next = node;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        if (next == null) {
            return "empty";
        }

        Node temp = next;
        while (temp != null) {
            //find final node
            stringBuilder.append(temp.data).append("__");
            temp = temp.next;
        }
        return stringBuilder.toString();
    }

    int getLength() {
        int length = 0;
        Node temp = this.next;
        while (temp != null) {
            length++;
            temp = temp.next;
        }
        return length;
    }

    static boolean hasSame(ComplexTable complexTable, ComplexTable complexTable1) {
        Node next = complexTable.next;
        while (next.next != null) {
            next = next.next;
        }
        Node next1 = complexTable1.next;
        while (next1.next != null) {
            next1 = next1.next;
        }
        return next == next1;
    }
static boolean hasCoin(ComplexTable complexTable){
    Node next = complexTable.next;
    Node next1 = complexTable.next;


    while (next1.next != null && next1.next.next!= null){
        next1 = next1.next.next;
        next = next.next;
        if(next == next1){
            return true;
        }

    }
    return false;
}
    static Node getSamePoint(ComplexTable complexTable, ComplexTable complexTable1) {
        int length = complexTable.getLength();
        int length1 = complexTable1.getLength();

        int k = length - length1;


        Node next = complexTable.next;
        Node next1 = complexTable1.next;

        if (k > 0) {
            while (k > 0) {
                next = next.next;
                k--;
            }
        } else {
            while (k < 0) {
                next1 = next1.next;
                k++;
            }
        }
        while (next != null){

            if(next == next1) {
                return next;
            }else {
                next = next.next;
                next1= next1.next;
            }
        }
        return null;
    }
     static Node getCoinPoint(ComplexTable complexTable){
        //先找出 交接点

         Node next = complexTable.next;
         Node next1 = complexTable.next;


         while (next1.next != null && next1.next.next!= null){
             next1 = next1.next.next;
             next = next.next;
             if(next == next1){
                break;
             }

         }

         Node next2 = complexTable.next;
         while (true){
             if(next == next2){
                 return next;
             }
             next = next.next;
             next2 = next2.next;
         }
     }
    public static void main(String[] args) {
        ComplexTable complexTable = new ComplexTable();
        complexTable.addNode(new Node(1));
        complexTable.addNode(new Node(2));
        complexTable.addNode(new Node(3));
        complexTable.addNode(new Node(4));
        complexTable.addNode(new Node(5));
        complexTable.next.next.next.next.next = complexTable.next.next.next;


        /*boolean b = hasCoin(complexTable);
        System.out.println(b);*/
        Node coinPoint = getCoinPoint(complexTable);
        System.out.println(coinPoint.data);
/*

        ComplexTable complexTable1 = new ComplexTable();
        complexTable1.addNode(new Node(1));

        complexTable1.addNode(complexTable.next.next.next);
*/


        //boolean b = hasCoin(complexTable, complexTable1);

        //System.out.println(b);

        //Node coinPoint = getCoinPoint(complexTable, complexTable1);
        //System.out.println(coinPoint.data);
    }
}

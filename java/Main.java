import com.sun.deploy.panel.DeleteFilesDialog;

import java.util.HashMap;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        //添加链表
        LinkedTable linkedTable = new LinkedTable();
        linkedTable.addNode(1);
     
        linkedTable.addNode(2);
    
        linkedTable.addNode(3);
         /*linkedTable.addNode(2);
        linkedTable.addNode(3);*/
        //deleteDuplicate(linkedTable);
        //final int indexFromBottom = getIndexFromBottomBetter(linkedTable, 4);
        //LinkedTable reverse = reverse(linkedTable);
        /*reversePrint(linkedTable.next);
        Node mid = getMid(linkedTable.next);*/
        LinkedTable linkedTable1 = removeOneNode(linkedTable,linkedTable.next.next);
        System.out.println(linkedTable1.toString());

    }

    //删除链表中重复的元素 借用hashMap实现
    public static void deleteDuplicate(LinkedTable linkedTable) {

        HashMap<Integer, Integer> objectObjectHashMap = new HashMap<>();

        if (linkedTable.getLength() == 1) {
            return;
        }
        Node tempNode = linkedTable.next.next;
        Node preNode = linkedTable.next;
        objectObjectHashMap.put(preNode.data, 1);

        while (tempNode != null) {
            if (objectObjectHashMap.containsKey(tempNode.data)) {
                preNode.next = tempNode.next;
            } else {
                preNode = preNode.next;
                objectObjectHashMap.put(tempNode.data, 1);
            }
            tempNode = tempNode.next;

        }

    }
    //获取倒数第k的链表值 时间复杂度 O(kn)
    static int getIndexFromBottom(LinkedTable linkedTable, int index){
        int length = linkedTable.getLength();
        int i = length - index + 1;
        if(i <= 0){
            System.out.println("error1");
            return 0;
        }else{
            Node next = linkedTable.next;
            int k = 1;
            while (next != null){
                if(i == k){
                    return next.data;
                }
                next = next.next;
                k++;
            }
        }
        System.out.println("error2");
        return 0;
    }
    //获取倒数第k的链表值 时间复杂度 O(n)
    static int getIndexFromBottomBetter(LinkedTable linkedTable, int index){
        Node kNode = linkedTable.next;
        Node iNode = linkedTable.next;

        while (index > 1){

            iNode = iNode.next;
            if(iNode == null){
                System.out.println("index 越界");
                return 0;
            }
            index--;
        }

        while (iNode.next != null){
            iNode = iNode.next;
            kNode = kNode.next;
        }
        return kNode.data;
    }
    //链表翻转
    static LinkedTable reverse(LinkedTable linkedTable){
        Stack<Node> nodes = new Stack<>();
        Node next = linkedTable.next;
        while (next != null){
            nodes.push(next);
            next = next.next;
        }
        LinkedTable linkedTable1 = new LinkedTable();
        while (!nodes.empty()){
            linkedTable1.addNode(nodes.pop().data);
        }
        return linkedTable1;
    }
    //翻转打印
    static void reversePrint(Node head){
        Node next = head;
        if(next != null){
            reversePrint(next.next);
            System.out.println(head.data);
        }
    }
    //取中间值
    static Node getMid(Node head){
        Node kNode = head;
        Node iNode = head;

        while(iNode.next != null && iNode.next.next!= null){
            kNode = kNode.next;
            iNode= iNode.next.next;
        }
        return kNode;

    }
    //未知头结点 删除结点
    static LinkedTable removeOneNode(LinkedTable linkedTable,Node node){
        //尾结点删除 不了
        node.data = node.next.data;
        node.next = node.next.next;
        return linkedTable;
    }
}

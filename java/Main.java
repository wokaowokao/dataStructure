import com.sun.deploy.panel.DeleteFilesDialog;

public class Main {
    public static void main(String[] args) {
        //添加链表
        LinkedTable linkedTable = new LinkedTable();
        linkedTable.addNode(1);
        linkedTable.addNode(2);
        /*linkedTable.addNode(2);
        linkedTable.addNode(3);*/
        boolean remove = linkedTable.remove(1);
        System.out.println(linkedTable.toString());
        System.out.println(linkedTable.getLength());
    }
}

import common.Node;
import org.junit.Test;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapters;
import java.util.Stack;

/**
 * @author zhangyawei Created on 2022/3/11.
 */
public class TestNode {

    Node a = new Node(null, 0);
    Node b = new Node(null, 1);
    Node c = new Node(null, 2);
    Node d = new Node(null, 3);
    Node e = new Node(null, 4);
    {
        a.setNext(b);
        b.setNext(c);
        c.setNext(d);
        d.setNext(e);
    }
    @Test
    public void plusTest(){
        Node test = a;
        while (test != null){
            System.out.println(test.getValue());
            test = test.getNext();
        }
        //链表翻转，放入栈里，利用栈的先进后出的原理实现
        Stack<Node> nodes = new Stack<>();
        while (test != null){
            System.out.println(test.getValue());
            nodes.push(test);
            test = test.getNext();
        }
        while
        nodes.pop().getValue()

    }

}

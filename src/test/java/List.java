/**
 * @author zhangyawei Created on 2022/3/12.
 */
public class List {

    int[] i = {2,1,3,0,2};
    //数组范围 0-n-1,找重复
    void findSame(){
        for (int i1 = 0; i1 < i.length; i1++) {

            if(i[i1] == i1) continue;

        }
    }
}

package common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zhangyawei Created on 2022/3/11.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Node {
    Node next;
    int value;
}

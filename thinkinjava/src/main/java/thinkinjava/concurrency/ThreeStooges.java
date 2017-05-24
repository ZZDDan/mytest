package thinkinjava.concurrency;

import java.util.HashSet;
import java.util.Set;

/**
 * @Title      :ThreeStooges
 * @Description:
 * @Company    :
 * @author     :zhangdan
 * @date       :2017年4月21日 下午3:11:45
 */
public final class ThreeStooges {

    private final Set<String> stooges = new HashSet<>();
    
    public ThreeStooges() {
        stooges.add("One");
        stooges.add("Two");
        stooges.add("Three");
    }
    
    public boolean isBooges(String name){
        return stooges.contains(name);
    }
}

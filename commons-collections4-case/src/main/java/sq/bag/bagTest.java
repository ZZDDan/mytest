package sq.bag;

import org.apache.commons.collections4.Bag;
import org.apache.commons.collections4.bag.HashBag;
import org.apache.commons.collections4.bag.TreeBag;
import org.junit.Test;

import java.util.Set;

/**
 * @Author: sq
 * @Description:
 * @Date: Created in 2018/1/5
 **/
public class bagTest {

    @Test
    public void HashBagTest(){
        Bag<String> mybag = new HashBag();
        mybag.add("abc");
        mybag.add("abc");
        mybag.add("bc");

        int num = mybag.getCount("abc");
        System.out.println("元素abc的个数："+num);



        Set unique = mybag.uniqueSet();
        System.out.println("uniqueu : "+unique);

        Boolean flag = mybag.add("bc",3);
        System.out.println(flag +"  元素‘bc’个数： "+mybag.getCount("bc"));
        System.out.println("collection size : "+mybag.size());
        System.out.println("mybag: "+mybag);
        mybag.forEach(bag-> System.out.println(bag));

    }

    @Test
    public void wordCount(){
        String str = "to be or not to be this is a question";
        String[]  strArray  = str.split(" ");
        Bag<String> bag = new TreeBag<>();
        for(String temp:strArray)
        {
            bag.add(temp);
        }
        System.out.println("=====统计次数========");
        Set<String> keys = bag.uniqueSet();
        keys.forEach((letter)->{
            System.out.println(letter+" ----> "+bag.getCount(letter));
        });
    }
}

package sq.predicate;

import org.apache.commons.collections4.Predicate;
import org.apache.commons.collections4.PredicateUtils;
import org.apache.commons.collections4.functors.EqualPredicate;
import org.apache.commons.collections4.functors.NotNullPredicate;
import org.apache.commons.collections4.functors.UniquePredicate;
import org.apache.commons.collections4.list.PredicatedList;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: sq
 * @Description: 断言
 * @Date: Created in 2018/3/29
 **/
public class PredicateTest {

    /**
     * 相等断言
     */
    @Test
    public void equalPredicate(){
        System.out.println("=====相等判断=======");
        Predicate<String> pre = new EqualPredicate<String>("liguodong");
        //Predicate<String> pre = EqualPredicate.equalPredicate("liguodong");//同上
        boolean flag = pre.evaluate("li");
        System.out.println(flag);
    }

    /**
     * 非空断言
     */
    @Test
    public void notNullPredicate(){
        System.out.println("=====非空判断=======");
        Predicate  notNull = NotNullPredicate.INSTANCE;
        //Predicate  notNull = NotNullPredicate.notNullPredicate();//同上
        String str = "lgd";
        String str1 = "";
        String nullstr = null;
        //非空为true,否则为false。
        System.out.println("str is null : "+notNull.evaluate(str));
        System.out.println("str1 is null :" +notNull.evaluate(str1));
        System.out.println("nullstr is null :" +notNull.evaluate(nullstr));

        //添加容器值得判断
        List<Long> list = PredicatedList.predicatedList(new ArrayList<>(), notNull);
        list.add(1000L);
        //null值为false， 验证失败，出现异常
       // list.add(null);
        list.forEach(System.out::println);
    }

    /**
     * 唯一性断言
     */
    @Test
    public void uniquePredicate(){
        System.out.println("=====唯一性判断=======");
        Predicate<Long> uniquePre = UniquePredicate.uniquePredicate();
        List<Long> list = PredicatedList.predicatedList(new ArrayList<Long>(),uniquePre);
        list.add(100L);
        list.add(200L);
        list.add(200L);

        list.forEach(System.out::println);
    }

    /**
     * 自定义断言
     */
    @Test
    public void sefDefind(){
        System.out.println("=====自定义判断=======");
        //自定义的判别式
        Predicate<String> selfPre = new Predicate<String>() {
            @Override
            public boolean evaluate(String object) {
                return object.length()>=5&&object.length()<=20;
            }
        };

        //非空
        Predicate notNull = NotNullPredicate.notNullPredicate();

        // 可以添加多个断言
        Predicate all = PredicateUtils.allPredicate(selfPre,notNull);

        List<String> list = PredicatedList.predicatedList(new ArrayList<>(), all);
        list.add("zhangsanfeng");
        //list.add(null);//java.lang.NullPointerException
        //list.add("byby");//java.lang.IllegalArgumentException
        list.forEach(System.out::println);
    }

}

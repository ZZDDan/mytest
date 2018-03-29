package sq.collectionUtils;

import org.apache.commons.collections4.Closure;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.Predicate;
import org.apache.commons.collections4.Transformer;
import org.apache.commons.collections4.functors.IfClosure;
import org.junit.Before;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @Author: sq
 * @Description:
 * @Date: Created in 2018/3/29
 **/
public class CollectionUtilsTest {
    private List<String> list1 =null;
    private List<String> list2 =null;
    private List<Employee> wujiang =null;
    private List<Weapon> weapons = null;

    @Before
    public void before(){
        list1 = new ArrayList<>();
        list1.add("刘备");
        list1.add("关羽");
        list1.add("赵云");

        list2 = new ArrayList<>();
        list2.add("公孙瓒");
        list2.add("赵云");

        wujiang = new ArrayList<>();
        wujiang.add(new Employee("张飞",3000));
        wujiang.add(new Employee("马超",2000));
        wujiang.add(new Employee("黄忠",1000));

        weapons = new ArrayList<>();
        weapons.add(new Weapon("青龙偃月刀",120,false));
        weapons.add(new Weapon("丈八蛇矛",80,false));
        weapons.add(new Weapon("雌雄双股剑",150,true));
    }

    @Test
    public void collectionUtilsTest(){
        System.out.println("========交集==========");
        // 求交集的两种方式
        // Collection<String> col1 = CollectionUtils.intersection(list1,list2);
        Collection<String> col1 =  CollectionUtils.retainAll(list1, list2);
        col1.forEach(System.out::println);

        System.out.println("========并集==========");
        Collection<String> col2 = CollectionUtils.union(list1, list2);
        col2.forEach(System.out::println);

        System.out.println("========差集==========");
        Collection<String> col3 = CollectionUtils.subtract(list1,list2);
        col3.forEach(System.out::println);

    }

    /**
     * 转换器
     */
    @Test
    public void transformatTest(){
        System.out.println("========《内置类型转换 长整型时间日期，转成指定格式的字符串》========");
        //类型转换器
        Transformer<Long,String> trans = new Transformer<Long,String>()
        {
            @Override
            public String transform(Long input) {
                return new SimpleDateFormat("yyyy年MM月dd日").format(input);
            }
        };
        //容器
        List<Long> list = new ArrayList<>();
        list.add(99999999L);
        list.add(30000L);
        // 参数 ：容器，转换器
        Collection<String> result = CollectionUtils.collect(list, trans);
        //遍历查看结果
       result.forEach(System.out::println);

        Transformer<String,String> tran = new Transformer<String,String>(){
            @Override
            public String transform(String input) {
                return "蜀将："+input;
            }
        };
        Collection<String> result2 = CollectionUtils.collect(list2,tran);
        result2.forEach(System.out::println);
    }

    /**
     函数式编程Closure 闭包封装业务功能
     *  1.  Closure
     *      CollectionUtils.forAllDo(容器,功能类对象)
     *
     *  2.  IfClosure
     *      IfClosure.ifClosure(断言，功能1，功能2)
     *      CollectionUtils.forAllDo(容器,功能类对象)
     *
     *  3.  WhileClosure
     *      WhileClosure.whileClosure(断言,功能，标识符)
     *      CollectionUtils.forAllDo(容器,功能类对象)
     *
     */
    @Test
    public void closure (){
        //业务功能
        System.out.println("################### 所有人涨薪30% ##################");
        Closure<Employee> cols = new Closure<Employee>()
        {
            @Override
            public void execute(Employee emp) {
                //涨薪30%
                emp.setSalary(emp.getSalary()*1.3);
            }
        };
        //工具类
        CollectionUtils.forAllDo(wujiang, cols);
        wujiang.forEach(System.out::println);


        System.out.println("################### 购买兵器 ##################");
        //满百减20
        Closure<Weapon> subtract = new Closure<Weapon>() {
            @Override
            public void execute(Weapon input) {
                if(input.getPrice()>=100){
                    input.setPrice(input.getPrice()-20);
                }
            }
        };

        //打折
        Closure<Weapon> discount = new Closure<Weapon>() {
            @Override
            public void execute(Weapon input) {
                if(input.isDiscount()){
                    input.setPrice(input.getPrice()*0.9);
                }
            }
        };

        //判断
        Predicate<Weapon> pre = new Predicate<Weapon>() {
            @Override
            public boolean evaluate(Weapon goods) {
                return goods.isDiscount();
            }
        };
        //二选一
        Closure<Weapon> ifClo = IfClosure.ifClosure(pre,discount,subtract);
        //关联
        CollectionUtils.forAllDo(weapons,ifClo);

        weapons.forEach(System.out::println);


     /*   System.out.println("###################如果工资小于3000 每次涨薪20% ####################");
        //业务功能 每次上涨0.2
        Closure<Employee> cols2 = new Closure<Employee>()
        {
            @Override
            public void execute(Employee emp) {
                emp.setSalary(emp.getSalary()*1.2);
            }

        };

        //判断
        Predicate<Employee> empPre = new Predicate<Employee>() {
            @Override
            public boolean evaluate(Employee emp) {
                return emp.getSalary()<3000;
            }
        };

        //false 表示while结构先判断后执行
        //true  表示do..while先执行后判断
        Closure<Employee> whileCols = WhileClosure.whileClosure(empPre,cols2,false);
        //工具类
        CollectionUtils.forAllDo(wujiang, whileCols);
        wujiang.forEach(System.out::println);*/


    }
}

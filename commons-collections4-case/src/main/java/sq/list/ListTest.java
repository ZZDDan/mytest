package sq.list;

import org.apache.commons.collections4.Factory;
import org.apache.commons.collections4.functors.NotNullPredicate;
import org.apache.commons.collections4.functors.StringValueTransformer;
import org.apache.commons.collections4.functors.UniquePredicate;
import org.apache.commons.collections4.list.*;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @Author: sq
 * @Description:
 * @Date: Created in 2018/1/4
 **/
public class ListTest {

    private List<String> list = null;
    private List<String> list2 = null;
    private List<Double> doubleList = null;

    @Before
    public void before() {
        list = new ArrayList<>();
        list.add("123");
        list.add("abc");

        list2 = new ArrayList(16);
        list2.add("a");
        list2.add("b");
        list2.add("c");

      /*  doubleList = new ArrayList<>();
        doubleList.add(3.14);
        doubleList.add(0.618);
        doubleList.add(2.71828);*/


    }

    @Test
    public void treeListTest() {
        TreeList<String> treelist = new TreeList();
    }

    @Test
    public void fixedSizeListTest() {

        FixedSizeList<String> fixedsizelist = FixedSizeList.fixedSizeList(list);
        // java.lang.UnsupportedOperationException: List is fixed size
       // fixedsizelist.add("123");
        //fixedsizelist.set(2,"nba"); // java.lang.IndexOutOfBoundsException: Index: 2, Size: 2
        System.out.println("原始list :"+fixedsizelist);
        fixedsizelist.set(1, "nba");
        System.out.println("调用set之后："+fixedsizelist);
        //fixedsizelist.forEach(item -> System.out.println(item));


    }

    @Test
    public void cursorableLinkedListTest() {
        //原始的list不能在遍历的同时对元素进行修改操作，这是会有并发修改异常
      /* list2.forEach(item -> {
            // java.util.ConcurrentModificationException
            if (item == "b") {
                list2.remove(item);
            }

        });*/

       /* for (int i = 0; i < list2.size(); i++) {
            System.out.println(list2.get(i));
        }*/

        System.out.println("=========================");
        CursorableLinkedList cur = new CursorableLinkedList();
        cur.add("A");
        cur.add("B");
        cur.add("C");
        cur.add("D");

        System.out.print("出始数组：");
        cur.forEach(item -> System.out.print(item + " "));
        System.out.println();


        CursorableLinkedList.Cursor cursor = cur.cursor();
        if (cursor.hasNext()) {
            Object o = cursor.next();
            System.out.println("使用游标移除元素: " + o);
            cursor.remove();
            // 也可以使用下面这种方式直接删除
            //cur.remove("D");
        }
        cursor.close();
        System.out.println("使用游标移除元素之后 : "+cur);


        Iterator<?> iterator = cur.iterator();
        if (iterator.hasNext()) {
            Object o = iterator.next();
            System.out.println("使用迭代器移除元素: " + o);
            iterator.remove();
        }

        System.out.println("使用迭代器移除元素之后: "+cur);
    }

    /**
     *  java.util.concurrent.CopyOnWriteArrayList
     */
    @Test
    public void CopyOnWriteArrayListTest(){
        CopyOnWriteArrayList clist = new CopyOnWriteArrayList();
        clist.addAll(list2);
        clist.forEach((item)->{
            if (item=="b"){
                clist.remove(item);
            }
        });
        System.out.println(clist);
    }

    @Test
    public void CuncurrentListTest(){

    }

    @Test
    public void GrowthListTest() {
        GrowthList growthList = GrowthList.growthList(list);
        System.out.println("原始list："+growthList);
        // 索引超出，自动增长,未赋值索引处为 null
        growthList.set(3, "44");
        System.out.println("自动增长后: "+growthList);
    }

    @Test
    public void LazyListTest() {
        LazyList lazyList = LazyList.lazyList(list, new Factory<String>() {
            @Override
            public String create() {
                return "new";
            }
        });
        System.out.println(lazyList);
        // 获得超出索引位置的元素(get(2))，自动增长,使用Factory返回的填充
        System.out.println("lazyList.get(1): " + lazyList.get(1));
        //System.out.println("lazyList.get(2): "+lazyList.get(2));
        System.out.println("lazyList.get(3): " + lazyList.get(3));
        System.out.println(lazyList);
    }

    @Test
    public void PredicatedListTest() {
        PredicatedList predicatedList = PredicatedList.predicatedList(
                list, NotNullPredicate.INSTANCE);
        predicatedList.add("123");
        // 抛出异常
        // predicatedList.add(null);
        System.out.println(predicatedList);

        PredicatedList predicatedList2 = PredicatedList.predicatedList(
                list, UniquePredicate.uniquePredicate());
        predicatedList2.add("abc");
        System.out.println(predicatedList2);

    }

    @Test
    public void setUniqueListTest() {
        SetUniqueList setUniqueList = SetUniqueList.setUniqueList(list);
        boolean success = setUniqueList.add("abc");
        System.out.println("add elemets 'abc' is " + success);
        boolean success2 = setUniqueList.add("def");
        System.out.println("add elemets 'def' is " + success2);
        System.out.println(setUniqueList);
    }

    @Test
    public void TransformedListTest() {
        TransformedList transformedList = TransformedList.transformedList(list, StringValueTransformer.stringValueTransformer());
        // 添加时会将其转换为字符串
        transformedList.add(new Integer(20));
        transformedList.forEach(item ->{
            System.out.println(item+"----"+item.getClass());
        });
        System.out.println(transformedList);
    }



}

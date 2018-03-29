package sq.bidimap;

import org.apache.commons.collections4.BidiMap;
import org.apache.commons.collections4.Factory;
import org.apache.commons.collections4.MapIterator;
import org.apache.commons.collections4.MultiValuedMap;
import org.apache.commons.collections4.bidimap.DualHashBidiMap;
import org.apache.commons.collections4.map.*;
import org.apache.commons.collections4.multimap.HashSetValuedHashMap;
import org.junit.Before;
import org.junit.Test;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @Author: sq
 * @Description:
 * @Date: Created in 2018/1/5
 **/
public class MapTest {

    private Map<String, String> map = null;

    @Before
    public void before() {
        map = new HashMap();
        map.put("CHN", "习近平");
        map.put("USA", "特朗普");
        map.put("FRA", "马克龙");
    }

    /**
     * map 的几种常用遍历方式
     */
    @Test
    public void showMap() {

        // 第一种：
        System.out.println("第一种：通过Map.keySet遍历key和value：");
        for (String s : map.keySet()) {
            //map.keySet()返回的是所有key的值
            //得到每个key多对用value的值
            String str = map.get(s);
            System.out.println(s + "  ==   " + str);
        }


        System.out.println("###################################");
        // 第二种：
        System.out.println("第二种：通过Map.entrySet使用iterator遍历key和value：");
        Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, String> entry = it.next();
            System.out.println("key= " + entry.getKey() + " and value= " + entry.getValue());
        }


        System.out.println("###################################");
        // 第三种：推荐，尤其是容量大时
        System.out.println("第三种：通过Map.entrySet遍历key和value");
        for (Map.Entry<String, String> entry : map.entrySet()) {

            System.out.println("key= " + entry.getKey() + " and value= "
                    + entry.getValue());
        }


        System.out.println("###################################");
        // 第四种：
        System.out.println("第四种：通过Map.values()遍历所有的value，但不能遍历key");
        for (String v : map.values()) {
            System.out.println("value= " + v);
        }


        System.out.println("###################################");
        System.out.println("第五种：JDK 8 的新特性 lambda表达式");
        map.forEach((k,v)->{
            System.out.println(k+"==="+v);
        });
    }

    @Test
    public void BidiMapTest() {
        BidiMap map = new DualHashBidiMap();
        map.put("wei", "郭嘉");
        map.put("wei", "曹操");
        map.put("吴", "孙权");

        map.put("魏", "诸葛亮");
        map.put("蜀", "诸葛亮");

        Object keys = map.getKey("诸葛亮");

        System.out.println("value find key :" + keys);

        Object values1 = map.get("蜀");
        Object values2 = map.get("wei");
        System.out.println("key find value1 :" + values1 + "  values2 : " + values2);

        System.out.println("init map : " + map);

        // K-V <---> V-K
        BidiMap map2 = map.inverseBidiMap();
        System.out.println("inverse map: " + map2);

        MapIterator it = map2.mapIterator();
        while (it.hasNext()) {
            Object next = it.next();
            Object key = it.getKey();
            Object value = it.getValue();
            //it.setValue("");
            System.out.println("next: " + next + "  key：" + key + "  value:" + value);
        }
    }


    /**
     * 一个对键的大小写不敏感的Map，在将键添加或与其它键比较之前，会将其转换为小写字符串
     */
    @Test
    public void CaseInsensitiveMapTest() {

        CaseInsensitiveMap caseInsensitiveMap = new CaseInsensitiveMap();
        caseInsensitiveMap.put("name", "China");
        caseInsensitiveMap.put("NAME", "China");
        System.out.println(caseInsensitiveMap);
        System.out.println(caseInsensitiveMap.get("NAme"));
        System.out.println(caseInsensitiveMap.get("nAme"));
    }

    /**
     * 修饰另一个Map。添加和移除操作使用可插拔的策略，如果没有提供策略，添加和删除是不支持的。
     */
    @Test
    public void CompositeMapTest() {
        CompositeMap compositeMap = new CompositeMap();
        compositeMap.addComposited(map);
        CompositeMap.MapMutator mapMutator1 = new CompositeMap.MapMutator() {
            @Override
            public void resolveCollision(CompositeMap composite, Map existing,
                                         Map added, Collection intersect) {
            }

            @Override
            public void putAll(CompositeMap map, Map[] composited, Map mapToAdd) {
            }

            @Override
            public Object put(CompositeMap map, Map[] composited, Object key,
                              Object value) {
                return composited[0].put(key, value);
            }
        };

        CompositeMap.MapMutator mapMutator2 = new CompositeMap.MapMutator() {

            @Override
            public void resolveCollision(CompositeMap composite, Map existing,
                                         Map added, Collection intersect) {
            }

            @Override
            public void putAll(CompositeMap map, Map[] composited, Map mapToAdd) {
            }

            @Override
            public Object put(CompositeMap map, Map[] composited, Object key,
                              Object value) {
                return composited[0].put(key.toString().toUpperCase(), value + " 万岁");
            }
        };

        CompositeMap.MapMutator mapMutator3 = new CompositeMap.MapMutator(){
            @Override
            public void resolveCollision(CompositeMap composite, Map existing, Map added, Collection intersect) {

            }

            @Override
            public Object put(CompositeMap map, Map[] composited, Object key, Object value) {
                return null;
            }

            @Override
            public void putAll(CompositeMap map, Map[] composited, Map mapToAdd) {

            }
        };

        compositeMap.setMutator(mapMutator1);
        compositeMap.put("name", "china");

        compositeMap.setMutator(mapMutator2);
        compositeMap.put("name", "CHINA");
        System.out.println(compositeMap.get("name"));
        System.out.println(compositeMap.get("NAME"));
    }


    /**
     * 修饰另一个Map，当使用get方法时，如果键不存在，将返回默认对象。
     */
    @Test
    public void DefaultedMapTest() {
        DefaultedMap defaultedMap = new DefaultedMap("default value");
        defaultedMap.put("name", "CHINA");
        System.out.println(defaultedMap);
        // 返回默认值 key = "NAME" 不存在
        System.out.println(defaultedMap.get("NAME"));
    }

    @Test
    public void FixedSizeMapTest() {
        FixedSizeMap fixedSizeMap = FixedSizeMap.fixedSizeMap(map);
        // FixedSizeMap fixedSizeMap2 = (FixedSizeMap)MapUtils.fixedSizeMap(map);
        // 不支持添加
        //fixedSizeMap.put("name", "121");
        // 支持修改
        //fixedSizeMap.put("USA", "I don't know");
        System.out.println(fixedSizeMap);
        MapIterator iterator = fixedSizeMap.mapIterator();
        while (iterator.hasNext()) {
            iterator.next();
            System.out.println(iterator.getKey() + "====" + iterator.getValue());
        }

    }


    /**
     * LazyMap修饰另一个Map。当执行get()方法时，如果键值不存在，则返回工厂创建的对象。
     */
    @Test
    public void LazyMapTest() {
        Factory factory = new Factory() {
            @Override
            public Object create() {
                return "NULL";
            }
        };
        LazyMap lazyMap = LazyMap.lazyMap(map, factory);
        lazyMap.put("RUS", "普京");
        System.out.println(lazyMap);
        System.out.println(lazyMap.get("UK"));


    }

    /**
     * LinkedMap实现了一个可维护顺序的Map，键的顺序为插入的顺序。
     */
    @Test
    public void linkedMapTest() {
        LinkedMap linkedMap = new LinkedMap();
        for (int i = 0; i < 10; i++) {
            linkedMap.put("key" + i, "value" + i);
        }
        System.out.println(linkedMap);
        String key = "key5";
        System.out.println("key5 previousKey :" + linkedMap.previousKey(key));
        System.out.println("key5 nextKey :" + linkedMap.nextKey(key));
        System.out.println("key5 index :" + linkedMap.indexOf(key));

    }

    /**
     * MultiKeyMap实现了一个允许多个键的Map，允许将多个键关联到一个值上。
     */
    @Test
    public void multiKeyMapTest() {
        MultiKeyMap multiKeyMap = new MultiKeyMap();
        // 多个键对应一个值
        multiKeyMap.put("天罡星", "豹子头", "卢俊义");
        multiKeyMap.put("天雄星", "豹子头", "林冲");

        System.out.println(multiKeyMap);
        System.out.println("天雄星 " + multiKeyMap.get("天雄星"));
        System.out.println("天雄星 豹子头 ：" + multiKeyMap.get("天雄星", "豹子头"));
        System.out.println("天罡星 豹子头 ：" + multiKeyMap.get("天罡星", "豹子头"));

        MapIterator mapIterator = multiKeyMap.mapIterator();
        System.out.println("MapIterator遍历：");
        while (mapIterator.hasNext()) {
            mapIterator.next();
            System.out.println(mapIterator.getKey() + "===" + mapIterator.getValue());
        }
        System.out.println("JDK 8 forEach遍历：");
        multiKeyMap.forEach((k, v) -> {
            System.out.println(k + "===" + v);
        });
    }

    @Test
    public void  t(){
        MultiValuedMap<String,String> map = new HashSetValuedHashMap<>();
        map.put("A","ddd");
        map.put("A","aae");
        map.put("A","aae");
        map.put("A","aaa");

        System.out.println(map);
    }

}

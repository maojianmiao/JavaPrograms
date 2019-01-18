package javaCore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;



import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;

import org.testng.annotations.Test;

public class Compare {

	@SuppressWarnings("unchecked")
    public static void compareJson(JSONObject json1, JSONObject json2, String key) {
        Iterator<String> i = json1.keySet().iterator();
        while (i.hasNext()) {
            key = i.next();
            compareJson(json1.get(key), json2.get(key), key);
        }
//        return sb.toString();
    }

    public static void compareJson(Object json1, Object json2, String key) {
        if (json1 instanceof JSONObject) {
//            System.out.println("this JSONObject----" + key);
            compareJson((JSONObject) json1, (JSONObject) json2, key);
        } else if (json1 instanceof JSONArray) {
//            System.out.println("this JSONArray----" + key);
            compareJson((JSONArray) json1, (JSONArray) json2, key);
        } else if (json1 instanceof String) {
//            System.out.println("this String----" + key);
//            compareJson((String) json1, (String) json2, key);
            try {
                String json1ToStr = json1.toString();
                String json2ToStr = json2.toString();
                compareJson(json1ToStr, json2ToStr, key);
            } catch (Exception e) {
                System.out.println("转换发生异常 key:" + key);
                e.printStackTrace();
            }
 
        } else {
//            System.out.println("this other----" + key);
            compareJson(json1.toString(), json2.toString(), key);
        }
    }
 
    public static void compareJson(String str1, String str2, String key) {
        if (!str1.equals(str2)) {
            System.err.println("不一致key:" + key + ",json1:" + str1 + ",json2:" + str2);
        } else {
            System.out.println("一致：key:" + key + ",json1:" + str1 + ",json2:" + str2);
        }
    }
 
    public static void compareJson(JSONArray json1, JSONArray json2, String key) {
        if (json1 != null && json2 != null) {
            Iterator i1 = (Iterator) json1.iterator();
            Iterator i2 = (Iterator) json2.iterator();
            while (i1.hasNext()) {
                compareJson(i1.next(), i2.next(), key);
            }
        } else {
            if (json1 == null && json2 == null) {
                System.err.println("不一致：key:" + key + "  在json1和json2中均不存在");
            } else if (json1 == null) {
                System.err.println("不一致：key:" + key + "  在json1中不存在");
            } else if (json2 == null) {
                System.err.println("不一致：key:" + key + "  在json2中不存在");
            } else {
                System.err.println("不一致：key:" + key + "  未知原因");
            }
 
        }
    }

	@Test
	public void toJson() {
		Person p = new Person("测试",true,12,180.1);
		Person z = new Person("妹子",false,19,170.1);
		Person x = new Person("傻子",false,33,170.1);
		
		List<Person> lp = new ArrayList();
		lp.add(z);
		lp.add(x);
		Person[] ap = {z,x};
		Map mp = new HashMap<String,Person>();
		mp.put("shazi", x);
		mp.put("妹子", z);
		
		p.setPersons(lp);
		p.setArraypersons(ap);
		p.setMappersons(mp);
		//关闭循环引用
		JSONObject j1 = JSONObject.parseObject(JSON.toJSONString(p, SerializerFeature.DisableCircularReferenceDetect));
		JSONObject j2 = JSONObject.parseObject(JSON.toJSONString(z, SerializerFeature.DisableCircularReferenceDetect));
		//String s = JSON.toJSONString(p, SerializerFeature.DisableCircularReferenceDetect);
		//System.out.println(s);
		compareJson(j1, j2, null);
		
	}
	
	
	public static CompareResult cmp(Object origin,Object baseline){
		
		return new CompareResult();
	}
}

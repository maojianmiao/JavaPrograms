package javaCore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.naming.spi.DirStateFactory.Result;
import bsh.This;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.testng.annotations.Test;
public class Compare {

	private CompareResult result;
	
	public Compare(){
		this.result = new CompareResult(0);
	}
	
	@SuppressWarnings("unchecked")
    public CompareResult compareJson(JSONObject json1, JSONObject json2, String key) {
        Set<String> set = new HashSet<String>();
        set.addAll(json2.keySet());
        set.addAll(json1.keySet());
		Iterator<String> i = set.iterator();
        System.out.println("set:" + set);
        while (i.hasNext()) {
            key = i.next();
            if (json2.containsKey(key) && json1.containsKey(key)){
            	compareObject(json1.get(key), json2.get(key), key);
            }
            else if (json1.containsKey(key)){
            	String s = String.format("不一致，key: %s, json2 不包含\r\n", key);
            	result.addCode();
            	result.addMessage(s);
            }
            else{
            	String s = String.format("不一致，key: %s, json1 不包含\r\n", key);
            	result.addCode();
            	result.addMessage(s);
            }
        }
        
        return result;
//        return sb.toString();
    }
	
    public void compareObject(Object json1, Object json2, String key) {
        if (json1 instanceof JSONObject) {
//            System.out.println("this JSONObject----" + key);
            compareJson((JSONObject) json1, (JSONObject) json2, key);
        } else if (json1 instanceof JSONArray) {
//            System.out.println("this JSONArray----" + key);
            compareArray((JSONArray) json1, (JSONArray) json2, key);
        } else if (json1 instanceof String) {
            try {
                String json1ToStr = json1.toString();
                String json2ToStr = json2.toString();
                compareString(json1ToStr, json2ToStr, key);
            } catch (Exception e) {
            	String s = "转换发生异常 key:" + key;
                result.addMessage(s);
                result.addCode();
                e.printStackTrace();
            }
 
        } else {
//            System.out.println("this other----" + key);
            compareString(json1.toString(), json2.toString(), key);
        }
    }
 
    public void compareString(String str1, String str2, String key) {
        if (!str1.equals(str2)) {
        	String s = "不一致，key:" + key + ",json1:" + str1 + ",json2:" + str2 + "\r\n";
        	result.addMessage(s);
        	result.addCode();
            //System.err.println(s);
        } else {
        	String s = "一致：key:" + key + ",json1:" + str1 + ",json2:" + str2 + "\r\n";
            System.out.println(s);
        }
    }
 
    public void compareArray(JSONArray json1, JSONArray json2, String key) {
        if (json1 != null && json2 != null) {
            Iterator i1 = (Iterator) json1.iterator();
            Iterator i2 = (Iterator) json2.iterator();
            while (i1.hasNext()) {
            	compareObject(i1.next(), i2.next(), key);
            }
        } else {
        	String s;
            if (json1 == null && json2 == null) {
            	s ="不一致, key:" + key + "  在json1和json2中均不存在\r\n";
                //System.err.println(s);
            } else if (json1 == null) {
            	s = "不一致, key:" + key + "  在json1中不存在\r\n";
                //System.err.println(s);
            } else if (json2 == null) {
            	s = "不一致, key:" + key + "  在json2中不存在\r\n";
                //System.err.println(s);
            } else {
            	s = "不一致, key:" + key + "  未知原因\r\n";
                //System.err.println(s);
            }
            result.addMessage(s);
            result.addCode();
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
		System.out.println("j1:" + j1);
		System.out.println("j2:" + j2);
		CompareResult result = compareJson(j2, j1,null);
		System.err.println(result.getMessage());
	}
	
}

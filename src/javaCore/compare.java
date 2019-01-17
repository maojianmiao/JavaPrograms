package javaCore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

import org.testng.annotations.Test;

public class compare {

	
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
		String s = JSON.toJSONString(p, SerializerFeature.DisableCircularReferenceDetect);
		System.out.println(s);
	}
}

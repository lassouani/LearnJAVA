package json;


import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;
/**
 * Hello world!
 *
 */
public class getJsonField 
{
    public static void main( String[] args )
    {
        
        String json = "{  \r\n" + 
        		"    \"uuid\":\"9f255b1d-ab5d-419a-b398-670668a4c271\",\r\n" + 
        		"    \"updates\":{  \r\n" + 
        		"        \"organizationList\":{  \r\n" + 
        		"            \"delete\":[  \r\n" + 
        		"\r\n" + 
        		"            ],\r\n" + 
        		"            \"insert\":[  \r\n" + 
        		"\r\n" + 
        		"            ],\r\n" + 
        		"            \"update\":[  \r\n" + 
        		"\r\n" + 
        		"            ]\r\n" + 
        		"        },\r\n" + 
        		"        \"unitList\":{  \r\n" + 
        		"            \"delete\":[  \r\n" + 
        		"\r\n" + 
        		"            ],\r\n" + 
        		"            \"insert\":[  \r\n" + 
        		"\r\n" + 
        		"            ],\r\n" + 
        		"            \"update\":[  \r\n" + 
        		"\r\n" + 
        		"            ]\r\n" + 
        		"        },\r\n" + 
        		"        \"professionalList\":{  \r\n" + 
        		"            \"delete\":[\r\n" + 
        		"            	\r\n" + 
        		"            	],\r\n" + 
        		"            \"insert\":[  \r\n" + 
        		"\r\n" + 
        		"            ],\r\n" + 
        		"            \"update\":[  \r\n" + 
        		"                {  \r\n" + 
        		"                    \"id\":660037,\r\n" + 
        		"                    \"origin\":\"ROR_BRG\",\r\n" + 
        		"                    \"sex\":\"H\",\r\n" + 
        		"                    \"lastName\":\"PALMA6\",\r\n" + 
        		"                    \"firstName\":\"Alexandre\",\r\n" + 
        		"                    \"adeliCode\":\"\",\r\n" + 
        		"                    \"rppsCode\":\"\",\r\n" + 
        		"                    \"qualifications\":[  \r\n" + 
        		"                       \r\n" + 
        		"                    ],\r\n" + 
        		"                    \"specialties\":[  \r\n" + 
        		"					\r\n" + 
        		"                    ],\r\n" + 
        		"                    \"competences\":[  \r\n" + 
        		"\r\n" + 
        		"                    ],\r\n" + 
        		"                    \"email\":\"alexandre.palma.5@esante-bourgogne.fr\",\r\n" + 
        		"                    \"securedEmail\":\"\",\r\n" + 
        		"                    \"personalEmail\":\"alexandre.palma@esante-bourgogne.fr\",\r\n" + 
        		"                    \"phone\":\"\",\r\n" + 
        		"                    \"deletedDate\":null,\r\n" + 
        		"                    \"unitList\":[  \r\n" + 
        		"                        6596\r\n" + 
        		"                    ]\r\n" + 
        		"                }\r\n" + 
        		"            ]\r\n" + 
        		"        }\r\n" + 
        		"    }\r\n" + 
        		"}";
        
        JSONObject jsonobj = new JSONObject(json);
        
        JSONObject update = (JSONObject) jsonobj.get("updates");
        
        JSONObject userObj = (JSONObject) update.get("professionalList");
        
        JSONArray userObjInsert = (JSONArray) userObj.get("insert");
        JSONArray userObjUdpdate = (JSONArray) userObj.get("update");
        JSONArray userObjDelete = (JSONArray) userObj.get("delete");
        
        JSONObject jsonobjuser = (JSONObject) userObjUdpdate.get(0);
        
        
        System.out.println(jsonobjuser.get("lastName").toString());
        
        
        System.out.println(userObj);
        
        System.out.println(getStringFromJson(userObjUdpdate.getJSONObject(0),"lastName"));
        System.out.println(userObjUdpdate.getJSONObject(0).get("lastName"));
        
        System.out.println(getid2("test_test@hotmail.fr"));
        
        String str = "ilo.ici.koi";
        
        System.out.println(str.split("//.")[0]);
        
        System.out.println(2<<2);

        Date date = new Date();
        
        System.out.println(date);
        
        Map<Long, String> m = new HashMap<Long, String>();
        m.put(new Long(0), "value");
        m.put(new Long(0), "value2");
        
        
        //m.forEach((k,v) -> System.out.println("key: "+k+" value:"+v));
        
        for(Long i : m.keySet())
        System.out.println(m.get(i));
        
        String b = " test de de string";
        String n = b.trim();
        
        System.out.println(n);
      
        
    }
    
    
   
    
    public static String getStringFromJson(JSONObject jsonobj, String code) {
		String result = null;
		if (!jsonobj.isNull(code)) {
			result = jsonobj.get(code).toString();
		}
		return result;
	}
    
    
    public static String getid2(String identifinat) {
		String id2 = null;
		if (identifinat != null && identifinat.contains("@")) {
			String id[] = identifinat.split("@");
			if (id.length > 1) {
				id2 = id[0] + "[@" + id[1] + "]";
			}
		}
		return id2;
	}
    
}


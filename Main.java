import java.io.IOException;
import java.util.*;
class Student
{
	String name,xueyuan,zhuanye;
	String xuehao;
	public Student(Map<String,String>nametoxuehao,Map<String,ArrayList<String>>theclass)
	{
		String name;
		String xuehao;
		System.out.println("请输入学号");
		Scanner sc = new Scanner(System.in);
		xuehao=sc.nextLine();
		name =nametoxuehao.get(xuehao);
		System.out.println(theclass.get(name));
		
		
	}
    public String toString()
    {
        return this.name+"\t"+this.xuehao+"\t"+this.xueyuan+"\t"+this.zhuanye;
    }
	
}
public class Main {
	
	static Map<String ,Map>zhuanye  =new HashMap<String,Map>();
	
	static Map<String ,ArrayList>banji = new HashMap<>();
	static Map<String ,ArrayList>xueyuan = new HashMap<>();/*方法getClassList(String ClassID*/	
	public static void main(String []args) throws IOException
	{
		/*获取映射*/
		xueyuan=Tools.getCollageToMajorMap();
		String keyset="网络空间安全与信息法学院";
		ArrayList<String> zhuanye1=new ArrayList<>();
		zhuanye1 = xueyuan.get(keyset);
		Map<String, List<String>> clazzes = new HashMap<>();
		clazzes = Tools.getMajorToClassList();
		Map<String,List<String>> clazz=new HashMap<>();
		for(String str:zhuanye1)
		{
			clazz.put(str,clazzes.get(str));
		}
		
		
		/*这里开始数据储存*/
		Map<String,Map<String,Map<String,ArrayList<String>>>>cyser = new HashMap<>();
		Map<String,Map<String,ArrayList<String>>>major = new HashMap<>();
		Map<String,ArrayList<String>>theclass = new HashMap<>();
		Map<String,String>nametoxuehao = new HashMap<>();
		for(String str:zhuanye1)
	    {
			for(String str3:clazz.get(str))
			{
				
				
			    Set key1 = Tools.getClassList(str3).keySet();
				for(Object str5:key1)
				{
					theclass.put(str5.toString(),Tools.getClassList(str3).get(str5));
					Object[] arr = new String[10];
					arr =Tools.getClassList(str3).get(str5).toArray();
					nametoxuehao.put(arr[1].toString(), str5.toString());	
				}
				major.put(str3,theclass);
			}
			cyser.put(str, major);	
	    }
		System.out.println("inputok!");
		while(true)
		{
			Student stut =new Student(nametoxuehao,theclass);
		}
	}
}

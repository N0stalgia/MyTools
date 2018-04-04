package bigDirectory;

import java.io.File;
import java.util.ArrayList;
import java.util.TreeMap;

public class BigDirectory {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//先获取父文件夹下所有的文件夹和文件，将文件夹和文件分开
		//对每个文件夹调用getBigestDir，递归，统计
		//
		File dirFile = new File("D:\\Program Files");
		File[] list = dirFile.listFiles();
//		System.out.println(list[0].getName());
//		TreeMap<String,Long> tm = new TreeMap<String,Long>();
		ArrayList<String> nameList = new ArrayList<String> ();	//用来放文件夹的名字，因为获取的名字列表是数组格式的
		ArrayList<Long> sizeList = new ArrayList<Long> ();	//存放文件夹大小
		
		for (int i=0; i<list.length; i++) {
			
			if(list[i].isDirectory()) {
				nameList.add("Dir\t"+list[i].getName());
				sizeList.add(BigDirectory.getBigestDir(list[i]));
			}
			else {
				nameList.add("File--"+list[i].getName());
				sizeList.add(list[i].length());
			}
		}
//		System.out.println(nameList.size());
		for (int i=0; i<nameList.size(); i++) {
			System.out.println(nameList.get(i)+"--"+sizeList.get(i)/1000000+"M");
		}
	}
	
	public static long getBigestDir(File file) {
		long size = 0;	//这个是否合理？
		File[] list = file.listFiles();
		for (int i=0; i<list.length; i++) {
			if (list[i].isDirectory()) {
				size = size + getBigestDir(list[i]);	//是文件夹就继续，到最后还是文件
			} 
			else {
				size = size + list[i].length();	//是文件就统计大小
			}
		}
		return size;
	}

}

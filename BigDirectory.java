package bigDirectory;

import java.io.File;
import java.util.ArrayList;
import java.util.TreeMap;

public class BigDirectory {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//�Ȼ�ȡ���ļ��������е��ļ��к��ļ������ļ��к��ļ��ֿ�
		//��ÿ���ļ��е���getBigestDir���ݹ飬ͳ��
		//
		File dirFile = new File("D:\\Program Files");
		File[] list = dirFile.listFiles();
//		System.out.println(list[0].getName());
//		TreeMap<String,Long> tm = new TreeMap<String,Long>();
		ArrayList<String> nameList = new ArrayList<String> ();	//�������ļ��е����֣���Ϊ��ȡ�������б��������ʽ��
		ArrayList<Long> sizeList = new ArrayList<Long> ();	//����ļ��д�С
		
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
		long size = 0;	//����Ƿ����
		File[] list = file.listFiles();
		for (int i=0; i<list.length; i++) {
			if (list[i].isDirectory()) {
				size = size + getBigestDir(list[i]);	//���ļ��оͼ�������������ļ�
			} 
			else {
				size = size + list[i].length();	//���ļ���ͳ�ƴ�С
			}
		}
		return size;
	}

}

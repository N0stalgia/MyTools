## 第五章 

### 内存gc概念 
使用System.gc() 可以让垃圾回收器尽快回收内存垃圾，但这也是一个不确定的过程，有可能调用完gc就清理了垃圾，也可能要等上一阵子。
系统在gc时，会调用finalize()方法，但是这个方法看起来`并没有什么卵用`。
不过，覆盖这个方法，让其输出信息，可以让我们看到，系统在什么时候进行了gc。
```java
class Chair {
  static boolean gcrun = false;
  static boolean f = false;
  static int created = 0;
  static int finalized = 0;
  int i;
  Chair() {
    i = ++created;
    if(created == 47) 
      System.out.println("Created 47");
  }
  protected void finalize() {
    if(!gcrun) {
      gcrun = true;
      System.out.println(
        "Beginning to finalize after " +
        created + " Chairs have been created");
    }
    if(i == 47) {
      System.out.println(
        "Finalizing Chair #47, " +
        "Setting flag to stop Chair creation");
      f = true;
    }
    finalized++;
    if(finalized >= created)
      System.out.println(
        "All " + finalized + " finalized");
  }
}

public class Garbage {
  public static void main(String[] args) {
    if(args.length == 0) {
      System.err.println("Usage: \n" +
        "java Garbage before\n  or:\n" +
        "java Garbage after");
      return;
    }
    while(!Chair.f) {
      new Chair();
      new String("To take up space");
    }
    System.out.println(
      "After all Chairs have been created:\n" +
      "total created = " + Chair.created +
      ", total finalized = " + Chair.finalized);
    if(args[0].equals("before")) {
      System.out.println("gc():");
      System.gc();
      System.out.println("runFinalization():");
      System.runFinalization();
    }
    System.out.println("bye!");
    if(args[0].equals("after"))
      System.runFinalizersOnExit(true);
  }
}
```
### 类初始化时成员加载顺序 
 首先加载静态成员，注意，静态成员随着类的加载而加载，并且只加载一次，被该类所有的对象所共享。   
 其次加载普通成员，并做默认初始化。   
    
 还有一种静态成员初始化的方法，static代码块,随着类的加载而加载，一次，共享。
 ```java
 static int s1;
 static {
    s1 = 5;
 }
 ```
 非静态成员初始化，代码块，随着每一个对象建立都加载一次。
  ```java
  public class Cups {
	Cup c1;
	Cup c2;
	{
		c1 = new Cup(1);
		c2 = new Cup(2);
	}
  	public Cups() {
	}
	public Cups(Cup c1, Cup c2) {
		this.c1 = c1;
		this.c2 = c2;
	}

	public static void main(String[] args) {
		new Cups();
		new Cups(new Cup(3),new Cup(4));
	}
}
输出结果：
Cup(1)
Cup(2)
Cup(3)
Cup(4)
Cup(1)
Cup(2)
   ```
   

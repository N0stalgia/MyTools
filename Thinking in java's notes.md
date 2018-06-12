## 第五章 

### 内存gc概念 
使用System.gc() 可以让垃圾回收器尽快回收内存垃圾，但这也是一个不确定的过程，有可能调用完gc就清理了垃圾，也可能要等上一阵子。
系统在gc时，会调用finalize()方法，但是这个方法看起来`并没有什么卵用`。
不过，覆盖这个方法，让其输出信息，可以让我们看到，系统在什么时候进行了gc。
```java
public static void main(String[] args) {
  System.out.println("Hello World!");
}
```

## 第六章
### 类访问
每个文件中只能有一个public的class   
类中的所有private方法是自动成为final   
一个类定义成final之后，其数据成员可以是final也可不是，而类中的所有方法都是final的。
   
在有继承关系的某个子类中，其初始化顺序是：   
父类静态-->>子类静态-->>父类默认-->>子类默认-->>父类构造-->>子类构造   
`静态-->>默认-->>构造`   


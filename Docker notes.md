### Docker上下文目录
在docker build -t nginx:v3 . 命令后有一个点，这个就是上下文路径，代表当前目录，也就是说，`运行这条命令时的当前目录？？？`      
静态一对一转换   
address outSideAdd   
range 220.100.1.100 220.100.1.130   

address virtualAdd  
192.168.10.100-192.168.10.130   

bnatrule virtual address-book virtualAdd real address-book outSideAdd   


端口转换   
snatrule from any to any service any eif ethernet0/0 trans-to eif-ip mode dynamicport   
snatrule from SubnetAdd to any service any trans-to address-book outSideAdd mode dynamicport   

可以指定用接口ip地址作为SNAT的转换地址，也可以使用自定义的地址簿中的对象，但都需要是公网地址   
在定义SNAT时，可以指定service对象的类型，如不指定，默认设置为any   
ingress-interface 在SNAT中不能指定，与文档上冲突   

SNAT与DNAT之间的区别   
snat主要用于内部的私有地址主机共享外部一个或者多个公网地址   
dnat则主要用于内部的服务器不地址不被暴露，且在定义规则时，目的地址与要进行转换的地址数目要一致   
证实我的猜想是对的，只需要定义snat就可以进行内外网的相互访问，而不是一条snat对应一条dnat   

dnatrule from any to outSideAdd service any trans-to virtualAdd   
dnatrule from any to outSideAdd service any trans-to virtualAdd port 2556   

NAT444   
snatrule from SubnetAdd to any service any trans-to address-book outSideAdd mode dynamicport random-block start 1024 end 65535 size 1024    
snatrule from SubnetAdd to any service any trans-to address-book outSideAdd mode dynamicport fixed-block start 1024 end 2288 size 128    
snatrule from SubnetAdd to any service any trans-to address-book outSideAdd mode dynamicport random-block start 1024 end 65535 size 1024    max-block-per-user 2   


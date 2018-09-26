## Linux上用FTP传文件到windows   
碰到这种事情真的尴尬，要把在linux系统上的文件传到windows上去。    
1.在windows上搭建好ftp服务器，用软件或者IIS都可以，添加一个用户，并给予对FTP服务器文件读写的权限。   
2.在linux上，用Put 命令将文件上传到windows上。   如当前文件夹下有一个hehe.txt，put hehe.txt  就OK了。

## 查看Linux系统版本信息
cat /proc/verion
## 设置默认网关以及路由
route add default gw 192.168.1.1   
添加路由   
route add -net 192.168.0.0/24 gw 192.168.0.1   
route add -host 192.168.1.1 dev 192.168.0.1   
删除路由   
route del -net 192.168.0.0/24 gw 192.168.0.1   
## windows下添加路由
1. 查看所有的路由表信息   

route print   

2. 添加一条路由条目   

route add 157.0.0.0 MASK 255.0.0.0  157.55.80.1   

route add 157.0.0.0 MASK 255.0.0.0  157.55.80.1 METRIC 3   

route add 157.0.0.0 MASK 255.0.0.0  157.55.80.1 METRIC 3 IF 2   

3. 添加一条永久路由条目（-p 表示永久路由，重启后不丢失）   

route -p add 157.0.0.0 MASK 255.0.0.0  157.55.80.1    

4. 删除路由条目  

route delete 157.0.0.0   
  
5. 修改路由条目（CHANGE 只用于修改网关和/或跃点数）   

route CHANGE 157.0.0.0 MASK 255.0.0.0 157.55.80.5 METRIC 2 IF 2     

## SCP可以传输文件或者文件夹
scp -r test/      codinglog@192.168.0.101:/var/www/      传输文件夹   
传输文件不带-r参数    
## 剪切与粘贴
用vi打开某个文件，光标在某行时，按dd可以剪切当前行，再按p可以粘贴   

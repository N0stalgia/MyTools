## Linux上用FTP传文件到windows   
碰到这种事情真的尴尬，要把在linux系统上的文件传到windows上去。    
1.在windows上搭建好ftp服务器，用软件或者IIS都可以，添加一个用户，并给予对FTP服务器文件读写的权限。   
2.在linux上，用Put 命令将文件上传到windows上。   如当前文件夹下有一个hehe.txt，put hehe.txt  就OK了。

## 查看Linux系统版本信息
cat /proc/verion
## 设置默认网关
route add default gw 192.168.1.1 

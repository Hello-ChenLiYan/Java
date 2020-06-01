两种方式：

1.centos启动docker服务

​    systemctl start docker

​    安装nginx的docker镜像

​    docker pull nginx:1.18.0



2.在windows上直接下载一个nginx的安装包，解压，双击nginx.exe启动服务

   运行nginx成功的界面

![image-20200601162509192](C:\Users\小胖\AppData\Roaming\Typora\typora-user-images\image-20200601162509192.png)



在解压的nginx安装包下找到conf文件夹下的nginx.conf配置文件

​     修改配置文件

​     proxy_pass 反向代理的域名（反向代理只需要知道域名）

![image-20200601162612916](C:\Users\小胖\AppData\Roaming\Typora\typora-user-images\image-20200601162612916.png)



​     重新载入配置文件

​      nginx -s reload

![image-20200601162657846](C:\Users\小胖\AppData\Roaming\Typora\typora-user-images\image-20200601162657846.png)



​    使用虚拟机ip成功打开了页面

​     域名:端口号

![image-20200601164749843](C:\Users\小胖\AppData\Roaming\Typora\typora-user-images\image-20200601164749843.png)
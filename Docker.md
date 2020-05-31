启动网络

![image-20200531154138530](C:\Users\小胖\AppData\Roaming\Typora\typora-user-images\image-20200531154138530.png)



在Linux虚拟机上安装Docker

1.查看内核版本，需要在3.10以上  

​      uname -r   

![image-20200531154414339](C:\Users\小胖\AppData\Roaming\Typora\typora-user-images\image-20200531154414339.png)

2.把yum包更新到最新版本

​      sudo yum update

3.安装需要的软件包   

​      sudo yum install -y yum-utils device-mapper-persistent-data lvm2 

![image-20200531162859934](C:\Users\小胖\AppData\Roaming\Typora\typora-user-images\image-20200531162859934.png)

4.设置yum源  

​        sudo yum-config-manager --add-repo https://download.docker.com/linux/centos/docker-ce.repo 

![image-20200531163040911](C:\Users\小胖\AppData\Roaming\Typora\typora-user-images\image-20200531163040911.png)

5.查看仓库docker版本   yum list docker-ce --showduplicates | sort -r 

![image-20200531163525535](C:\Users\小胖\AppData\Roaming\Typora\typora-user-images\image-20200531163525535.png)

6.安装Docker 

​       sudo yum install docker-ce

7.启动docker

​       systemctl start docker 

8.设置开机启动

​        systemctl enable docker 

![image-20200531155644347](C:\Users\小胖\AppData\Roaming\Typora\typora-user-images\image-20200531155644347.png)

9.查看是否启动成功

​       systemctl status docker.service  

![image-20200531165334627](C:\Users\小胖\AppData\Roaming\Typora\typora-user-images\image-20200531165334627.png)

10.阿里云镜像加速

​      vim /etc/docker/daemon.json

​      {

​             "registry-mirrors":["http://hub-mirror.c.163.com"]

​      }



在Docker上安装MySql

1.下载mysql5.7的docker镜像

​      docker pull mysql:5.7

![image-20200531172548843](C:\Users\小胖\AppData\Roaming\Typora\typora-user-images\image-20200531172548843.png)

2.使用docker命令启动

![image-20200531172955082](C:\Users\小胖\AppData\Roaming\Typora\typora-user-images\image-20200531172955082.png)

3.运行mysql的docker容器，使用mysql命令打开客户端

![image-20200531173230093](C:\Users\小胖\AppData\Roaming\Typora\typora-user-images\image-20200531173230093.png)

4.创建数据库

![image-20200531173330318](C:\Users\小胖\AppData\Roaming\Typora\typora-user-images\image-20200531173330318.png)



网络错误：

![image-20200531160022410](C:\Users\小胖\AppData\Roaming\Typora\typora-user-images\image-20200531160022410.png)

按照上面步骤设置yum源，即可解决


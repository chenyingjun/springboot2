## springboot2.x
### 环境：
* springboot2.4
* swagger2：2.8.0
* jdk：1.8.0_111
* alibaba Druid：1.1.10
* config_toolkit:3.3.2-RELEASE

###config_toolkit启动
-Dconfig.zookeeper.connectString=localhost:2181

-Dconfig.rootNode=/project/module

-Dconfig.version=1.0.0

-Dconfig.groupName=sb2

-Xdebug

-Xrunjdwp:transport=dt_socket,server=y,suspend=n,address=7777
1、安装 ionic CLI  全局安装
   npm install -g ionic
   安装完成后查看版本
   ionic -v
2、初始化项目
   ionic start myApp tabs
3、项目启动
   ionic serve
4、查看运行平台
   ionic cordova platform
5、ios app 环境搭建
   ionic cordova platform add ios
   ionic cordova build ios
6、Android app 环境搭建
   ionic cordova platform add android
   ionic cordova build android
   https://maven.google.com 连接不上的解决办法
   https://blog.csdn.net/qq_29443203/article/details/77511615
   安卓环境变量配置
   https://blog.csdn.net/daihuimaozideren/article/details/79501515
   sdk安装
   https://www.cnblogs.com/yjmyzz/p/4219829.html
7、编译
   ionic build
8、ionic 资源
ionic 图标 https://ionicons.com
9、ionic 打包
ionic build --prod --env=prod
ionic build --prod --env=dev
10、添加模块
ionic g 


参考资料
Ionic 4, Angular 7 and Cordova Tutorial: Build CRUD Mobile Apps
https://www.colabug.com/5206556.html
   
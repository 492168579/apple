# ApplePlatform

This project was generated with [Angular CLI](https://github.com/angular/angular-cli) version 8.1.1.

## Development server

Run `ng serve` for a dev server. Navigate to `http://localhost:4200/`. The app will automatically reload if you change any of the source files.

## Code scaffolding

Run `ng generate component component-name` to generate a new component. You can also use `ng generate directive|pipe|service|class|guard|interface|enum|module`.

## Build

Run `ng build` to build the project. The build artifacts will be stored in the `dist/` directory. Use the `--prod` flag for a production build.

## Running unit tests

Run `ng test` to execute the unit tests via [Karma](https://karma-runner.github.io).

## Running end-to-end tests

Run `ng e2e` to execute the end-to-end tests via [Protractor](http://www.protractortest.org/).

## Further help

To get more help on the Angular CLI use `ng help` or go check out the [Angular CLI README](https://github.com/angular/angular-cli/blob/master/README.md).

angular8 从0到1
1、搭建环境
   1.1  npm install -g @angular/cli
2 、创建项目 apple-platform
   2.1  ng new apple-platform
          Would you like to add Angular routing? Yes
          Which stylesheet format would you like to use? Less   [ http://lesscss.org   
3、启动项目
   3.1  cd apple-platform
        ng serve --open
4、添加模块
   项目采用子路由和懒加载方式加载 
   文档: https://www.angular.cn/guide/lazy-loading-ngmodules
   4.1  添加login 模块
        ng generate component login 
        ng generate module  login --routing
        ng generate service  login


ng generate directive my-directive - 生成一个新指令
ng generate pipe my-pipe - 生成一个新管道
ng generate service my-service - 生成一个新服务
ng generate route my-route - 生成一个新路由
ng generate class my-class - 生成一个简易的模型类

5、配置路由
   5.1  项目添加路由
   5.2  添加模块路由
6、整合 adminLTE
   https://blog.csdn.net/vily_luky/article/details/83416373
7、整合echart
   https://efe.baidu.com/blog/echarts-with-ionic/
   
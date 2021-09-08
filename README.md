# AliYunPan-AutoBackup

#### 介绍
阿里云盘自动备份工具

#### 新增一个Login类，可以完成自动登陆
使用方法:需要下载chromeDrive 下载注意本机chrome版本
修改其中userName和pwd变量即可
下载地址:http://chromedriver.storage.googleapis.com/index.html

#### Token获取方法
登录网页端阿里云盘后 控制台输入 JSON.parse(localStorage.getItem('token')).refresh_token 即可获取Token
网页端地址:https://www.aliyundrive.com/



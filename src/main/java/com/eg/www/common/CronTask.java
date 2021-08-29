package com.eg.www.common;

import cn.hutool.core.util.StrUtil;
import com.eg.www.common.utils.AliYunPanUtil;

/**
 * Description: 定时任务类
 * Author: Eg
 * Date: 2021/08/29
 */
public class CronTask {

    //阿里云工具类
    private AliYunPanUtil aliYunPanUtil=new AliYunPanUtil();

    /**
     * 更新阿里云盘token
     */
    public void updateALiYunPanToken(){
        if (StrUtil.isNotEmpty(CommonConstants.REFRESH_TOKEN)){
            CommonConstants.addConsole("定时更新阿里云Token");
            aliYunPanUtil.getAliYunPanInfo();
        }
    }

    /**
     * 定时备份文件
     */
    public void backFileList(){
        try {
            //执行上传文件操作
            Thread backup = new Thread(() -> aliYunPanUtil.startBackup());
            backup.start();
        } catch (Exception e) {
            CommonConstants.addConsole("遇到异常情况："+e.toString());
        }
    }

}

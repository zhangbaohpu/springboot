package com.zhangbaohpu.springboot.config;

public class Constant {
    public static String DOWNLOAD_ADDRESS = "data/share/ds/dowload/incfile/";
    //自动去除表前缀
    public static String AUTO_REOMVE_PRE = "true";
    //停止计划任务
    public static String STATUS_RUNNING_STOP = "stop";
    //开启计划任务
    public static String STATUS_RUNNING_START = "start";
    //通知公告阅读状态-未读
    public static String OA_NOTIFY_READ_NO = "0";
    //通知公告阅读状态-已读
    public static int OA_NOTIFY_READ_YES = 1;
    //部门根节点id
    public static Long DEPT_ROOT_ID = 0l;
    //缓存方式
    public static String CACHE_TYPE_REDIS ="redis";

    public static String LOG_ERROR = "error";

    /**
     * bootstrapTable rows
     */
    public static  final  String BOOTSTRAP_TABLE_ROWS = "rows";
    /**
     * bootstrapTable total
     */
    public static  final  String BOOTSTRAP_TABLE_TOTAL = "total";

}

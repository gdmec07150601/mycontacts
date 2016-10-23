package com.example.huas.mycontacts;

import android.content.ContentValues;
import android.content.Context;

/**
 * Created by HUAS on 2016/10/23.
 */
public class ContactsTable {
    //数据表名常量
    private final static String TABLENAME="contactsTable";
    //声明数据库对象
    private MyDB db;
    //构造方法
    public ContactsTable(Context context) {
        //创建MyDB对象 context狠重要
        db=new MyDB(context);
        //如果数据表不存在就新建数据表
        if(!db.isTableExits(TABLENAME)){
            String creatTableSql="CREAT TABLE IF NOT EXISTS"+TABLENAME+"(id_DB integer"+
                    "primayr key AUTOINCREMENT,"+
                    User.NAME+"VARCHAR,"+
                    User.MOBILE+"VARCHAR,"+
                    User.QQ+"VARCHAR,"+
                    User.DANWEI+"VARCHAR,"+
                    User.ADDRESS+"VARCHAR)";
            db.createTable(creatTableSql);
        }
    }
    //增加数据
    public boolean addData(User user){
        //创建ContentValues对象用于保存数据
        ContentValues values=new ContentValues();
        //contentvalue赋值
        values.put(User.NAME,user.getName());
        values.put(User.MOBILE,user.getMobile());
        values.put(User.DANWEI,user.getDanwei());
        values.put(User.QQ,user.getQq());
        values.put(User.ADDRESS,user.getAddress());
        //保存数据
        return db.save(TABLENAME,values);
    }
}

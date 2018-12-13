package com.example.administrator.project.DAO;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.administrator.project.model.Teacher;

import java.util.ArrayList;
import java.util.List;

public class TeacherDAO {

    private DBOpenHelper helper;                  //创建DBOpenHelper对象
    private SQLiteDatabase db;                          //创建SQLiteDatabase对象

    public TeacherDAO(Context context){            //定义构造函数
        helper = new DBOpenHelper(context);         //初始化DBOpenHelper对象
        db = helper.getWritableDatabase();             //初始化SQLiteDatabase对象
    }
    /**
     * 添加老师信息
     * @param teacher
     */
    public void add(Teacher teacher){
        db = helper.getWritableDatabase();          //初始化SQLiteDatabase对象
        db.execSQL("insert into teacher(t_id,t_loginid,t_name,t_password,t_sex,t_grade,t_subject," +
                "t_salary,t_edu_experience,t_major,t_self_introduction,t_photo,t_telnumber) values" +
                "(?,?,?,?,?,?,?,?,?,?,?,?,?)",new Object[]
                {teacher.getT_id(),teacher.getT_loginid(),teacher.getT_name(),teacher.getT_password(),
                teacher.getT_sex(),teacher.getT_grade(),teacher.getT_subject(),teacher.getT_salary(),
                teacher.getT_edu_experience(),teacher.getT_major(),teacher.getT_self_introduction(),
                teacher.getT_photo(),teacher.getT_telnumber()});
        //插入操作
    }
    /**
     * 更新老师信息
     * @param teacher
     */
    public void update(Teacher teacher){
        db = helper.getWritableDatabase();          //初始化SQLiteDatabase对象
        db.execSQL("update taeacher set t_id=?,t_loginid=?,t_name=?,t_password=?,t_sex=?,t_grade=?," +
                "t_subject=?,t_salary=?,t_edu_experience=?,t_major=?,t_self_introduction=?,t_photo=?," +
                "t_telnumber=?",new Object[]
                {teacher.getT_id(),teacher.getT_loginid(),teacher.getT_name(),teacher.getT_password(),
                 teacher.getT_sex(),teacher.getT_grade(),teacher.getT_subject(),teacher.getT_salary(),
                 teacher.getT_edu_experience(),teacher.getT_major(),teacher.getT_self_introduction(),
                 teacher.getT_photo(),teacher.getT_telnumber()});
        //更新操作
    }
    /**
     * 查找老师信息
     * @param phone
     */
    public Teacher find(String phone){
        db = helper.getWritableDatabase();          //初始化SQLiteDatabase对象
        Cursor  cursor = db.rawQuery("select * where t_telnumber = ?",new String[]
                {String.valueOf(phone)});    //根据电话号码查找老师信息，并储存在Cursor类中
        if (cursor.moveToNext())                   //遍历查找到的老师信息
        {
            //将遍历的老师信息存储到Teacher中
            return new Teacher(cursor.getInt(cursor.getColumnIndex("t_id")),
                    cursor.getString(cursor.getColumnIndex("t_loginid")),
                    cursor.getString(cursor.getColumnIndex("t_name")),
                    cursor.getString(cursor.getColumnIndex("t_password")),
                    cursor.getString(cursor.getColumnIndex("t_sex")),
                    cursor.getString(cursor.getColumnIndex("t_grade")),
                    cursor.getString(cursor.getColumnIndex("t_subject")),
                    cursor.getString(cursor.getColumnIndex("t_salary")),
                    cursor.getString(cursor.getColumnIndex("t_edu_experience")),
                    cursor.getString(cursor.getColumnIndex("t_major")),
                    cursor.getString(cursor.getColumnIndex("t_self_introduction")),
                    cursor.getString(cursor.getColumnIndex("t_photo")),
                    cursor.getString(cursor.getColumnIndex("t_telnumber")));
        }
        return null;
    }
    /**
     * 删除老师信息
     * @param ids
     */
    public void delete(Integer... ids){                     //判断是否存在要删除的id
        if (ids.length>0){
            StringBuffer sb = new StringBuffer();           //创建StringBuffer对象
            for (int i=0; i<ids.length;i++){                //遍历要删除的id集合
                sb.append('?').append(',');                 //将删除条件添加到StringBuffer对象中
            }
            sb.deleteCharAt(sb.length() - 1);               //去掉最后一个“,”字符
            db = helper.getWritableDatabase();              //初始化SQLiteDatabase对象
            db.execSQL("delete from teacher where t_id in("+ sb +")", ids);//删除老师的操作
        }
    }
    /**
     * 获取老师信息
     * @param start   起始位置
     * @param count   每页显示数量
     * @return
     */
    public List<Teacher> getTeacherData(int start,int count){
        List<Teacher> teacher = new ArrayList<Teacher>();   //创建集合对象
        db = helper.getWritableDatabase();           //初始化SQLiteDatabase对象
        Cursor cursor = db.rawQuery("select * from teacher limit ?,?",new String[]{
                String.valueOf(start),String.valueOf(count)});          //获取所有老师信息
        while (cursor.moveToNext()){            //遍历所有老师信息
            teacher.add(new Teacher(cursor.getInt(cursor.getColumnIndex("t_id")),
                    cursor.getString(cursor.getColumnIndex("t_loginid")),
                    cursor.getString(cursor.getColumnIndex("t_name")),
                    cursor.getString(cursor.getColumnIndex("t_password")),
                    cursor.getString(cursor.getColumnIndex("t_sex")),
                    cursor.getString(cursor.getColumnIndex("t_grade")),
                    cursor.getString(cursor.getColumnIndex("t_subject")),
                    cursor.getString(cursor.getColumnIndex("t_salary")),
                    cursor.getString(cursor.getColumnIndex("t_edu_experience")),
                    cursor.getString(cursor.getColumnIndex("t_major")),
                    cursor.getString(cursor.getColumnIndex("t_self_introduction")),
                    cursor.getString(cursor.getColumnIndex("t_photo")),
                    cursor.getString(cursor.getColumnIndex("t_telnumber"))));
                    //将遍历到的老师信息添加到集合中
            }
            return teacher;
    }
    /**
     * 获取总记录数
     * @return
     */
    public long getCount(){
        db = helper.getWritableDatabase();           //初始化SQLiteDatabase对象
        Cursor cursor = db.rawQuery("select count(t_id) from teacher",null);
                                                //获取老师信息的记录数
        if (cursor.moveToNext()){
            return  cursor.getLong(0);  //返回总记录数
        }
        return 0;                           //如果没有数据，则返回0
    }
    /**
     * 获取老师最大编号
     * @return
     */
    public int getMaxId(){
        db = helper.getWritableDatabase();           //初始化SQLiteDatabase对象
        Cursor cursor = db.rawQuery("select max(t_id) from teacher",null);
                                        //获取老师表中的最大编号
        while (cursor.moveToLast()){        //访问Cursor中是最后一条数据
            return cursor.getInt(0);   //获取访问到的数据，即最大编号
        }
        return 0;                              //如果没有数据，则返回0
    }
}

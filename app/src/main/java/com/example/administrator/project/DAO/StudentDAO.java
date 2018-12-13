package com.example.administrator.project.DAO;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.administrator.project.model.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentDAO {

    private DBOpenHelper helper;                  //创建DBOpenHelper对象
    private SQLiteDatabase db;                          //创建SQLiteDatabase对象

    public StudentDAO(Context context) {            //定义构造函数
        helper = new DBOpenHelper(context);         //初始化DBOpenHelper对象
        db = helper.getWritableDatabase();             //初始化SQLiteDatabase对象
    }

    /**
     *添加学生信息
     * @param student
     */
    public void add(Student student){
        db = helper.getWritableDatabase();             //初始化SQLiteDatabase对象
        ////添加学生,执行插入操作
        db.execSQL("insert into student (s_id,s_loginid,s_name,s_password,s_sex,s_grade,s_price," +
                "s_frequency,s_address,s_basics,s_require_sex,s_require_grade,s_self_introduction," +
                "s_photo,s_telnumber) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)",new Object[]{
                student.getS_id(),student.getS_loginid(),student.getS_name(),student.getS_password(),
                student.getS_sex(),student.getS_grade(),student.getS_price(),student.getS_frequency(),
                student.getS_address(),student.getS_basics(),student.getS_require_sex(),student.getS_require_grade(),
                student.getS_self_introduction(),student.getS_photo(),student.getS_telnumber()});
    }
    /**
     * 更新学生信息
     * @param student
     */
    public void update(Student student){
        db = helper.getWritableDatabase();             //初始化SQLiteDatabase对象
        //执行修改学生信息操作
        db.execSQL("update student set s_id=?,s_loginid=?,s_name=?,s_password=?,s_sex=?,s_grade=?," +
                "s_price=?,s_frequency=?,s_address=?,s_basic=?,s_require__sex=?,s_require_grade=?," +
                "s_self_introduction=?,s_photo=?,s_tel_number=?",new Object[]{
                student.getS_id(),student.getS_loginid(),student.getS_name(),student.getS_password(),
                student.getS_sex(),student.getS_grade(),student.getS_price(),student.getS_frequency(),
                student.getS_address(),student.getS_basics(),student.getS_require_sex(),student.getS_require_grade(),
                student.getS_self_introduction(),student.getS_photo(),student.getS_telnumber()
        });
    }
    /**
     * 查找学生信息
     * @param account
     */
    public Student find(String account){
        db = helper.getWritableDatabase();             //初始化SQLiteDatabase对象
        Cursor cursor =db.rawQuery("select * from student where s_loginid = ?",new String[]{
                String.valueOf(account)});   //根据账号查找学生信息，并存储到Cursor类中
        if (cursor.moveToNext()){           //遍历查找到的学生信息
            //将遍历到的学生信息存储到Student类中
            return new Student(cursor.getInt(cursor.getColumnIndex("s_id")),
                    cursor.getString(cursor.getColumnIndex("s_loginid")),
                    cursor.getString(cursor.getColumnIndex("s_name")),
                    cursor.getString(cursor.getColumnIndex("s_password")),
                    cursor.getString(cursor.getColumnIndex("s_sex")),
                    cursor.getString(cursor.getColumnIndex("s_grade")),
                    cursor.getString(cursor.getColumnIndex("s_price")),
                    cursor.getString(cursor.getColumnIndex("s_frequency")),
                    cursor.getString(cursor.getColumnIndex("s_address")),
                    cursor.getString(cursor.getColumnIndex("s_basics")),
                    cursor.getString(cursor.getColumnIndex("s_require_sex")),
                    cursor.getString(cursor.getColumnIndex("s_require_grade")),
                    cursor.getString(cursor.getColumnIndex("s_self_introduction")),
                    cursor.getString(cursor.getColumnIndex("s_photo")),
                    cursor.getString(cursor.getColumnIndex("s_telnumber")));
        }
        return null;                //如果没有信息，则返回null
    }
    /**
     * 删除学生信息
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
            db.execSQL("delete from student where t_id in("+ sb +")", ids);  //删除学生的操作
        }
    }
    /**
     * 获取学生信息
     * @param start
     * @param count
     * @return
     */
    public List<Student> getStudentData(int start, int count){
        List<Student> student = new ArrayList<Student>();   //创建集合对象
        db = helper.getWritableDatabase();           //初始化SQLiteDatabase对象
        Cursor cursor = db.rawQuery("select * from student limit ?,?",new String[]{
                String.valueOf(start),String.valueOf(count)});          //获取所有学生信息
        while(cursor.moveToNext()){
            student.add(new Student(cursor.getInt(cursor.getColumnIndex("s_id")),
                    cursor.getString(cursor.getColumnIndex("s_loginid")),
                    cursor.getString(cursor.getColumnIndex("s_name")),
                    cursor.getString(cursor.getColumnIndex("s_password")),
                    cursor.getString(cursor.getColumnIndex("s_sex")),
                    cursor.getString(cursor.getColumnIndex("s_grade")),
                    cursor.getString(cursor.getColumnIndex("s_price")),
                    cursor.getString(cursor.getColumnIndex("s_frequency")),
                    cursor.getString(cursor.getColumnIndex("s_address")),
                    cursor.getString(cursor.getColumnIndex("s_basics")),
                    cursor.getString(cursor.getColumnIndex("s_require_sex")),
                    cursor.getString(cursor.getColumnIndex("s_require_grade")),
                    cursor.getString(cursor.getColumnIndex("s_self_introduction")),
                    cursor.getString(cursor.getColumnIndex("s_photo")),
                    cursor.getString(cursor.getColumnIndex("s_telnumber"))));
        }
        return student;
    }
    /**
     * 获取总记录数
     */
    public long getCount(){
        db = helper.getWritableDatabase();           //初始化SQLiteDatabase对象
        Cursor cursor = db.rawQuery("select count(t_id) from student",null);
        //获取学生信息的记录数
        if (cursor.moveToNext()){
            return  cursor.getLong(0);  //返回总记录数
        }
        return 0;                           //如果没有数据，则返回0
    }
    /**
     * 获取学生最大编号
     * @return
     */
    public int getMaxId(){
        db = helper.getWritableDatabase();           //初始化SQLiteDatabase对象
        Cursor cursor = db.rawQuery("select max(s_id) from student",null);
        //获取学生表中的最大编号
        while (cursor.moveToLast()){        //访问Cursor中是最后一条数据
            return cursor.getInt(0);   //获取访问到的数据，即最大编号
        }
        return 0;                              //如果没有数据，则返回0
    }
}


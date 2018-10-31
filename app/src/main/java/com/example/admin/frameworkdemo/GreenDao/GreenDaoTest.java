package com.example.admin.frameworkdemo.GreenDao;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import java.util.List;

public class GreenDaoTest {
    Context context;
    private UserDao userDao;
    private final static String TAG = "GreenDaoTest";

    public GreenDaoTest(Context context) {
        this.context = context;
    }

    /*
    * 首先获取一个DevOpenHelper对象，这个类有点类似于我们使用的SqliteOpenHelper，
    * 我们主要在这个类中对数据库的版本进行管理。这个我们到后面的数据库升级一节再说。
    * 这样之后，我们对数据库基本的初始化操作就完成了，玩过Hibernate的小伙伴都知道，
    * 在Hibernate框架中如果我们想要操作实体类要通过DAO来操作，那么在这里也一样。
    * 想要操作User实体类，得先有一个UserDao，这个UserDao要怎么获取呢？如下：*/
    public void init(){
        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(context, "lenve.db", null);
        DaoMaster daoMaster = new DaoMaster(devOpenHelper.getWritableDb());
        DaoSession daoSession = daoMaster.newSession();
        userDao = daoSession.getUserDao();
    }

    /*数据库的增删改查我们都将通过UserDao来进行
    * User的第一个参数为id，这里传null的话在插入的过程中id字段会自动增长（现在知道为什么id要为Long类型了吧！）
    * 第二个参数是username，每次插入时生成一个随机数，避免重复*/
    public void add(){
        for(int i=0; i<10; i++){
            User user = new User(null, "zhangsan"+i,"张三");
            userDao.insert(user);
        }
    }

    public void delete(){
        List<User> userList = (List<User>) userDao.queryBuilder().where(UserDao.Properties.Id.le(10)).build().list();
        for (User user : userList) {
            userDao.delete(user);
        }

        /*where表示查询条件，这里我是查询id小于等于10的数据，where中的参数可以有多个，
        就是说可以添加多个查询条件。最后的list表示查询结果是一个List集合，
        如果你只想查询一条数据，最后unique即可。当然，我们也可以根据id来删除数据：*/

        /*
    User user = userDao.queryBuilder().where(UserDao.Properties.Id.eq(16)).build().unique();
            if (user == null) {
                Toast.makeText(MainActivity.this, "用户不存在", Toast.LENGTH_SHORT).show();
            }else{
                userDao.deleteByKey(user.getId());
            }
*/

        /*也可以将表中所有数据一次删除：*/
        /*userDao.deleteAll();  */

    }

    public void update(){
        User user = userDao.queryBuilder().where(UserDao.Properties.Id.eq(2)).build().unique();
        if(user == null) {
            Log.d(TAG, "该用户不存在");
        }else{
            user.setUsername("王五");
            userDao.update(user);
        }
    }

    /*我这里举两个例子between表示查询id介于2到13之间的数据，limit表示查询5条数据*/
    public void search(){
        List<User> list = userDao.queryBuilder()
                .where(UserDao.Properties.Id.between(2, 50)).build().list();
        for (int i = 0; i < list.size(); i++) {
            Log.d(TAG, "search: " + list.get(i).toString());
        }

    }
}

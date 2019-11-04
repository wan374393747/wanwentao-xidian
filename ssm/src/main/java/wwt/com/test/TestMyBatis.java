package wwt.com.test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import wwt.com.dao.AccountDao;
import wwt.com.domain.Account;

import java.io.InputStream;
import java.util.List;

public class TestMyBatis {

    @Test
    public void run1() throws Exception{
        // 加载配置文件
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        // 创建SqlSessionFactory对象
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        // 创建SqlSession对象
        SqlSession session = factory.openSession();
        // 获取到代理对象
        AccountDao dao = session.getMapper(AccountDao.class);
        List<Account> accountList = dao.findAll();
        for (Account account : accountList) {
            System.out.println(account);
        }
        // 关闭资源
        session.close();
        in.close();
    }

    @Test
    public void run2() throws Exception{
        // 加载配置文件
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        // 创建SqlSessionFactory对象
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        // 创建SqlSession对象
        SqlSession session = factory.openSession();
        // 获取到代理对象
        AccountDao dao = session.getMapper(AccountDao.class);
        Account account = new Account();
        account.setName("佟丽娅");
        account.setMoney(98d);
        dao.saveAccount(account);
        session.commit();
        // 关闭资源
        session.close();
        in.close();
    }
}

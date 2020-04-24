package com.shang.news.component;

import java.time.LocalDateTime;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.reflection.MetaObject;
import org.springframework.beans.factory.annotation.Autowired;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;

public class CommonsFieldMetaObjectHandler implements MetaObjectHandler {

	@Autowired
	private HttpSession session;
	
	@Override
    public void insertFill(MetaObject metaObject) {
		Object currentuser = session.getAttribute("login_user");
        this.strictInsertFill(metaObject, "createtime", LocalDateTime.class, LocalDateTime.now()); // 起始版本 3.3.0(推荐使用)
        this.strictInsertFill(metaObject, "creater", String.class, currentuser); // 起始版本 3.3.0(推荐使用)
        this.strictInsertFill(metaObject, "order_user", String.class, currentuser); // 起始版本 3.3.0(推荐使用)
        this.strictInsertFill(metaObject, "order_time", LocalDateTime.class, LocalDateTime.now()); // 起始版本 3.3.0(推荐使用)
        this.strictInsertFill(metaObject, "sendtime", LocalDateTime.class, LocalDateTime.now()); // 起始版本 3.3.0(推荐使用)
        this.strictInsertFill(metaObject, "relation_user", String.class, currentuser); // 起始版本 3.3.0(推荐使用)
        this.strictInsertFill(metaObject, "collect_time", LocalDateTime.class, LocalDateTime.now()); // 起始版本 3.3.0(推荐使用)
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        this.strictUpdateFill(metaObject, "updatetime", LocalDateTime.class, LocalDateTime.now()); // 起始版本 3.3.0(推荐使用)
        this.strictUpdateFill(metaObject, "updater", String.class, session.getAttribute("login_user")); // 起始版本 3.3.0(推荐使用)
        this.strictUpdateFill(metaObject, "order_time", LocalDateTime.class, LocalDateTime.now()); // 起始版本 3.3.0(推荐使用)
        this.strictUpdateFill(metaObject, "collect_time", LocalDateTime.class, LocalDateTime.now()); // 起始版本 3.3.0(推荐使用)
    }
}

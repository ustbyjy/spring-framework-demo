package com.yjy.test.lookup;

import com.yjy.test.bean.User;

public abstract class GetBean {

    public void showMe() {
        this.getBean().showMe();
    }

    public abstract User getBean();
}

package com.yjy.lookup;

import com.yjy.lookup.bean.User;

public abstract class GetBeanTest {

    public void showMe() {
        this.getBean().showMe();
    }

    public abstract User getBean();
}

package com.yjy.test.condition;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

public class MyImportSelector implements ImportSelector {

    /**
     * 返回值，是导入到容器中的组件的全类名
     *
     * @param importingClassMetadata 标注@Import注解的类的信息
     * @return
     */
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        // 可以返回空数组，不能返回null
//        return new String[0];

        return new String[]{"com.yjy.test.bean.Blue", "com.yjy.test.bean.Red"};
    }
}

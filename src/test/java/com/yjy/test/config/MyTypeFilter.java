package com.yjy.test.config;

import org.springframework.core.io.Resource;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

import java.io.IOException;

public class MyTypeFilter implements TypeFilter {

    @Override
    public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {
        // 声明信息
        AnnotationMetadata annotationMetadata = metadataReader.getAnnotationMetadata();
        // 类信息
        ClassMetadata classMetadata = metadataReader.getClassMetadata();
        // 资源信息
        Resource resource = metadataReader.getResource();

        String className = classMetadata.getClassName();
        System.out.print("--->" + className);

        if (className.contains("er")) {
            System.out.println(": 注入");
            
            return true;
        }

        System.out.println();

        return false;
    }
}

package com.mloine.spring.demo6.config;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 *  @Author: XueYongKang
 *  @Description: 自定义选择器 返回不能为空  放回全类名
 *  @Data: 2019/11/26 14:37
 */
public class MloineImportSelect implements ImportSelector {

    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
//        return null;
        return new String[]{"com.mloine.spring.demo6.bean.Tiger","com.mloine.spring.demo6.bean.Fish"};
    }


}
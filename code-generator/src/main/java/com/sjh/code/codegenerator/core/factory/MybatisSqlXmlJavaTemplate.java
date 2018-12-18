package com.sjh.code.codegenerator.core.factory;

import com.sjh.code.codegenerator.core.util.FilePathUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * @author sjh
 * @Description: Mybatis XML文件生成类，与DAO接口类相对应
 * @date 2018/12/14 22:58
 */
public class MybatisSqlXmlJavaTemplate extends AbstractFreemarkerTemplate {

    /** 默认Freemarker模板名称*/
    private static final String DEFAULT_FTL_NAME = "mybatisSqlXml.ftl";
    private static final String SUFFIX_XML = ".xml";

    public MybatisSqlXmlJavaTemplate(String freemarkerTemplateName) {
        super(freemarkerTemplateName);
    }

    public MybatisSqlXmlJavaTemplate() {
        super(DEFAULT_FTL_NAME);
    }

    @Override
    protected Map<String, Object> createParameterMap(FreemarkerContext freemarkerContext) {
        String entityFilePath = freemarkerContext.getEntityFilePath();
        String packageName = FilePathUtil.cutPathToPackage(entityFilePath);
        Map<String, Object> fieldsMap = freemarkerContext.getFieldsMap();
        Map<String, Object> parameterMap = new HashMap<>();
        parameterMap.put("package", packageName);
        parameterMap.put("fields", fieldsMap);
        return parameterMap;
    }


    @Override
    protected String getDirPath(FreemarkerContext freemarkerContext) {
        return freemarkerContext.getEntityFilePath();
    }

    @Override
    protected String getJavaFileName(FreemarkerContext freemarkerContext) {
        return freemarkerContext.getFileName() + SUFFIX_XML;
    }
}

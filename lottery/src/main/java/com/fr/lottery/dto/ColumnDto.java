package com.fr.lottery.dto;

/**
 * Created by Liyu7342 on 2017-12-8.
 */
public class ColumnDto {
    private String id;
    private String columnName;

    private String className;
    private String headerClassName;
    private String headerName;
    private String template;

    public ColumnDto(){

    }

    public ColumnDto(String columnName,String headerName){
        this.columnName = columnName;
        this.headerName=headerName;
    }
    public ColumnDto(String columnName,String headerName,String headerClassName,String className,String template){
        this.columnName=columnName;
        this.headerName = headerName;
        this.headerClassName = headerClassName;
        this.className = className;
        this.template = template;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getHeaderClassName() {
        return headerClassName;
    }

    public void setHeaderClassName(String headerClassName) {
        this.headerClassName = headerClassName;
    }

    public String getTemplate() {
        return template;
    }

    public void setTemplate(String template) {
        this.template = template;
    }

    public String getHeaderName() {
        return headerName;
    }

    public void setHeaderName(String headerName) {
        this.headerName = headerName;
    }
}

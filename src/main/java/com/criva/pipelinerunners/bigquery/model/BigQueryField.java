package com.criva.pipelinerunners.bigquery.model;

import java.io.Serializable;

public class BigQueryField<T> implements Serializable {

  private String type;

  private BigQueryFieldFn<T> fieldFunction;

  public BigQueryField(String type,
      BigQueryFieldFn<T> fieldFunction) {
    this.type = type;
    this.fieldFunction = fieldFunction;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public BigQueryFieldFn<T> getFieldFunction() {
    return fieldFunction;
  }

  public void setFieldFunction(BigQueryFieldFn<T> fieldFunction) {
    this.fieldFunction = fieldFunction;
  }
}

package com.criva.pipelinerunners.bigquery.model;

import java.util.Map;

public class BigQueryData<T> {

  private String projectId;

  private String datasetId;

  private String tableId;

  private Map<String, BigQueryField<T>> fieldMap;

  public BigQueryData(String projectId, String datasetId, String tableId,
      Map<String, BigQueryField<T>> fieldMap) {
    super();
    this.projectId = projectId;
    this.datasetId = datasetId;
    this.tableId = tableId;
    this.fieldMap = fieldMap;
  }

  public String getProjectId() {
    return projectId;
  }

  public void setProjectId(String projectId) {
    this.projectId = projectId;
  }

  public String getDatasetId() {
    return datasetId;
  }

  public void setDatasetId(String datasetId) {
    this.datasetId = datasetId;
  }

  public String getTableId() {
    return tableId;
  }

  public void setTableId(String tableId) {
    this.tableId = tableId;
  }

  public Map<String, BigQueryField<T>> getFieldMap() {
    return fieldMap;
  }

  public void setFieldMap(Map<String, BigQueryField<T>> fieldMap) {
    this.fieldMap = fieldMap;
  }
}

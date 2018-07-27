package com.criva.pipelinerunners.bigquery.function;

import com.criva.pipelinerunners.bigquery.model.BigQueryData;
import com.google.api.services.bigquery.model.TableFieldSchema;
import com.google.api.services.bigquery.model.TableReference;
import com.google.api.services.bigquery.model.TableSchema;
import org.apache.beam.sdk.io.gcp.bigquery.BigQueryIO;
import org.apache.beam.sdk.transforms.PTransform;
import org.apache.beam.sdk.transforms.ParDo;
import org.apache.beam.sdk.values.PCollection;
import org.apache.beam.sdk.values.PDone;

import java.util.ArrayList;
import java.util.List;

public class BigQueryWrite<T> extends PTransform<PCollection<T>, PDone> {

  private BigQueryData<T> data;

  public BigQueryWrite(BigQueryData<T> data) {
    this.data = data;
  }

  @Override
  public PDone expand(PCollection<T> input) {
    input.apply("ConvertToRow", ParDo.of(new BigQueryCreateRow<T>(data.getFieldMap())))
        .apply(BigQueryIO.writeTableRows()
            .to(getTable())
            .withSchema(getSchema())
            .withCreateDisposition(BigQueryIO.Write.CreateDisposition.CREATE_IF_NEEDED)
            .withWriteDisposition(BigQueryIO.Write.WriteDisposition.WRITE_APPEND));

    return PDone.in(input.getPipeline());
  }

  private TableReference getTable() {
    TableReference table = new TableReference();

    table.setDatasetId(data.getDatasetId());
    table.setProjectId(data.getProjectId());
    table.setTableId(data.getTableId());

    return table;
  }

  private TableSchema getSchema() {
    TableSchema schema = new TableSchema();
    List<TableFieldSchema> tableFields = new ArrayList<>();

    data.getFieldMap().entrySet().stream().forEach(
        entry -> {
          String key = entry.getKey();
          String type = entry.getValue().getType();
          tableFields.add(new TableFieldSchema().setName(key).setType(type));
        }
    );

    return schema.setFields(tableFields);
  }
}
